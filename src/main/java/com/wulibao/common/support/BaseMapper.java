package com.wulibao.common.support;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.toolkit.Constants;

/**
 * @author WuliBao
 */
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
    /**
     * 批量插入
     * 
     * @param list list
     * @return int
     */
    int insertBatch(List<T> list);
    
    /**
     * 插入,如果存在则更新
     *
     * @param entity entity
     * @return int
     */
    int insertDuplicateKeyUpdate(T entity);
    
    /**
     * 插入,如果存在则更新(批量)
     * 
     * @param list list
     * @return int
     */
    int insertBatchDuplicateKeyUpdate(@Param("list") List<T> list);
    
    /**
     * 根据ID更新（包含为空字段）
     *
     * @param entity entity
     * @return int
     */
    int updateAllColumnById(@Param(Constants.ENTITY) T entity);
}
