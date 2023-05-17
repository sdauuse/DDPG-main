package com.hmall.order.utils;

import java.util.Map;

/**
 * threalLocal工具类
 */
public class UserThrealLocalUtil {
    //实例化ThreadLocal
    private static final ThreadLocal<Map> userThrealLocal=new ThreadLocal();
    //存入信息
    public static void setUser(Map user){
        userThrealLocal.set(user);
    }
    //取出信息
    public static Map getUser(){
        return userThrealLocal.get();
    }
    //删除信息
    public static void removeUser(){
        userThrealLocal.remove();
    }
}
