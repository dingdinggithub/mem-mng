package com.kevin.mem.mng.domain.entity;

import lombok.Data;

/**
 * 部门Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:02
 */
@Data
public class Dept extends BaseEntity {

    /**
     * 部门名称
     */
    private String name;
    /**
     * 上级部门id
     */
    private Long parentId;
    /**
     * 部门层级
     */
    private String level;
    /**
     * 部门在当前层级下的顺序
     */
    private Integer seq;

}
	