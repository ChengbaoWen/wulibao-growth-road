package com.wulibao.common.model.emuns;

import lombok.AllArgsConstructor;

/**
 * 删除状态
 *
 * @author WuliBao
 * @date 2020-04-07
 */
@AllArgsConstructor
public enum DeletedStateEnum {
    
    /**
     * 删除状态 0未删除 1已删除
     */
    NOT_DELETED(0, "未删除"),
    
    IS_DELETED(1, "已删除");
    
    private final Integer value;
    
    private final String desc;
    
    public Integer value() {
        return this.value;
    }
    
    public String desc() {
        return this.desc;
    }
    
}
