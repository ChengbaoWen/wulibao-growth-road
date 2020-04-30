package com.wulibao.provider.design.pattern.structural.adapter.player.audio.service;

/**
 * 音频播放器顶级接口
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public interface AudioMediaService {
    /**
     * 播放
     * 
     * @param type type
     * @param fileName fileName
     */
    void play(String type, String fileName);
}
