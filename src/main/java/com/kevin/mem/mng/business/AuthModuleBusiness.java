package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.authModule.*;
import com.kevin.mem.mng.dto.response.authModule.AuthModulePageResDTO;

import java.util.List;
/**
 * 权限模块关系Business
 * @author 丁海峰
 * @date 2018-11-24 02:18:13
 */
public interface AuthModuleBusiness {

    BaseResponse insertAuthModule(AuthModuleInsertReqDTO authModule);

    BaseResponse batchInsertAuthModule(AuthModuleBatchInsertReqDTO reqDTO);

    BaseResponse updateAuthModule(AuthModuleUpdateReqDTO authModule);

    BaseResponse batchUpdateAuthModule(AuthModuleBatchUpdateReqDTO reqDTO);

    BaseResponse deleteAuthModule(Long id);

    BaseResponse batchDeleteAuthModule(AuthModuleBatchDeleteReqDTO reqDTO);

    BaseResponse queryAuthModule(Long id);

    PageQueryResponse<AuthModulePageResDTO> queryPage(PageRequest<AuthModulePageReqDTO> pageRequest);

    BaseResponse<List<AuthModulePageResDTO>> queryAll(AuthModulePageReqDTO reqDTO);

}
	