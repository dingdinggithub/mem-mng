package com.kevin.mem.mng.dto.request.roleUser;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 用户角色关系BatchInsertReqDTO
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class RoleUserBatchInsertReqDTO implements Serializable, DTO {

	@NotNull
    List<RoleUserInsertReqDTO> insertRoleUserList;
	
}
	