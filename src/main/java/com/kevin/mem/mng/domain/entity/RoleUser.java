package com.kevin.mem.mng.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色关系Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:01
 */
@Data
@NoArgsConstructor
public class RoleUser extends BaseEntity {

    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 用户Id
     */
    private Long userId;

    public RoleUser(Long userId) {
        this.userId = userId;
    }
}
	