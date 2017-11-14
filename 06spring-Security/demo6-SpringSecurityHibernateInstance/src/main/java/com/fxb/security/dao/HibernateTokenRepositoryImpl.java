package com.fxb.security.dao;

import com.fxb.security.entity.PersistentLogin;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:14.
 * @description HibernateTokenRepositoryImpl
 */
@Repository
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao <String, PersistentLogin>
        implements PersistentTokenRepository {
    
    static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);
    
    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("create token for user : {}", token.getUsername());
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setId(token.getSeries());
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setLastUsed(token.getDate());
        persistentLogin.setToken(token.getTokenValue());
        persist(persistentLogin);
    }
    
    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        logger.info("update Token if any for seriesId : {}", series);
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLastUsed(lastUsed);
        update(persistentLogin);
    }
    
    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch token if an for seriesId : {}", seriesId);
        try {
            Criteria entityCriteria = createEntityCriteria();
            entityCriteria.add(Restrictions.eq("id", seriesId));
            PersistentLogin persistentLogin = (PersistentLogin) entityCriteria.uniqueResult();
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getId(), persistentLogin.getToken(), persistentLogin.getLastUsed());
        } catch(Exception e) {
            logger.info("Token not found");
            return null;
        }
    }
    
    @Override
    public void removeUserTokens(String username) {
        logger.info("Removing token if any for user {}", username);
        Criteria entityCriteria = createEntityCriteria();
        entityCriteria.add(Restrictions.eq("username", username));
        PersistentLogin persistentLogin = (PersistentLogin) entityCriteria.uniqueResult();
        if(null != persistentLogin) {
            logger.info("Remember me is seleted ");
            delete(persistentLogin);
        }
    }
}
