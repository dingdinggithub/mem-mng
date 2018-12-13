package com.kevin.mem.mng.dto.request.module;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 模块PageReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:04
 */
@Data
public class ModulePageReqDTO implements Serializable, DTO {

	/**
	 * 权限模块名称
	 */
	private String name;
	/**
	 * 上级权限模块id
	 */
	private Long parentId;
	/**
	 * 权限模块层级
	 */
	private String level;
	/**
	 * 权限模块在当前层级下的顺序，由小到大
	 */
	private Integer seq;
	/**
	 * 状态，1：正常，0：冻结
	 */
	private Integer status;
	
}
	