package com.cms.modules.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by taifuyu on 17/6/30.
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String email;
    private Integer roleIds;
    private Integer state;
    private String description;
    private Date createtime;
}
