package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

/**
 * 用户BatchDeleteReqDTO
 * @author 丁海峰
 * @date 2018-12-13 11:21:02
 */
@Data
public class UserBatchDeleteReqDTO implements Serializable, DTO {

	@NotNull
    private List<Long> idList;
	
}
	