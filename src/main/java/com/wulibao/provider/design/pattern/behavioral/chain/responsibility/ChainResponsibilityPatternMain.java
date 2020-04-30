package com.wulibao.provider.test.design.pattern.behavioral.chain.responsibility;

import com.wulibao.provider.test.design.pattern.behavioral.chain.responsibility.service.impl.ChimpanzeeChain;
import com.wulibao.provider.test.design.pattern.behavioral.chain.responsibility.service.impl.MonkeyChain;
import com.wulibao.provider.test.design.pattern.behavioral.chain.responsibility.service.impl.TigerChain;

/**
 * 责任链模式
 * 
 * @author WuliBao
 * @date 2020-04-29
 */
public class ChainResponsibilityPatternMain {
    public static void main(String[] args) {
        TigerChain tigerChain = new TigerChain();
        MonkeyChain monkeyChain = new MonkeyChain();
        ChimpanzeeChain chimpanzeeChain = new ChimpanzeeChain();
        tigerChain.setNextAnimalChain(monkeyChain);
        monkeyChain.setNextAnimalChain(chimpanzeeChain);
        boolean flag = tigerChain.animal("猩猩");
        System.out.println("结果：" + flag);
    }
}
