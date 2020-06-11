package com.wulibao.provider.object.layout;

import org.openjdk.jol.info.ClassLayout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Object Layout测试
 * 
 * 1.Mark Word：包含一系列的标记位，比如轻量级锁的标记位，偏向锁标记位等等。在64位系统中占8字节；
 * 
 * 2.Class Pointer：用来指向对象对应的Class对象（其对应的元数据对象）的内存地址。在64位系统中占8字节；
 *
 * 3.Instance data: 不同数据类型的长度不同
 * 
 * 4.补充部分（使对象布局整体数据为8字节的整数倍）
 * 
 * @author WuliBao
 * @date 2020-06-03
 */
public class ObjectLayoutMain {
    public static void main(String[] args)
        throws InterruptedException {
        Student student = Student.builder().age(18).name("小明").build();
        // 未加锁，看mark word标记
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
        Thread.sleep(5000);
        // 加入锁，看mark word标记的改变
        synchronized (student) {
            System.out.println(ClassLayout.parseInstance(student).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Student {
        
        private String name;
        
        private Integer age;
    }
}
