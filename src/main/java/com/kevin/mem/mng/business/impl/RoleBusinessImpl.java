package com.kevin.mem.mng.business.impl;


import com.kevin.mem.mng.business.RoleBusiness;
import com.kevin.mem.mng.domain.entity.Role;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleBusinessImpl implements RoleBusiness {
    @Autowired
    private BaseService<Role> baseService;

    @Autowired
    private RoleService roleService;
}
