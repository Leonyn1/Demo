package com.example.demo.controller;

import com.example.demo.dao.DemoUserDao;
import com.example.demo.dao.dto.DemoUser;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Leon
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private DemoUserDao userDao;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/info/id/{id}", method = RequestMethod.GET)
    public Result<?> queryUser(@PathVariable("id") Integer id){
        return ResultGenerator.genSuccessResult(userService.getUser(id));
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Result<?> saveUser(@RequestBody DemoUser user){
        userService.saveUser(user);
        return ResultGenerator.genSuccessResult(user.getId());
    }

    @RequestMapping(value = "/info/id/{id}", method = RequestMethod.DELETE)
    public Result<?> deleteUser(@PathVariable("id") Integer id){
        userDao.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

}
