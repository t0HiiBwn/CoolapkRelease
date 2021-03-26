package com.kk.taurus.playerbase.assist;

import android.view.ViewGroup;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;
import com.kk.taurus.playerbase.provider.IDataProvider;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.OnReceiverEventListener;
import com.kk.taurus.playerbase.render.AspectRatio;

public interface AssistPlay {
    void attachContainer(ViewGroup viewGroup);

    void destroy();

    int getAudioSessionId();

    int getBufferPercentage();

    int getCurrentPosition();

    int getDuration();

    int getState();

    boolean isInPlaybackState();

    boolean isPlaying();

    void pause();

    void play();

    void play(boolean z);

    void rePlay(int i);

    void reset();

    void resume();

    void seekTo(int i);

    void setAspectRatio(AspectRatio aspectRatio);

    void setDataProvider(IDataProvider iDataProvider);

    void setDataSource(DataSource dataSource);

    void setOnErrorEventListener(OnErrorEventListener onErrorEventListener);

    void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener);

    void setOnProviderListener(IDataProvider.OnProviderListener onProviderListener);

    void setOnReceiverEventListener(OnReceiverEventListener onReceiverEventListener);

    void setReceiverGroup(IReceiverGroup iReceiverGroup);

    void setRenderType(int i);

    void setSpeed(float f);

    void setVolume(float f, float f2);

    void stop();

    boolean switchDecoder(int i);
}
