package com.wulibao.provider.design.pattern.behavioral.visitor.visitor;

import com.wulibao.provider.design.pattern.behavioral.visitor.element.BlueElement;
import com.wulibao.provider.design.pattern.behavioral.visitor.element.RedElement;

/**
 * @author WuliBao
 * @date 2020-05-26
 */
public class SquareVisitor implements Visitor {
    private final String shape = "方形";
    
    /**
     * 访问红色元素
     *
     * @param element element
     */
    @Override
    public void visit(RedElement element) {
        String color = element.getColor();
        System.out.println("画一个" + color + "的" + shape);
    }
    
    /**
     * 访问蓝色元素
     *
     * @param element element
     */
    @Override
    public void visit(BlueElement element) {
        String color = element.getColor();
        System.out.println("画一个" + color + "的" + shape);
    }
    
}
