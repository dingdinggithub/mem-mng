package com.kevin.mem.mng.dto.request.role;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 角色BatchInsertReqDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:49
 */
@Data
public class RoleBatchInsertReqDTO implements Serializable, DTO {

	@NotNull
    List<RoleInsertReqDTO> insertRoleList;
	
}
	