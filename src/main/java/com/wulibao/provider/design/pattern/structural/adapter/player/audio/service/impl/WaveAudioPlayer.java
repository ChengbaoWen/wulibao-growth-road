package com.wulibao.provider.design.pattern.structural.adapter.player.audio.service.impl;

import com.wulibao.provider.design.pattern.structural.adapter.player.audio.service.AudioMediaService;
import org.springframework.lang.NonNull;

/**
 * WAVE 格式音频播放实现
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class WaveAudioPlayer implements AudioMediaService {
    public static final String WAVE = "wave";
    
    @Override
    public void play(@NonNull String type, @NonNull String fileName) {
        if (WAVE.equals(type)) {
            System.out.println("播放" + WAVE + ":" + fileName);
        }
    }
}
