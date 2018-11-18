package com.kevin.mem.mng.dto.request.user;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 丁海峰
 * @DateTime 2018/11/17 14:34
 * @Description
 */
@Data
public class UserUpdateReqDTO implements Serializable, DTO {
    private Long id;

    @NotBlank
    private String userCode;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Integer status;
}
