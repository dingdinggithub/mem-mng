package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.ModuleBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Module;
import com.kevin.mem.mng.dto.request.module.*;
import com.kevin.mem.mng.dto.response.module.ModulePageResDTO;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 模块BusinessImpl
 * @author 丁海峰
 * @date 2018-11-24 02:42:19
 */
@Service
@Slf4j
public class ModuleBusinessImpl implements ModuleBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ModuleService moduleService;

    @Override
    public BaseResponse insertModule(ModuleInsertReqDTO module) {

        int result = moduleService.insert(mapper.map(module,Module.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertModule(ModuleBatchInsertReqDTO moduleBatchInsertReqDTO) {
        List<Module> moduleList = moduleBatchInsertReqDTO.getInsertModuleList().stream()
                .map(item-> mapper.map(item, Module.class)).collect(Collectors.toList());
        moduleService.batchInsert(moduleList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateModule(ModuleUpdateReqDTO module) {
        int result = moduleService.updateById(mapper.map(module,Module.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateModule(ModuleBatchUpdateReqDTO moduleBatchUpdateReqDTO) {
        List<Module> moduleList = moduleBatchUpdateReqDTO.getUpdateModuleList().stream()
                .map(item-> mapper.map(item, Module.class)).collect(Collectors.toList());
        moduleService.batchUpdate(moduleList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteModule(Long id) {
        int result = moduleService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteModule(ModuleBatchDeleteReqDTO reqDTO) {
        moduleService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryModule(Long id) {
        Module result = moduleService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, ModulePageResDTO.class));
    }

    @Override
    public PageQueryResponse<ModulePageResDTO> queryPage(PageRequest<ModulePageReqDTO> pageRequest) {

        PageRequest<Module> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());
        request.setModel(mapper.map(pageRequest.getModel(), Module.class));

        Page<Module> moduleList = moduleService.queryPage(request);

        List<ModulePageResDTO> modulePageResDTOList = moduleList.stream().map(item->mapper
                .map(item,ModulePageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<ModulePageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(modulePageResDTOList);
        pageQueryResponse.setPageIndex(moduleList.getPageNum()+1);
        pageQueryResponse.setPageSize(moduleList.getPageSize());
        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<ModulePageResDTO>> queryAll(ModulePageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                moduleService.queryAll(mapper.map(reqDTO,Module.class))
                                        .stream().map(item -> mapper.map(item,ModulePageResDTO.class))
                                                 .collect(Collectors.toList()));
    }


}
	