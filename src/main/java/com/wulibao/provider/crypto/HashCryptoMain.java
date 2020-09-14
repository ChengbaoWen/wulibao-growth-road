package com.wulibao.provider.crypto;

import cn.hutool.crypto.SecureUtil;

/**
 * Hash加密技术
 * 
 * @author WuliBao
 * @date 2020-09-03
 */
public class HashCryptoMain {
    public static void main(String[] args) {
        // String hashcode生成方式
        String password = "abcdefg";
        int hash = hash(password.toCharArray());
        System.out.println("密码的散列值：" + hash);
        // md5加密方式
         String md5 = md5(password);
         System.out.println(md5);
    }
    
    private static int hash(char[] value) {
        int hashCode = 0;
        for (char c : value) {
            hashCode = 31 * hashCode + c;
        }
        return hashCode;
    }
    
    /**
     * MD5加密方式
     * 
     * @param password password
     */
    private static String md5(String password) {
        return SecureUtil.md5(password);
    }
}
