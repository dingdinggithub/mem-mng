package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.RoleAuth;
import com.kevin.mem.mng.domain.mapper.RoleAuthMapper;
import com.kevin.mem.mng.service.RoleAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 角色权限关系ServiceImpl
 * @author 丁海峰
 * @date 2018-11-24 02:37:25
 */
@Service
@Slf4j
public class RoleAuthServiceImpl implements RoleAuthService{

	@Autowired
    private RoleAuthMapper roleAuthMapper;

    @Override
    public int deleteById(Long id) {
        return roleAuthMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        roleAuthMapper.batchDelete(idList);
    }

    @Override
    public int insert(RoleAuth record) {
        record.setCreateTime(LocalDateTime.now());
        return roleAuthMapper.insert(record);
    }

    @Override
    public void batchInsert(List<RoleAuth> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            roleAuthMapper.insert(record);
        });
    }

    @Override
    public RoleAuth selectByCode(Long id) {
        return roleAuthMapper.selectById(id);
    }

    @Override
    public int updateById(RoleAuth record) {
        record.setUpdateTime(LocalDateTime.now());
        return roleAuthMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<RoleAuth> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setUpdateTime(LocalDateTime.now());
            roleAuthMapper.updateById(record);
        });
    }

    @Override
    public Page<RoleAuth> queryPage(PageRequest<RoleAuth> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return roleAuthMapper.queryPage(record.getModel());
    }

    @Override
    public List<RoleAuth> queryAll(RoleAuth record) {
        return roleAuthMapper.queryPage(record);
    }

}
	