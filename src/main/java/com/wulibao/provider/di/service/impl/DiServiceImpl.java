package com.wulibao.provider.di.service.impl;

import com.wulibao.provider.di.service.DiService;
import org.openjdk.jol.vm.VM;
import org.springframework.stereotype.Service;

/**
 * @author WuliBao
 * @date 2020-06-02
 */
@Service
public class DiServiceImpl implements DiService {
    @Override
    public String getAddress() {
        // 获取DiServiceImpl内存地址值
        long address = VM.current().addressOf(this);
        System.out.println("DiServiceImpl内存地址值：" + address);
        return String.valueOf(address);
    }
}
