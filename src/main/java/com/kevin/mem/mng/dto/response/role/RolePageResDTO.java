package com.kevin.mem.mng.dto.response.role;

import com.kevin.common.domain.dto.DTO;
import com.kevin.mem.mng.enums.RoleTypeEnum;
import com.kevin.mem.mng.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色PageResDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:49
 */
@Data
public class RolePageResDTO implements Serializable, DTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 类型名
     */
    private String name;
    /**
     * 角色的类型，1：管理员角色，2：其他
     */
    private Integer type;

    /**
     * 角色的类型，1：管理员角色，2：其他
     */
    private String typeDesc;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 状态
     */
    private String statusDesc;
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

    public void setType(Integer type) {
        this.type = type;
        this.typeDesc = RoleTypeEnum.getDesc(type);
    }

    public void setStatus(Integer status) {
        this.status = status;
        this.statusDesc = StatusEnum.getDesc(this.status);
    }

}
	