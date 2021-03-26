package com.qq.e.comm.pi;

public interface AdData {

    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    int getECPM();

    String getECPMLevel();

    <T> T getProperty(Class<T> cls);

    String getProperty(String str);

    String getTitle();

    int getVideoDuration();
}
