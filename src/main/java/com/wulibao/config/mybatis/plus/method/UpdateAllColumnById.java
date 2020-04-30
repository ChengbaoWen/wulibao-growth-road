package com.wulis.config.mybatis.plus.method;

import java.util.function.Predicate;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;

/**
 * @author WuliBao
 * @date 2020-04-07
 */
public class UpdateAllColumnById extends AbstractMethod {
    private Predicate<TableFieldInfo> predicate = null;
    
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.UPDATE_BY_ID;
        String additional = this.optlockVersion(tableInfo) + tableInfo.getLogicDeleteSql(true, true);
        String sqlSet = this
            .filterTableFieldInfo(tableInfo.getFieldList(), this.getPredicate(), (i) -> i.getSqlSet(true, "et."), "\n");
        sqlSet = SqlScriptUtils.convertSet(sqlSet);
        String sql = String.format(sqlMethod.getSql(),
            tableInfo.getTableName(),
            sqlSet,
            tableInfo.getKeyColumn(),
            "et." + tableInfo.getKeyProperty(),
            additional);
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        return this.addUpdateMappedStatement(mapperClass, modelClass, this.getMethod(sqlMethod), sqlSource);
    }
    
    private Predicate<TableFieldInfo> getPredicate() {
        Predicate<TableFieldInfo> noLogic = (t) -> !t.isLogicDelete();
        return this.predicate != null ? noLogic.and(this.predicate) : noLogic;
    }
    
    @Override
    public String getMethod(SqlMethod sqlMethod) {
        return "updateAllColumnById";
    }
    
    public UpdateAllColumnById() {
    }
}