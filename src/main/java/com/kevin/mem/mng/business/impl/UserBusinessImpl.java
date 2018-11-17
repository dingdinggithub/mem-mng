package com.kevin.mem.mng.business.impl;


import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.dto.request.user.UserBatchInsertReqDTO;
import com.kevin.mem.mng.dto.request.user.UserInsertReqDTO;
import com.kevin.mem.mng.dto.request.user.UserPageReqDTO;
import com.kevin.mem.mng.dto.request.user.UserUpdateReqDTO;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private BaseService<User> baseService;

    @Autowired
    private UserService userService;


    @Override
    public BaseResponse insertUser(UserInsertReqDTO user) {

        int result = baseService.insert(mapper.map(user,User.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertUser(UserBatchInsertReqDTO userBatchInsertReqDTO) {
        List<User> userList = userBatchInsertReqDTO.getUserInsertReqDTOList().stream()
                .map(item-> mapper.map(item, User.class)).collect(Collectors.toList());
        int result = baseService.batchInsert(userList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateUser(UserUpdateReqDTO user) {
        int result = baseService.updateByPrimaryKey(mapper.map(user,User.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteUser(long userId) {
        int result = baseService.deleteById(userId);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryUser(long userId) {
        User result = baseService.selectByCode(userId);
        return BaseResponse.createSuccessResult(mapper.map(result, UserPageResDTO.class));
    }

    @Override
    public PageQueryResponse<UserPageResDTO> queryPage(PageRequest<UserPageReqDTO> pageRequest) {

        PageRequest<User> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());
        request.setModel(mapper.map(pageRequest.getModel(), User.class));

        Page<User> userList = baseService.queryPage(request);

        List<UserPageResDTO> userPageResDTOList = userList.stream().map(item->mapper
                .map(item,UserPageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<UserPageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(userPageResDTOList);
        pageQueryResponse.setPageIndex(userList.getPageNum()+1);
        pageQueryResponse.setPageSize(userList.getPageSize());
        return pageQueryResponse;
    }

}
