package com.wulibao.provider.test.design.pattern.structural.adapter.player;

import java.util.HashMap;
import java.util.Map;

import com.wulibao.provider.test.design.pattern.structural.adapter.player.video.adapter.AudioMediaAdapter;
import com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.VideoMediaService;
import com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.impl.Mp4AudioPlayer;
import com.wulibao.provider.test.design.pattern.structural.adapter.player.video.service.impl.RmvbAudioPlayer;

/**
 * 播放器
 * 
 * @author WuliBao
 * @date 2020-04-27
 */

public class VideoMediaPlayer {
    private final AudioMediaAdapter audioMediaAdapter = new AudioMediaAdapter();
    
    private final Map<String, VideoMediaService> map = new HashMap<>(2);
    {
        map.put(Mp4AudioPlayer.MP4, new Mp4AudioPlayer());
        map.put(RmvbAudioPlayer.RMVB, new RmvbAudioPlayer());
    }
    
    public void play(String type, String fileName) {
        VideoMediaService video;
        // 定义MP4播放实现
        if (Mp4AudioPlayer.MP4.equals(type)) {
            video = map.get(Mp4AudioPlayer.MP4);
        }
        // 定义RMVB播放实现
        else if (RmvbAudioPlayer.RMVB.equals(type)) {
            video = map.get(RmvbAudioPlayer.RMVB);
        }
        // 交给适配器实现（音频播放器）
        else {
            video = audioMediaAdapter;
        }
        // 开始播放
        video.play(type, fileName);
    }
}
