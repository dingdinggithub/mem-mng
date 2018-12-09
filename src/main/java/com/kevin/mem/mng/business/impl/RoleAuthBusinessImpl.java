package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleAuthBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.RoleAuth;
import com.kevin.mem.mng.dto.request.roleAuth.*;
import com.kevin.mem.mng.dto.response.roleAuth.RoleAuthPageResDTO;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.RoleAuthService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色权限关系BusinessImpl
 * @author 丁海峰
 * @date 2018-12-09 02:18:05
 */
@Service
@Slf4j
public class RoleAuthBusinessImpl implements RoleAuthBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private RoleAuthService roleAuthService;

    @Override
    public BaseResponse insertRoleAuth(RoleAuthInsertReqDTO roleAuth) {

        int result = roleAuthService.insert(mapper.map(roleAuth,RoleAuth.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertRoleAuth(RoleAuthBatchInsertReqDTO roleAuthBatchInsertReqDTO) {
        List<RoleAuth> roleAuthList = roleAuthBatchInsertReqDTO.getInsertRoleAuthList().stream()
                .map(item-> mapper.map(item, RoleAuth.class)).collect(Collectors.toList());
        roleAuthService.batchInsert(roleAuthList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateRoleAuth(RoleAuthUpdateReqDTO roleAuth) {
        int result = roleAuthService.updateById(mapper.map(roleAuth,RoleAuth.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateRoleAuth(RoleAuthBatchUpdateReqDTO roleAuthBatchUpdateReqDTO) {
        List<RoleAuth> roleAuthList = roleAuthBatchUpdateReqDTO.getUpdateRoleAuthList().stream()
                .map(item-> mapper.map(item, RoleAuth.class)).collect(Collectors.toList());
        roleAuthService.batchUpdate(roleAuthList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteRoleAuth(Long id) {
        int result = roleAuthService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteRoleAuth(RoleAuthBatchDeleteReqDTO reqDTO) {
        roleAuthService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryRoleAuth(Long id) {
        RoleAuth result = roleAuthService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, RoleAuthPageResDTO.class));
    }

    @Override
    public PageQueryResponse<RoleAuthPageResDTO> queryPage(PageRequest<RoleAuthPageReqDTO> pageRequest) {

        PageRequest<RoleAuth> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());

        if (Objects.nonNull(pageRequest.getModel())) {
            request.setModel(mapper.map(pageRequest.getModel(), RoleAuth.class));
        }

        Page<RoleAuth> roleAuthList = roleAuthService.queryPage(request);

        List<RoleAuthPageResDTO> roleAuthPageResDTOList = roleAuthList.stream().map(item->mapper
                .map(item,RoleAuthPageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<RoleAuthPageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(roleAuthPageResDTOList);

        pageQueryResponse.setTotalCount((int)roleAuthList.getTotal());
        pageQueryResponse.setPageSize(pageRequest.getPageSize());
        pageQueryResponse.setPageIndex(pageRequest.getPageIndex());

        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<RoleAuthPageResDTO>> queryAll(RoleAuthPageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                roleAuthService.queryAll(mapper.map(reqDTO,RoleAuth.class))
                                        .stream().map(item -> mapper.map(item,RoleAuthPageResDTO.class))
                                                 .collect(Collectors.toList()));
    }


}
	