package com.testPackage.DesignMode.adapter;

/**
 * 实现了 MediaPlayer 接口的适配器类
 */
public class MediaAdapter implements  MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if("vlc".equalsIgnoreCase(audioType)){
            advancedMusicPlayer = new VlcPlay();
        }
        if("mp4".equalsIgnoreCase(audioType)){
            advancedMusicPlayer = new Mp4Play();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if("vlc".equalsIgnoreCase(audioType)){
            advancedMusicPlayer.playVlc(fileName);
        }

        if("mp4".equalsIgnoreCase(audioType)){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
