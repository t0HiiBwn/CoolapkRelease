package com.kk.taurus.playerbase.player;

import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;

public interface IPlayer {
    public static final int STATE_END = -2;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETE = 6;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_STARTED = 3;
    public static final int STATE_STOPPED = 5;

    void destroy();

    int getAudioSessionId();

    int getBufferPercentage();

    int getCurrentPosition();

    int getDuration();

    int getState();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void option(int i, Bundle bundle);

    void pause();

    void reset();

    void resume();

    void seekTo(int i);

    void setDataSource(DataSource dataSource);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setOnBufferingListener(OnBufferingListener onBufferingListener);

    void setOnErrorEventListener(OnErrorEventListener onErrorEventListener);

    void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();

    void start(int i);

    void stop();
}
