package com.kevin.mem.mng.controller;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.common.log.OperatorLog;
import com.kevin.mem.mng.dto.request.user.UserInsertReqDTO;
import com.kevin.mem.mng.dto.request.user.UserPageReqDTO;
import com.kevin.mem.mng.dto.request.user.UserUpdateReqDTO;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(description = "用户管理接口")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserBusiness userBusiness;

    @ApiOperation("插入用戶接口")
    @PostMapping("/insertUser")
    @OperatorLog(description = "/insertUser")
    public BaseResponse insertUser(@RequestBody @Validated UserInsertReqDTO user, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.insertUser(user);
    }

    @ApiOperation("更新用戶接口")
    @PostMapping("/updateUser")
    @OperatorLog(description = "/updateUser")
    public BaseResponse updateUser(@RequestBody @Validated UserUpdateReqDTO user, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.updateUser(user);
    }

    @ApiOperation("刪除用戶接口")
    @PostMapping("/deleteUser")
    @OperatorLog(description = "/deleteUser")
    public BaseResponse deleteUser(@RequestBody @Validated long userId, @RequestHeader(required = false) @NotBlank(message = "用户名不能为空") String userName){
        return userBusiness.deleteUser(userId);
    }

    @ApiOperation("根据id查询用戶接口")
    @PostMapping("/queryUser")
    @OperatorLog(description = "/queryUser")
    public BaseResponse queryUser(@RequestBody @Validated long userId){
        return userBusiness.queryUser(userId);
    }

    @ApiOperation("分页查询用戶接口")
    @PostMapping("/queryPage")
    @OperatorLog(description = "/queryPage")
    public PageQueryResponse<UserPageResDTO> queryPage(@RequestBody @Validated PageRequest<UserPageReqDTO> pageRequest){
        return userBusiness.queryPage(pageRequest);
    }

}
