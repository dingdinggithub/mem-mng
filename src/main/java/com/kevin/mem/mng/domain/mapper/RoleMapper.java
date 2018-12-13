package com.kevin.mem.mng.domain.mapper;

import com.kevin.mem.mng.domain.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:00
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> queryWithIdList(@Param("roleIdList") List<Long> roleIdList);
}