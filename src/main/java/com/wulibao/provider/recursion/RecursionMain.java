package com.wulibao.provider.recursion;

/**
 * 递归方法
 * 
 * @author WuliBao
 * @date 2020-05-06
 */
public class RecursionMain {
    
    public static void main(String[] args) {
        int result = function(1);
        System.out.println(result);
    }
    
    private static int function(int param) {
        if (param >= 10) {
            return param;
        }
        else {
            return function(param + 1) + function(param + 1);
        }
    }
}
