package com.kevin.mem.mng.dto.request.role;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色UpdateReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:04
 */
@Data
public class RoleUpdateReqDTO implements Serializable, DTO {

    @NotNull
    private Long id;

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
	