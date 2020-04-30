package com.wulibao.provider.design.pattern.structural.adapter;

import com.wulibao.provider.design.pattern.structural.adapter.player.VideoMediaPlayer;

/**
 * 适配器模式
 * 
 * @author WuliBao
 * @date 2020-04-27
 */
public class AdapterPatternMain {
    public static void main(String[] args) {
        VideoMediaPlayer mediaPlayer = new VideoMediaPlayer();
        mediaPlayer.play("mp3", "周杰伦-晴天");
        mediaPlayer.play("wave", "林俊杰-江南");
        mediaPlayer.play("mp4", "周星驰-大话西游");
        mediaPlayer.play("rmvb", "徐峥-泰囧");
        mediaPlayer.play("avi", "梁朝伟-无间道");
    }
}
