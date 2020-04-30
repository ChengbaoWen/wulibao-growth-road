package com.wulis.common.utils;

import java.time.LocalDateTime;

import com.wulis.common.model.emuns.DeletedStateEnum;
import com.wulis.common.model.entity.BaseEntity;

/**
 * @author WuliBao
 * @date 2020-04-07
 */
public class OperationUtil {
    /**
     * 设置基本操作信息
     *
     * @param accountId 用户ID
     * @param c 实体对象
     * @param <T> 抽象对象
     */
    public static <T extends BaseEntity<T>> void insertOperation(Long accountId, T c) {
        c.setCreateBy(accountId);
        c.setCreateTime(LocalDateTime.now());
        c.setUpdateBy(accountId);
        c.setUpdateTime(LocalDateTime.now());
        c.setDeleted(DeletedStateEnum.NOT_DELETED.value());
    }
    
    /**
     * 设置修改操作信息
     *
     * @param accountId 用户ID
     * @param c 实体对象
     * @param <T> 抽象对象
     */
    public static <T extends BaseEntity<T>> void updateOperation(Long accountId, T c) {
        c.setUpdateBy(accountId);
        c.setUpdateTime(LocalDateTime.now());
    }
    
    /**
     * 设置删除操作信息
     *
     * @param accountId 用户ID
     * @param c 实体对象
     * @param <T> 抽象对象
     */
    public static <T extends BaseEntity<T>> void deleteOperation(Long accountId, T c) {
        c.setDeleted(DeletedStateEnum.IS_DELETED.value());
        c.setUpdateBy(accountId);
        c.setUpdateTime(LocalDateTime.now());
    }
}
