package com.banyi.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别,1:男, 2:女
     */
    private Integer gender;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号/护照号
     */
    private String passport;

    /**
     * 参与者,1: 参与者, 2: 媒体, 3: 外交官
     */
    private Integer participant;

    /**
     * 场合, 1: 第一场11:00-13:00,2: 第二场13:30-16:00,3: 第三场16:00-18:30
     */
    private String occasion;

    private static final long serialVersionUID = 1L;


}