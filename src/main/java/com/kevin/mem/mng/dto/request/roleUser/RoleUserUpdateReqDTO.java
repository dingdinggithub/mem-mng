package com.kevin.mem.mng.dto.request.roleUser;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色关系UpdateReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:05
 */
@Data
public class RoleUserUpdateReqDTO implements Serializable, DTO {

    @NotNull
    private Long id;

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
	