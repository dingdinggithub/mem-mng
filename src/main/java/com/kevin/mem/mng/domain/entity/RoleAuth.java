package com.kevin.mem.mng.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色权限关系Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:01
 */
@Data
@NoArgsConstructor
public class RoleAuth extends BaseEntity {

    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 权限Id
     */
    private Long authId;

    public RoleAuth(Long roleId) {
        this.roleId = roleId;
    }
}
	