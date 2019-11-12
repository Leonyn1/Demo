package com.example.demo.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.demo.dao.dto.DemoUser;
import com.example.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Leon
 */
@Controller
@RequestMapping(value = "/test")
public class UserController {

    @Autowired
    private IUserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 下载Excel
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = "/downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", DateUtil.date());

        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());

        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(rows, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=test.xls");
        ServletOutputStream outputStream = response.getOutputStream();
        writer.flush(outputStream, true);
        writer.close();
        IoUtil.close(outputStream);
    }

    /**
     * 下载压缩包
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = "/downloadZip")
    public void downloadZip(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition","attachment;filename=test.zip");
        ServletOutputStream outputStream = response.getOutputStream();
        IoUtil.write(outputStream, true, ZipUtil.gzip(ZipUtil.zip("D:\\remain file\\Pictures")));
        outputStream.flush();
        IoUtil.close(outputStream);
    }

    @GetMapping(value = "/listUser")
    @ResponseBody
    public void listUser(){
        try {
            List<DemoUser> demoUserList = userService.listUser();
            Map<String, List<DemoUser>> demoUserListMap = demoUserList.stream().collect(groupingBy(DemoUser::getSex));
            List<DemoUser> demoUserListMan = demoUserListMap.get("1");
            List<DemoUser> demoUserListWoman = demoUserListMap.get("0");
            logger.info("userList:{}", demoUserList);
            logger.info("userListMan:{}", demoUserListMan);
            logger.info("userListWoman:{}", demoUserListWoman);
        } catch (Exception e) {
            logger.error("出现异常：{}", e);
        }
    }

}
