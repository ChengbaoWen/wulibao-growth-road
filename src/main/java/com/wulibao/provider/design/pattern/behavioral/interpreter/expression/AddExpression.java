package com.wulibao.provider.design.pattern.behavioral.interpreter.expression;

/**
 * 加法计算器
 * 
 * @author WuliBao
 * @date 2020-05-06
 */
public class AddExpression implements Expression {
    private final Expression before, after;
    
    public AddExpression(Expression before, Expression after) {
        this.before = before;
        this.after = after;
        
    }
    
    @Override
    public double interpret() {
        return before.interpret() + after.interpret();
    }
}
