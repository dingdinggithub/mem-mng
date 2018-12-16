package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.UserBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Role;
import com.kevin.mem.mng.domain.entity.RoleUser;
import com.kevin.mem.mng.domain.entity.User;
import com.kevin.mem.mng.dto.request.UpdateTreeReqDTO;
import com.kevin.mem.mng.dto.request.user.*;
import com.kevin.mem.mng.dto.response.TreeDataDTO;
import com.kevin.mem.mng.dto.response.UpdateTreeAuthListResDTO;
import com.kevin.mem.mng.dto.response.user.UserPageResDTO;
import com.kevin.mem.mng.enums.StatusEnum;
import com.kevin.mem.mng.service.RoleService;
import com.kevin.mem.mng.service.RoleUserService;
import com.kevin.mem.mng.service.UserService;
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
 * 用户BusinessImpl
 * @author 丁海峰
 * @date 2018-12-09 02:18:02
 */
@Service
@Slf4j
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleUserService roleUserService;

    @Autowired
    private RoleService roleService;

    @Override
    public BaseResponse insertUser(UserInsertReqDTO user) {

        int result = userService.insert(mapper.map(user,User.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertUser(UserBatchInsertReqDTO userBatchInsertReqDTO) {
        List<User> userList = userBatchInsertReqDTO.getInsertUserList().stream()
                .map(item-> mapper.map(item, User.class)).collect(Collectors.toList());
        userService.batchInsert(userList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateUser(UserUpdateReqDTO user) {
        int result = userService.updateById(mapper.map(user,User.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateUser(UserBatchUpdateReqDTO userBatchUpdateReqDTO) {
        List<User> userList = userBatchUpdateReqDTO.getUpdateUserList().stream()
                .map(item-> mapper.map(item, User.class)).collect(Collectors.toList());
        userService.batchUpdate(userList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteUser(Long id) {
        int result = userService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteUser(UserBatchDeleteReqDTO reqDTO) {
        userService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryUser(Long id) {
        User result = userService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, UserPageResDTO.class));
    }

    @Override
    public PageQueryResponse<UserPageResDTO> queryPage(PageRequest<UserPageReqDTO> pageRequest) {

        PageRequest<User> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());

        if (Objects.nonNull(pageRequest.getModel())) {
            request.setModel(mapper.map(pageRequest.getModel(), User.class));
        }

        Page<User> userList = userService.queryPage(request);

        List<UserPageResDTO> userPageResDTOList = userList.stream().map(item->mapper
                .map(item,UserPageResDTO.class)).collect(Collectors.toList());
        userPageResDTOList.forEach(item-> item.setStatusDesc(StatusEnum.getDesc(item.getStatus())));

        PageQueryResponse<UserPageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(userPageResDTOList);

        pageQueryResponse.setTotalCount((int)userList.getTotal());
        pageQueryResponse.setPageSize(pageRequest.getPageSize());
        pageQueryResponse.setPageIndex(pageRequest.getPageIndex());

        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<UserPageResDTO>> queryAll(UserPageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                userService.queryAll(mapper.map(reqDTO,User.class))
                                        .stream().map(item -> mapper.map(item,UserPageResDTO.class))
                                                 .collect(Collectors.toList()));
    }

    @Override
    public BaseResponse<UpdateTreeAuthListResDTO> queryTreeRoleUnderUser(Long userId) {
        List<Role> roleList = roleService.queryAll(new Role());
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(userId);
        List<RoleUser> roleUserList = roleUserService.queryAll(roleUser);
        TreeDataDTO rootTreeDTO = new TreeDataDTO(0L, "所有角色");
        rootTreeDTO.setChildren(getChildTree(roleList, roleUserList));

        //存在checked角色
        if (CollectionUtils.isNotEmpty(roleUserList)) {
            rootTreeDTO.setChecked(true);
        }

        UpdateTreeAuthListResDTO updateTreeAuthListResDTO = new UpdateTreeAuthListResDTO();
        updateTreeAuthListResDTO.setModelId(userId);
        updateTreeAuthListResDTO.setTreeJson(rootTreeDTO.toString());

        return BaseResponse.createSuccessResult(updateTreeAuthListResDTO);
    }

    @Override
    public BaseResponse updateRoleUnderUser(UpdateTreeReqDTO roleReqDTO) {
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(roleReqDTO.getModelId());
        List<RoleUser> roleUserList = roleUserService.queryAll(roleUser);

        List<Long> idList = roleUserList.stream().map(RoleUser::getId).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(idList)) {
            roleUserService.batchDelete(idList);
        }

        roleUserList.clear();

        roleReqDTO.getModelIdList().forEach(item-> {
            final RoleUser roleUserInsert = new RoleUser();
            roleUserInsert.setUserId(roleReqDTO.getModelId());
            roleUserInsert.setRoleId(item);

            roleUserList.add(roleUserInsert);
        });

        roleUserService.batchInsert(roleUserList);

        return BaseResponse.createSuccessResult(null);
    }

    /**
     * 初始化角色树
     *
     * @param allRole
     * @param roleUserList
     * @return
     */
    private List<TreeDataDTO> getChildTree(List<Role> allRole, List<RoleUser> roleUserList) {
        List<TreeDataDTO> childRole = Lists.newArrayList();
        allRole.forEach(role -> {
            Optional<RoleUser> roleUserOptional = roleUserList.stream()
                    .filter(item -> item.getRoleId().equals(role.getId())).findFirst();
            if (roleUserOptional.isPresent()) {
                childRole.add(new TreeDataDTO(role.getId(), role.getName(), true));
            } else {
                childRole.add(new TreeDataDTO(role.getId(), role.getName()));
            }
        });

        return childRole;
    }


}
	