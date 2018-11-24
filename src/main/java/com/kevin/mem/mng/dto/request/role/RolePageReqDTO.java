package com.kevin.mem.mng.dto.request.role;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色PageReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:49
 */
@Data
public class RolePageReqDTO implements Serializable, DTO {

    /**
     * 类型名
     */
    private String name;
    /**
     * 角色的类型，1：管理员角色，2：其他
     */
    private Integer type;
    /**
     * 状态
     */
    private Integer status;

}
	