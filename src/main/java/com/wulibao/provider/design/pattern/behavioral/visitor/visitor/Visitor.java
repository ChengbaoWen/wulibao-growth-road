package com.wulibao.provider.design.pattern.behavioral.visitor.visitor;

import com.wulibao.provider.design.pattern.behavioral.visitor.element.BlueElement;
import com.wulibao.provider.design.pattern.behavioral.visitor.element.RedElement;

/**
 * @author WuliBao
 * @date 2020-05-26
 */
public interface Visitor {
    
    /**
     * 访问红色元素
     * 
     * @param element element
     */
    void visit(RedElement element);
    
    /**
     * 访问蓝色元素
     *
     * @param element element
     */
    void visit(BlueElement element);
}
