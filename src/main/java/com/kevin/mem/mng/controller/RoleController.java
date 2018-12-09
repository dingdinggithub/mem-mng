package com.kevin.mem.mng.controller;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.role.*;
import com.kevin.mem.mng.dto.response.role.RolePageResDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kevin.mem.mng.dto.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Slf4j
@Api(description = "管理接口")
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleBusiness roleBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertRole")
    @OperatorLog(description = "/insertRole")
    public BaseResponse insertRole(@RequestBody @Validated RoleInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleBusiness.insertRole(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertRole")
    @OperatorLog(description = "/batchInsertRole")
    public BaseResponse batchInsertRole(@RequestBody @Validated RoleBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){

        return roleBusiness.batchInsertRole(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateRole")
    @OperatorLog(description = "/updateRole")
    public BaseResponse updateRole(@RequestBody @Validated RoleUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleBusiness.updateRole(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateRole")
    @OperatorLog(description = "/batchUpdateRole")
    public BaseResponse batchUpdateRole(@RequestBody @Validated RoleBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){

        return roleBusiness.batchUpdateRole(reqDTO);
    }

    @ApiOperation("刪除接口")
    @GetMapping("/deleteRole")
    @OperatorLog(description = "/deleteRole")
    public BaseResponse deleteRole(Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleBusiness.deleteRole(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteRole")
    @OperatorLog(description = "/batchDeleteRole")
    public BaseResponse batchDeleteRole(@RequestBody @Validated RoleBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleBusiness.batchDeleteRole(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @GetMapping("/queryRole")
    @OperatorLog(description = "/queryRole")
    public BaseResponse queryRole(Long id){
        return roleBusiness.queryRole(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<RolePageResDTO> queryPage(@RequestBody @Validated PageRequest<RolePageReqDTO> pageRequest){
        return roleBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<RolePageResDTO>> queryAll(@RequestBody @Validated RolePageReqDTO reqDTO){
        return roleBusiness.queryAll(reqDTO);
    }

}
	