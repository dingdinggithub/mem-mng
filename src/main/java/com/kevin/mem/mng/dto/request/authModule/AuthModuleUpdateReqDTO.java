package com.kevin.mem.mng.dto.request.authModule;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限模块关系UpdateReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:04
 */
@Data
public class AuthModuleUpdateReqDTO implements Serializable, DTO {

    @NotNull
    private Long id;

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
	 * 状态，1：正常，0：冻结
	 */
	@NotNull
	private Integer status;
	
}
	