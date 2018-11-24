package com.kevin.mem.mng.dto.request.dept;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门PageReqDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:51
 */
@Data
public class DeptPageReqDTO implements Serializable, DTO {

	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 上级部门id
	 */
	private Long parentId;
	/**
	 * 部门层级
	 */
	private String level;
	/**
	 * 部门在当前层级下的顺序
	 */
	private Integer seq;
	
}
	