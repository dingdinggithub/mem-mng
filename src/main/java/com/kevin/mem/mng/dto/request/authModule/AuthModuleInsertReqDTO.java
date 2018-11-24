package com.kevin.mem.mng.dto.request.authModule;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限模块关系InsertReqDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class AuthModuleInsertReqDTO implements Serializable, DTO {

	/**
	 * 权限码
	 */
	@NotNull
	private String code;
	/**
	 * 权限名称
	 */
	@NotNull
	private String name;
	/**
	 * 权限所在的模块id
	 */
	@NotNull
	private Long moduleId;
	/**
	 * 请求的url
	 */
	@NotNull
	private String url;
	/**
	 * 类型，1：菜单，2：按钮，3：其他
	 */
	@NotNull
	private Integer type;
	/**
	 * 权限模块在当前层级下的顺序，由小到大
	 */
	@NotNull
	private Integer seq;
	/**
	 * 状态，1：正常，0：冻结
	 */
	@NotNull
	private Integer status;

	
}
	