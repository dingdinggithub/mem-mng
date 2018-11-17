package com.kevin.mem.mng.service.impl;


import com.kevin.mem.mng.domain.mapper.RoleMapper;
import com.kevin.mem.mng.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
}
