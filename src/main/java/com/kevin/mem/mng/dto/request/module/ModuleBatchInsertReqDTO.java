package com.kevin.mem.mng.dto.request.module;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 模块BatchInsertReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:04
 */
@Data
public class ModuleBatchInsertReqDTO implements Serializable, DTO {

	@NotNull
    List<ModuleInsertReqDTO> insertModuleList;
	
}
	