package com.wulibao.provider.design.pattern.structural.composite.menu;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author WuliBao
 * @date 2020-04-28
 */
@Data
@Accessors(chain = true)
public class Menu {
    
    private String name;
    
    private List<Menu> menus = new ArrayList<>();
    
    public Menu addMenu(Menu menu) {
        menus.add(menu);
        return this;
    }
}
