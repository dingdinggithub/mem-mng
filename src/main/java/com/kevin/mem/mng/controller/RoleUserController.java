package com.kevin.mem.mng.controller;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleUserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.roleUser.*;
import com.kevin.mem.mng.dto.response.roleUser.RoleUserPageResDTO;
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
@RequestMapping("/roleUser")
public class RoleUserController extends BaseController {

    @Autowired
    private RoleUserBusiness roleUserBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertRoleUser")
    @OperatorLog(description = "/insertRoleUser")
    public BaseResponse insertRoleUser(@RequestBody @Validated RoleUserInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleUserBusiness.insertRoleUser(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertRoleUser")
    @OperatorLog(description = "/batchInsertRoleUser")
    public BaseResponse batchInsertRoleUser(@RequestBody @Validated RoleUserBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){

        return roleUserBusiness.batchInsertRoleUser(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateRoleUser")
    @OperatorLog(description = "/updateRoleUser")
    public BaseResponse updateRoleUser(@RequestBody @Validated RoleUserUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleUserBusiness.updateRoleUser(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateRoleUser")
    @OperatorLog(description = "/batchUpdateRoleUser")
    public BaseResponse batchUpdateRoleUser(@RequestBody @Validated RoleUserBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){

        return roleUserBusiness.batchUpdateRoleUser(reqDTO);
    }

    @ApiOperation("刪除接口")
    @PostMapping("/deleteRoleUser")
    @OperatorLog(description = "/deleteRoleUser")
    public BaseResponse deleteRoleUser(@RequestBody @Validated Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleUserBusiness.deleteRoleUser(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteRoleUser")
    @OperatorLog(description = "/batchDeleteRoleUser")
    public BaseResponse batchDeleteRoleUser(@RequestBody @Validated RoleUserBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return roleUserBusiness.batchDeleteRoleUser(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @PostMapping("/queryRoleUser")
    @OperatorLog(description = "/queryRoleUser")
    public BaseResponse queryRoleUser(@RequestBody @Validated Long id){
        return roleUserBusiness.queryRoleUser(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<RoleUserPageResDTO> queryPage(@RequestBody @Validated PageRequest<RoleUserPageReqDTO> pageRequest){
        return roleUserBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<RoleUserPageResDTO>> queryAll(@RequestBody @Validated RoleUserPageReqDTO reqDTO){
        return roleUserBusiness.queryAll(reqDTO);
    }

}
	