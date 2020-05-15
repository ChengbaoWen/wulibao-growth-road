package com.wulibao.provider.hashmap;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

/**
 * 测试hash碰撞
 * 
 * @author WuliBao
 * @date 2020-05-13
 */
public class HashMapMain {
    
    public static void main(String[] args) {
        // 创建学生实例
        Student ming = Student.builder().age(18).name("小明同学").build();
        Student gang = Student.builder().age(18).name("小刚同学").build();
        Student hong = Student.builder().age(18).name("小红同学").build();
        Student qiang = Student.builder().age(18).name("小强同学").build();
        Student han = Student.builder().age(18).name("小晗同学").build();
        // 创建老师实例
        Teacher li = Teacher.builder().age(18).name("李老师").build();
        Teacher zhao = Teacher.builder().age(18).name("赵老师").build();
        Teacher zhang = Teacher.builder().age(18).name("张老师").build();
        Teacher liu = Teacher.builder().age(18).name("刘老师").build();
        // 测试hash碰撞
        Map<Object, Object> map = new HashMap<>(16);
        map.put(ming, ming);
        map.put(gang, gang);
        map.put(hong, hong);
        map.put(qiang, qiang);
        map.put(han, han);
        map.put(li, li);
        map.put(zhao, zhao);
        map.put(zhang, zhang);
        map.put(liu, liu);
        map.put(zhang, zhang);
        System.out.println("map:" + map.toString());
    }
}

@Data
@Builder
class Student {
    private String name;
    
    private Integer age;
    
    /**
     * 重写hash code
     * 
     * 使Student类实例的hash 分组与age相关
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        return this.age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student)obj;
            return student.name.equals(this.name) && student.age.equals(this.age);
        }
        return false;
    }
}

@Data
@Builder
class Teacher {
    private String name;
    
    private Integer age;
    
    /**
     * 重写hash code
     * 
     * 使Teacher类实例的hash 分组与age相关
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return this.age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Teacher) {
            Teacher teacher = (Teacher)obj;
            return teacher.name.equals(this.name) && teacher.age.equals(this.age);
        }
        return false;
    }
}