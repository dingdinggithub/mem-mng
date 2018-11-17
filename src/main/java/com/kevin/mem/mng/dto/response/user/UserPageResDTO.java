package com.kevin.mem.mng.dto.response.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 丁海峰
 * @DateTime 2018/11/17 15:21
 * @Description
 */
@Data
public class UserPageResDTO implements Serializable, DTO {

    private Long id;

    private String userCode;

    private String username;

    private String password;

    private Integer status;

}
