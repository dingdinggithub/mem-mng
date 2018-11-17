package com.kevin.mem.mng.business.impl;


import com.kevin.mem.mng.business.RoleModuleBusiness;
import com.kevin.mem.mng.domain.entity.RoleModule;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.RoleModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleModuleBusinessImpl implements RoleModuleBusiness {

    @Autowired
    private BaseService<RoleModule> baseService;

    @Autowired
    private RoleModuleService roleModuleService;
}
