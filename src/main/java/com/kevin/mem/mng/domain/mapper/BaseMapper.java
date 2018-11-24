package com.kevin.mem.mng.domain.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 丁海峰
 * @DateTime 2018/11/13 22:40
 * @Description
 */
public interface BaseMapper<T> {

    /* ********************************插入操作************************************************/

    /**
     * 插入实体
     *
     * @param record
     * @return
     */
    int insert(T record);

    /* ********************************更新操作************************************************/

    /**
     * 更新实体
     *
     * @param record
     * @return
     */
    int updateById(T record);


    /* ********************************删除操作************************************************/

    /**
     * 根据id删除实体(物理删)
     *
     * @param id
     * @return
     */
    int deleteById(@Param("id") Long id);

    /**
     * 根据id批量删除实体(物理删)
     *
     * @param idList
     * @return
     */
    int batchDelete(@Param("idList") List<Long> idList);

    /* ********************************查询操作************************************************/

    /**
     * 分页查询实体列表
     *
     * @param model
     * @return
     */
    Page<T> queryPage(T model);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    T selectById(@Param("id") Long id);
}
