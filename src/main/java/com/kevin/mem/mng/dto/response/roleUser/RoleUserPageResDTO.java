package com.kevin.mem.mng.dto.response.roleUser;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 用户角色关系PageResDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class RoleUserPageResDTO implements Serializable, DTO {
	/**
	* 主键
	*/
	private Long id;
	
	/**
	 * 角色Id
	 */
	private Long roleId;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否已删除
	 */
	private Integer isDeleted;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
	
}
	