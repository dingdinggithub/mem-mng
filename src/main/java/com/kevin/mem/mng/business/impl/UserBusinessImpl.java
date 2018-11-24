package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.dto.request.user.*;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户BusinessImpl
 * @author 丁海峰
 * @date 2018-11-24 02:42:18
 */
@Service
@Slf4j
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public BaseResponse insertUser(UserInsertReqDTO user) {

        int result = userService.insert(mapper.map(user,User.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertUser(UserBatchInsertReqDTO userBatchInsertReqDTO) {
        List<User> userList = userBatchInsertReqDTO.getInsertUserList().stream()
                .map(item-> mapper.map(item, User.class)).collect(Collectors.toList());
        userService.batchInsert(userList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateUser(UserUpdateReqDTO user) {
        int result = userService.updateById(mapper.map(user,User.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateUser(UserBatchUpdateReqDTO userBatchUpdateReqDTO) {
        List<User> userList = userBatchUpdateReqDTO.getUpdateUserList().stream()
                .map(item-> mapper.map(item, User.class)).collect(Collectors.toList());
        userService.batchUpdate(userList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteUser(Long id) {
        int result = userService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteUser(UserBatchDeleteReqDTO reqDTO) {
        userService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryUser(Long id) {
        User result = userService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, UserPageResDTO.class));
    }

    @Override
    public PageQueryResponse<UserPageResDTO> queryPage(PageRequest<UserPageReqDTO> pageRequest) {

        PageRequest<User> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());
        request.setModel(mapper.map(pageRequest.getModel(), User.class));

        Page<User> userList = userService.queryPage(request);

        List<UserPageResDTO> userPageResDTOList = userList.stream().map(item->mapper
                .map(item,UserPageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<UserPageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(userPageResDTOList);
        pageQueryResponse.setPageIndex(userList.getPageNum()+1);
        pageQueryResponse.setPageSize(userList.getPageSize());
        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<UserPageResDTO>> queryAll(UserPageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                userService.queryAll(mapper.map(reqDTO,User.class))
                                        .stream().map(item -> mapper.map(item,UserPageResDTO.class))
                                                 .collect(Collectors.toList()));
    }


}
	