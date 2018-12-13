package com.kevin.mem.mng.controller;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleBusiness;
import com.kevin.mem.mng.business.RoleUserBusiness;
import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.role.RolePageReqDTO;
import com.kevin.mem.mng.dto.request.roleUser.RoleUserPageReqDTO;
import com.kevin.mem.mng.dto.request.user.*;
import com.kevin.mem.mng.dto.response.TreeDataDTO;
import com.kevin.mem.mng.dto.response.role.RolePageResDTO;
import com.kevin.mem.mng.dto.response.roleUser.RoleUserPageResDTO;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;
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
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    private RoleUserBusiness roleUserBusiness;

    @Autowired
    private RoleBusiness roleBusiness;

    @ApiOperation("插入接口")
    @PostMapping("/insertUser")
    @OperatorLog(description = "/insertUser")
    public BaseResponse insertUser(@RequestBody @Validated UserInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.insertUser(reqDTO);
    }

    @ApiOperation("批量插入接口")
    @PostMapping("/batchInsertUser")
    @OperatorLog(description = "/batchInsertUser")
    public BaseResponse batchInsertUser(@RequestBody @Validated UserBatchInsertReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){

        return userBusiness.batchInsertUser(reqDTO);
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateUser")
    @OperatorLog(description = "/updateUser")
    public BaseResponse updateUser(@RequestBody @Validated UserUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.updateUser(reqDTO);
    }

    @ApiOperation("批量更新接口")
    @PostMapping("/batchUpdateUser")
    @OperatorLog(description = "/batchUpdateUser")
    public BaseResponse batchUpdateUser(@RequestBody @Validated UserBatchUpdateReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){

        return userBusiness.batchUpdateUser(reqDTO);
    }

    @ApiOperation("刪除接口")
    @GetMapping("/deleteUser")
    @OperatorLog(description = "/deleteUser")
    public BaseResponse deleteUser(Long id, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.deleteUser(id);
    }

    @ApiOperation("批量刪除接口")
    @PostMapping("/batchDeleteUser")
    @OperatorLog(description = "/batchDeleteUser")
    public BaseResponse batchDeleteUser(@RequestBody @Validated UserBatchDeleteReqDTO reqDTO, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.batchDeleteUser(reqDTO);
    }

    @ApiOperation("根据id查询接口")
    @GetMapping("/queryUser")
    @OperatorLog(description = "/queryUser")
    public BaseResponse queryUser(Long id){
        return userBusiness.queryUser(id);
    }

    @ApiOperation("分页查询接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<UserPageResDTO> queryPage(@RequestBody @Validated PageRequest<UserPageReqDTO> pageRequest){
        return userBusiness.queryPage(pageRequest);
    }

    @ApiOperation("根据条件查询所有接口")
    @PostMapping("/queryAll")
    @OperatorLog(description = "/queryAll")
    public BaseResponse<List<UserPageResDTO>> queryAll(@RequestBody @Validated UserPageReqDTO reqDTO){
        return userBusiness.queryAll(reqDTO);
    }

    @ApiOperation("获取用户下的角色树接口")
    @GetMapping("/queryRoleUnderUser")
    @OperatorLog(description = "/queryRoleUnderUser")
    public BaseResponse<String> queryTreeRoleUnderUser(Long id){
        return userBusiness.queryTreeRoleUnderUser(id);
    }

}
	