package com.kevin.mem.mng.domain.entity;

import lombok.Data;

@Data
public class User extends BaseEntity {

    private String userCode;

    private String username;

    private String password;

    private Integer status;

}