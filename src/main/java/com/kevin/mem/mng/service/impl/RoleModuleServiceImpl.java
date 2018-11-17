package com.kevin.mem.mng.service.impl;


import com.kevin.mem.mng.domain.mapper.RoleModuleMapper;
import com.kevin.mem.mng.service.RoleModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleModuleServiceImpl implements RoleModuleService {

    @Autowired
    private RoleModuleMapper roleModuleMapper;
}
