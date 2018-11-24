package com.kevin.mem.mng.dto.request.dept;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 部门BatchInsertReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:51
 */
@Data
public class DeptBatchInsertReqDTO implements Serializable, DTO {

    @NotNull
    List<DeptInsertReqDTO> insertDeptList;

}
	