package com.kevin.mem.mng.service.impl;


import com.kevin.mem.mng.domain.mapper.RoleUserMapper;
import com.kevin.mem.mng.service.RoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;
}
