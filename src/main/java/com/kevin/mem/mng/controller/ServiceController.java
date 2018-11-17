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

    @Autowired
    private Mapper mapper;

    @Autowired
    private DataSource dataSource;

    /**
     * 测试插入数据库表接口
     *
     * @return String
     */
    @ApiOperation("分页查询数据库表数据接口")
    @PostMapping("/listUser")
    @OperatorLog(description = "/listUser")
    public BaseResponse listTest(@RequestBody PageRequest pageRequest){
        log.info("分页查找开始");
        return null;//BaseResponse.createSuccessResult(userService.listUser(pageRequest));
    }

    /**
     * 测试插入数据库表接口
     *
     * @return String
     */
    @ApiOperation("测试插入数据库表接口")
    @PostMapping("/insertUser")
    @OperatorLog(description = "/insertUser")
    public BaseResponse insertTest(@RequestBody @Validated User user){
        return null;//BaseResponse.createSuccessResult(userService.insert(user));
    }

    /**
     * 数据库连接测试
     *
     * @return String
     */
    @ApiOperation("数据库连接测试接口")
    @GetMapping("/connectMysql")
    public BaseResponse connectMysql() throws Exception{
        Connection connection = dataSource.getConnection();
        return BaseResponse.createSuccessResult(connection);
    }

    /**
     * 获取列表内容接口
     *
     * @return String
     */
    @ApiOperation("获取列表内容接口")
    @GetMapping("/getArray")
    public BaseResponse getArray(){
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("First-Name");
        strArr.add("Second-Name");
        return BaseResponse.createSuccessResult(strArr);
    }

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
