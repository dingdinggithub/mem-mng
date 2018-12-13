package com.kevin.mem.mng.service;

import com.github.pagehelper.Page;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.BaseEntity;

import java.util.List;

/**
 * 部门Service
 * @author 丁海峰
 * @date 2018-12-11 09:34:06
 */
public interface BaseService<T> {
	
	int insert(T record);

    void batchInsert(List<T> recordList);

    int updateById(T record);

    void batchUpdate(List<T> recordList);

    int deleteById(Long id);

    void batchDelete(List<Long> idList);

    T selectByCode(Long id);

    Page<T> queryPage(PageRequest<T> record);

    List<T> queryAll(T record);
	
}
	