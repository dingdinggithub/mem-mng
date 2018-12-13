package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleUserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.RoleUser;
import com.kevin.mem.mng.dto.request.roleUser.*;
import com.kevin.mem.mng.dto.response.role.RolePageResDTO;
import com.kevin.mem.mng.dto.response.roleUser.RoleUserPageResDTO;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.RoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色关系BusinessImpl
 * @author 丁海峰
 * @date 2018-12-09 02:18:05
 */
@Service
@Slf4j
public class RoleUserBusinessImpl implements RoleUserBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private RoleUserService roleUserService;

    @Override
    public BaseResponse insertRoleUser(RoleUserInsertReqDTO roleUser) {

        int result = roleUserService.insert(mapper.map(roleUser,RoleUser.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertRoleUser(RoleUserBatchInsertReqDTO roleUserBatchInsertReqDTO) {
        List<RoleUser> roleUserList = roleUserBatchInsertReqDTO.getInsertRoleUserList().stream()
                .map(item-> mapper.map(item, RoleUser.class)).collect(Collectors.toList());
        roleUserService.batchInsert(roleUserList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateRoleUser(RoleUserUpdateReqDTO roleUser) {
        int result = roleUserService.updateById(mapper.map(roleUser,RoleUser.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateRoleUser(RoleUserBatchUpdateReqDTO roleUserBatchUpdateReqDTO) {
        List<RoleUser> roleUserList = roleUserBatchUpdateReqDTO.getUpdateRoleUserList().stream()
                .map(item-> mapper.map(item, RoleUser.class)).collect(Collectors.toList());
        roleUserService.batchUpdate(roleUserList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteRoleUser(Long id) {
        int result = roleUserService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteRoleUser(RoleUserBatchDeleteReqDTO reqDTO) {
        roleUserService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryRoleUser(Long id) {
        RoleUser result = roleUserService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, RoleUserPageResDTO.class));
    }

    @Override
    public PageQueryResponse<RoleUserPageResDTO> queryPage(PageRequest<RoleUserPageReqDTO> pageRequest) {

        PageRequest<RoleUser> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());

        if (Objects.nonNull(pageRequest.getModel())) {
            request.setModel(mapper.map(pageRequest.getModel(), RoleUser.class));
        }

        Page<RoleUser> roleUserList = roleUserService.queryPage(request);

        List<RoleUserPageResDTO> roleUserPageResDTOList = roleUserList.stream().map(item->mapper
                .map(item,RoleUserPageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<RoleUserPageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(roleUserPageResDTOList);

        pageQueryResponse.setTotalCount((int)roleUserList.getTotal());
        pageQueryResponse.setPageSize(pageRequest.getPageSize());
        pageQueryResponse.setPageIndex(pageRequest.getPageIndex());

        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<RoleUserPageResDTO>> queryAll(RoleUserPageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                roleUserService.queryAll(mapper.map(reqDTO,RoleUser.class))
                                        .stream().map(item -> mapper.map(item,RoleUserPageResDTO.class))
                                                 .collect(Collectors.toList()));
    }

    @Override
    public BaseResponse<List<RolePageResDTO>> queryRoleUnderUser(Long userId) {
        return BaseResponse.createSuccessResult(roleUserService.queryRoleUnderUser(userId)
                                        .stream().map(item -> mapper.map(item,RolePageResDTO.class))
                                                .collect(Collectors.toList()));
    }

}
	