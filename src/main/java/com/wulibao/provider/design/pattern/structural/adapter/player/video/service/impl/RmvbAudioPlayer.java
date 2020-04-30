package com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.impl;

import com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.VideoMediaService;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class RmvbAudioPlayer implements VideoMediaService {
    public static final String RMVB = "rmvb";
    
    @Override
    public void play(String type, String fileName) {
        if (RMVB.equals(type)) {
            System.out.println("播放" + RMVB + ":" + fileName);
        }
    }
}
