package com.fxb.micro3componentmybatis.mapper;

import com.fxb.micro3componentmybatis.model.User;

import java.util.List;

/***
 * @author fangjiaxiaobai@163.com
 * @date 2018-03-08
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();
}