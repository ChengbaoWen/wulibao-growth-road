package com.wulis.config.mybatis.plus.method;

import static com.wulis.config.mybatis.plus.method.InsertDuplicateKeyUpdate.prepareFieldSql;

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
public class InsertBatchDuplicateKeyUpdate extends AbstractMethod {
    
    public static final String SQL = "<script>insert into %s %s values %s on duplicate key update %s</script>";
    
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        KeyGenerator keyGenerator = new NoKeyGenerator();
        String keyProperty = null;
        String keyColumn = null;
        if (StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
            if (tableInfo.getIdType() == IdType.AUTO) {
                keyProperty = tableInfo.getKeyProperty();
                keyGenerator = new Jdbc3KeyGenerator();
                keyColumn = tableInfo.getKeyColumn();
            }
            else if (null != tableInfo.getKeySequence()) {
                keyGenerator = TableInfoHelper.genKeyGenerator(this.getMethod(), tableInfo, this.builderAssistant);
                keyProperty = tableInfo.getKeyProperty();
                keyColumn = tableInfo.getKeyColumn();
            }
        }
        final String fieldSql = prepareFieldSql(tableInfo);
        final String valueSql = prepareValuesSqlForMysqlBatch(tableInfo);
        final String updateSql = prepareUpdateSqlForMysqlBatch(tableInfo);
        final String sqlResult = String.format(SQL, tableInfo.getTableName(), fieldSql, valueSql, updateSql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
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
        return "insertBatchDuplicateKeyUpdate";
    }
    
    /**
     * 设置 values () 部分
     *
     * @param tableInfo tableInfo
     * @return String
     */
    private String prepareValuesSqlForMysqlBatch(TableInfo tableInfo) {
        final StringBuilder valueSql = new StringBuilder();
        valueSql.append(
            "<foreach collection=\"list\" item=\"item\" index=\"index\" open=\"(\" separator=\"),(\" close=\")\">");
        valueSql.append("#{item.").append(tableInfo.getKeyProperty()).append("},");
        tableInfo.getFieldList().forEach(x -> valueSql.append("#{item.").append(x.getProperty()).append("},"));
        valueSql.delete(valueSql.length() - 1, valueSql.length());
        valueSql.append("</foreach>");
        return valueSql.toString();
    }
    
    /**
     * 设置 on duplicate key update 部分
     *
     * @param tableInfo tableInfo
     * @return String
     */
    private String prepareUpdateSqlForMysqlBatch(TableInfo tableInfo) {
        String createBy = "create_by";
        String createTime = "create_time";
        final StringBuilder updateSql = new StringBuilder();
        tableInfo.getFieldList().forEach(field -> {
            if (!createTime.equals(field.getColumn()) && !createBy.equals(field.getColumn())) {
                updateSql.append(field.getColumn())
                    .append(" = ")
                    .append("values(")
                    .append(field.getColumn())
                    .append("),");
            }
        });
        updateSql.delete(updateSql.length() - 1, updateSql.length());
        return updateSql.toString();
    }
}
