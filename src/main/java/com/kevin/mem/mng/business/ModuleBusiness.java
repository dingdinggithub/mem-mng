package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.module.*;
import com.kevin.mem.mng.dto.response.module.ModulePageResDTO;

import java.util.List;
/**
 * 模块Business
 * @author 丁海峰
 * @date 2018-11-24 02:18:13
 */
public interface ModuleBusiness {

    BaseResponse insertModule(ModuleInsertReqDTO module);

    BaseResponse batchInsertModule(ModuleBatchInsertReqDTO reqDTO);

    BaseResponse updateModule(ModuleUpdateReqDTO module);

    BaseResponse batchUpdateModule(ModuleBatchUpdateReqDTO reqDTO);

    BaseResponse deleteModule(Long id);

    BaseResponse batchDeleteModule(ModuleBatchDeleteReqDTO reqDTO);

    BaseResponse queryModule(Long id);

    PageQueryResponse<ModulePageResDTO> queryPage(PageRequest<ModulePageReqDTO> pageRequest);

    BaseResponse<List<ModulePageResDTO>> queryAll(ModulePageReqDTO reqDTO);

}
	