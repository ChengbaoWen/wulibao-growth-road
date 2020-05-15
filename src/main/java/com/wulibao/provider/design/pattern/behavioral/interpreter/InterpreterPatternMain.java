package com.wulibao.provider.design.pattern.behavioral.interpreter;

import com.wulibao.provider.design.pattern.behavioral.interpreter.expression.Expression;
import com.wulibao.provider.design.pattern.behavioral.interpreter.expression.OperationExpression;

/**
 * 解释器模式
 * 
 * @author WuliBao
 * @date 2020-04-30
 */
public class InterpreterPatternMain {
    
    public static void main(String[] args) {
        Expression expression = OperationExpression.get("1+3-2+100-20");
        double result = expression.interpret();
        System.out.println(result);
    }
}
