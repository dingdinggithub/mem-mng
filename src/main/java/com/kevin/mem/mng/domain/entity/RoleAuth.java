package com.kevin.mem.mng.domain.entity;

import lombok.Data;

/**
 * 角色权限关系Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:01
 */
@Data
public class RoleAuth extends BaseEntity {

    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 权限Id
     */
    private Long authId;


}
	