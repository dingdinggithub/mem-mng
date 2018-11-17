package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.mapper.BaseMapper;
import com.kevin.mem.mng.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    BaseMapper<T> baseMapper;

    @Override
    public int deleteByCode(Long id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public T selectByCode(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<T> queryPage(PageRequest<T> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return baseMapper.queryPage(record.getModel());
    }


}
