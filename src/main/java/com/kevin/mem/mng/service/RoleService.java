package com.kevin.mem.mng.service;

import com.kevin.mem.mng.domain.entity.*;

import java.util.List;

/**
 * 角色Service
 * @author 丁海峰
 * @date 2018-12-11 09:34:05
 */
public interface RoleService extends BaseService<Role>{
	List<Role> queryWithIdList(List<Long> idList);
}
	