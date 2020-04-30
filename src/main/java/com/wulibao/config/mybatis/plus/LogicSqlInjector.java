package com.wulis.config.mybatis.plus;

import java.util.List;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.wulis.config.mybatis.plus.method.InsertBatch;
import com.wulis.config.mybatis.plus.method.InsertBatchDuplicateKeyUpdate;
import com.wulis.config.mybatis.plus.method.InsertDuplicateKeyUpdate;
import com.wulis.config.mybatis.plus.method.UpdateAllColumnById;

/**
 * @author WuliBao
 * @date 2020-04-07
 */
public class LogicSqlInjector extends DefaultSqlInjector {
    
    /**
     * 如果只需增加方法，保留MP自带方法 可以super.getMethodList() 再add
     * 
     * @return List<AbstractMethod>
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        // 批量新增
        methodList.add(new InsertBatch());
        // 存在则更新
        methodList.add(new InsertDuplicateKeyUpdate());
        // 存在则更新(批量)
        methodList.add(new InsertBatchDuplicateKeyUpdate());
        // 更新方法（包含为空字段）
        methodList.add(new UpdateAllColumnById());
        return methodList;
    }
}