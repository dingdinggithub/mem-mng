package com.kevin.mem.mng.business;


import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.dto.request.user.UserBatchInsertReqDTO;
import com.kevin.mem.mng.dto.request.user.UserInsertReqDTO;
import com.kevin.mem.mng.dto.request.user.UserPageReqDTO;
import com.kevin.mem.mng.dto.request.user.UserUpdateReqDTO;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;

public interface UserBusiness {

    BaseResponse insertUser(UserInsertReqDTO user);

    BaseResponse batchInsertUser(UserBatchInsertReqDTO userBatchInsertReqDTO);

    BaseResponse updateUser(UserUpdateReqDTO user);

    BaseResponse deleteUser(long userId);

    BaseResponse queryUser(long userId);

    PageQueryResponse<UserPageResDTO> queryPage(PageRequest<UserPageReqDTO> pageRequest);
}
