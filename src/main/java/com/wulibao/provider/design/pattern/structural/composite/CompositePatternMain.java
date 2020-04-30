package com.wulibao.provider.design.pattern.structural.composite;

import com.wulibao.provider.design.pattern.structural.composite.menu.Menu;

/**
 * 组合模式
 * 
 * @author WuliBao
 * @date 2020-04-28
 */
public class CompositePatternMain {
    public static void main(String[] args) {
        Menu one1 = new Menu().setName("1-1");
        Menu two1 = new Menu().setName("2-1");
        Menu two2 = new Menu().setName("2-2");
        Menu three1 = new Menu().setName("3-1");
        Menu three2 = new Menu().setName("3-2");
        Menu three3 = new Menu().setName("3-3");
        two1.addMenu(three1).addMenu(three2);
        two2.addMenu(three3);
        one1.addMenu(two1).addMenu(two2);
        System.out.println(one1);
    }
}
