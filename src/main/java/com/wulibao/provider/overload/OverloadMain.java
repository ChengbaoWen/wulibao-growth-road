package com.wulibao.provider.overload;

/**
 * 重载方法匹配顺序测试
 * 
 * @author WuliBao
 * @date 2020-05-20
 */
public class OverloadMain {
    public static void main(String[] args) {
        Print print = new Print();
        Color color = new Color();
        Color red = new Red();
        Blue blue = new Blue();
        print.print(red);
        print.print(blue);
        print.print(color);
        
    }
    
    static class Print {
        void print(Color color) {
            System.out.println(1);
            color.print();
        }
        
        void print(Red color) {
            System.out.println(2);
            color.print();
        }
        
        void print(Blue color) {
            System.out.println(3);
            color.print();
        }
    }
    
    static class Color {
        void print() {
            System.out.println("默认颜色");
        }
    }
    
    static class Red extends Color {
        @Override
        void print() {
            System.out.println("红色");
        }
    }
    
    static class Blue extends Color {
        @Override
        void print() {
            System.out.println("蓝色");
        }
    }
    
}
