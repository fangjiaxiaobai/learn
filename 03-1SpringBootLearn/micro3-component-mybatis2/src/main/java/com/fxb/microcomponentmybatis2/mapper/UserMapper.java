package com.fxb.microcomponentmybatis2.mapper;

import com.fxb.microcomponentmybatis2.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/8
 */
@Mapper
public interface UserMapper {
    
    @Select("select * from t_user where phone=#{phone}")
    @Results({
        @Result(property = "username",column = "user_name"),
        @Result(property = "password",column = "password"),
        @Result(property = "phone",column = "phone")
    })
    User findUserByPhone(@Param("phone")String phone);
    
    @Insert("insert into t_user(user_name,password,phone) value(#{name},#{password},#{phone})")
    int insert(@Param("name")String name,@Param("password")String password,@Param("phone")String phone);
}
