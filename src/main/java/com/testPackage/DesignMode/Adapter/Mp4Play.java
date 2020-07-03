package com.testPackage.DesignMode.Adapter;

public class Mp4Play implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file. Name: "+ fileName);
    }
}
