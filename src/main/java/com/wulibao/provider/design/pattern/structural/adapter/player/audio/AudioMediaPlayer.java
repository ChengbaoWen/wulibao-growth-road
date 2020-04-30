package com.wulibao.provider.design.pattern.structural.adapter.player.audio;

import java.util.HashMap;
import java.util.Map;

import com.wulibao.provider.design.pattern.structural.adapter.player.audio.service.AudioMediaService;
import com.wulibao.provider.design.pattern.structural.adapter.player.audio.service.impl.Mp3AudioPlayer;
import com.wulibao.provider.design.pattern.structural.adapter.player.audio.service.impl.WaveAudioPlayer;

/**
 * @author WuliBao
 * @date 2020-04-27
 */
public class AudioMediaPlayer implements AudioMediaService {
    private final Map<String, AudioMediaService> map = new HashMap<>(2);
    {
        map.put(Mp3AudioPlayer.MP3, new Mp3AudioPlayer());
        map.put(WaveAudioPlayer.WAVE, new WaveAudioPlayer());
    }
    
    @Override
    public void play(String type, String fileName) {
        if (Mp3AudioPlayer.MP3.equals(type)) {
            map.get(Mp3AudioPlayer.MP3).play(type, fileName);
        }
        else if (WaveAudioPlayer.WAVE.equals(type)) {
            map.get(WaveAudioPlayer.WAVE).play(type, fileName);
        }
        else {
            System.out.println("暂不支持" + type + "格式");
        }
    }
}
