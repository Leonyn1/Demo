package com.example.demo.dao.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * demo_user
 * @author leon
 */
public class DemoUser implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 用户名(唯一约束)
     */
    private String name;

    /**
     * 性别 1-男 0-女 2-外星人
     */
    private String sex;

    private int age;

    private int height;

    /**
     * 备注
     */
    private String remark;

    /**
     * 加入时间
     */
    private Date joinTime;

    private double num;

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public String toString() {
        return "DemoUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", remark='" + remark + '\'' +
                ", joinTime=" + joinTime +
                '}';
    }
}