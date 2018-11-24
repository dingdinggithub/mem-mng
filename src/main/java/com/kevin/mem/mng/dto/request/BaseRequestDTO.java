package com.kevin.mem.mng.dto.request;

import com.kevin.common.domain.dto.DTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 丁海峰
 * @DateTime 2018/11/17 16:55
 * @Description
 */
@Data
public class BaseRequestDTO<T> implements Serializable, DTO {
    T model;
}
