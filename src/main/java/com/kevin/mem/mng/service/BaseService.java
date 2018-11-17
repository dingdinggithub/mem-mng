package com.kevin.mem.mng.service;

import com.github.pagehelper.Page;
import com.kevin.mem.mng.common.PageRequest;

/**
 * @author 丁海峰
 * @DateTime 2018/11/13 22:22
 * @Description
 */

public interface BaseService<T> {

    int deleteByCode(Long id);

    int insert(T record);

    T selectByCode(Long id);

    int updateByPrimaryKey(T record);

    Page<T> queryPage(PageRequest<T> record);
}
