package com.kevin.mem.mng.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @author 丁海峰
 * @DateTime 2018/12/9 17:51
 * @Description
 */
@Data
public class KeyValueLevelDTO {
    private Integer code;//字段编号

    private String desc;//字段描述

    private List<KeyValueLevelDTO> children;
}
