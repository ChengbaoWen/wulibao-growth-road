package com.wulis.config.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;

/**
 * @author WuliBao
 * @date 2020-04-07
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.wulis.**.mapper")
public class MybatisPlusConfig {
    
    /**
     * MyBatis-Plus 分页设置
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求 默认false
        paginationInterceptor.setOverflow(false);
        // 开启 count 的 join 优化,只针对 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
    
    /**
     * 开启MyBatis-Plus 乐观锁 @Version 特别说明（重点了解）：
     * 1.支持的数据类型只有:int,Integer,long,Long,Date,Timestamp,LocalDateTime
     * 2.整数类型下 newVersion = oldVersion + 1
     * 3.newVersion 会回写到 entity 中
     * 4.仅支持 updateById(id) 与 update(entity, wrapper) 方法
     * 5.在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
     * @return OptimisticLockerInterceptor
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
    
    /**
     * 自定义 SqlInjector 里面包含自定义的全局方法
     */
    @Bean
    public LogicSqlInjector logicSqlInjector() {
        return new LogicSqlInjector();
    }
}
