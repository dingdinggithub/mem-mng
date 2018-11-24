package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.user.*;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;

import java.util.List;
/**
 * 用户Business
 * @author 丁海峰
 * @date 2018-11-24 02:18:11
 */
public interface UserBusiness {

    BaseResponse insertUser(UserInsertReqDTO user);

    BaseResponse batchInsertUser(UserBatchInsertReqDTO reqDTO);

    BaseResponse updateUser(UserUpdateReqDTO user);

    BaseResponse batchUpdateUser(UserBatchUpdateReqDTO reqDTO);

    BaseResponse deleteUser(Long id);

    BaseResponse batchDeleteUser(UserBatchDeleteReqDTO reqDTO);

    BaseResponse queryUser(Long id);

    PageQueryResponse<UserPageResDTO> queryPage(PageRequest<UserPageReqDTO> pageRequest);

    BaseResponse<List<UserPageResDTO>> queryAll(UserPageReqDTO reqDTO);

}
	