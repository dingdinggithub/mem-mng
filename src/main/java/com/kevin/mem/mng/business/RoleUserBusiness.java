package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.roleUser.*;
import com.kevin.mem.mng.dto.response.roleUser.RoleUserPageResDTO;

import java.util.List;

/**
 * 用户角色关系Business
 *
 * @author 丁海峰
 * @date 2018-11-24 02:18:13
 */
public interface RoleUserBusiness {

    BaseResponse insertRoleUser(RoleUserInsertReqDTO roleUser);

    BaseResponse batchInsertRoleUser(RoleUserBatchInsertReqDTO reqDTO);

    BaseResponse updateRoleUser(RoleUserUpdateReqDTO roleUser);

    BaseResponse batchUpdateRoleUser(RoleUserBatchUpdateReqDTO reqDTO);

    BaseResponse deleteRoleUser(Long id);

    BaseResponse batchDeleteRoleUser(RoleUserBatchDeleteReqDTO reqDTO);

    BaseResponse queryRoleUser(Long id);

    PageQueryResponse<RoleUserPageResDTO> queryPage(PageRequest<RoleUserPageReqDTO> pageRequest);

    BaseResponse<List<RoleUserPageResDTO>> queryAll(RoleUserPageReqDTO reqDTO);

}
	