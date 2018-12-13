package com.kevin.mem.mng.service;

import com.kevin.mem.mng.domain.entity.Role;
import com.kevin.mem.mng.domain.entity.RoleUser;

import java.util.List;

/**
 * 用户角色关系Service
 * @author 丁海峰
 * @date 2018-12-11 09:34:06
 */
public interface RoleUserService extends BaseService<RoleUser>{
    /**
     * 查询用户下的角色
     * @param userId
     * @return
     */
    List<Role> queryRoleUnderUser(Long userId);
}
	