package com.wulibao.provider.crypto;

/**
 * 对称加密方式
 * 
 * @author WuliBao
 * @date 2020-09-04
 */
public class SymmetricKeyCryptoMain {
    public static void main(String[] args) {
        // 密钥
        Integer secretKey = 22;
        // 密码
        String password = "AGDEBCF";
        System.out.println("原始密码：" + password);
        // 加密
        password = encryption(password, secretKey);
        System.out.println("加密后结果：" + password);
        // 解密
        password = decrypt(password, secretKey);
        System.out.println("解密后结果：" + password);
    }
    
    /**
     * 加密算法
     *
     * @param password 明文密码
     * @param secretKey 密钥
     * @return int
     */
    public static String encryption(String password, Integer secretKey) {
        char[] array = new char[password.length()];
        byte[] bytes = password.getBytes();
        for (int i = 0; i < password.length(); i++) {
            array[i] = (char)(bytes[i] + secretKey);
        }
        return String.valueOf(array);
    }
    
    /**
     * 解密算法
     *
     * @param password 明文密码
     * @param secretKey 密钥
     * @return int
     */
    public static String decrypt(String password, Integer secretKey) {
        char[] array = new char[password.length()];
        byte[] bytes = password.getBytes();
        for (int i = 0; i < password.length(); i++) {
            array[i] = (char)(bytes[i] - secretKey);
        }
        return String.valueOf(array);
    }
}
