package com.kk.taurus.playerbase.assist;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kk.taurus.playerbase.AVPlayer;
import com.kk.taurus.playerbase.config.PlayerConfig;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;
import com.kk.taurus.playerbase.extension.NetworkEventProducer;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.provider.IDataProvider;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.OnReceiverEventListener;
import com.kk.taurus.playerbase.receiver.PlayerStateGetter;
import com.kk.taurus.playerbase.receiver.StateGetter;
import com.kk.taurus.playerbase.render.AspectRatio;
import com.kk.taurus.playerbase.render.IRender;
import com.kk.taurus.playerbase.render.RenderSurfaceView;
import com.kk.taurus.playerbase.render.RenderTextureView;
import com.kk.taurus.playerbase.widget.SuperContainer;

public final class RelationAssist implements AssistPlay {
    private final String TAG;
    private boolean isBuffering;
    private AspectRatio mAspectRatio;
    private Context mContext;
    private DataSource mDataSource;
    private OnErrorEventListener mInternalErrorEventListener;
    private OnPlayerEventListener mInternalPlayerEventListener;
    private PlayerStateGetter mInternalPlayerStateGetter;
    private OnReceiverEventListener mInternalReceiverEventListener;
    private StateGetter mInternalStateGetter;
    private OnErrorEventListener mOnErrorEventListener;
    private OnAssistPlayEventHandler mOnEventAssistHandler;
    private OnPlayerEventListener mOnPlayerEventListener;
    private OnReceiverEventListener mOnReceiverEventListener;
    private AVPlayer mPlayer;
    private IReceiverGroup mReceiverGroup;
    private IRender mRender;
    private IRender.IRenderCallback mRenderCallback;
    private IRender.IRenderHolder mRenderHolder;
    private int mRenderType;
    private boolean mRenderTypeChange;
    private SuperContainer mSuperContainer;
    private int mVideoHeight;
    private int mVideoRotation;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;

    /* access modifiers changed from: private */
    public void onInternalHandleErrorEvent(int i, Bundle bundle) {
    }

    public RelationAssist(Context context) {
        this(context, null);
    }

    public RelationAssist(Context context, SuperContainer superContainer) {
        this.TAG = "RelationAssist";
        this.mRenderType = 0;
        this.mAspectRatio = AspectRatio.AspectRatio_FIT_PARENT;
        this.mInternalStateGetter = new StateGetter() {
            /* class com.kk.taurus.playerbase.assist.RelationAssist.AnonymousClass1 */

            @Override // com.kk.taurus.playerbase.receiver.StateGetter
            public PlayerStateGetter getPlayerStateGetter() {
                return RelationAssist.this.mInternalPlayerStateGetter;
            }
        };
        this.mInternalPlayerStateGetter = new PlayerStateGetter() {
            /* class com.kk.taurus.playerbase.assist.RelationAssist.AnonymousClass2 */

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getState() {
                return RelationAssist.this.mPlayer.getState();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getCurrentPosition() {
                return RelationAssist.this.mPlayer.getCurrentPosition();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getDuration() {
                return RelationAssist.this.mPlayer.getDuration();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getBufferPercentage() {
                return RelationAssist.this.mPlayer.getBufferPercentage();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public boolean isBuffering() {
                return RelationAssist.this.isBuffering;
            }
        };
        this.mInternalPlayerEventListener = new OnPlayerEventListener() {
            /* class com.kk.taurus.playerbase.assist.RelationAssist.AnonymousClass3 */

            @Override // com.kk.taurus.playerbase.event.OnPlayerEventListener
            public void onPlayerEvent(int i, Bundle bundle) {
                RelationAssist.this.onInternalHandlePlayerEvent(i, bundle);
                if (RelationAssist.this.mOnPlayerEventListener != null) {
                    RelationAssist.this.mOnPlayerEventListener.onPlayerEvent(i, bundle);
                }
                RelationAssist.this.mSuperContainer.dispatchPlayEvent(i, bundle);
            }
        };
        this.mInternalErrorEventListener = new OnErrorEventListener() {
            /* class com.kk.taurus.playerbase.assist.RelationAssist.AnonymousClass4 */

            @Override // com.kk.taurus.playerbase.event.OnErrorEventListener
            public void onErrorEvent(int i, Bundle bundle) {
                RelationAssist.this.onInternalHandleErrorEvent(i, bundle);
                if (RelationAssist.this.mOnErrorEventListener != null) {
                    RelationAssist.this.mOnErrorEventListener.onErrorEvent(i, bundle);
                }
                RelationAssist.this.mSuperContainer.dispatchErrorEvent(i, bundle);
            }
        };
        this.mInternalReceiverEventListener = new OnReceiverEventListener() {
            /* class com.kk.taurus.playerbase.assist.RelationAssist.AnonymousClass5 */

            @Override // com.kk.taurus.playerbase.receiver.OnReceiverEventListener
            public void onReceiverEvent(int i, Bundle bundle) {
                if (i == -66015) {
                    RelationAssist.this.mPlayer.setUseTimerProxy(true);
                } else if (i == -66016) {
                    RelationAssist.this.mPlayer.setUseTimerProxy(false);
                }
                if (RelationAssist.this.mOnEventAssistHandler != null) {
                    RelationAssist.this.mOnEventAssistHandler.onAssistHandle(RelationAssist.this, i, bundle);
                }
                if (RelationAssist.this.mOnReceiverEventListener != null) {
                    RelationAssist.this.mOnReceiverEventListener.onReceiverEvent(i, bundle);
                }
            }
        };
        this.mRenderCallback = new IRender.IRenderCallback() {
            /* class com.kk.taurus.playerbase.assist.RelationAssist.AnonymousClass6 */

            @Override // com.kk.taurus.playerbase.render.IRender.IRenderCallback
            public void onSurfaceChanged(IRender.IRenderHolder iRenderHolder, int i, int i2, int i3) {
            }

            @Override // com.kk.taurus.playerbase.render.IRender.IRenderCallback
            public void onSurfaceCreated(IRender.IRenderHolder iRenderHolder, int i, int i2) {
                PLog.d("RelationAssist", "onSurfaceCreated : width = " + i + ", height = " + i2);
                RelationAssist.this.mRenderHolder = iRenderHolder;
                RelationAssist relationAssist = RelationAssist.this;
                relationAssist.bindRenderHolder(relationAssist.mRenderHolder);
            }

            @Override // com.kk.taurus.playerbase.render.IRender.IRenderCallback
            public void onSurfaceDestroy(IRender.IRenderHolder iRenderHolder) {
                PLog.d("RelationAssist", "onSurfaceDestroy...");
                RelationAssist.this.mRenderHolder = null;
            }
        };
        this.mContext = context;
        this.mPlayer = new AVPlayer();
        superContainer = superContainer == null ? new SuperContainer(context) : superContainer;
        if (PlayerConfig.isUseDefaultNetworkEventProducer()) {
            superContainer.addEventProducer(new NetworkEventProducer(context));
        }
        this.mSuperContainer = superContainer;
        superContainer.setStateGetter(this.mInternalStateGetter);
    }

    public SuperContainer getSuperContainer() {
        return this.mSuperContainer;
    }

    private void attachPlayerListener() {
        this.mPlayer.setOnPlayerEventListener(this.mInternalPlayerEventListener);
        this.mPlayer.setOnErrorEventListener(this.mInternalErrorEventListener);
        this.mSuperContainer.setOnReceiverEventListener(this.mInternalReceiverEventListener);
    }

    private void detachPlayerListener() {
        this.mPlayer.setOnPlayerEventListener(null);
        this.mPlayer.setOnErrorEventListener(null);
        this.mSuperContainer.setOnReceiverEventListener(null);
    }

    /* access modifiers changed from: private */
    public void onInternalHandlePlayerEvent(int i, Bundle bundle) {
        switch (i) {
            case -99018:
                if (!(bundle == null || this.mRender == null)) {
                    this.mVideoWidth = bundle.getInt("int_arg1");
                    int i2 = bundle.getInt("int_arg2");
                    this.mVideoHeight = i2;
                    this.mRender.updateVideoSize(this.mVideoWidth, i2);
                }
                bindRenderHolder(this.mRenderHolder);
                return;
            case -99017:
                if (bundle != null) {
                    this.mVideoWidth = bundle.getInt("int_arg1");
                    this.mVideoHeight = bundle.getInt("int_arg2");
                    this.mVideoSarNum = bundle.getInt("int_arg3");
                    this.mVideoSarDen = bundle.getInt("int_arg4");
                    IRender iRender = this.mRender;
                    if (iRender != null) {
                        iRender.updateVideoSize(this.mVideoWidth, this.mVideoHeight);
                        this.mRender.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
                        return;
                    }
                    return;
                }
                return;
            case -99011:
                this.isBuffering = false;
                return;
            case -99010:
                this.isBuffering = true;
                return;
            case 99020:
                if (bundle != null) {
                    int i3 = bundle.getInt("int_data");
                    this.mVideoRotation = i3;
                    IRender iRender2 = this.mRender;
                    if (iRender2 != null) {
                        iRender2.setVideoRotation(i3);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setEventAssistHandler(OnAssistPlayEventHandler onAssistPlayEventHandler) {
        this.mOnEventAssistHandler = onAssistPlayEventHandler;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setOnErrorEventListener(OnErrorEventListener onErrorEventListener) {
        this.mOnErrorEventListener = onErrorEventListener;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setOnReceiverEventListener(OnReceiverEventListener onReceiverEventListener) {
        this.mOnReceiverEventListener = onReceiverEventListener;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setOnProviderListener(IDataProvider.OnProviderListener onProviderListener) {
        this.mPlayer.setOnProviderListener(onProviderListener);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setDataProvider(IDataProvider iDataProvider) {
        this.mPlayer.setDataProvider(iDataProvider);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public boolean switchDecoder(int i) {
        boolean switchDecoder = this.mPlayer.switchDecoder(i);
        if (switchDecoder) {
            releaseRender();
        }
        return switchDecoder;
    }

    public void option(int i, Bundle bundle) {
        this.mPlayer.option(i, bundle);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setReceiverGroup(IReceiverGroup iReceiverGroup) {
        this.mReceiverGroup = iReceiverGroup;
    }

    public IReceiverGroup getReceiverGroup() {
        return this.mReceiverGroup;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setRenderType(int i) {
        this.mRenderTypeChange = this.mRenderType != i;
        this.mRenderType = i;
        updateRender();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mAspectRatio = aspectRatio;
        IRender iRender = this.mRender;
        if (iRender != null) {
            iRender.updateAspectRatio(aspectRatio);
        }
    }

    public IRender getRender() {
        return this.mRender;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setVolume(float f, float f2) {
        this.mPlayer.setVolume(f, f2);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setSpeed(float f) {
        this.mPlayer.setSpeed(f);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void attachContainer(ViewGroup viewGroup) {
        attachContainer(viewGroup, false);
    }

    public void attachContainer(ViewGroup viewGroup, boolean z) {
        attachPlayerListener();
        detachSuperContainer();
        IReceiverGroup iReceiverGroup = this.mReceiverGroup;
        if (iReceiverGroup != null) {
            this.mSuperContainer.setReceiverGroup(iReceiverGroup);
        }
        if (z || isNeedForceUpdateRender()) {
            releaseRender();
            updateRender();
        }
        if (viewGroup != null) {
            viewGroup.addView(this.mSuperContainer, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private boolean isNeedForceUpdateRender() {
        return this.mRender == null || this.mRenderTypeChange;
    }

    private void updateRender() {
        if (isNeedForceUpdateRender()) {
            this.mRenderTypeChange = false;
            releaseRender();
            if (this.mRenderType != 1) {
                RenderTextureView renderTextureView = new RenderTextureView(this.mContext);
                this.mRender = renderTextureView;
                renderTextureView.setTakeOverSurfaceTexture(true);
            } else {
                this.mRender = new RenderSurfaceView(this.mContext);
            }
            this.mRenderHolder = null;
            this.mPlayer.setSurface(null);
            this.mRender.updateAspectRatio(this.mAspectRatio);
            this.mRender.setRenderCallback(this.mRenderCallback);
            this.mRender.updateVideoSize(this.mVideoWidth, this.mVideoHeight);
            this.mRender.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
            this.mRender.setVideoRotation(this.mVideoRotation);
            this.mSuperContainer.setRenderView(this.mRender.getRenderView());
        }
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void setDataSource(DataSource dataSource) {
        this.mDataSource = dataSource;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void play() {
        play(false);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void play(boolean z) {
        if (z) {
            releaseRender();
            updateRender();
        }
        DataSource dataSource = this.mDataSource;
        if (dataSource != null) {
            onInternalSetDataSource(dataSource);
            onInternalStart(this.mDataSource.getStartPos());
        }
    }

    /* access modifiers changed from: private */
    public void bindRenderHolder(IRender.IRenderHolder iRenderHolder) {
        if (iRenderHolder != null) {
            iRenderHolder.bindPlayer(this.mPlayer);
        }
    }

    private void releaseRender() {
        IRender iRender = this.mRender;
        if (iRender != null) {
            iRender.setRenderCallback(null);
            this.mRender.release();
        }
        this.mRender = null;
    }

    private void detachSuperContainer() {
        ViewParent parent = this.mSuperContainer.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.mSuperContainer);
        }
    }

    private void onInternalSetDataSource(DataSource dataSource) {
        this.mPlayer.setDataSource(dataSource);
    }

    private void onInternalStart(int i) {
        this.mPlayer.start(i);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public boolean isInPlaybackState() {
        int state = getState();
        return (state == -2 || state == -1 || state == 0 || state == 1 || state == 5) ? false : true;
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public int getCurrentPosition() {
        return this.mPlayer.getCurrentPosition();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public int getDuration() {
        return this.mPlayer.getDuration();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public int getAudioSessionId() {
        return this.mPlayer.getAudioSessionId();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public int getBufferPercentage() {
        return this.mPlayer.getBufferPercentage();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public int getState() {
        return this.mPlayer.getState();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void rePlay(int i) {
        DataSource dataSource = this.mDataSource;
        if (dataSource != null) {
            onInternalSetDataSource(dataSource);
            onInternalStart(i);
        }
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void resume() {
        this.mPlayer.resume();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.kk.taurus.playerbase.assist.AssistPlay
    public void destroy() {
        this.mPlayer.destroy();
        detachPlayerListener();
        this.mRenderHolder = null;
        releaseRender();
        this.mSuperContainer.destroy();
        detachSuperContainer();
        setReceiverGroup(null);
    }
}
