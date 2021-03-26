package com.kk.taurus.playerbase.player;

import android.os.Bundle;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;

public abstract class BaseInternalPlayer implements IPlayer {
    private int mBufferPercentage;
    private int mCurrentState = 0;
    private OnBufferingListener mOnBufferingListener;
    private OnErrorEventListener mOnErrorEventListener;
    private OnPlayerEventListener mOnPlayerEventListener;

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void option(int i, Bundle bundle) {
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public final void setOnBufferingListener(OnBufferingListener onBufferingListener) {
        this.mOnBufferingListener = onBufferingListener;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public final void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public final void setOnErrorEventListener(OnErrorEventListener onErrorEventListener) {
        this.mOnErrorEventListener = onErrorEventListener;
    }

    /* access modifiers changed from: protected */
    public final void submitPlayerEvent(int i, Bundle bundle) {
        OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onPlayerEvent(i, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final void submitErrorEvent(int i, Bundle bundle) {
        OnErrorEventListener onErrorEventListener = this.mOnErrorEventListener;
        if (onErrorEventListener != null) {
            onErrorEventListener.onErrorEvent(i, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final void submitBufferingUpdate(int i, Bundle bundle) {
        this.mBufferPercentage = i;
        OnBufferingListener onBufferingListener = this.mOnBufferingListener;
        if (onBufferingListener != null) {
            onBufferingListener.onBufferingUpdate(i, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final void updateStatus(int i) {
        this.mCurrentState = i;
        Bundle obtain = BundlePool.obtain();
        obtain.putInt("int_data", i);
        submitPlayerEvent(-99031, obtain);
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getBufferPercentage() {
        return this.mBufferPercentage;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public final int getState() {
        return this.mCurrentState;
    }
}
