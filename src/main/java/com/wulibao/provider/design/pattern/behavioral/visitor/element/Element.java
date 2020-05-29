package com.wulibao.provider.design.pattern.behavioral.visitor.element;

import com.wulibao.provider.design.pattern.behavioral.visitor.visitor.Visitor;

/**
 * @author WuliBao
 * @date 2020-05-26
 */
public interface Element {
    /**
     * 接受访问者
     * 
     * @param visitor visitor
     */
    void accept(Visitor visitor);
}
