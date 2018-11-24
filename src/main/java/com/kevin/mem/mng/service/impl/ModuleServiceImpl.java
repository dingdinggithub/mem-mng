package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Module;
import com.kevin.mem.mng.domain.mapper.ModuleMapper;
import com.kevin.mem.mng.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 模块ServiceImpl
 * @author 丁海峰
 * @date 2018-11-24 02:37:24
 */
@Service
@Slf4j
public class ModuleServiceImpl implements ModuleService{

	@Autowired
    private ModuleMapper moduleMapper;

    @Override
    public int deleteById(Long id) {
        return moduleMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        moduleMapper.batchDelete(idList);
    }

    @Override
    public int insert(Module record) {
        record.setCreateTime(LocalDateTime.now());
        return moduleMapper.insert(record);
    }

    @Override
    public void batchInsert(List<Module> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            moduleMapper.insert(record);
        });
    }

    @Override
    public Module selectByCode(Long id) {
        return moduleMapper.selectById(id);
    }

    @Override
    public int updateById(Module record) {
        record.setUpdateTime(LocalDateTime.now());
        return moduleMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<Module> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setUpdateTime(LocalDateTime.now());
            moduleMapper.updateById(record);
        });
    }

    @Override
    public Page<Module> queryPage(PageRequest<Module> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return moduleMapper.queryPage(record.getModel());
    }

    @Override
    public List<Module> queryAll(Module record) {
        return moduleMapper.queryPage(record);
    }

}
	