package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.ModuleBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.module.*;
import com.kevin.mem.mng.dto.response.module.ModulePageResDTO;
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
@RequestMapping("/module")
public class ModuleController extends BaseController {

    @Autowired
    private ModuleBusiness moduleBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertModule")
    @OperatorLog(description = "/insertModule")
    public BaseResponse insertModule(@RequestBody @Validated ModuleInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return moduleBusiness.insertModule(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertModule")
    @OperatorLog(description = "/batchInsertModule")
    public BaseResponse batchInsertModule(@RequestBody @Validated ModuleBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return moduleBusiness.batchInsertModule(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateModule")
    @OperatorLog(description = "/updateModule")
    public BaseResponse updateModule(@RequestBody @Validated ModuleUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return moduleBusiness.updateModule(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateModule")
    @OperatorLog(description = "/batchUpdateModule")
    public BaseResponse batchUpdateModule(@RequestBody @Validated ModuleBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return moduleBusiness.batchUpdateModule(reqDTO);
    }

    @ApiOperation("刪除接口")
    @PostMapping("/deleteModule")
    @OperatorLog(description = "/deleteModule")
    public BaseResponse deleteModule(@RequestBody @Validated Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return moduleBusiness.deleteModule(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteModule")
    @OperatorLog(description = "/batchDeleteModule")
    public BaseResponse batchDeleteModule(@RequestBody @Validated ModuleBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return moduleBusiness.batchDeleteModule(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @PostMapping("/queryModule")
    @OperatorLog(description = "/queryModule")
    public BaseResponse queryModule(@RequestBody @Validated Long id) {
        return moduleBusiness.queryModule(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<ModulePageResDTO> queryPage(@RequestBody @Validated PageRequest<ModulePageReqDTO> pageRequest) {
        return moduleBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<ModulePageResDTO>> queryAll(@RequestBody @Validated ModulePageReqDTO reqDTO) {
        return moduleBusiness.queryAll(reqDTO);
    }

}
	