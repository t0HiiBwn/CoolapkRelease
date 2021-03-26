package com.kk.taurus.playerbase.receiver;

public interface PlayerStateGetter {
    int getBufferPercentage();

    int getCurrentPosition();

    int getDuration();

    int getState();

    boolean isBuffering();
}
