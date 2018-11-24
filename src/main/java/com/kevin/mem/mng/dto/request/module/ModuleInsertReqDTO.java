package com.kevin.mem.mng.dto.request.module;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 模块InsertReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class ModuleInsertReqDTO implements Serializable, DTO {

    /**
     * 权限模块名称
     */
    @NotNull
    private String name;
    /**
     * 上级权限模块id
     */
    @NotNull
    private Long parentId;
    /**
     * 权限模块层级
     */
    @NotNull
    private String level;
    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    @NotNull
    private Integer seq;
    /**
     * 状态，1：正常，0：冻结
     */
    @NotNull
    private Integer status;

}
	