package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户PageReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:02
 */
@Data
public class UserPageReqDTO implements Serializable, DTO {

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
	