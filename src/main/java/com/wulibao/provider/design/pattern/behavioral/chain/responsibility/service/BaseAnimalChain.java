package com.wulibao.provider.design.pattern.behavioral.chain.responsibility.service;

/**
 * @author WuliBao
 * @date 2020-04-29
 */
public abstract class BaseAnimalChain {
    private BaseAnimalChain nextAnimalChain;
    
    public void setNextAnimalChain(BaseAnimalChain baseAnimalChain) {
        this.nextAnimalChain = baseAnimalChain;
    }
    
    public boolean animal(String animal) {
        if (cheAnimal(animal)) {
            return true;
        }
        if (nextAnimalChain != null) {
            return nextAnimalChain.animal(animal);
        }
        System.out.println("无法匹配");
        return false;
    }
    
    /**
     * 检查动物
     * 
     * @param animal animal
     * @return boolean
     */
    abstract protected boolean cheAnimal(String animal);
}
