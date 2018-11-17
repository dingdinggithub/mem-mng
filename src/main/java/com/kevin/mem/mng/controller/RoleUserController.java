package com.kevin.mem.mng.controller;

import com.kevin.mem.mng.business.RoleUserBusiness;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(description = "角色用户关系管理接口")
public class RoleUserController extends BaseController {
    @Autowired
    private RoleUserBusiness roleUserBusiness;
}
