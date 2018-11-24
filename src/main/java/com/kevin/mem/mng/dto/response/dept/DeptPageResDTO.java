package com.kevin.mem.mng.dto.response.dept;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 部门PageResDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:51
 */
@Data
public class DeptPageResDTO implements Serializable, DTO {
	/**
	* 主键
	*/
	private Long id;
	
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
	