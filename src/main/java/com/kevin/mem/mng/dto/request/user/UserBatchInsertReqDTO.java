package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 用户BatchInsertReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:48
 */
@Data
public class UserBatchInsertReqDTO implements Serializable, DTO {

    @NotNull
    List<UserInsertReqDTO> insertUserList;

}
	