package com.kevin.mem.mng.dto.request.roleUser;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户角色关系UpdateReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class RoleUserUpdateReqDTO implements Serializable, DTO {

    /**
     * 角色Id
     */
    @NotNull
    private Long roleId;
    /**
     * 用户Id
     */
    @NotNull
    private Long userId;

}
	