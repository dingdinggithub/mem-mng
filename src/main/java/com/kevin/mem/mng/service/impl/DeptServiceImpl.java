package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Dept;
import com.kevin.mem.mng.domain.mapper.DeptMapper;
import com.kevin.mem.mng.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 部门ServiceImpl
 *
 * @author 丁海峰
 * @date 2018-11-24 02:37:26
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int deleteById(Long id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        deptMapper.batchDelete(idList);
    }

    @Override
    public int insert(Dept record) {
        record.setCreateTime(LocalDateTime.now());
        return deptMapper.insert(record);
    }

    @Override
    public void batchInsert(List<Dept> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return;
        }

        recordList.forEach(record -> {
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            deptMapper.insert(record);
        });
    }

    @Override
    public Dept selectByCode(Long id) {
        return deptMapper.selectById(id);
    }

    @Override
    public int updateById(Dept record) {
        record.setUpdateTime(LocalDateTime.now());
        return deptMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<Dept> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return;
        }

        recordList.forEach(record -> {
            record.setUpdateTime(LocalDateTime.now());
            deptMapper.updateById(record);
        });
    }

    @Override
    public Page<Dept> queryPage(PageRequest<Dept> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return deptMapper.queryPage(record.getModel());
    }

    @Override
    public List<Dept> queryAll(Dept record) {
        return deptMapper.queryPage(record);
    }

}
	