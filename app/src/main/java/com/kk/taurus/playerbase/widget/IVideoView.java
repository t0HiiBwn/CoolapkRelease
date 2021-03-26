package com.kk.taurus.playerbase.widget;

import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.render.AspectRatio;
import com.kk.taurus.playerbase.render.IRender;

public interface IVideoView {
    int getAudioSessionId();

    int getBufferPercentage();

    int getCurrentPosition();

    int getDuration();

    IRender getRender();

    int getState();

    boolean isInPlaybackState();

    boolean isPlaying();

    void pause();

    void resume();

    void seekTo(int i);

    void setAspectRatio(AspectRatio aspectRatio);

    void setDataSource(DataSource dataSource);

    void setRenderType(int i);

    void setSpeed(float f);

    void setVolume(float f, float f2);

    void start();

    void start(int i);

    void stop();

    void stopPlayback();

    boolean switchDecoder(int i);
}
