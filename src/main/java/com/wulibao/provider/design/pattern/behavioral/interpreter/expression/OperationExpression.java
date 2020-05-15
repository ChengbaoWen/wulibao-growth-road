package com.wulibao.provider.design.pattern.behavioral.interpreter.expression;

import org.springframework.lang.NonNull;

/**
 * @author WuliBao
 * @date 2020-05-06
 */
public class OperationExpression {
    private static final String ADD = "+";
    
    private static final String SUB = "-";
    
    public static Expression get(@NonNull String expression) {
        if (expression.contains(ADD)) {
            int i = expression.indexOf(ADD);
            return new AddExpression(get(expression.substring(0, i)), get(expression.substring(i + 1)));
        }
        if (expression.contains(SUB)) {
            int i = expression.indexOf(SUB);
            return new SubtractExpression(get(expression.substring(0, i)), get(expression.substring(i + 1)));
        }
        return new EndExpression(expression);
    }
}
