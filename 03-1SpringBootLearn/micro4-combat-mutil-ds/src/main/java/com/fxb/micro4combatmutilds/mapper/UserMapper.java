package com.fxb.micro4combatmutilds.mapper;

import com.fxb.micro4combatmutilds.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "username",column = "user_name"),
        @Result(property = "password",column = "password"),
        @Result(property = "phone",column = "phone")
    })
    List<User> selectUser();
}
