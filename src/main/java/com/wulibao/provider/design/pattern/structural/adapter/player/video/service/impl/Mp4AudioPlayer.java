package com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.impl;

import com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.VideoMediaService;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class Mp4AudioPlayer implements VideoMediaService {
    public static final String MP4 = "mp4";
    
    @Override
    public void play(String type, String fileName) {
        if (MP4.equals(type)) {
            System.out.println("播放" + MP4 + ":" + fileName);
        }
    }
}
