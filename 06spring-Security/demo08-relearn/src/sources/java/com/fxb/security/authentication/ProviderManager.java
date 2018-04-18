/*
 * Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fxb.security.authentication;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.util.Assert;


/**
 * AuthenticationManager的实现类
 *      被AuthenticationManager委托，通过多种的验证方式认证一个请求可以被认证通过。
 *   验证方式如通过用户名+密码，手机号+密码，微信号+密码(扫一扫)，邮箱+密码等等。
 *
 */
public class ProviderManager implements AuthenticationManager, MessageSourceAware,
        InitializingBean {

    private static final Log logger = LogFactory.getLog(ProviderManager.class);


    private AuthenticationEventPublisher eventPublisher = new NullEventPublisher();
    /**
     * 上面说的多种认证方式的集合。
     * ProviderManager 中的List，会依照次序去认证，认证成功则立即返回，
     * 若认证失败则返回null，下一个AuthenticationProvider会继续尝试认证，
     * 如果所有认证器都无法认证成功，则ProviderManager 会抛出一个ProviderNotFoundException异常
     */
    private List<AuthenticationProvider> providers = Collections.emptyList();


    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();


    private AuthenticationManager parent;

    private boolean eraseCredentialsAfterAuthentication = true;

    public ProviderManager(List<AuthenticationProvider> providers) {
        this(providers, null);
    }

    public ProviderManager(List<AuthenticationProvider> providers,
                           AuthenticationManager parent) {
        Assert.notNull(providers, "providers list cannot be null");
        this.providers = providers;
        this.parent = parent;
        checkState();
    }


    public void afterPropertiesSet() throws Exception {
        checkState();
    }

    private void checkState() {
        if (parent == null && providers.isEmpty()) {
            throw new IllegalArgumentException(
                    "A parent AuthenticationManager or a list "
                            + "of AuthenticationProviders is required");
        }
    }

    /**
     *  真正的认证逻辑
     *      尝试认证传递过来的Authentication对象。
     *  每个认证方式都会被执行。
     *  如果一个AuthenticationProvider(认证方式) 认证这个Authentication是通过的，那么就决定其是通过认证的。
     *  第一个认证成功，就会覆盖所有可能的认证异常(AuthenticationException)
     *
     */
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        Class<? extends Authentication> toTest = authentication.getClass();
        AuthenticationException lastException = null;
        Authentication result = null;
        boolean debug = logger.isDebugEnabled();

        // 一次尝试每中认证方策略
        for (AuthenticationProvider provider : getProviders()) {
            if (!provider.supports(toTest)) {
                continue;
            }

            if (debug) {
                // 打印使用那种策略进行认证
                logger.debug("Authentication attempt using " + provider.getClass().getName());
            }

            try {
                // 尝试认证
                result = provider.authenticate(authentication);

                // 如果认证成功,
                if (result != null) {
                    copyDetails(authentication, result);
                    break;
                }
            }
            catch (AccountStatusException e) {
                prepareException(e, authentication);
                throw e;
            }
            catch (InternalAuthenticationServiceException e) {
                prepareException(e, authentication);
                throw e;
            }
            catch (AuthenticationException e) {
                lastException = e;
            }
        }

        if (result == null && parent != null) {
            try {
                result = parent.authenticate(authentication);
            }
            catch (ProviderNotFoundException e) {
            }
            catch (AuthenticationException e) {
                lastException = e;
            }
        }

        if (result != null) {
            if (eraseCredentialsAfterAuthentication
                    && (result instanceof CredentialsContainer)) {
                // Authentication is complete. Remove credentials and other secret data
                // from authentication
                ((CredentialsContainer) result).eraseCredentials();
            }

            eventPublisher.publishAuthenticationSuccess(result);
            return result;
        }

        // Parent was null, or didn't authenticate (or throw an exception).

        if (lastException == null) {
            lastException = new ProviderNotFoundException(messages.getMessage(
                    "ProviderManager.providerNotFound",
                    new Object[] { toTest.getName() },
                    "No AuthenticationProvider found for {0}"));
        }

        prepareException(lastException, authentication);

        throw lastException;
    }

    @SuppressWarnings("deprecation")
    private void prepareException(AuthenticationException ex, Authentication auth) {
        eventPublisher.publishAuthenticationFailure(ex, auth);
    }

    /**
     * Copies the authentication details from a source Authentication object to a
     * destination one, provided the latter does not already have one set.
     *
     * @param source source authentication
     * @param dest the destination authentication object
     */
    private void copyDetails(Authentication source, Authentication dest) {
        if ((dest instanceof AbstractAuthenticationToken) && (dest.getDetails() == null)) {
            AbstractAuthenticationToken token = (AbstractAuthenticationToken) dest;

            token.setDetails(source.getDetails());
        }
    }

    public List<AuthenticationProvider> getProviders() {
        return providers;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }

    public void setAuthenticationEventPublisher(
            AuthenticationEventPublisher eventPublisher) {
        Assert.notNull(eventPublisher, "AuthenticationEventPublisher cannot be null");
        this.eventPublisher = eventPublisher;
    }

    /**
     * If set to, a resulting {@code Authentication} which implements the
     * {@code CredentialsContainer} interface will have its
     * {@link CredentialsContainer#eraseCredentials() eraseCredentials} method called
     * before it is returned from the {@code authenticate()} method.
     *
     * @param eraseSecretData set to {@literal false} to retain the credentials data in
     * memory. Defaults to {@literal true}.
     */
    public void setEraseCredentialsAfterAuthentication(boolean eraseSecretData) {
        this.eraseCredentialsAfterAuthentication = eraseSecretData;
    }

    public boolean isEraseCredentialsAfterAuthentication() {
        return eraseCredentialsAfterAuthentication;
    }

    private static final class NullEventPublisher implements AuthenticationEventPublisher {
        public void publishAuthenticationFailure(AuthenticationException exception,
                                                 Authentication authentication) {
        }

        public void publishAuthenticationSuccess(Authentication authentication) {
        }
    }
}
