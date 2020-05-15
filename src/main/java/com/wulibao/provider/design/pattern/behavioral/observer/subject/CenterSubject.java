package com.wulibao.provider.design.pattern.behavioral.observer.subject;

import lombok.*;

/**
 * 中央气象台
 * 
 * @author WuliBao
 * @date 2020-05-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CenterSubject extends BaseSubject<Integer> {
    /**
     * 气温
     */
    private Integer temperature;
    
    /**
     * 修改温度
     * 
     * @param temperature temperature
     */
    public void updateTemperature(Integer temperature) {
        // 修改温度
        this.temperature = temperature;
        // 通知观察者
        super.notifyAllObservers(this.temperature);
    }
}
