package com.fxb.security.crypto.password;


/***
 * 密码加密的顶级接口
 *  主要实现对密码的加密，
 *  和加密后，对密码的匹配。
 *
 */
public interface PasswordEncoder {

    /**
     * 对密码进行加密
     * @param rawPassword
     * @return
     */
    String encode(CharSequence rawPassword);

    /**
     * 匹配加密后的密码是否和用户的密码一致
     * @return
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);

}
