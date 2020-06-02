package com.wulibao.provider.di.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wulibao.provider.di.service.DiService;

/**
 * @author WuliBao
 * @date 2020-06-02
 */
@RestController
@RequestMapping("two")
public class TwoController {
    @Resource
    private DiService diService;
    
    @GetMapping("getServiceAddr")
    public String getServiceAddr() {
        return diService.getAddress();
    }
}
