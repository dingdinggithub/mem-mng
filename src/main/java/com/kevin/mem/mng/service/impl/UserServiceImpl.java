package com.kevin.mem.mng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.RoleUser;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.domain.mapper.RoleUserMapper;
import com.kevin.mem.mng.domain.mapper.UserMapper;
import com.kevin.mem.mng.service.UserService;
import com.kevin.mem.mng.utils.IdGeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户ServiceImpl
 * @author 丁海峰
 * @date 2018-12-11 09:34:03
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public int deleteById(Long id) {

        Page<RoleUser> roleUserPage = roleUserMapper.queryPage(new RoleUser(id));
        if (CollectionUtils.isNotEmpty(roleUserPage)) {
            roleUserMapper.batchDelete(roleUserPage.stream().map(RoleUser::getId).collect(Collectors.toList()));
        }

        return userMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        userMapper.batchDelete(idList);
    }

    @Override
    public int insert(User record) {
		record.setId(IdGeneralUtils.generatorId());
        record.setCreateTime(LocalDateTime.now());
        return userMapper.insert(record);
    }

    @Override
    public void batchInsert(List<User> recordList) {

        if (CollectionUtils.isEmpty(recordList)) {
            return ;
        }

        recordList.forEach(record-> {
			record.setId(IdGeneralUtils.generatorId());
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            userMapper.insert(record);
        });
    }

    @Override
    public User selectByCode(Long id) {
        User user = userMapper.selectById(id);
        user.setPassword(StringUtils.EMPTY);
        return user;
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
        Page<User> userPage = userMapper.queryPage(record.getModel());
        userPage.forEach(item-> item.setPassword(StringUtils.EMPTY));
        return userPage;
    }

    @Override
    public List<User> queryAll(User record) {
        Page<User> pageUser = userMapper.queryPage(record);
        pageUser.forEach(item-> item.setPassword(StringUtils.EMPTY));
        return pageUser;
    }

}
	