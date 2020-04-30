package com.wulibao.provider.design.pattern.structural.adapter.player.video.adapter;

import com.wulibao.provider.design.pattern.structural.adapter.player.video.service.VideoMediaService;
import com.wulibao.provider.design.pattern.structural.adapter.player.audio.AudioMediaPlayer;

/**
 * 音频播放器适配器
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class AudioMediaAdapter extends AudioMediaPlayer implements VideoMediaService {
    
    @Override
    public void play(String type, String fileName) {
        super.play(type, fileName);
    }
}
