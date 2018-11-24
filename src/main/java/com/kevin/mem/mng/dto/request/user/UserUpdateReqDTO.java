package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户UpdateReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:48
 */
@Data
public class UserUpdateReqDTO implements Serializable, DTO {

    /**
     * 用户名
     */
    @NotNull
    private String username;
    /**
     * 用户密码
     */
    @NotNull
    private String password;
    /**
     * 用户状态
     */
    @NotNull
    private Integer status;
    /**
     * 手机号
     */
    @NotNull
    private String telephone;
    /**
     * 邮箱
     */
    @NotNull
    private String mail;
    /**
     * 部门id
     */
    @NotNull
    private Long deptId;

}
	