package com.kevin.mem.mng.domain.mapper;

import com.github.pagehelper.Page;

/**
 * @author 丁海峰
 * @DateTime 2018/11/13 22:40
 * @Description
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    Page<T> queryPage(T model);
}
