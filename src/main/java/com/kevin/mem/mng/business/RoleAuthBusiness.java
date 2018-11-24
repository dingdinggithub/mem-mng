package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.roleAuth.*;
import com.kevin.mem.mng.dto.response.roleAuth.RoleAuthPageResDTO;

import java.util.List;
/**
 * 角色权限关系Business
 * @author 丁海峰
 * @date 2018-11-24 02:18:13
 */
public interface RoleAuthBusiness {

    BaseResponse insertRoleAuth(RoleAuthInsertReqDTO roleAuth);

    BaseResponse batchInsertRoleAuth(RoleAuthBatchInsertReqDTO reqDTO);

    BaseResponse updateRoleAuth(RoleAuthUpdateReqDTO roleAuth);

    BaseResponse batchUpdateRoleAuth(RoleAuthBatchUpdateReqDTO reqDTO);

    BaseResponse deleteRoleAuth(Long id);

    BaseResponse batchDeleteRoleAuth(RoleAuthBatchDeleteReqDTO reqDTO);

    BaseResponse queryRoleAuth(Long id);

    PageQueryResponse<RoleAuthPageResDTO> queryPage(PageRequest<RoleAuthPageReqDTO> pageRequest);

    BaseResponse<List<RoleAuthPageResDTO>> queryAll(RoleAuthPageReqDTO reqDTO);

}
	