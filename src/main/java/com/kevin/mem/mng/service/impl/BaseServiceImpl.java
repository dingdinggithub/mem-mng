package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.BaseEntity;
import com.kevin.mem.mng.domain.mapper.BaseMapper;
import com.kevin.mem.mng.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    BaseMapper<T> baseMapper;

    @Override
    public int deleteById(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int insert(T record) {
        record.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(record);
    }

    @Override
    public int batchInsert(List<T> record) {
        return baseMapper.batchInsert(record);
    }

    @Override
    public T selectByCode(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        record.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(record);
    }

    @Override
    public Page<T> queryPage(PageRequest<T> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return baseMapper.queryPage(record.getModel());
    }


}
