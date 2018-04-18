package com.fxb.relearn.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * demo08-relearn
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-12
 */
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     * 对密码进行编码
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }

    /**
     * 比较密码是否匹配
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return true;
    }
}
