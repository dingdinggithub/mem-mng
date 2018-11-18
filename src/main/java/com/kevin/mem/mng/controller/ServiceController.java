package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.domain.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

@RestController
@Slf4j
@Api(description = "服务接口")
public class ServiceController extends BaseController{

    /**
     * 打印日志接口
     *
     * @return String
     */
    @ApiOperation("打印日志接口")
    @GetMapping("/printLog")
    public BaseResponse printLog(){
        log.info("基本信息");
        log.warn("警告信息");
        log.error("出现严重错误!");
        return BaseResponse.createSuccessResult(null);
    }
}
