package com.wulis.common.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.wulis.config.mybatis.plus.MybatisPlusGeneratorConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * 代码生成入口
 * 
 * @author WuliBao
 * @date 2020-04-07
 */
@Slf4j
public class MybatisPlusGeneratorEntrance {
    
    public static void main(String[] args) {
        // 需要生成的表名
        String[] tableNames = new String[] {"permission_user"};
        // 获取代码生成对象及基础配置(可传模块名，默认取第一个表名的前缀)
        AutoGenerator generator = new MybatisPlusGeneratorConfig().mybatisPlusGenerator(tableNames, null);
        // 执行代码生成
        generator.execute();
    }
}
