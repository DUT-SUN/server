package com.kemi.actable.common;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/05/29  14:02
 */
public class PasswordUtils {

     /**
     * @explain
     * @param password 明文
     * @return java.lang.String 返回存在数据库的密码
     * @author DUT-SUN
     * @date   2023/5/29
     */
    //1.加盐并生成密码
    public static String encrypt(String password){
        String salt= UUID.randomUUID().toString().replace("-","");
        String saltPassword= DigestUtils.md5DigestAsHex((salt+password).getBytes());
        String finalPassword=salt+"$"+saltPassword;
        System.out.println("注册后加密完的密码"+finalPassword);
        return finalPassword;
    }
    public static String encrypt(String password,String salt){
        String saltPassword=DigestUtils.md5DigestAsHex((salt+password).getBytes());
        String finalPassword=salt+"$"+saltPassword;
        return finalPassword;
    }
    //3.验证密码
    public static boolean check(String inputPassword,String finalPassword){
        if(StringUtils.hasLength(inputPassword)&& StringUtils.hasLength(finalPassword)&& finalPassword.length()==65){
String salt=finalPassword.split("\\$")[0];
//$符是一个通配符，需要转义
String confirmPassword=PasswordUtils.encrypt(inputPassword,salt);
            System.out.println("验证的字符串是？"+confirmPassword);
return confirmPassword.equals(finalPassword);
        }
        return false;
    }
}
