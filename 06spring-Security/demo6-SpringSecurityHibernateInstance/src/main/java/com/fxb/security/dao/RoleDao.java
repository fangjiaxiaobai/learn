package com.fxb.security.dao;

import com.fxb.security.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/12 16:58.
 * @description RoleDao
 */
@Repository
@Transactional
public class RoleDao extends AbstractDao<String,Role> {
    public List<Role> findAll() {
        return createEntityCriteria().list();
    }
}
