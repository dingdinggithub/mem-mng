package com.kevin.mem.mng.dto.request.authModule;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 权限模块关系BatchInsertReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:04
 */
@Data
public class AuthModuleBatchInsertReqDTO implements Serializable, DTO {

	@NotNull
    List<AuthModuleInsertReqDTO> insertAuthModuleList;
	
}
	