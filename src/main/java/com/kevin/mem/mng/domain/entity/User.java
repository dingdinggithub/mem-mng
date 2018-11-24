package com.kevin.mem.mng.domain.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户Entity
 * @author 丁海峰
 * @date 2018-11-24 02:21:59
 */
 @Data
public class User extends BaseEntity {
	
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户状态
	 */
	private Integer status;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String mail;
	/**
	 * 部门id
	 */
	private Long deptId;
	
}
	