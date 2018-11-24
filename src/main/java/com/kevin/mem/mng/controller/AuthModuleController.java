package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.AuthModuleBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.authModule.*;
import com.kevin.mem.mng.dto.response.authModule.AuthModulePageResDTO;
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
@Api(description = "管理接口")
@RequestMapping("/authModule")
public class AuthModuleController extends BaseController {

    @Autowired
    private AuthModuleBusiness authModuleBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertAuthModule")
    @OperatorLog(description = "/insertAuthModule")
    public BaseResponse insertAuthModule(@RequestBody @Validated AuthModuleInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return authModuleBusiness.insertAuthModule(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertAuthModule")
    @OperatorLog(description = "/batchInsertAuthModule")
    public BaseResponse batchInsertAuthModule(@RequestBody @Validated AuthModuleBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return authModuleBusiness.batchInsertAuthModule(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateAuthModule")
    @OperatorLog(description = "/updateAuthModule")
    public BaseResponse updateAuthModule(@RequestBody @Validated AuthModuleUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return authModuleBusiness.updateAuthModule(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateAuthModule")
    @OperatorLog(description = "/batchUpdateAuthModule")
    public BaseResponse batchUpdateAuthModule(@RequestBody @Validated AuthModuleBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return authModuleBusiness.batchUpdateAuthModule(reqDTO);
    }

    @ApiOperation("刪除接口")
    @PostMapping("/deleteAuthModule")
    @OperatorLog(description = "/deleteAuthModule")
    public BaseResponse deleteAuthModule(@RequestBody @Validated Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return authModuleBusiness.deleteAuthModule(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteAuthModule")
    @OperatorLog(description = "/batchDeleteAuthModule")
    public BaseResponse batchDeleteAuthModule(@RequestBody @Validated AuthModuleBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return authModuleBusiness.batchDeleteAuthModule(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @PostMapping("/queryAuthModule")
    @OperatorLog(description = "/queryAuthModule")
    public BaseResponse queryAuthModule(@RequestBody @Validated Long id) {
        return authModuleBusiness.queryAuthModule(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<AuthModulePageResDTO> queryPage(@RequestBody @Validated PageRequest<AuthModulePageReqDTO> pageRequest) {
        return authModuleBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<AuthModulePageResDTO>> queryAll(@RequestBody @Validated AuthModulePageReqDTO reqDTO) {
        return authModuleBusiness.queryAll(reqDTO);
    }

}
	