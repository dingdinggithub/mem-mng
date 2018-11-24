package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Role;
import com.kevin.mem.mng.domain.mapper.RoleMapper;
import com.kevin.mem.mng.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 角色ServiceImpl
 * @author 丁海峰
 * @date 2018-11-24 02:37:24
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService{

	@Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteById(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        roleMapper.batchDelete(idList);
    }

    @Override
    public int insert(Role record) {
        record.setCreateTime(LocalDateTime.now());
        return roleMapper.insert(record);
    }

    @Override
    public void batchInsert(List<Role> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            roleMapper.insert(record);
        });
    }

    @Override
    public Role selectByCode(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int updateById(Role record) {
        record.setUpdateTime(LocalDateTime.now());
        return roleMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<Role> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setUpdateTime(LocalDateTime.now());
            roleMapper.updateById(record);
        });
    }

    @Override
    public Page<Role> queryPage(PageRequest<Role> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return roleMapper.queryPage(record.getModel());
    }

    @Override
    public List<Role> queryAll(Role record) {
        return roleMapper.queryPage(record);
    }

}
	