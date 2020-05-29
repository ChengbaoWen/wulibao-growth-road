package com.wulibao.provider.design.pattern.behavioral.visitor;

import com.wulibao.provider.design.pattern.behavioral.visitor.element.BlueElement;
import com.wulibao.provider.design.pattern.behavioral.visitor.element.Element;
import com.wulibao.provider.design.pattern.behavioral.visitor.element.RedElement;
import com.wulibao.provider.design.pattern.behavioral.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuliBao
 * @date 2020-05-26
 */
public class VisitElements {
    /**
     * 所有被访问元素对象
     */
    private final List<Element> elements = new ArrayList<>();
    
    public VisitElements() {
        elements.add(new BlueElement());
        elements.add(new RedElement());
    }
    
    /**
     * 访问者访问所有元素对象
     * 
     * @param visitor visitor
     */
    void visit(Visitor visitor) {
        elements.forEach(element -> element.accept(visitor));
    }
}
