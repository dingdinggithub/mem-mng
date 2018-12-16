package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.RoleBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.*;
import com.kevin.mem.mng.dto.request.role.*;
import com.kevin.mem.mng.dto.request.UpdateTreeReqDTO;
import com.kevin.mem.mng.dto.response.TreeDataDTO;
import com.kevin.mem.mng.dto.response.role.RolePageResDTO;
import com.kevin.mem.mng.dto.response.UpdateTreeAuthListResDTO;
import com.kevin.mem.mng.service.AuthModuleService;
import com.kevin.mem.mng.service.RoleAuthService;
import com.kevin.mem.mng.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 角色BusinessImpl
 * @author 丁海峰
 * @date 2018-12-09 02:18:04
 */
@Service
@Slf4j
public class RoleBusinessImpl implements RoleBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleAuthService roleAuthService;

    @Autowired
    private AuthModuleService authModuleService;

    @Override
    public BaseResponse insertRole(RoleInsertReqDTO role) {

        int result = roleService.insert(mapper.map(role,Role.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertRole(RoleBatchInsertReqDTO roleBatchInsertReqDTO) {
        List<Role> roleList = roleBatchInsertReqDTO.getInsertRoleList().stream()
                .map(item-> mapper.map(item, Role.class)).collect(Collectors.toList());
        roleService.batchInsert(roleList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateRole(RoleUpdateReqDTO role) {
        int result = roleService.updateById(mapper.map(role,Role.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateRole(RoleBatchUpdateReqDTO roleBatchUpdateReqDTO) {
        List<Role> roleList = roleBatchUpdateReqDTO.getUpdateRoleList().stream()
                .map(item-> mapper.map(item, Role.class)).collect(Collectors.toList());
        roleService.batchUpdate(roleList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteRole(Long id) {
        int result = roleService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteRole(RoleBatchDeleteReqDTO reqDTO) {
        roleService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryRole(Long id) {
        Role result = roleService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, RolePageResDTO.class));
    }

    @Override
    public PageQueryResponse<RolePageResDTO> queryPage(PageRequest<RolePageReqDTO> pageRequest) {

        PageRequest<Role> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());

        if (Objects.nonNull(pageRequest.getModel())) {
            request.setModel(mapper.map(pageRequest.getModel(), Role.class));
        }

        Page<Role> roleList = roleService.queryPage(request);

        List<RolePageResDTO> rolePageResDTOList = roleList.stream().map(item->mapper
                .map(item,RolePageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<RolePageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(rolePageResDTOList);

        pageQueryResponse.setTotalCount((int)roleList.getTotal());
        pageQueryResponse.setPageSize(pageRequest.getPageSize());
        pageQueryResponse.setPageIndex(pageRequest.getPageIndex());

        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<RolePageResDTO>> queryAll(RolePageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                roleService.queryAll(mapper.map(reqDTO,Role.class))
                                        .stream().map(item -> mapper.map(item,RolePageResDTO.class))
                                                 .collect(Collectors.toList()));
    }

    /**
     * 初始化权限树
     *
     * @param allAuth
     * @param roleAuthList
     * @return
     */
    private List<TreeDataDTO> getChildTree(List<AuthModule> allAuth, List<RoleAuth> roleAuthList) {
        List<TreeDataDTO> treeDataDTOList = Lists.newArrayList();
        allAuth.forEach(auth -> {
            Optional<RoleAuth> roleAuthOptional = roleAuthList.stream()
                    .filter(item -> item.getAuthId().equals(auth.getId())).findFirst();
            if (roleAuthOptional.isPresent()) {
                treeDataDTOList.add(new TreeDataDTO(auth.getId(), auth.getName(), true));
            } else {
                treeDataDTOList.add(new TreeDataDTO(auth.getId(), auth.getName()));
            }
        });

        return treeDataDTOList;
    }

    @Override
    public BaseResponse<UpdateTreeAuthListResDTO> queryTreeAuthUnderRole(Long roleId) {
        List<AuthModule> moduleList = authModuleService.queryAll(new AuthModule());
        RoleAuth roleAuth = new RoleAuth();
        roleAuth.setRoleId(roleId);
        List<RoleAuth> roleAuthList = roleAuthService.queryAll(roleAuth);
        TreeDataDTO rootTreeDTO = new TreeDataDTO(0L, "所有权限");
        rootTreeDTO.setChildren(getChildTree(moduleList, roleAuthList));

        //存在checked角色
        if (CollectionUtils.isNotEmpty(roleAuthList)) {
            rootTreeDTO.setChecked(true);
        }

        UpdateTreeAuthListResDTO updateTreeAuthListResDTO = new UpdateTreeAuthListResDTO();
        updateTreeAuthListResDTO.setModelId(roleId);
        updateTreeAuthListResDTO.setTreeJson(rootTreeDTO.toString());

        return BaseResponse.createSuccessResult(updateTreeAuthListResDTO);
    }

    @Override
    public BaseResponse updateTreeAuthUnderRole(UpdateTreeReqDTO roleReqDTO) {
        RoleAuth roleAuth = new RoleAuth();
        roleAuth.setRoleId(roleReqDTO.getModelId());
        List<RoleAuth> roleAuthList = roleAuthService.queryAll(roleAuth);

        List<Long> idList = roleAuthList.stream().map(RoleAuth::getId).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(idList)) {
            roleAuthService.batchDelete(idList);
        }

        roleAuthList.clear();

        roleReqDTO.getModelIdList().forEach(item-> {
            final RoleAuth roleAuthInsert = new RoleAuth();
            roleAuthInsert.setRoleId(roleReqDTO.getModelId());
            roleAuthInsert.setAuthId(item);

            roleAuthList.add(roleAuthInsert);
        });

        roleAuthService.batchInsert(roleAuthList);

        return BaseResponse.createSuccessResult(null);
    }

}
	