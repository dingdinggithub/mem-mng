package com.kevin.mem.mng.dto.response;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色关系PageResDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class UpdateTreeAuthListResDTO implements Serializable, DTO {

    private Long modelId;

    private String treeJson;

}
	