package com.kevin.mem.mng.dto.request.dept;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 部门BatchUpdateReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:05
 */
@Data
public class DeptBatchUpdateReqDTO implements Serializable, DTO {

	@NotNull
    List<DeptUpdateReqDTO> updateDeptList;
	
}
	