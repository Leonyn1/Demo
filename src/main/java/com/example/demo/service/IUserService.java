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

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return {@link List<DemoUser>}
     */
    DemoUser getUser(Integer id);

    /**
     * 插入用户信息
     * @param demoUser 用户信息
     */
    void saveUser(DemoUser demoUser);

    /**
     * sessionTest
     */
    void sessionTest();

}
