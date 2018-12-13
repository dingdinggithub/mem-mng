package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Role;
import com.kevin.mem.mng.domain.entity.RoleUser;
import com.kevin.mem.mng.domain.mapper.RoleMapper;
import com.kevin.mem.mng.domain.mapper.RoleUserMapper;
import com.kevin.mem.mng.service.RoleUserService;
import com.kevin.mem.mng.utils.IdGeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色关系ServiceImpl
 * @author 丁海峰
 * @date 2018-12-11 09:34:06
 */
@Service
@Slf4j
public class RoleUserServiceImpl implements RoleUserService{

	@Autowired
    private RoleUserMapper roleUserMapper;

	@Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteById(Long id) {
        return roleUserMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        roleUserMapper.batchDelete(idList);
    }

    @Override
    public int insert(RoleUser record) {
		record.setId(IdGeneralUtils.generatorId());
        record.setCreateTime(LocalDateTime.now());
        return roleUserMapper.insert(record);
    }

    @Override
    public void batchInsert(List<RoleUser> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
			record.setId(IdGeneralUtils.generatorId());
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            roleUserMapper.insert(record);
        });
    }

    @Override
    public RoleUser selectByCode(Long id) {
        return roleUserMapper.selectById(id);
    }

    @Override
    public int updateById(RoleUser record) {
        record.setUpdateTime(LocalDateTime.now());
        return roleUserMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<RoleUser> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setUpdateTime(LocalDateTime.now());
            roleUserMapper.updateById(record);
        });
    }

    @Override
    public Page<RoleUser> queryPage(PageRequest<RoleUser> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return roleUserMapper.queryPage(record.getModel());
    }

    @Override
    public List<RoleUser> queryAll(RoleUser record) {
        return roleUserMapper.queryPage(record);
    }

    @Override
    public List<Role> queryRoleUnderUser(Long userId) {
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(userId);
        Page<RoleUser> roleUserList = roleUserMapper.queryPage(roleUser);
        if (CollectionUtils.isEmpty(roleUserList)) {
            return Lists.newArrayList();
        }
        List<Long> roleIdList = roleUserList.stream().map(RoleUser::getRoleId).collect(Collectors.toList());
        return roleMapper.queryWithIdList(roleIdList);
    }
}
	