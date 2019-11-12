package com.example.demo.service;

import com.example.demo.dao.dto.DemoUser;

import java.util.List;

/**
 * @author Leon
 */
public interface IUserService {

    /**
     * 获取全部用户信息
     * @return {@link List<DemoUser>}
     */
    List<DemoUser> listUser();

}
