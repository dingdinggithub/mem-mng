package com.kevin.mem.mng.business;


import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.dto.request.user.*;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;

import java.util.List;

public interface UserBusiness {

    BaseResponse insertUser(UserInsertReqDTO user);

    BaseResponse batchInsertUser(UserBatchInsertReqDTO reqDTO);

    BaseResponse updateUser(UserUpdateReqDTO user);

    BaseResponse batchUpdateUser(UserBatchUpdateReqDTO reqDTO);

    BaseResponse deleteUser(long userId);

    BaseResponse batchDeleteUser(UserBatchDeleteReqDTO reqDTO);

    BaseResponse queryUser(long userId);

    PageQueryResponse<UserPageResDTO> queryPage(PageRequest<UserPageReqDTO> pageRequest);

    BaseResponse<List<UserPageResDTO>> queryAll(UserPageReqDTO reqDTO);

}
