package com.wulibao.provider.design.pattern.behavioral.visitor.element;

import com.wulibao.provider.design.pattern.behavioral.visitor.visitor.Visitor;
import lombok.Data;

/**
 * @author WuliBao
 * @date 2020-05-26
 */
@Data
public class BlueElement implements Element {
    private String color = "蓝色";
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
