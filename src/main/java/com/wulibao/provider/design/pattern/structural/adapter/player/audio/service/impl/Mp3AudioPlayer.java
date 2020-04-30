package com.wulibao.provider.test.design.pattern.structural.adapter.player.audio.service.impl;

import com.wulibao.provider.test.design.pattern.structural.adapter.player.audio.service.AudioMediaService;
import org.springframework.lang.NonNull;

/**
 * MP3音频播放实现
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class Mp3AudioPlayer implements AudioMediaService {
    public static final String MP3 = "mp3";
    
    @Override
    public void play(@NonNull String type, @NonNull String fileName) {
        if (MP3.equals(type)) {
            System.out.println("播放" + MP3 + ":" + fileName);
        }
    }
}
