package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.role.*;
import com.kevin.mem.mng.dto.response.role.RolePageResDTO;

import java.util.List;

/**
 * 角色Business
 *
 * @author 丁海峰
 * @date 2018-11-24 02:18:12
 */
public interface RoleBusiness {

    BaseResponse insertRole(RoleInsertReqDTO role);

    BaseResponse batchInsertRole(RoleBatchInsertReqDTO reqDTO);

    BaseResponse updateRole(RoleUpdateReqDTO role);

    BaseResponse batchUpdateRole(RoleBatchUpdateReqDTO reqDTO);

    BaseResponse deleteRole(Long id);

    BaseResponse batchDeleteRole(RoleBatchDeleteReqDTO reqDTO);

    BaseResponse queryRole(Long id);

    PageQueryResponse<RolePageResDTO> queryPage(PageRequest<RolePageReqDTO> pageRequest);

    BaseResponse<List<RolePageResDTO>> queryAll(RolePageReqDTO reqDTO);

}
	