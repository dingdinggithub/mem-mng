package com.kevin.mem.mng.dto.request.roleAuth;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关系BatchUpdateReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class RoleAuthBatchUpdateReqDTO implements Serializable, DTO {

    @NotNull
    List<RoleAuthUpdateReqDTO> updateRoleAuthList;

}
	