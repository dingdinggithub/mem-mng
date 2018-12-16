package com.kevin.mem.mng.domain.entity;

import lombok.Data;

/**
 * 权限模块关系Entity
 *
 * @author 丁海峰
 * @date 2018-11-24 02:22:00
 */
@Data
public class AuthModule extends BaseEntity {

    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限所在的模块id
     */
    private Long moduleId;

    /**
     * 权限所在的模块名
     */
    private String moduleName;
    /**
     * 请求的url
     */
    private String url;
    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    private Integer type;
    /**
     * 状态，1：正常，0：冻结
     */
    private Integer status;

}
	