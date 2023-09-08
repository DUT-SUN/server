package com.kemi.actable.common;

import com.kemi.actable.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 功能描述 当前登录用户相关的操作
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/05/15  10:26
 */
public class UserSessionUtils {
    /**
    * @explain 得到当前登录用户
    * @param request
    * @return com.kemi.actable.entity.User
    * @author DUT-SUN
    * @date   2023/5/15
    */
   public static User getSessUser(HttpServletRequest request){
       HttpSession session=request.getSession(false);
       if(session!=null && session.getAttribute(AppVarible.USER_SESSION_KEY)!=null){
           return (User)session.getAttribute(AppVarible.USER_SESSION_KEY);
       }
       return null;
   }
}
