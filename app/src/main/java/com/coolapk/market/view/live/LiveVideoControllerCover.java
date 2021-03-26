package com.coolapk.market.view.live;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import com.blankj.utilcode.util.KeyboardUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import com.coolapk.market.model.Live;
import com.coolapk.market.widget.video.cover.BaseControlCover;
import com.kk.taurus.playerbase.utils.TimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010A\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020CH\u0016J\b\u0010H\u001a\u00020CH\u0016J\u0018\u0010I\u001a\u00020C2\u0006\u0010J\u001a\u00020K2\u0006\u0010\u0017\u001a\u00020LH\u0016J\u001a\u0010M\u001a\u00020C2\u0006\u0010N\u001a\u00020\u00182\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0018\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8PX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128PX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8PX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00128PX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0014R\u0016\u00101\u001a\u0004\u0018\u0001028PX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u00010 8PX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\"R\u0016\u00107\u001a\u0004\u0018\u0001088PX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\fR\u0016\u0010=\u001a\u0004\u0018\u00010\u000e8PX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0010R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/coolapk/market/view/live/LiveVideoControllerCover;", "Lcom/coolapk/market/widget/video/cover/BaseControlCover;", "context", "Landroid/content/Context;", "binding", "Lcom/coolapk/market/databinding/ItemLiveVideoViewPartBinding;", "(Landroid/content/Context;Lcom/coolapk/market/databinding/ItemLiveVideoViewPartBinding;)V", "getBinding", "()Lcom/coolapk/market/databinding/ItemLiveVideoViewPartBinding;", "bottomContainer", "Landroid/view/ViewGroup;", "getBottomContainer", "()Landroid/view/ViewGroup;", "currentTimeView", "Landroid/widget/TextView;", "getCurrentTimeView$presentation_coolapkAppRelease", "()Landroid/widget/TextView;", "fullScreenView", "Landroid/widget/ImageView;", "getFullScreenView$presentation_coolapkAppRelease", "()Landroid/widget/ImageView;", "handler", "Landroid/os/Handler;", "value", "", "isFullScreen", "()Z", "setFullScreen", "(Z)V", "isVideoRender", "setVideoRender", "liveViewContainer", "Landroid/view/View;", "getLiveViewContainer$presentation_coolapkAppRelease", "()Landroid/view/View;", "liveViewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "getLiveViewModel", "()Lcom/coolapk/market/view/live/LiveViewModel;", "setLiveViewModel", "(Lcom/coolapk/market/view/live/LiveViewModel;)V", "notFullscreenFlag", "", "getNotFullscreenFlag", "()I", "setNotFullscreenFlag", "(I)V", "playView", "getPlayView$presentation_coolapkAppRelease", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$presentation_coolapkAppRelease", "()Landroid/widget/ProgressBar;", "replayView", "getReplayView$presentation_coolapkAppRelease", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar$presentation_coolapkAppRelease", "()Landroid/widget/SeekBar;", "topContainer", "getTopContainer", "totalTimeView", "getTotalTimeView$presentation_coolapkAppRelease", "updateLiveTimeRunnable", "Ljava/lang/Runnable;", "onCreateCoverView", "onPlayerEvent", "", "eventCode", "bundle", "Landroid/os/Bundle;", "onReceiverBind", "onReceiverUnBind", "onValueUpdate", "key", "", "", "setControllerState", "state", "animator", "Landroid/animation/ValueAnimator;", "updateProgress", "current", "duration", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveVideoControllerCover.kt */
public final class LiveVideoControllerCover extends BaseControlCover {
    private final ItemLiveVideoViewPartBinding binding;
    private Handler handler;
    private boolean isFullScreen;
    private boolean isVideoRender;
    private LiveViewModel liveViewModel;
    private int notFullscreenFlag;
    private final Runnable updateLiveTimeRunnable = new LiveVideoControllerCover$updateLiveTimeRunnable$1(this);

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ProgressBar getProgressBar$presentation_coolapkAppRelease() {
        return null;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getReplayView$presentation_coolapkAppRelease() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveVideoControllerCover(Context context, ItemLiveVideoViewPartBinding itemLiveVideoViewPartBinding) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemLiveVideoViewPartBinding, "binding");
        this.binding = itemLiveVideoViewPartBinding;
        View root = itemLiveVideoViewPartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.notFullscreenFlag = root.getWindowSystemUiVisibility();
        itemLiveVideoViewPartBinding.setClick(this);
        itemLiveVideoViewPartBinding.executePendingBindings();
    }

    public final ItemLiveVideoViewPartBinding getBinding() {
        return this.binding;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ViewGroup getTopContainer() {
        LinearLayout linearLayout = this.binding.topContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
        return linearLayout;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ViewGroup getBottomContainer() {
        LinearLayout linearLayout = this.binding.bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
        return linearLayout;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public SeekBar getSeekBar$presentation_coolapkAppRelease() {
        return this.binding.seekBar;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ImageView getPlayView$presentation_coolapkAppRelease() {
        return this.binding.playView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ImageView getFullScreenView$presentation_coolapkAppRelease() {
        return this.binding.fullScreenView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public TextView getCurrentTimeView$presentation_coolapkAppRelease() {
        return this.binding.currentTimeView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getLiveViewContainer$presentation_coolapkAppRelease() {
        return this.binding.liveViewContainer;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public TextView getTotalTimeView$presentation_coolapkAppRelease() {
        return this.binding.totalTimeView;
    }

    public final boolean isVideoRender() {
        return this.isVideoRender;
    }

    public final void setVideoRender(boolean z) {
        this.isVideoRender = z;
    }

    public final int getNotFullscreenFlag() {
        return this.notFullscreenFlag;
    }

    public final void setNotFullscreenFlag(int i) {
        this.notFullscreenFlag = i;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final void setFullScreen(boolean z) {
        this.isFullScreen = z;
        if (z) {
            BaseControlCover.setControllerState$default(this, false, null, 2, null);
        } else {
            BaseControlCover.setControllerState$default(this, true, null, 2, null);
        }
    }

    public final LiveViewModel getLiveViewModel() {
        return this.liveViewModel;
    }

    public final void setLiveViewModel(LiveViewModel liveViewModel2) {
        this.liveViewModel = liveViewModel2;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public void setControllerState(boolean z, ValueAnimator valueAnimator) {
        super.setControllerState(z, valueAnimator);
        if (z) {
            if (this.isFullScreen) {
                View root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                root.setSystemUiVisibility(5894);
                return;
            }
            View root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setSystemUiVisibility(this.notFullscreenFlag & -4097 & -5 & -3 & -513);
        } else if (this.isFullScreen) {
            View root3 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            root3.setSystemUiVisibility(5894);
            KeyboardUtils.hideSoftInput(this.binding.danmakuSendEdit);
        } else {
            View root4 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
            root4.setSystemUiVisibility((this.notFullscreenFlag | 4096 | 4) & -3 & -513);
        }
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover, com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public void onValueUpdate(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        super.onValueUpdate(str, obj);
        if (str.hashCode() == -1685900111 && str.equals("isLandscape")) {
            ((Boolean) obj).booleanValue();
        }
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public void updateProgress(int i, int i2) {
        Live live;
        super.updateProgress(i, i2);
        LiveViewModel liveViewModel2 = this.liveViewModel;
        long liveStartTime = (liveViewModel2 == null || (live = liveViewModel2.getLive()) == null) ? 0 : live.getLiveStartTime();
        boolean z = i == 0 && i2 == 0 && liveStartTime > 0 && this.isVideoRender;
        TextView textView = this.binding.liveTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.liveTimeView");
        textView.setVisibility(z ? 0 : 8);
        if (z) {
            TextView textView2 = this.binding.liveTimeView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.liveTimeView");
            textView2.setText(TimeUtil.getTimeSmartFormat(System.currentTimeMillis() - (liveStartTime * ((long) 1000))));
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacks(this.updateLiveTimeRunnable);
            }
            Handler handler3 = this.handler;
            if (handler3 != null) {
                handler3.postDelayed(this.updateLiveTimeRunnable, 1000);
            }
        } else {
            Handler handler4 = this.handler;
            if (handler4 != null) {
                handler4.removeCallbacks(this.updateLiveTimeRunnable);
            }
        }
        LiveViewModel liveViewModel3 = this.liveViewModel;
        if (liveViewModel3 != null && liveViewModel3.isLiveStart()) {
            SeekBar seekBar$presentation_coolapkAppRelease = getSeekBar$presentation_coolapkAppRelease();
            if (seekBar$presentation_coolapkAppRelease != null) {
                ViewKt.setVisible(seekBar$presentation_coolapkAppRelease, false);
            }
            TextView currentTimeView$presentation_coolapkAppRelease = getCurrentTimeView$presentation_coolapkAppRelease();
            if (currentTimeView$presentation_coolapkAppRelease != null) {
                ViewKt.setVisible(currentTimeView$presentation_coolapkAppRelease, false);
            }
            TextView totalTimeView$presentation_coolapkAppRelease = getTotalTimeView$presentation_coolapkAppRelease();
            if (totalTimeView$presentation_coolapkAppRelease != null) {
                ViewKt.setVisible(totalTimeView$presentation_coolapkAppRelease, false);
            }
        }
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover, com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        super.onPlayerEvent(i, bundle);
        if (i == -99015) {
            this.isVideoRender = true;
        } else if (i == -99008) {
            this.isVideoRender = false;
        }
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover, com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        this.handler = AppHolder.getMainThreadHandler();
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover, com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        this.isVideoRender = true;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.updateLiveTimeRunnable);
        }
        this.handler = null;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }
}
