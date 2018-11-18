package com.kevin.mem.mng.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.domain.mapper.UserMapper;
import com.kevin.mem.mng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        userMapper.batchDelete(idList);
    }

    @Override
    public int insert(User record) {
        record.setCreateTime(LocalDateTime.now());
        return userMapper.insert(record);
    }

    @Override
    public void batchInsert(List<User> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            userMapper.insert(record);
        });
    }

    @Override
    public User selectByCode(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public int updateById(User record) {
        record.setUpdateTime(LocalDateTime.now());
        return userMapper.updateById(record);
    }

    @Override
    public void batchUpdate(List<User> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
            record.setUpdateTime(LocalDateTime.now());
            userMapper.updateById(record);
        });
    }

    @Override
    public Page<User> queryPage(PageRequest<User> record) {
        PageHelper.startPage(record.getPageIndex(), record.getPageSize());
        return userMapper.queryPage(record.getModel());
    }

    @Override
    public List<User> queryAll(User record) {
        return userMapper.queryPage(record);
    }
}
