package com.wulis.config.mybatis.plus.method;

import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @author WuliBao
 * @date 2020-04-07
 */
public class InsertDuplicateKeyUpdate extends AbstractMethod {
    public static final String SQL = "<script>insert into %s %s value %s on duplicate key update %s</script>";
    
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        final String fieldSql = prepareFieldSql(tableInfo);
        final String updateSql = prepareUpdateSqlForMysqlBatch(tableInfo);
        final String valueSql = prepareValueSqlForMysqlBatch(tableInfo);
        final String sqlResult = String.format(SQL, tableInfo.getTableName(), fieldSql, valueSql, updateSql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
        String keyColumn = null;
        String keyProperty = null;
        KeyGenerator keyGenerator = new NoKeyGenerator();
        if (StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
            if (tableInfo.getIdType() == IdType.AUTO) {
                keyGenerator = new Jdbc3KeyGenerator();
                keyProperty = tableInfo.getKeyProperty();
                keyColumn = tableInfo.getKeyColumn();
            }
            else if (null != tableInfo.getKeySequence()) {
                keyGenerator = TableInfoHelper.genKeyGenerator(this.getMethod(), tableInfo, this.builderAssistant);
                keyProperty = tableInfo.getKeyProperty();
                keyColumn = tableInfo.getKeyColumn();
            }
        }
        return this.addInsertMappedStatement(mapperClass,
            modelClass,
            getMethod(),
            sqlSource,
            keyGenerator,
            keyProperty,
            keyColumn);
    }
    
    /**
     * 获取方法名（与Mapper中的方法名要一致）
     * 
     * @return String
     */
    private String getMethod() {
        return "insertDuplicateKeyUpdate";
    }
    
    /**
     * 设置 insert into table (field) 部分
     *
     * @param tableInfo tableInfo
     * @return String
     */
    public static String prepareFieldSql(TableInfo tableInfo) {
        StringBuilder fieldSql = new StringBuilder();
        fieldSql.append(tableInfo.getKeyColumn()).append(",");
        tableInfo.getFieldList().forEach(x -> fieldSql.append(x.getColumn()).append(","));
        fieldSql.delete(fieldSql.length() - 1, fieldSql.length());
        fieldSql.insert(0, "(");
        fieldSql.append(")");
        return fieldSql.toString();
    }
    
    /**
     * 设置 value () 部分
     *
     * @param tableInfo tableInfo
     * @return String
     */
    private String prepareValueSqlForMysqlBatch(TableInfo tableInfo) {
        final StringBuilder valueSql = new StringBuilder();
        valueSql.append("(");
        valueSql.append("#{").append(tableInfo.getKeyProperty()).append("},");
        tableInfo.getFieldList().forEach(x -> valueSql.append("#{").append(x.getProperty()).append("},"));
        valueSql.delete(valueSql.length() - 1, valueSql.length());
        valueSql.append(")");
        return valueSql.toString();
    }
    
    /**
     * 设置 on duplicate key update 部分
     *
     * @param tableInfo tableInfo
     * @return String
     */
    private String prepareUpdateSqlForMysqlBatch(TableInfo tableInfo) {
        String createTime = "create_time";
        String createBy = "create_by";
        final StringBuilder updateSql = new StringBuilder();
        tableInfo.getFieldList().forEach(field -> {
            if (!createTime.equals(field.getColumn()) && !createBy.equals(field.getColumn())) {
                updateSql.append(field.getColumn()).append(" = ").append("#{").append(field.getProperty()).append("},");
            }
        });
        updateSql.delete(updateSql.length() - 1, updateSql.length());
        return updateSql.toString();
    }
}
