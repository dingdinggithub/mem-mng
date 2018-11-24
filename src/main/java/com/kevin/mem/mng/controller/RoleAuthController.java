package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleAuthBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.roleAuth.*;
import com.kevin.mem.mng.dto.response.roleAuth.RoleAuthPageResDTO;
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
@RequestMapping("/roleAuth")
public class RoleAuthController extends BaseController {

    @Autowired
    private RoleAuthBusiness roleAuthBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertRoleAuth")
    @OperatorLog(description = "/insertRoleAuth")
    public BaseResponse insertRoleAuth(@RequestBody @Validated RoleAuthInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return roleAuthBusiness.insertRoleAuth(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertRoleAuth")
    @OperatorLog(description = "/batchInsertRoleAuth")
    public BaseResponse batchInsertRoleAuth(@RequestBody @Validated RoleAuthBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return roleAuthBusiness.batchInsertRoleAuth(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateRoleAuth")
    @OperatorLog(description = "/updateRoleAuth")
    public BaseResponse updateRoleAuth(@RequestBody @Validated RoleAuthUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return roleAuthBusiness.updateRoleAuth(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateRoleAuth")
    @OperatorLog(description = "/batchUpdateRoleAuth")
    public BaseResponse batchUpdateRoleAuth(@RequestBody @Validated RoleAuthBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {

        return roleAuthBusiness.batchUpdateRoleAuth(reqDTO);
    }

    @ApiOperation("刪除接口")
    @PostMapping("/deleteRoleAuth")
    @OperatorLog(description = "/deleteRoleAuth")
    public BaseResponse deleteRoleAuth(@RequestBody @Validated Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return roleAuthBusiness.deleteRoleAuth(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteRoleAuth")
    @OperatorLog(description = "/batchDeleteRoleAuth")
    public BaseResponse batchDeleteRoleAuth(@RequestBody @Validated RoleAuthBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName) {
        return roleAuthBusiness.batchDeleteRoleAuth(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @PostMapping("/queryRoleAuth")
    @OperatorLog(description = "/queryRoleAuth")
    public BaseResponse queryRoleAuth(@RequestBody @Validated Long id) {
        return roleAuthBusiness.queryRoleAuth(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<RoleAuthPageResDTO> queryPage(@RequestBody @Validated PageRequest<RoleAuthPageReqDTO> pageRequest) {
        return roleAuthBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<RoleAuthPageResDTO>> queryAll(@RequestBody @Validated RoleAuthPageReqDTO reqDTO) {
        return roleAuthBusiness.queryAll(reqDTO);
    }

}
	