package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.mem.mng.business.ModuleBusiness;
import com.kevin.mem.mng.common.log.OperatorLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(description = "模块管理接口")
public class ModuleController extends BaseController {

    @Autowired
    private ModuleBusiness moduleBusiness;

    @ApiOperation("测试接口")
    @PostMapping("/test")
    @OperatorLog(description = "/test")
    public BaseResponse test(){
        log.info("test");
        return null;
    }
}
