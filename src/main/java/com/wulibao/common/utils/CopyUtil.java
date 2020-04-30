package com.wulibao.common.utils;

import java.io.*;

import lombok.NonNull;

/**
 * 利用序列化方式实现深度克隆
 * 
 * 注意：若对象中包含内部类或其他对象属性，需要对应的内部类或对象同样实现序列化标记
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class CopyUtil {
    public static <T extends Serializable> T deep(@NonNull T obj) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            @SuppressWarnings("unchecked")
            T copy = (T)objectInputStream.readObject();
            return copy;
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
