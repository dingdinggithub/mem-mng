package com.kevin.mem.mng.dto.response.module;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 模块PageResDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class ModulePageResDTO implements Serializable, DTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限模块名称
     */
    private String name;
    /**
     * 上级权限模块id
     */
    private Long parentId;
    /**
     * 权限模块层级
     */
    private String level;
    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    private Integer seq;
    /**
     * 状态，1：正常，0：冻结
     */
    private Integer status;
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

}
	