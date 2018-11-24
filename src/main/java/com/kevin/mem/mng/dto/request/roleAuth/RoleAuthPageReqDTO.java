package com.kevin.mem.mng.dto.request.roleAuth;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限关系PageReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class RoleAuthPageReqDTO implements Serializable, DTO {

    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 权限Id
     */
    private Long authId;

}
	