package com.kevin.mem.mng.controller;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.ModuleBusiness;
import com.kevin.mem.mng.business.RoleBusiness;
import com.kevin.mem.mng.business.RoleUserBusiness;
import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.UpdateTreeReqDTO;
import com.kevin.mem.mng.dto.request.user.*;
import com.kevin.mem.mng.dto.response.UpdateTreeAuthListResDTO;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;
import com.kevin.mem.mng.enums.AuthTypeEnum;
import com.kevin.mem.mng.enums.RoleTypeEnum;
import com.kevin.mem.mng.enums.StatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(description = "系统字典接口")
@RequestMapping("/dict")
public class DictionaryController extends BaseController {

    @Autowired
    private ModuleBusiness moduleBusiness;

    @ApiOperation("获取状态字典接口")
    @GetMapping("/getStatus")
    @OperatorLog(description = "/getStatus")
    public BaseResponse getStatus(){
        return BaseResponse.createSuccessResult(StatusEnum.getList());
    }


    @ApiOperation("获取角色类型字典接口")
    @GetMapping("/getRoleType")
    @OperatorLog(description = "/getRoleType")
    public BaseResponse getRoleType(){
        return BaseResponse.createSuccessResult(RoleTypeEnum.getList());
    }

    @ApiOperation("获取权限类型字典接口")
    @GetMapping("/getAuthType")
    @OperatorLog(description = "/getAuthType")
    public BaseResponse getAuthType(){
        return BaseResponse.createSuccessResult(AuthTypeEnum.getList());
    }

    @ApiOperation("获取模块字典接口")
    @GetMapping("/getModule")
    @OperatorLog(description = "/getModule")
    public BaseResponse getModule(){
        return BaseResponse.createSuccessResult(moduleBusiness.dircModule());
    }

}
	