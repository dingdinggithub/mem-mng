package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.AuthModuleBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.AuthModule;
import com.kevin.mem.mng.dto.request.authModule.*;
import com.kevin.mem.mng.dto.response.authModule.AuthModulePageResDTO;
import com.kevin.mem.mng.service.AuthModuleService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限模块关系BusinessImpl
 *
 * @author 丁海峰
 * @date 2018-11-24 02:42:20
 */
@Service
@Slf4j
public class AuthModuleBusinessImpl implements AuthModuleBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private AuthModuleService authModuleService;

    @Override
    public BaseResponse insertAuthModule(AuthModuleInsertReqDTO authModule) {

        int result = authModuleService.insert(mapper.map(authModule, AuthModule.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertAuthModule(AuthModuleBatchInsertReqDTO authModuleBatchInsertReqDTO) {
        List<AuthModule> authModuleList = authModuleBatchInsertReqDTO.getInsertAuthModuleList().stream()
                .map(item -> mapper.map(item, AuthModule.class)).collect(Collectors.toList());
        authModuleService.batchInsert(authModuleList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateAuthModule(AuthModuleUpdateReqDTO authModule) {
        int result = authModuleService.updateById(mapper.map(authModule, AuthModule.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateAuthModule(AuthModuleBatchUpdateReqDTO authModuleBatchUpdateReqDTO) {
        List<AuthModule> authModuleList = authModuleBatchUpdateReqDTO.getUpdateAuthModuleList().stream()
                .map(item -> mapper.map(item, AuthModule.class)).collect(Collectors.toList());
        authModuleService.batchUpdate(authModuleList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteAuthModule(Long id) {
        int result = authModuleService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteAuthModule(AuthModuleBatchDeleteReqDTO reqDTO) {
        authModuleService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryAuthModule(Long id) {
        AuthModule result = authModuleService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, AuthModulePageResDTO.class));
    }

    @Override
    public PageQueryResponse<AuthModulePageResDTO> queryPage(PageRequest<AuthModulePageReqDTO> pageRequest) {

        PageRequest<AuthModule> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());
        request.setModel(mapper.map(pageRequest.getModel(), AuthModule.class));

        Page<AuthModule> authModuleList = authModuleService.queryPage(request);

        List<AuthModulePageResDTO> authModulePageResDTOList = authModuleList.stream().map(item -> mapper
                .map(item, AuthModulePageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<AuthModulePageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(authModulePageResDTOList);
        pageQueryResponse.setPageIndex(authModuleList.getPageNum() + 1);
        pageQueryResponse.setPageSize(authModuleList.getPageSize());
        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<AuthModulePageResDTO>> queryAll(AuthModulePageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                authModuleService.queryAll(mapper.map(reqDTO, AuthModule.class))
                        .stream().map(item -> mapper.map(item, AuthModulePageResDTO.class))
                        .collect(Collectors.toList()));
    }


}
	