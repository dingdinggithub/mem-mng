package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.AuthModule;
import com.kevin.mem.mng.domain.mapper.AuthModuleMapper;
import com.kevin.mem.mng.service.AuthModuleService;
import com.kevin.mem.mng.utils.IdGeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 权限模块关系ServiceImpl
 * @author 丁海峰
 * @date 2018-12-11 09:34:05
 */
@Service
@Slf4j
public class AuthModuleServiceImpl implements AuthModuleService{

	@Autowired
    private AuthModuleMapper authModuleMapper;

    @Override
    public int deleteById(Long id) {
        return authModuleMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        authModuleMapper.batchDelete(idList);
    }

    @Override
    public int insert(AuthModule record) {
		record.setId(IdGeneralUtils.generatorId());
        record.setCreateTime(LocalDateTime.now());
        return authModuleMapper.insert(record);
    }

    @Override
    public void batchInsert(List<AuthModule> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
			record.setId(IdGeneralUtils.generatorId());
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            authModuleMapper.insert(record);
        });
    }

    @Override
    public AuthModule selectByCode(Long id) {
        return authModuleMapper.selectById(id);
    }

    @Override
    public int updateById(AuthModule record) {
        record.setUpdateTime(LocalDateTime.now());
        return authModuleMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<AuthModule> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setUpdateTime(LocalDateTime.now());
            authModuleMapper.updateById(record);
        });
    }

    @Override
    public Page<AuthModule> queryPage(PageRequest<AuthModule> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return authModuleMapper.queryPage(record.getModel());
    }

    @Override
    public List<AuthModule> queryAll(AuthModule record) {
        return authModuleMapper.queryPage(record);
    }

}
	