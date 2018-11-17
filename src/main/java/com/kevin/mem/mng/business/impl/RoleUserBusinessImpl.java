package com.kevin.mem.mng.business.impl;


import com.kevin.mem.mng.business.RoleUserBusiness;
import com.kevin.mem.mng.domain.entity.RoleUser;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.RoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleUserBusinessImpl implements RoleUserBusiness {

    @Autowired
    private BaseService<RoleUser> baseService;

    @Autowired
    private RoleUserService roleUserService;
}
