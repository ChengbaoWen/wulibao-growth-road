package com.wulibao.provider.design.pattern.behavioral.visitor;

import com.wulibao.provider.design.pattern.behavioral.visitor.visitor.CircularVisitor;
import com.wulibao.provider.design.pattern.behavioral.visitor.visitor.SquareVisitor;

/**
 * 访问者模式
 * 
 * @author WuliBao
 * @date 2020-05-21
 */
public class VisitorPatternMain {
    public static void main(String[] args) {
        VisitElements visitElements = new VisitElements();
        // 圆形访问者访问不同的颜色元素
        visitElements.visit(new CircularVisitor());
        // 方形访问者访问不同的颜色元素
        visitElements.visit(new SquareVisitor());
    }
}
