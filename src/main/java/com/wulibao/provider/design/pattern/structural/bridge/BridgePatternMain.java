package com.wulibao.provider.design.pattern.structural.bridge;

import com.wulibao.provider.design.pattern.structural.bridge.color.DrawColor;
import com.wulibao.provider.design.pattern.structural.bridge.color.service.impl.BlueColorServiceImpl;
import com.wulibao.provider.design.pattern.structural.bridge.color.service.impl.RedColorServiceImpl;

/**
 * 桥接模式
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class BridgePatternMain {
    public static void main(String[] args) {
        // 红色
        DrawColor red = new DrawColor("希望打印红色", new RedColorServiceImpl());
        red.draw();
        
        // 蓝色
        DrawColor blue = new DrawColor("希望打印蓝色", new BlueColorServiceImpl());
        blue.draw();
    }
}
