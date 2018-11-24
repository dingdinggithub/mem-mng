package com.kevin.mem.mng.dto.request.roleUser;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关系PageReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class RoleUserPageReqDTO implements Serializable, DTO {

    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 用户Id
     */
    private Long userId;

}
	