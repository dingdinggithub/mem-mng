package com.kevin.mem.mng.dto.request.role;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色InsertReqDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:49
 */
@Data
public class RoleInsertReqDTO implements Serializable, DTO {

	/**
	 * 类型名
	 */
	@NotNull
	private String name;
	/**
	 * 角色的类型，1：管理员角色，2：其他
	 */
	@NotNull
	private Integer type;
	/**
	 * 状态
	 */
	@NotNull
	private Integer status;
	
}
	