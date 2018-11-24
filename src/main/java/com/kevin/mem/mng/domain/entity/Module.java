package com.kevin.mem.mng.domain.entity;

import lombok.Data;

/**
 * 模块Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:00
 */
@Data
public class Module extends BaseEntity {

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

}
	