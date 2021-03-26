package com.coolapk.market.widget.video.cover;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.player.OnTimerUpdateListener;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.PlayerStateGetter;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;
import com.kk.taurus.playerbase.utils.TimeUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseControlCover.kt */
public abstract class BaseControlCover extends ThemeableCover implements OnTimerUpdateListener, OnTouchGestureListener, IReceiverGroup.OnGroupValueUpdateListener {
    public static final Companion Companion = new Companion(null);
    private int bufferPercentage;
    private ValueAnimator controllerAnimator;
    private final TextView currentTimeView;
    private final ImageView fullScreenView;
    private final Handler handler;
    private final Runnable hideControllerRunnable;
    private boolean hideFrameContent;
    private boolean isTouchingSeekBar;
    private boolean isUnseekable;
    private final View liveViewContainer;
    private final View moreView;
    private final View navigationView;
    private final View pipView;
    private final ImageView playView;
    private final ProgressBar progressBar;
    private final View refreshView;
    private final View replayView;
    private final SeekBar seekBar;
    private final SeekBarListener seekBarListener;
    private final View shareView;
    private String timeFormat;
    private boolean timerUpdateProgressEnable = true;
    private final TextView totalTimeView;
    private final ImageView volumeView;

    public abstract ViewGroup getBottomContainer();

    public abstract ViewGroup getTopContainer();

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onEndGesture() {
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onErrorEvent(int i, Bundle bundle) {
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverEvent(int i, Bundle bundle) {
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent, "e1");
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseControlCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Handler handler2 = new Handler();
        this.handler = handler2;
        this.seekBarListener = new SeekBarListener();
        this.hideControllerRunnable = new BaseControlCover$hideControllerRunnable$1(this);
        handler2.post(new Runnable(this) {
            /* class com.coolapk.market.widget.video.cover.BaseControlCover.AnonymousClass1 */
            final /* synthetic */ BaseControlCover this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.initTheme();
                View navigationView$presentation_coolapkAppRelease = this.this$0.getNavigationView$presentation_coolapkAppRelease();
                if (navigationView$presentation_coolapkAppRelease != null) {
                    navigationView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                ImageView playView$presentation_coolapkAppRelease = this.this$0.getPlayView$presentation_coolapkAppRelease();
                if (playView$presentation_coolapkAppRelease != null) {
                    playView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                View refreshView$presentation_coolapkAppRelease = this.this$0.getRefreshView$presentation_coolapkAppRelease();
                if (refreshView$presentation_coolapkAppRelease != null) {
                    refreshView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                ImageView fullScreenView$presentation_coolapkAppRelease = this.this$0.getFullScreenView$presentation_coolapkAppRelease();
                if (fullScreenView$presentation_coolapkAppRelease != null) {
                    fullScreenView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                View shareView$presentation_coolapkAppRelease = this.this$0.getShareView$presentation_coolapkAppRelease();
                if (shareView$presentation_coolapkAppRelease != null) {
                    shareView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                View replayView$presentation_coolapkAppRelease = this.this$0.getReplayView$presentation_coolapkAppRelease();
                if (replayView$presentation_coolapkAppRelease != null) {
                    replayView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                View moreView$presentation_coolapkAppRelease = this.this$0.getMoreView$presentation_coolapkAppRelease();
                if (moreView$presentation_coolapkAppRelease != null) {
                    moreView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                View pipView$presentation_coolapkAppRelease = this.this$0.getPipView$presentation_coolapkAppRelease();
                if (pipView$presentation_coolapkAppRelease != null) {
                    pipView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
                ImageView volumeView$presentation_coolapkAppRelease = this.this$0.getVolumeView$presentation_coolapkAppRelease();
                if (volumeView$presentation_coolapkAppRelease != null) {
                    volumeView$presentation_coolapkAppRelease.setOnClickListener(this.this$0);
                }
            }
        });
    }

    /* compiled from: BaseControlCover.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SeekBar getSeekBar$presentation_coolapkAppRelease() {
        return this.seekBar;
    }

    public ProgressBar getProgressBar$presentation_coolapkAppRelease() {
        return this.progressBar;
    }

    public ImageView getPlayView$presentation_coolapkAppRelease() {
        return this.playView;
    }

    public ImageView getFullScreenView$presentation_coolapkAppRelease() {
        return this.fullScreenView;
    }

    public TextView getCurrentTimeView$presentation_coolapkAppRelease() {
        return this.currentTimeView;
    }

    public View getLiveViewContainer$presentation_coolapkAppRelease() {
        return this.liveViewContainer;
    }

    public View getReplayView$presentation_coolapkAppRelease() {
        return this.replayView;
    }

    public TextView getTotalTimeView$presentation_coolapkAppRelease() {
        return this.totalTimeView;
    }

    public View getNavigationView$presentation_coolapkAppRelease() {
        return this.navigationView;
    }

    public View getRefreshView$presentation_coolapkAppRelease() {
        return this.refreshView;
    }

    public View getShareView$presentation_coolapkAppRelease() {
        return this.shareView;
    }

    public View getMoreView$presentation_coolapkAppRelease() {
        return this.moreView;
    }

    public View getPipView$presentation_coolapkAppRelease() {
        return this.pipView;
    }

    public ImageView getVolumeView$presentation_coolapkAppRelease() {
        return this.volumeView;
    }

    private final boolean isControllerShow() {
        return getBottomContainer().getVisibility() == 0;
    }

    public final void initTheme() {
        Drawable thumb;
        int i = (int) 2566914048L;
        getTopContainer().setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, 0}));
        getBottomContainer().setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, 0}));
        SeekBar seekBar$presentation_coolapkAppRelease = getSeekBar$presentation_coolapkAppRelease();
        if (!(seekBar$presentation_coolapkAppRelease == null || (thumb = seekBar$presentation_coolapkAppRelease.getThumb()) == null)) {
            thumb.setTint(-1);
        }
        SeekBar seekBar$presentation_coolapkAppRelease2 = getSeekBar$presentation_coolapkAppRelease();
        if (seekBar$presentation_coolapkAppRelease2 != null) {
            seekBar$presentation_coolapkAppRelease2.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        }
        ProgressBar progressBar$presentation_coolapkAppRelease = getProgressBar$presentation_coolapkAppRelease();
        if (progressBar$presentation_coolapkAppRelease != null) {
            progressBar$presentation_coolapkAppRelease.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public String[] filterKeys() {
        return new String[]{"timer_update_enable", "isLandscape", "hide_frame_content", "screen_switch_enable", "need_mute"};
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public void onValueUpdate(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        int i = 0;
        switch (str.hashCode()) {
            case -1802542529:
                if (str.equals("timer_update_enable")) {
                    this.timerUpdateProgressEnable = ((Boolean) obj).booleanValue();
                    return;
                }
                return;
            case -1685900111:
                if (str.equals("isLandscape")) {
                    int i2 = ((Boolean) obj).booleanValue() ? 2131230846 : 2131230845;
                    ImageView fullScreenView$presentation_coolapkAppRelease = getFullScreenView$presentation_coolapkAppRelease();
                    if (fullScreenView$presentation_coolapkAppRelease != null) {
                        fullScreenView$presentation_coolapkAppRelease.setImageResource(i2);
                        return;
                    }
                    return;
                }
                return;
            case -1204875685:
                if (str.equals("screen_switch_enable")) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    ImageView fullScreenView$presentation_coolapkAppRelease2 = getFullScreenView$presentation_coolapkAppRelease();
                    if (fullScreenView$presentation_coolapkAppRelease2 != null) {
                        if (!booleanValue) {
                            i = 8;
                        }
                        fullScreenView$presentation_coolapkAppRelease2.setVisibility(i);
                        return;
                    }
                    return;
                }
                return;
            case 1076260898:
                if (str.equals("need_mute")) {
                    Drawable drawable = ResourceUtils.getDrawable(getContext(), ((Boolean) obj).booleanValue() ? 2131231642 : 2131231643);
                    ImageView volumeView$presentation_coolapkAppRelease = getVolumeView$presentation_coolapkAppRelease();
                    if (volumeView$presentation_coolapkAppRelease != null) {
                        volumeView$presentation_coolapkAppRelease.setImageDrawable(drawable);
                        return;
                    }
                    return;
                }
                return;
            case 2051873642:
                if (str.equals("hide_frame_content")) {
                    boolean booleanValue2 = ((Boolean) obj).booleanValue();
                    this.hideFrameContent = booleanValue2;
                    if (booleanValue2) {
                        setControllerState$default(this, false, null, 2, null);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        this.timeFormat = null;
        this.timerUpdateProgressEnable = true;
        getGroupValue().registerOnGroupValueUpdateListener(this);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        getGroupValue().unregisterOnGroupValueUpdateListener(this);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        int i = 0;
        updateProgress(0, 0);
        ImageView playView$presentation_coolapkAppRelease = getPlayView$presentation_coolapkAppRelease();
        if (playView$presentation_coolapkAppRelease != null) {
            playView$presentation_coolapkAppRelease.setImageResource(2131231467);
        }
        SeekBar seekBar$presentation_coolapkAppRelease = getSeekBar$presentation_coolapkAppRelease();
        if (seekBar$presentation_coolapkAppRelease != null) {
            seekBar$presentation_coolapkAppRelease.setOnSeekBarChangeListener(this.seekBarListener);
        }
        ProgressBar progressBar$presentation_coolapkAppRelease = getProgressBar$presentation_coolapkAppRelease();
        if (progressBar$presentation_coolapkAppRelease != null) {
            progressBar$presentation_coolapkAppRelease.setVisibility(4);
        }
        Integer num = null;
        setControllerState$default(this, true, null, 2, null);
        setPlayCompleteState(getGroupValue().getBoolean("complete_show"));
        requestNotifyTimer();
        boolean z = getGroupValue().getBoolean("isLive");
        View liveViewContainer$presentation_coolapkAppRelease = getLiveViewContainer$presentation_coolapkAppRelease();
        if (liveViewContainer$presentation_coolapkAppRelease != null) {
            if (!z) {
                i = 8;
            }
            liveViewContainer$presentation_coolapkAppRelease.setVisibility(i);
        }
        PlayerStateGetter playerStateGetter = getPlayerStateGetter();
        if (playerStateGetter != null) {
            num = Integer.valueOf(playerStateGetter.getState());
        }
        syncUIState(num);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverDetachedToWindow() {
        super.onCoverDetachedToWindow();
        requestStopTimer();
        this.handler.removeCallbacks(this.seekBarListener);
    }

    public static /* synthetic */ void setControllerState$default(BaseControlCover baseControlCover, boolean z, ValueAnimator valueAnimator, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                valueAnimator = null;
            }
            baseControlCover.setControllerState(z, valueAnimator);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setControllerState");
    }

    public void setControllerState(boolean z, ValueAnimator valueAnimator) {
        if (!z || !this.hideFrameContent) {
            if (valueAnimator == null) {
                valueAnimator = new ValueAnimator();
            }
            valueAnimator.addListener(new BaseControlCover$setControllerState$1(this, z));
            float alpha = getBottomContainer().getAlpha();
            if (z) {
                valueAnimator.setFloatValues(alpha, 1.0f);
            } else {
                valueAnimator.setFloatValues(alpha, 0.0f);
            }
            valueAnimator.addUpdateListener(new BaseControlCover$setControllerState$2(this));
            valueAnimator.addListener(new BaseControlCover$setControllerState$3(this, z));
            valueAnimator.start();
            this.controllerAnimator = valueAnimator;
        }
    }

    public final void enqueueDelayHideController(boolean z) {
        if (z) {
            this.handler.removeCallbacks(this.hideControllerRunnable);
            this.handler.postDelayed(this.hideControllerRunnable, 5000);
            return;
        }
        this.handler.removeCallbacks(this.hideControllerRunnable);
    }

    private final void toggleController() {
        if (isControllerShow()) {
            setControllerState$default(this, false, null, 2, null);
        } else {
            setControllerState$default(this, true, null, 2, null);
        }
    }

    @Override // com.kk.taurus.playerbase.player.OnTimerUpdateListener
    public void onTimerUpdate(int i, int i2, int i3) {
        if (this.timerUpdateProgressEnable) {
            if (this.timeFormat == null) {
                this.timeFormat = TimeUtil.getFormat((long) i2);
            }
            this.bufferPercentage = i3;
            updateProgress(i, i2);
        }
    }

    public void updateProgress(int i, int i2) {
        int i3 = 0;
        boolean z = i == 0 && i2 == 0;
        this.isUnseekable = z;
        if (z) {
            i3 = 4;
        }
        SeekBar seekBar$presentation_coolapkAppRelease = getSeekBar$presentation_coolapkAppRelease();
        if (seekBar$presentation_coolapkAppRelease != null) {
            seekBar$presentation_coolapkAppRelease.setVisibility(i3);
        }
        TextView totalTimeView$presentation_coolapkAppRelease = getTotalTimeView$presentation_coolapkAppRelease();
        if (totalTimeView$presentation_coolapkAppRelease != null) {
            totalTimeView$presentation_coolapkAppRelease.setVisibility(i3);
        }
        TextView currentTimeView$presentation_coolapkAppRelease = getCurrentTimeView$presentation_coolapkAppRelease();
        if (currentTimeView$presentation_coolapkAppRelease != null) {
            currentTimeView$presentation_coolapkAppRelease.setVisibility(i3);
        }
        if (!this.isTouchingSeekBar && !this.isUnseekable) {
            ProgressBar progressBar$presentation_coolapkAppRelease = getProgressBar$presentation_coolapkAppRelease();
            if (progressBar$presentation_coolapkAppRelease != null) {
                progressBar$presentation_coolapkAppRelease.setMax(i2);
            }
            ProgressBar progressBar$presentation_coolapkAppRelease2 = getProgressBar$presentation_coolapkAppRelease();
            if (progressBar$presentation_coolapkAppRelease2 != null) {
                progressBar$presentation_coolapkAppRelease2.setProgress(i);
            }
            ProgressBar progressBar$presentation_coolapkAppRelease3 = getProgressBar$presentation_coolapkAppRelease();
            if (progressBar$presentation_coolapkAppRelease3 != null) {
                progressBar$presentation_coolapkAppRelease3.setSecondaryProgress((int) (((((float) this.bufferPercentage) * 1.0f) / ((float) 100)) * ((float) i2)));
            }
            SeekBar seekBar$presentation_coolapkAppRelease2 = getSeekBar$presentation_coolapkAppRelease();
            if (seekBar$presentation_coolapkAppRelease2 != null) {
                seekBar$presentation_coolapkAppRelease2.setMax(i2);
            }
            SeekBar seekBar$presentation_coolapkAppRelease3 = getSeekBar$presentation_coolapkAppRelease();
            if (seekBar$presentation_coolapkAppRelease3 != null) {
                seekBar$presentation_coolapkAppRelease3.setProgress(i);
            }
            float f = (((float) this.bufferPercentage) / ((float) 100)) * ((float) i2);
            SeekBar seekBar$presentation_coolapkAppRelease4 = getSeekBar$presentation_coolapkAppRelease();
            if (seekBar$presentation_coolapkAppRelease4 != null) {
                seekBar$presentation_coolapkAppRelease4.setSecondaryProgress((int) f);
            }
            if (this.timeFormat != null) {
                TextView currentTimeView$presentation_coolapkAppRelease2 = getCurrentTimeView$presentation_coolapkAppRelease();
                if (currentTimeView$presentation_coolapkAppRelease2 != null) {
                    currentTimeView$presentation_coolapkAppRelease2.setText(TimeUtil.getTime(this.timeFormat, (long) i));
                }
                TextView totalTimeView$presentation_coolapkAppRelease2 = getTotalTimeView$presentation_coolapkAppRelease();
                if (totalTimeView$presentation_coolapkAppRelease2 != null) {
                    totalTimeView$presentation_coolapkAppRelease2.setText(TimeUtil.getTime(this.timeFormat, (long) i2));
                }
            }
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        Integer num = null;
        switch (i) {
            case -99031:
                if (bundle != null) {
                    num = Integer.valueOf(bundle.getInt("int_data"));
                }
                syncUIState(num);
                return;
            case -99015:
            case -99014:
                this.timerUpdateProgressEnable = true;
                setPlayCompleteState(false);
                return;
            case -99001:
                this.bufferPercentage = 0;
                this.timeFormat = null;
                updateProgress(0, 0);
                return;
            default:
                return;
        }
    }

    private final void syncUIState(Integer num) {
        ImageView playView$presentation_coolapkAppRelease;
        if (num != null && num.intValue() == 4) {
            ImageView playView$presentation_coolapkAppRelease2 = getPlayView$presentation_coolapkAppRelease();
            if (playView$presentation_coolapkAppRelease2 != null) {
                playView$presentation_coolapkAppRelease2.setImageResource(2131231486);
            }
        } else if (num != null && num.intValue() == 3) {
            ImageView playView$presentation_coolapkAppRelease3 = getPlayView$presentation_coolapkAppRelease();
            if (playView$presentation_coolapkAppRelease3 != null) {
                playView$presentation_coolapkAppRelease3.setImageResource(2131231467);
            }
        } else if (((num != null && num.intValue() == 0) || ((num != null && num.intValue() == -1) || ((num != null && num.intValue() == 5) || (num != null && num.intValue() == 6)))) && (playView$presentation_coolapkAppRelease = getPlayView$presentation_coolapkAppRelease()) != null) {
            playView$presentation_coolapkAppRelease.setImageResource(2131231486);
        }
        setPlayCompleteState(num != null && num.intValue() == 6);
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131362600:
                notifyReceiverEvent(-104, null);
                return;
            case 2131362970:
                showMoreOptionMenu(view);
                return;
            case 2131363008:
                notifyReceiverEvent(-100, null);
                return;
            case 2131363113:
                notifyReceiverEvent(-124, null);
                return;
            case 2131363129:
                PlayerStateGetter playerStateGetter = getPlayerStateGetter();
                if (playerStateGetter != null) {
                    int state = playerStateGetter.getState();
                    if (!(state == -1 || state == 0)) {
                        if (state == 3) {
                            requestPause(null);
                            notifyReceiverEvent(-120, null);
                            return;
                        } else if (state == 4) {
                            requestResume(null);
                            notifyReceiverEvent(-121, null);
                            return;
                        } else if (!(state == 5 || state == 6)) {
                            return;
                        }
                    }
                    requestResume(null);
                    return;
                }
                return;
            case 2131363223:
                requestStop(null);
                requestResume(null);
                return;
            case 2131363240:
                requestReplay(null);
                setPlayCompleteState(false);
                return;
            case 2131363358:
                notifyReceiverEvent(-107, null);
                return;
            case 2131363943:
                getGroupValue().putBoolean("need_mute", !getGroupValue().getBoolean("need_mute"));
                return;
            default:
                return;
        }
    }

    private final void showMoreOptionMenu(View view) {
        BasePopMenu basePopMenu = new BasePopMenu(AppHolder.getCurrentActivity(), view);
        basePopMenu.getMenu().add(0, 2131361981, 101, 2131887153);
        basePopMenu.setOnMenuItemClickListener(new BaseControlCover$showMoreOptionMenu$1(this));
        basePopMenu.show();
    }

    private final void setPlayCompleteState(boolean z) {
        if (z) {
            getView().setBackgroundColor(1711276032);
            View replayView$presentation_coolapkAppRelease = getReplayView$presentation_coolapkAppRelease();
            if (replayView$presentation_coolapkAppRelease != null) {
                replayView$presentation_coolapkAppRelease.setVisibility(0);
            }
            setControllerState$default(this, true, null, 2, null);
        } else {
            View view = getView();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            view.setBackground(null);
            View replayView$presentation_coolapkAppRelease2 = getReplayView$presentation_coolapkAppRelease();
            if (replayView$presentation_coolapkAppRelease2 != null) {
                replayView$presentation_coolapkAppRelease2.setVisibility(8);
            }
        }
        if (z != getGroupValue().getBoolean("complete_show", false)) {
            getGroupValue().putBoolean("complete_show", z);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public Bundle onPrivateEvent(int i, Bundle bundle) {
        if (i != -201 || bundle == null) {
            return null;
        }
        updateProgress(bundle.getInt("int_arg1"), bundle.getInt("int_arg2"));
        return null;
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover
    public void onThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        super.onThemeChange(appTheme);
        SeekBar seekBar$presentation_coolapkAppRelease = getSeekBar$presentation_coolapkAppRelease();
        if (seekBar$presentation_coolapkAppRelease != null) {
            seekBar$presentation_coolapkAppRelease.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        }
        ProgressBar progressBar$presentation_coolapkAppRelease = getProgressBar$presentation_coolapkAppRelease();
        if (progressBar$presentation_coolapkAppRelease != null) {
            progressBar$presentation_coolapkAppRelease.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelLow(1);
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        toggleController();
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        ImageView playView$presentation_coolapkAppRelease = getPlayView$presentation_coolapkAppRelease();
        if (playView$presentation_coolapkAppRelease != null) {
            playView$presentation_coolapkAppRelease.performClick();
        }
        setControllerState$default(this, true, null, 2, null);
    }

    /* compiled from: BaseControlCover.kt */
    public final class SeekBarListener implements SeekBar.OnSeekBarChangeListener, Runnable {
        private int seekProgress = -1;

        public SeekBarListener() {
            BaseControlCover.this = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            if (z) {
                boolean z2 = BaseControlCover.this.isTouchingSeekBar;
                BaseControlCover.this.isTouchingSeekBar = false;
                BaseControlCover.this.updateProgress(i, seekBar.getMax());
                BaseControlCover.this.isTouchingSeekBar = z2;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            BaseControlCover.this.isTouchingSeekBar = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            requestSeek(seekBar.getProgress());
            BaseControlCover.this.isTouchingSeekBar = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.seekProgress >= 0) {
                Bundle obtain = BundlePool.obtain();
                obtain.putInt("int_data", this.seekProgress);
                BaseControlCover.this.requestSeek(obtain);
                obtain.clear();
            }
        }

        private final void requestSeek(int i) {
            BaseControlCover.this.timerUpdateProgressEnable = false;
            this.seekProgress = i;
            SeekBarListener seekBarListener = this;
            BaseControlCover.this.handler.removeCallbacks(seekBarListener);
            BaseControlCover.this.handler.postDelayed(seekBarListener, 300);
        }
    }
}
