package com.kevin.mem.mng.business.impl;


import com.kevin.mem.mng.business.ModuleBusiness;
import com.kevin.mem.mng.domain.entity.Module;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ModuleBusinessImpl implements ModuleBusiness {

    @Autowired
    private BaseService<Module> baseService;

    @Autowired
    private ModuleService moduleService;
}
