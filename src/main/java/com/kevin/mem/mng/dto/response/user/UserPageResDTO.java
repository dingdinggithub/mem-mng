package com.kevin.mem.mng.dto.response.user;

import com.kevin.common.domain.dto.DTO;
import com.kevin.mem.mng.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户PageResDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:48
 */
@Data
public class UserPageResDTO implements Serializable, DTO {
    /**
     * 主键
     */
    private Long id;

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
     * 用户状态
     */
    private String statusDesc;

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
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否已删除
     */
    private Integer isDeleted;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public void setStatus(Integer status) {
        this.status = status;
        this.setStatusDesc(StatusEnum.getDesc(this.status));
    }
}
	