package com.testPackage.DesignMode.Adapter;
// 定义媒体播放器
public interface MediaPlayer {
    /**
     * 播放
     * @param audioType 音频类型
     * @param fileName  文件名称
     */
     void play(String audioType,String fileName);
}
