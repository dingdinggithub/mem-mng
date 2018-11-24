package com.kevin.mem.mng.domain.entity;

import lombok.Data;

/**
 * 角色Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:00
 */
@Data
public class Role extends BaseEntity {

    /**
     * 类型名
     */
    private String name;
    /**
     * 角色的类型，1：管理员角色，2：其他
     */
    private Integer type;
    /**
     * 状态
     */
    private Integer status;

}
	