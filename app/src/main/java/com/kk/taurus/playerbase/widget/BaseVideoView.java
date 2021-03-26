package com.kk.taurus.playerbase.widget;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kk.taurus.playerbase.AVPlayer;
import com.kk.taurus.playerbase.assist.OnVideoViewEventHandler;
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
import com.kk.taurus.playerbase.style.IStyleSetter;
import com.kk.taurus.playerbase.style.StyleSetter;

public class BaseVideoView extends FrameLayout implements IVideoView, IStyleSetter {
    final String TAG;
    private boolean isBuffering;
    private AspectRatio mAspectRatio;
    private OnVideoViewEventHandler mEventAssistHandler;
    private OnErrorEventListener mInternalErrorEventListener;
    private OnPlayerEventListener mInternalPlayerEventListener;
    private PlayerStateGetter mInternalPlayerStateGetter;
    private OnReceiverEventListener mInternalReceiverEventListener;
    private StateGetter mInternalStateGetter;
    private OnErrorEventListener mOnErrorEventListener;
    private OnPlayerEventListener mOnPlayerEventListener;
    private OnReceiverEventListener mOnReceiverEventListener;
    private AVPlayer mPlayer;
    private IRender mRender;
    private IRender.IRenderCallback mRenderCallback;
    private IRender.IRenderHolder mRenderHolder;
    private int mRenderType;
    private IStyleSetter mStyleSetter;
    private SuperContainer mSuperContainer;
    private int mVideoHeight;
    private int mVideoRotation;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;

    public BaseVideoView(Context context) {
        this(context, null);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "BaseVideoView";
        this.mRenderType = 0;
        this.mAspectRatio = AspectRatio.AspectRatio_FIT_PARENT;
        this.mInternalReceiverEventListener = new OnReceiverEventListener() {
            /* class com.kk.taurus.playerbase.widget.BaseVideoView.AnonymousClass1 */

            @Override // com.kk.taurus.playerbase.receiver.OnReceiverEventListener
            public void onReceiverEvent(int i, Bundle bundle) {
                if (i == -66015) {
                    BaseVideoView.this.mPlayer.setUseTimerProxy(true);
                } else if (i == -66016) {
                    BaseVideoView.this.mPlayer.setUseTimerProxy(false);
                }
                if (BaseVideoView.this.mEventAssistHandler != null) {
                    BaseVideoView.this.mEventAssistHandler.onAssistHandle(BaseVideoView.this, i, bundle);
                }
                if (BaseVideoView.this.mOnReceiverEventListener != null) {
                    BaseVideoView.this.mOnReceiverEventListener.onReceiverEvent(i, bundle);
                }
            }
        };
        this.mInternalStateGetter = new StateGetter() {
            /* class com.kk.taurus.playerbase.widget.BaseVideoView.AnonymousClass2 */

            @Override // com.kk.taurus.playerbase.receiver.StateGetter
            public PlayerStateGetter getPlayerStateGetter() {
                return BaseVideoView.this.mInternalPlayerStateGetter;
            }
        };
        this.mInternalPlayerStateGetter = new PlayerStateGetter() {
            /* class com.kk.taurus.playerbase.widget.BaseVideoView.AnonymousClass3 */

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getState() {
                return BaseVideoView.this.mPlayer.getState();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getCurrentPosition() {
                return BaseVideoView.this.mPlayer.getCurrentPosition();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getDuration() {
                return BaseVideoView.this.mPlayer.getDuration();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public int getBufferPercentage() {
                return BaseVideoView.this.mPlayer.getBufferPercentage();
            }

            @Override // com.kk.taurus.playerbase.receiver.PlayerStateGetter
            public boolean isBuffering() {
                return BaseVideoView.this.isBuffering;
            }
        };
        this.mInternalPlayerEventListener = new OnPlayerEventListener() {
            /* class com.kk.taurus.playerbase.widget.BaseVideoView.AnonymousClass4 */

            @Override // com.kk.taurus.playerbase.event.OnPlayerEventListener
            public void onPlayerEvent(int i, Bundle bundle) {
                switch (i) {
                    case -99018:
                        if (!(bundle == null || BaseVideoView.this.mRender == null)) {
                            BaseVideoView.this.mVideoWidth = bundle.getInt("int_arg1");
                            BaseVideoView.this.mVideoHeight = bundle.getInt("int_arg2");
                            BaseVideoView.this.mRender.updateVideoSize(BaseVideoView.this.mVideoWidth, BaseVideoView.this.mVideoHeight);
                        }
                        BaseVideoView baseVideoView = BaseVideoView.this;
                        baseVideoView.bindRenderHolder(baseVideoView.mRenderHolder);
                        break;
                    case -99017:
                        if (bundle != null) {
                            BaseVideoView.this.mVideoWidth = bundle.getInt("int_arg1");
                            BaseVideoView.this.mVideoHeight = bundle.getInt("int_arg2");
                            BaseVideoView.this.mVideoSarNum = bundle.getInt("int_arg3");
                            BaseVideoView.this.mVideoSarDen = bundle.getInt("int_arg4");
                            PLog.d("BaseVideoView", "onVideoSizeChange : videoWidth = " + BaseVideoView.this.mVideoWidth + ", videoHeight = " + BaseVideoView.this.mVideoHeight + ", videoSarNum = " + BaseVideoView.this.mVideoSarNum + ", videoSarDen = " + BaseVideoView.this.mVideoSarDen);
                            if (BaseVideoView.this.mRender != null) {
                                BaseVideoView.this.mRender.updateVideoSize(BaseVideoView.this.mVideoWidth, BaseVideoView.this.mVideoHeight);
                                BaseVideoView.this.mRender.setVideoSampleAspectRatio(BaseVideoView.this.mVideoSarNum, BaseVideoView.this.mVideoSarDen);
                                break;
                            }
                        }
                        break;
                    case -99011:
                        BaseVideoView.this.isBuffering = false;
                        break;
                    case -99010:
                        BaseVideoView.this.isBuffering = true;
                        break;
                    case 99020:
                        if (bundle != null) {
                            BaseVideoView.this.mVideoRotation = bundle.getInt("int_data");
                            PLog.d("BaseVideoView", "onVideoRotationChange : videoRotation = " + BaseVideoView.this.mVideoRotation);
                            if (BaseVideoView.this.mRender != null) {
                                BaseVideoView.this.mRender.setVideoRotation(BaseVideoView.this.mVideoRotation);
                                break;
                            }
                        }
                        break;
                }
                if (BaseVideoView.this.mOnPlayerEventListener != null) {
                    BaseVideoView.this.mOnPlayerEventListener.onPlayerEvent(i, bundle);
                }
                BaseVideoView.this.mSuperContainer.dispatchPlayEvent(i, bundle);
            }
        };
        this.mInternalErrorEventListener = new OnErrorEventListener() {
            /* class com.kk.taurus.playerbase.widget.BaseVideoView.AnonymousClass5 */

            @Override // com.kk.taurus.playerbase.event.OnErrorEventListener
            public void onErrorEvent(int i, Bundle bundle) {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append("onError : code = ");
                sb.append(i);
                sb.append(", Message = ");
                if (bundle == null) {
                    str = "no message";
                } else {
                    str = bundle.toString();
                }
                sb.append(str);
                PLog.e("BaseVideoView", sb.toString());
                if (BaseVideoView.this.mOnErrorEventListener != null) {
                    BaseVideoView.this.mOnErrorEventListener.onErrorEvent(i, bundle);
                }
                BaseVideoView.this.mSuperContainer.dispatchErrorEvent(i, bundle);
            }
        };
        this.mRenderCallback = new IRender.IRenderCallback() {
            /* class com.kk.taurus.playerbase.widget.BaseVideoView.AnonymousClass6 */

            @Override // com.kk.taurus.playerbase.render.IRender.IRenderCallback
            public void onSurfaceChanged(IRender.IRenderHolder iRenderHolder, int i, int i2, int i3) {
            }

            @Override // com.kk.taurus.playerbase.render.IRender.IRenderCallback
            public void onSurfaceCreated(IRender.IRenderHolder iRenderHolder, int i, int i2) {
                PLog.d("BaseVideoView", "onSurfaceCreated : width = " + i + ", height = " + i2);
                BaseVideoView.this.mRenderHolder = iRenderHolder;
                BaseVideoView baseVideoView = BaseVideoView.this;
                baseVideoView.bindRenderHolder(baseVideoView.mRenderHolder);
            }

            @Override // com.kk.taurus.playerbase.render.IRender.IRenderCallback
            public void onSurfaceDestroy(IRender.IRenderHolder iRenderHolder) {
                PLog.d("BaseVideoView", "onSurfaceDestroy...");
                BaseVideoView.this.mRenderHolder = null;
            }
        };
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        AVPlayer createPlayer = createPlayer();
        this.mPlayer = createPlayer;
        createPlayer.setOnPlayerEventListener(this.mInternalPlayerEventListener);
        this.mPlayer.setOnErrorEventListener(this.mInternalErrorEventListener);
        this.mStyleSetter = new StyleSetter(this);
        SuperContainer onCreateSuperContainer = onCreateSuperContainer(context);
        this.mSuperContainer = onCreateSuperContainer;
        onCreateSuperContainer.setStateGetter(this.mInternalStateGetter);
        this.mSuperContainer.setOnReceiverEventListener(this.mInternalReceiverEventListener);
        addView(this.mSuperContainer, new ViewGroup.LayoutParams(-1, -1));
    }

    public final SuperContainer getSuperContainer() {
        return this.mSuperContainer;
    }

    protected SuperContainer onCreateSuperContainer(Context context) {
        SuperContainer superContainer = new SuperContainer(context);
        if (PlayerConfig.isUseDefaultNetworkEventProducer()) {
            superContainer.addEventProducer(new NetworkEventProducer(context));
        }
        return superContainer;
    }

    private AVPlayer createPlayer() {
        return new AVPlayer();
    }

    public void option(int i, Bundle bundle) {
        this.mPlayer.option(i, bundle);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public final boolean switchDecoder(int i) {
        boolean switchDecoder = this.mPlayer.switchDecoder(i);
        if (switchDecoder) {
            releaseRender();
        }
        return switchDecoder;
    }

    public void setDataProvider(IDataProvider iDataProvider) {
        this.mPlayer.setDataProvider(iDataProvider);
    }

    public void setOnProviderListener(IDataProvider.OnProviderListener onProviderListener) {
        this.mPlayer.setOnProviderListener(onProviderListener);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void setDataSource(DataSource dataSource) {
        requestAudioFocus();
        releaseRender();
        setRenderType(this.mRenderType);
        this.mPlayer.setDataSource(dataSource);
    }

    private void requestAudioFocus() {
        PLog.d("BaseVideoView", ">>requestAudioFocus<<");
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 1);
        }
    }

    private void releaseAudioFocus() {
        PLog.d("BaseVideoView", "<<releaseAudioFocus>>");
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    public void setReceiverGroup(IReceiverGroup iReceiverGroup) {
        this.mSuperContainer.setReceiverGroup(iReceiverGroup);
    }

    public void setEventHandler(OnVideoViewEventHandler onVideoViewEventHandler) {
        this.mEventAssistHandler = onVideoViewEventHandler;
    }

    public void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    public void setOnErrorEventListener(OnErrorEventListener onErrorEventListener) {
        this.mOnErrorEventListener = onErrorEventListener;
    }

    public void setOnReceiverEventListener(OnReceiverEventListener onReceiverEventListener) {
        this.mOnReceiverEventListener = onReceiverEventListener;
    }

    public void rePlay(int i) {
        this.mPlayer.rePlay(i);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mAspectRatio = aspectRatio;
        IRender iRender = this.mRender;
        if (iRender != null) {
            iRender.updateAspectRatio(aspectRatio);
        }
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void setVolume(float f, float f2) {
        this.mPlayer.setVolume(f, f2);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void setSpeed(float f) {
        this.mPlayer.setSpeed(f);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void setRenderType(int i) {
        if ((this.mRenderType != i) || this.mRender == null) {
            releaseRender();
            this.mRenderType = i;
            if (i != 1) {
                RenderTextureView renderTextureView = new RenderTextureView(getContext());
                this.mRender = renderTextureView;
                renderTextureView.setTakeOverSurfaceTexture(true);
            } else {
                this.mRender = new RenderSurfaceView(getContext());
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

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public boolean isInPlaybackState() {
        int state = getState();
        return (state == -2 || state == -1 || state == 0 || state == 1 || state == 5) ? false : true;
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public IRender getRender() {
        return this.mRender;
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public int getCurrentPosition() {
        return this.mPlayer.getCurrentPosition();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public int getDuration() {
        return this.mPlayer.getDuration();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public int getAudioSessionId() {
        return this.mPlayer.getAudioSessionId();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public int getBufferPercentage() {
        return this.mPlayer.getBufferPercentage();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public int getState() {
        return this.mPlayer.getState();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void start(int i) {
        this.mPlayer.start(i);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void resume() {
        this.mPlayer.resume();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.kk.taurus.playerbase.widget.IVideoView
    public void stopPlayback() {
        PLog.e("BaseVideoView", "stopPlayback release.");
        releaseAudioFocus();
        this.mPlayer.destroy();
        this.mRenderHolder = null;
        releaseRender();
        this.mSuperContainer.destroy();
    }

    private void releaseRender() {
        IRender iRender = this.mRender;
        if (iRender != null) {
            iRender.release();
            this.mRender = null;
        }
    }

    /* access modifiers changed from: private */
    public void bindRenderHolder(IRender.IRenderHolder iRenderHolder) {
        if (iRenderHolder != null) {
            iRenderHolder.bindPlayer(this.mPlayer);
        }
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setRoundRectShape(float f) {
        this.mStyleSetter.setRoundRectShape(f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setRoundRectShape(Rect rect, float f) {
        this.mStyleSetter.setRoundRectShape(rect, f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setOvalRectShape() {
        this.mStyleSetter.setOvalRectShape();
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setOvalRectShape(Rect rect) {
        this.mStyleSetter.setOvalRectShape(rect);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void clearShapeStyle() {
        this.mStyleSetter.clearShapeStyle();
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setElevationShadow(float f) {
        this.mStyleSetter.setElevationShadow(f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setElevationShadow(int i, float f) {
        this.mStyleSetter.setElevationShadow(i, f);
    }
}
