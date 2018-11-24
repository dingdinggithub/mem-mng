package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.DeptBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.dept.*;
import com.kevin.mem.mng.dto.response.dept.DeptPageResDTO;
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
@RequestMapping("/dept")
public class DeptController extends BaseController {

    @Autowired
    private DeptBusiness deptBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertDept")
    @OperatorLog(description = "/insertDept")
    public BaseResponse insertDept(@RequestBody @Validated DeptInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return deptBusiness.insertDept(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertDept")
    @OperatorLog(description = "/batchInsertDept")
    public BaseResponse batchInsertDept(@RequestBody @Validated DeptBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return deptBusiness.batchInsertDept(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateDept")
    @OperatorLog(description = "/updateDept")
    public BaseResponse updateDept(@RequestBody @Validated DeptUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return deptBusiness.updateDept(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateDept")
    @OperatorLog(description = "/batchUpdateDept")
    public BaseResponse batchUpdateDept(@RequestBody @Validated DeptBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return deptBusiness.batchUpdateDept(reqDTO);
    }

    @ApiOperation("刪除接口")
    @PostMapping("/deleteDept")
    @OperatorLog(description = "/deleteDept")
    public BaseResponse deleteDept(@RequestBody @Validated Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return deptBusiness.deleteDept(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteDept")
    @OperatorLog(description = "/batchDeleteDept")
    public BaseResponse batchDeleteDept(@RequestBody @Validated DeptBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return deptBusiness.batchDeleteDept(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @PostMapping("/queryDept")
    @OperatorLog(description = "/queryDept")
    public BaseResponse queryDept(@RequestBody @Validated Long id) {
        return deptBusiness.queryDept(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<DeptPageResDTO> queryPage(@RequestBody @Validated PageRequest<DeptPageReqDTO> pageRequest) {
        return deptBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<DeptPageResDTO>> queryAll(@RequestBody @Validated DeptPageReqDTO reqDTO) {
        return deptBusiness.queryAll(reqDTO);
    }

}
	