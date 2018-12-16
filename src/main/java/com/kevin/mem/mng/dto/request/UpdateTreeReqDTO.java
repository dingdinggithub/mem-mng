package com.kevin.mem.mng.dto.request;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 用户UpdateReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:02
 */
@Data
public class UpdateTreeReqDTO implements Serializable, DTO {

    @NotNull
    private Long modelId;

	@NotNull
    private List<Long> modelIdList;
	
}
	