package com.wulibao.provider.serialization;

import com.wulibao.provider.design.pattern.creational.prototype.util.CopyUtil;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 测试序列化工具是否能够序列化内部类
 * 
 * 结论：若内部类没有序列化标记则无法实现序列化
 * 
 * @author WuliBao
 * @date 2020-04-30
 */
@Data
@Builder
public class SerializeMain implements Serializable {
    private String name;
    
    private Integer age;
    
    private Hobby hobby;
    
    public static void main(String[] args) {
        SerializeMain ming =
            SerializeMain.builder().age(18).name("小明").hobby(new Hobby(Arrays.asList("篮球", "足球"))).build();
        System.out.println(ming);
        SerializeMain mingCopy = CopyUtil.deep(ming);
        System.out.println(mingCopy);
    }
    
    @Data
    public static class Hobby implements Serializable {
        private List<String> hobby;
        
        public Hobby(List<String> hobby) {
            this.hobby = hobby;
        }
    }
}
