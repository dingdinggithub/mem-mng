package com.kevin.mem.mng.dto.request.authModule;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 权限模块关系PageReqDTO
 *
 * @author 丁海峰
 * @date 2018-11-24 02:26:50
 */
@Data
public class AuthModulePageReqDTO implements Serializable, DTO {

    /**
     * 权限码
     */
    private String code;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限所在的模块id
     */
    private Long moduleId;
    /**
     * 请求的url
     */
    private String url;
    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    private Integer type;
    /**
     * 权限模块在当前层级下的顺序，由小到大
     */
    private Integer seq;
    /**
     * 状态，1：正常，0：冻结
     */
    private Integer status;
}
	