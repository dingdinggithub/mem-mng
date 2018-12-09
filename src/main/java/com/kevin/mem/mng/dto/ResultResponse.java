package com.kevin.mem.mng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 丁海峰
 * @DateTime 2018/12/2 18:24
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse<T> implements Serializable {
    private T model;
}
