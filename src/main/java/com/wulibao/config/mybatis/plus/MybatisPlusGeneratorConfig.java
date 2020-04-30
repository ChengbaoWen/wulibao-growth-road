package com.wulibao.config.mybatis.plus;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static com.wulibao.common.constant.GlobalConstant.AUTHOR;

/**
 * mybatis-plus代码生成器配置
 *
 * @author : WuliBao
 */
@Slf4j
public class MybatisPlusGeneratorConfig {

    /**
     * 代码生成基础配置
     *
     * @param moduleName 模块名称
     * @param tableNames 生成的表名集合
     */
    public AutoGenerator mybatisPlusGenerator(String[] tableNames, String moduleName) {
        if (tableNames.length == 0) {
            throw new RuntimeException("请输入表名");
        }
        // 如果没有传模块名，取表名集合中第一个表的前缀
        if (moduleName == null || StringUtils.isEmpty(moduleName)) {
            moduleName = tableNames[0].split("_")[0];
        }
        // 数据源配置文件(resource路径下)
        String dataSourceFile = "application-dev.yml";
        // 项目工程包名
        String packageName = "com.wulibao.provider";
        // Mapper XML路径（resource路径）
        String mapperPackage = "mapper";
        // 代码生成器配置
        return new AutoGenerator()
                // 数据源配置
                .setDataSource(getDataSourceConfig(dataSourceFile))
                // 包配置
                .setPackageInfo(getPackageConfig(packageName, moduleName))
                // 全局配置
                .setGlobalConfig(getGlobalConfig())
                // 策略配置
                .setStrategy(getStrategyConfig(tableNames, moduleName))
                // 设置模版工具
                .setTemplateEngine(new FreemarkerTemplateEngine())
                // 配置模板
                .setTemplate(getTemplateConfig())
                // 自定义配置
                .setCfg(getInjectionConfig(mapperPackage, moduleName));
    }

    /**
     * 获取信息作者
     */
    private String getAuthor() {
        // 默认hostName
        String hostName = "Unknown";
        try {
            // 获取本机计算机名称
            String author = InetAddress.getLocalHost().getHostName();
            // 极端情况获取的网卡计算机名称为：Unknown
            if (!hostName.equalsIgnoreCase(author)) {
                return author;
            }
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
        return AUTHOR;
    }

    /**
     * 全局配置
     *
     * @return GlobalConfig
     */
    private GlobalConfig getGlobalConfig() {
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        return new GlobalConfig()
                // 输出路径
                .setOutputDir(projectPath + "/" + "/src/main/java")
                // 作者
                .setAuthor(getAuthor())
                // 是否打开输出目录
                .setOpen(false)
                // 实体属性 Swagger2 注解
                .setSwagger2(true)
                // 是否覆盖已有文件
                .setFileOverride(false)
                // 生成BaseResultMap
                .setBaseResultMap(true)
                // 生成BaseColumnList
                // .setBaseColumnList(true)
                // 设置生成的实体类名称
                // .setEntityName("%sEntity")
                // 设置生成的Controller名称
                .setControllerName("%sController")
                // 设置生成的Service名称
                .setServiceName("%sService")
                // 设置生成的Service实现类名称
                .setServiceImplName("%sServiceImpl")
                // 设置生成的Mappler名称
                .setMapperName("%sMapper")
                // 设置生成的Mappler名称
                .setXmlName("%sMapper")
                // 开启 ActiveRecord 模式
                .setActiveRecord(true);
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名集合
     * @param moduleName 模块名称
     * @return StrategyConfig
     */
    private StrategyConfig getStrategyConfig(String[] tableNames, String moduleName) {
        return new StrategyConfig()
                // 表名生成策略 下划线转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                // 表字段生成策略 下划线转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 获取生成的表名
                .setInclude(tableNames)
                // 去掉表前缀(取自模块名)
                .setTablePrefix(moduleName + "_")
                // 实体类忽略BaseEntity字段
                .setSuperEntityColumns("id", "create_time", "create_by", "update_time", "update_by", "deleted")
                // 实体类生成字段注解
                .setEntityTableFieldAnnotationEnable(true)
                // 是否为lombok模型
                .setEntityLombokModel(true)
                // 生成controller
                .setRestControllerStyle(true)
                // controller映射路径驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 继承BaseEntity
                .setSuperEntityClass("com.wulibao.common.model.entity.BaseEntity")
                // 继承BaseController
                .setSuperControllerClass("com.wulibao.common.support.BaseController")
                // 继承BaseService
                .setSuperServiceClass("com.wulibao.common.support.BaseService")
                // 继承BaseServiceImpl
                .setSuperServiceImplClass("com.wulibao.common.support.BaseServiceImpl")
                // 继承BaseMapper
                .setSuperMapperClass("com.wulibao.common.support.BaseMapper");
    }

    /**
     * 数据源配置
     *
     * @param dataSourceFile 数据源文件
     * @return DataSourceConfig
     */
    private DataSourceConfig getDataSourceConfig(String dataSourceFile) {
        JSONObject yaml = null;
        // 读取yml文件
        try {
            ClassPathResource resource = new ClassPathResource(dataSourceFile);
            yaml = JSONObject.parseObject(JSONObject.toJSONString((new Yaml()).load(resource.getInputStream())));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (yaml == null) {
            throw new RuntimeException("加载数据源失败");
        }
        // 获取dataSource
        JSONObject dataSource = yaml.getJSONObject("spring").getJSONObject("datasource");
        return new DataSourceConfig()
                // Mysql连接池配置
                .setUrl(dataSource.getString("url"))
                .setDriverName(dataSource.getString("driver-class-name"))
                .setUsername(dataSource.getString("username"))
                .setPassword(dataSource.getString("password"));
    }

    /**
     * 包配置
     *
     * @param packageName 包路径
     * @param moduleName  模块名称
     * @return DataSourceConfig
     */
    private PackageConfig getPackageConfig(String packageName, String moduleName) {
        return new PackageConfig()
                // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                .setParent(packageName)
                // 父包模块名
                .setModuleName(moduleName)
                // Entity包名
                .setEntity("model.entity")
                // controller包名
                .setController("web");
    }

    /**
     * 设置模版
     * <p>
     * 指定自定义模板路径，且路径不可变, 位置：/resources/templates/entity.java.ftl(或者是.vm)
     *
     * @return TemplateConfig
     */
    private TemplateConfig getTemplateConfig() {
        // 注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
        return new TemplateConfig()
                // entity模版
                .setEntity("/templates/entity.java")
                // controller模版
                .setController("/templates/controller.java")
                // service模版
                .setService("/templates/service.java")
                // serviceImpl模版
                .setServiceImpl("/templates/serviceImpl.java")
                // mapper模版
                .setMapper("/templates/mapper.java")
                // xml模版（自定义实现）
                .setXml(null);

    }

    /**
     * 个性化配置
     *
     * @param mapperPackage xml存放路径
     * @param moduleName    模块名称
     * @return InjectionConfig
     */
    private InjectionConfig getInjectionConfig(String mapperPackage, String moduleName) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // xml模版
        String xmlPath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 自定义XML配置
        fileOutConfigs.add(new FileOutConfig(xmlPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/" + "/src/main/resources/" + mapperPackage + "/" + moduleName + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigs);
        return injectionConfig;
    }
}
