package com.example.demo.service.impl;

import com.example.demo.dao.DemoUserDao;
import com.example.demo.dao.dto.DemoUser;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private DemoUserDao demoUserDao;

    @Override
    public List<DemoUser> listUser() {
        return demoUserDao.selectAll();
    }
}
