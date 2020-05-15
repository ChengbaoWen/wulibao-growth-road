package com.wulibao.provider.design.pattern.behavioral.interpreter.expression;

/**
 * @author WuliBao
 * @date 2020-05-06
 */
public class EndExpression implements Expression {
    
    private final String end;
    
    public EndExpression(String end) {
        this.end = end;
    }
    
    @Override
    public double interpret() {
        return Integer.parseInt(end);
    }
}
