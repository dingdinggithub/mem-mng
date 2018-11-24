package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author 丁海峰
 * @DateTime 2018/11/17 14:34
 * @Description
 */
@Data
public class UserBatchDeleteReqDTO implements Serializable, DTO {
    @NotNull
    private List<Long> idList;
}
