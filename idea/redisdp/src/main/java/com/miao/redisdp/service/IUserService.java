package com.miao.redisdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.redisdp.dto.LoginFormDTO;
import com.miao.redisdp.dto.Result;
import com.miao.redisdp.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
