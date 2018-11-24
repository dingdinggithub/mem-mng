package com.kevin.mem.mng.dto.request.authModule;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 权限模块关系BatchDeleteReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class AuthModuleBatchDeleteReqDTO implements Serializable, DTO {

    @NotNull
    private List<Long> idList;

}
	