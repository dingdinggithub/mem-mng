package com.kevin.mem.mng.dto.request.roleAuth;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色权限关系InsertReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:05
 */
@Data
public class RoleAuthInsertReqDTO implements Serializable, DTO {

	/**
	 * 角色Id
	 */
	@NotNull
	private Long roleId;
	/**
	 * 权限Id
	 */
	@NotNull
	private Long authId;
	
}
	