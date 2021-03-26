package com.kk.taurus.playerbase;

import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kk.taurus.playerbase.config.PlayerConfig;
import com.kk.taurus.playerbase.config.PlayerLoader;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.entity.DecoderPlan;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.player.BaseInternalPlayer;
import com.kk.taurus.playerbase.player.IPlayer;
import com.kk.taurus.playerbase.player.OnBufferingListener;
import com.kk.taurus.playerbase.player.TimerCounterProxy;
import com.kk.taurus.playerbase.provider.IDataProvider;
import java.io.Serializable;

public final class AVPlayer implements IPlayer {
    private final String TAG;
    private IDataProvider mDataProvider;
    private DataSource mDataSource;
    private int mDecoderPlanId;
    private OnBufferingListener mInternalBufferingListener;
    private OnErrorEventListener mInternalErrorEventListener;
    private BaseInternalPlayer mInternalPlayer;
    private OnPlayerEventListener mInternalPlayerEventListener;
    private IDataProvider.OnProviderListener mInternalProviderListener;
    private OnBufferingListener mOnBufferingListener;
    private TimerCounterProxy.OnCounterUpdateListener mOnCounterUpdateListener;
    private OnErrorEventListener mOnErrorEventListener;
    private OnPlayerEventListener mOnPlayerEventListener;
    private IDataProvider.OnProviderListener mOnProviderListener;
    private TimerCounterProxy mTimerCounterProxy;
    private float mVolumeLeft;
    private float mVolumeRight;

    public AVPlayer() {
        this(PlayerConfig.getDefaultPlanId());
    }

    public AVPlayer(int i) {
        this.TAG = "AVPlayer";
        this.mVolumeLeft = -1.0f;
        this.mVolumeRight = -1.0f;
        this.mOnCounterUpdateListener = new TimerCounterProxy.OnCounterUpdateListener() {
            /* class com.kk.taurus.playerbase.AVPlayer.AnonymousClass1 */

            @Override // com.kk.taurus.playerbase.player.TimerCounterProxy.OnCounterUpdateListener
            public void onCounter() {
                int currentPosition = AVPlayer.this.getCurrentPosition();
                int duration = AVPlayer.this.getDuration();
                int bufferPercentage = AVPlayer.this.getBufferPercentage();
                if (duration > 0 || AVPlayer.this.isLive()) {
                    Bundle obtain = BundlePool.obtain();
                    obtain.putInt("int_arg1", currentPosition);
                    obtain.putInt("int_arg2", duration);
                    obtain.putInt("int_arg3", bufferPercentage);
                    AVPlayer.this.callBackPlayEventListener(-99019, obtain);
                }
            }
        };
        this.mInternalPlayerEventListener = new OnPlayerEventListener() {
            /* class com.kk.taurus.playerbase.AVPlayer.AnonymousClass2 */

            @Override // com.kk.taurus.playerbase.event.OnPlayerEventListener
            public void onPlayerEvent(int i, Bundle bundle) {
                if (i == -99018 && (AVPlayer.this.mVolumeLeft > 0.0f || AVPlayer.this.mVolumeRight > 0.0f)) {
                    AVPlayer.this.mInternalPlayer.setVolume(AVPlayer.this.mVolumeLeft, AVPlayer.this.mVolumeRight);
                }
                AVPlayer.this.mTimerCounterProxy.proxyPlayEvent(i, bundle);
                AVPlayer.this.callBackPlayEventListener(i, bundle);
            }
        };
        this.mInternalErrorEventListener = new OnErrorEventListener() {
            /* class com.kk.taurus.playerbase.AVPlayer.AnonymousClass3 */

            @Override // com.kk.taurus.playerbase.event.OnErrorEventListener
            public void onErrorEvent(int i, Bundle bundle) {
                AVPlayer.this.mTimerCounterProxy.proxyErrorEvent(i, bundle);
                AVPlayer.this.callBackErrorEventListener(i, bundle);
            }
        };
        this.mInternalBufferingListener = new OnBufferingListener() {
            /* class com.kk.taurus.playerbase.AVPlayer.AnonymousClass4 */

            @Override // com.kk.taurus.playerbase.player.OnBufferingListener
            public void onBufferingUpdate(int i, Bundle bundle) {
                if (AVPlayer.this.mOnBufferingListener != null) {
                    AVPlayer.this.mOnBufferingListener.onBufferingUpdate(i, bundle);
                }
            }
        };
        this.mInternalProviderListener = new IDataProvider.OnProviderListener() {
            /* class com.kk.taurus.playerbase.AVPlayer.AnonymousClass5 */

            @Override // com.kk.taurus.playerbase.provider.IDataProvider.OnProviderListener
            public void onProviderDataStart() {
                if (AVPlayer.this.mOnProviderListener != null) {
                    AVPlayer.this.mOnProviderListener.onProviderDataStart();
                }
                AVPlayer.this.callBackPlayEventListener(-99050, null);
            }

            @Override // com.kk.taurus.playerbase.provider.IDataProvider.OnProviderListener
            public void onProviderDataSuccess(int i, Bundle bundle) {
                if (AVPlayer.this.mOnProviderListener != null) {
                    AVPlayer.this.mOnProviderListener.onProviderDataSuccess(i, bundle);
                }
                if (i != -77001) {
                    AVPlayer.this.callBackPlayEventListener(i, bundle);
                } else if (bundle != null) {
                    Serializable serializable = bundle.getSerializable("serializable_data");
                    if (serializable == null || !(serializable instanceof DataSource)) {
                        throw new RuntimeException("provider media success SERIALIZABLE_DATA must type of DataSource!");
                    }
                    DataSource dataSource = (DataSource) serializable;
                    PLog.d("AVPlayer", "onProviderDataSuccessMediaData : DataSource = " + dataSource);
                    AVPlayer.this.interPlayerSetDataSource(dataSource);
                    AVPlayer.this.internalPlayerStart(dataSource.getStartPos());
                    AVPlayer.this.callBackPlayEventListener(-99051, bundle);
                }
            }

            @Override // com.kk.taurus.playerbase.provider.IDataProvider.OnProviderListener
            public void onProviderError(int i, Bundle bundle) {
                Bundle bundle2;
                PLog.e("AVPlayer", "onProviderError : code = " + i + ", bundle = " + bundle);
                if (AVPlayer.this.mOnProviderListener != null) {
                    AVPlayer.this.mOnProviderListener.onProviderError(i, bundle);
                }
                if (bundle != null) {
                    bundle2 = new Bundle(bundle);
                } else {
                    bundle2 = new Bundle();
                }
                bundle2.putInt("int_data", i);
                AVPlayer.this.callBackPlayEventListener(i, bundle);
                AVPlayer.this.callBackErrorEventListener(-88000, bundle2);
            }
        };
        this.mTimerCounterProxy = new TimerCounterProxy(1000);
        loadInternalPlayer(i);
    }

    private void loadInternalPlayer(int i) {
        this.mDecoderPlanId = i;
        destroy();
        BaseInternalPlayer loadInternalPlayer = PlayerLoader.loadInternalPlayer(i);
        this.mInternalPlayer = loadInternalPlayer;
        if (loadInternalPlayer != null) {
            DecoderPlan plan = PlayerConfig.getPlan(this.mDecoderPlanId);
            if (plan != null) {
                PLog.d("AVPlayer", "=============================");
                PLog.d("AVPlayer", "DecoderPlanInfo : planId      = " + plan.getIdNumber());
                PLog.d("AVPlayer", "DecoderPlanInfo : classPath   = " + plan.getClassPath());
                PLog.d("AVPlayer", "DecoderPlanInfo : desc        = " + plan.getDesc());
                PLog.d("AVPlayer", "=============================");
                return;
            }
            return;
        }
        throw new RuntimeException("init decoder instance failure, please check your configuration, maybe your config classpath not found.");
    }

    public boolean switchDecoder(int i) {
        if (this.mDecoderPlanId == i) {
            PLog.e(getClass().getSimpleName(), "@@Your incoming planId is the same as the current use planId@@");
            return false;
        } else if (PlayerConfig.isLegalPlanId(i)) {
            loadInternalPlayer(i);
            return true;
        } else {
            throw new IllegalArgumentException("Illegal plan id = " + i + ", please check your config!");
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void option(int i, Bundle bundle) {
        this.mInternalPlayer.option(i, bundle);
    }

    public void setUseTimerProxy(boolean z) {
        this.mTimerCounterProxy.setUseProxy(z);
    }

    private void initListener() {
        this.mTimerCounterProxy.setOnCounterUpdateListener(this.mOnCounterUpdateListener);
        BaseInternalPlayer baseInternalPlayer = this.mInternalPlayer;
        if (baseInternalPlayer != null) {
            baseInternalPlayer.setOnPlayerEventListener(this.mInternalPlayerEventListener);
            this.mInternalPlayer.setOnErrorEventListener(this.mInternalErrorEventListener);
            this.mInternalPlayer.setOnBufferingListener(this.mInternalBufferingListener);
        }
    }

    private void resetListener() {
        this.mTimerCounterProxy.setOnCounterUpdateListener(null);
        BaseInternalPlayer baseInternalPlayer = this.mInternalPlayer;
        if (baseInternalPlayer != null) {
            baseInternalPlayer.setOnPlayerEventListener(null);
            this.mInternalPlayer.setOnErrorEventListener(null);
            this.mInternalPlayer.setOnBufferingListener(null);
        }
    }

    /* access modifiers changed from: private */
    public void callBackPlayEventListener(int i, Bundle bundle) {
        OnPlayerEventListener onPlayerEventListener = this.mOnPlayerEventListener;
        if (onPlayerEventListener != null) {
            onPlayerEventListener.onPlayerEvent(i, bundle);
        }
    }

    /* access modifiers changed from: private */
    public void callBackErrorEventListener(int i, Bundle bundle) {
        OnErrorEventListener onErrorEventListener = this.mOnErrorEventListener;
        if (onErrorEventListener != null) {
            onErrorEventListener.onErrorEvent(i, bundle);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setOnErrorEventListener(OnErrorEventListener onErrorEventListener) {
        this.mOnErrorEventListener = onErrorEventListener;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setOnBufferingListener(OnBufferingListener onBufferingListener) {
        this.mOnBufferingListener = onBufferingListener;
    }

    public void setOnProviderListener(IDataProvider.OnProviderListener onProviderListener) {
        this.mOnProviderListener = onProviderListener;
    }

    public void setDataProvider(IDataProvider iDataProvider) {
        IDataProvider iDataProvider2 = this.mDataProvider;
        if (iDataProvider2 != null) {
            iDataProvider2.destroy();
        }
        this.mDataProvider = iDataProvider;
        if (iDataProvider != null) {
            iDataProvider.setOnProviderListener(this.mInternalProviderListener);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setDataSource(DataSource dataSource) {
        this.mDataSource = dataSource;
        initListener();
        if (!useProvider()) {
            interPlayerSetDataSource(dataSource);
        }
    }

    boolean isLive() {
        DataSource dataSource = this.mDataSource;
        return dataSource != null && dataSource.isLive();
    }

    /* access modifiers changed from: private */
    public void interPlayerSetDataSource(DataSource dataSource) {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.setDataSource(dataSource);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void start() {
        if (useProvider()) {
            this.mDataProvider.handleSourceData(this.mDataSource);
        } else {
            internalPlayerStart(0);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void start(int i) {
        if (useProvider()) {
            this.mDataSource.setStartPos(i);
            this.mDataProvider.handleSourceData(this.mDataSource);
            return;
        }
        internalPlayerStart(i);
    }

    /* access modifiers changed from: private */
    public void internalPlayerStart(int i) {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.start(i);
        }
    }

    private boolean isPlayerAvailable() {
        return this.mInternalPlayer != null;
    }

    private boolean useProvider() {
        return this.mDataProvider != null;
    }

    public void rePlay(int i) {
        DataSource dataSource;
        DataSource dataSource2;
        if (!useProvider() && (dataSource2 = this.mDataSource) != null) {
            interPlayerSetDataSource(dataSource2);
            internalPlayerStart(i);
        } else if (useProvider() && (dataSource = this.mDataSource) != null) {
            dataSource.setStartPos(i);
            this.mDataProvider.handleSourceData(this.mDataSource);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setSurface(Surface surface) {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.setSurface(surface);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setVolume(float f, float f2) {
        this.mVolumeLeft = f;
        this.mVolumeRight = f2;
        if (isPlayerAvailable()) {
            this.mInternalPlayer.setVolume(f, f2);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void setSpeed(float f) {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.setSpeed(f);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public boolean isPlaying() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getCurrentPosition() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getDuration() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getAudioSessionId() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getVideoWidth() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getVideoHeight() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getState() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getState();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public int getBufferPercentage() {
        if (isPlayerAvailable()) {
            return this.mInternalPlayer.getBufferPercentage();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void pause() {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.pause();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void resume() {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.resume();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void seekTo(int i) {
        if (isPlayerAvailable()) {
            this.mInternalPlayer.seekTo(i);
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void stop() {
        if (useProvider()) {
            this.mDataProvider.cancel();
        }
        if (isPlayerAvailable()) {
            this.mInternalPlayer.stop();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void reset() {
        if (useProvider()) {
            this.mDataProvider.cancel();
        }
        if (isPlayerAvailable()) {
            this.mInternalPlayer.reset();
        }
    }

    @Override // com.kk.taurus.playerbase.player.IPlayer
    public void destroy() {
        if (useProvider()) {
            this.mDataProvider.destroy();
        }
        if (isPlayerAvailable()) {
            this.mInternalPlayer.destroy();
        }
        TimerCounterProxy timerCounterProxy = this.mTimerCounterProxy;
        if (timerCounterProxy != null) {
            timerCounterProxy.cancel();
        }
        resetListener();
    }
}
