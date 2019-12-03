package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.dao.DemoUserDao;
import com.example.demo.dao.dto.DemoUser;
import com.example.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Leon
 */
@Service
public class UserServiceImpl implements IUserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private DemoUserDao demoUserDao;

    @Override
    public List<DemoUser> listUser() {
        return demoUserDao.selectAll();
    }

    @Override
    public DemoUser getUser(Integer id) {
        return demoUserDao.selectByPrimaryKey(id);
    }

    @Override
    public void saveUser(DemoUser demoUser) {
        demoUserDao.insertSelective(demoUser);
    }

    @Override
    public void sessionTest() {
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        String sessionTest = ObjectUtil.defaultIfNull(session.getAttribute("sessionTest"), "2").toString();
        logger.info(sessionTest);
    }
}
