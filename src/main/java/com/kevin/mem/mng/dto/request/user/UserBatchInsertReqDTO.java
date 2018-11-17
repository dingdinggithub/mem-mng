package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 丁海峰
 * @DateTime 2018/11/17 14:32
 * @Description
 */
@Data
public class UserBatchInsertReqDTO implements Serializable, DTO {
    List<UserInsertReqDTO> userInsertReqDTOList;
}
