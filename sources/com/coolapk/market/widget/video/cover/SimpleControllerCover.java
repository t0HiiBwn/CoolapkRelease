package com.coolapk.market.widget.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.VideoSimpleControllerBinding;
import com.coolapk.market.util.TintHelper;
import com.kk.taurus.playerbase.player.OnTimerUpdateListener;
import com.kk.taurus.playerbase.receiver.PlayerStateGetter;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;
import com.kk.taurus.playerbase.utils.TimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J(\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0016J \u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u00100\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/coolapk/market/widget/video/cover/SimpleControllerCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/player/OnTimerUpdateListener;", "Lcom/kk/taurus/playerbase/touch/OnTouchGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/coolapk/market/databinding/VideoSimpleControllerBinding;", "bufferPercentage", "", "onGroupValueUpdateListener", "com/coolapk/market/widget/video/cover/SimpleControllerCover$onGroupValueUpdateListener$1", "Lcom/coolapk/market/widget/video/cover/SimpleControllerCover$onGroupValueUpdateListener$1;", "timeFormat", "", "getCoverLevel", "onClick", "", "v", "Landroid/view/View;", "onCoverAttachedToWindow", "onCoverDetachedToWindow", "onCreateCoverView", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onDown", "onEndGesture", "onPlayerEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onReceiverBind", "onReceiverUnBind", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "onThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onTimerUpdate", "curr", "duration", "updateUI", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleControllerCover.kt */
public final class SimpleControllerCover extends ThemeableCover implements OnTimerUpdateListener, OnTouchGestureListener {
    private VideoSimpleControllerBinding binding;
    private int bufferPercentage;
    private final SimpleControllerCover$onGroupValueUpdateListener$1 onGroupValueUpdateListener;
    private String timeFormat;

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onEndGesture() {
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent, "e1");
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleControllerCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onGroupValueUpdateListener = new SimpleControllerCover$onGroupValueUpdateListener$1(this, context);
    }

    public static final /* synthetic */ VideoSimpleControllerBinding access$getBinding$p(SimpleControllerCover simpleControllerCover) {
        VideoSimpleControllerBinding videoSimpleControllerBinding = simpleControllerCover.binding;
        if (videoSimpleControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return videoSimpleControllerBinding;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        getGroupValue().registerOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        getGroupValue().unregisterOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        boolean z = getGroupValue().getBoolean("isLive");
        VideoSimpleControllerBinding videoSimpleControllerBinding = this.binding;
        if (videoSimpleControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoSimpleControllerBinding.liveViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.liveViewContainer");
        int i = 8;
        linearLayout.setVisibility(z ? 0 : 8);
        requestNotifyTimer();
        updateUI(0, 0);
        PlayerStateGetter playerStateGetter = getPlayerStateGetter();
        boolean z2 = playerStateGetter != null && playerStateGetter.getState() == 4;
        VideoSimpleControllerBinding videoSimpleControllerBinding2 = this.binding;
        if (videoSimpleControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = videoSimpleControllerBinding2.maskView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.maskView");
        if (z2) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        if (view.getId() == 2131363969) {
            getGroupValue().putBoolean("need_mute", !getGroupValue().getBoolean("need_mute"));
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverDetachedToWindow() {
        super.onCoverDetachedToWindow();
        VideoSimpleControllerBinding videoSimpleControllerBinding = this.binding;
        if (videoSimpleControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoSimpleControllerBinding.liveViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.liveViewContainer");
        linearLayout.setVisibility(8);
        requestStopTimer();
    }

    @Override // com.kk.taurus.playerbase.player.OnTimerUpdateListener
    public void onTimerUpdate(int i, int i2, int i3) {
        this.bufferPercentage = i3;
        updateUI(i, i2);
    }

    private final void updateUI(int i, int i2) {
        int i3 = 0;
        boolean z = i == 0 && i2 == 0;
        if (z) {
            i3 = 4;
        }
        if (this.timeFormat == null) {
            this.timeFormat = TimeUtil.getFormat((long) i2);
        }
        VideoSimpleControllerBinding videoSimpleControllerBinding = this.binding;
        if (videoSimpleControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = videoSimpleControllerBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(i3);
        VideoSimpleControllerBinding videoSimpleControllerBinding2 = this.binding;
        if (videoSimpleControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoSimpleControllerBinding2.remainTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.remainTimeView");
        textView.setVisibility(i3);
        if (!z) {
            String time = TimeUtil.getTime(this.timeFormat, (long) (i2 - i));
            VideoSimpleControllerBinding videoSimpleControllerBinding3 = this.binding;
            if (videoSimpleControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = videoSimpleControllerBinding3.remainTimeView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.remainTimeView");
            textView2.setText(time);
            VideoSimpleControllerBinding videoSimpleControllerBinding4 = this.binding;
            if (videoSimpleControllerBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView3 = videoSimpleControllerBinding4.remainTimeView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.remainTimeView");
            textView3.setContentDescription("视频 " + time);
            VideoSimpleControllerBinding videoSimpleControllerBinding5 = this.binding;
            if (videoSimpleControllerBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar2 = videoSimpleControllerBinding5.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
            progressBar2.setMax(i2);
            VideoSimpleControllerBinding videoSimpleControllerBinding6 = this.binding;
            if (videoSimpleControllerBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar3 = videoSimpleControllerBinding6.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar3, "binding.progressBar");
            progressBar3.setProgress(i);
            VideoSimpleControllerBinding videoSimpleControllerBinding7 = this.binding;
            if (videoSimpleControllerBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar4 = videoSimpleControllerBinding7.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar4, "binding.progressBar");
            progressBar4.setSecondaryProgress((int) (((((float) this.bufferPercentage) * 1.0f) / ((float) 100)) * ((float) i2)));
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        int i2 = 0;
        if (i == -99031) {
            PlayerStateGetter playerStateGetter = getPlayerStateGetter();
            boolean z = playerStateGetter != null && playerStateGetter.getState() == 4;
            VideoSimpleControllerBinding videoSimpleControllerBinding = this.binding;
            if (videoSimpleControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = videoSimpleControllerBinding.maskView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.maskView");
            if (!z) {
                i2 = 8;
            }
            frameLayout.setVisibility(i2);
        } else if (i == -99001) {
            this.bufferPercentage = 0;
            this.timeFormat = null;
            updateUI(0, 0);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559305, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…_controller, null, false)");
        VideoSimpleControllerBinding videoSimpleControllerBinding = (VideoSimpleControllerBinding) inflate;
        this.binding = videoSimpleControllerBinding;
        if (videoSimpleControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(videoSimpleControllerBinding.progressBar, AppHolder.getAppTheme().getColorAccent());
        VideoSimpleControllerBinding videoSimpleControllerBinding2 = this.binding;
        if (videoSimpleControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoSimpleControllerBinding2.setClick(this);
        VideoSimpleControllerBinding videoSimpleControllerBinding3 = this.binding;
        if (videoSimpleControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoSimpleControllerBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover
    public void onThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        super.onThemeChange(appTheme);
        if (this.binding != null) {
            VideoSimpleControllerBinding videoSimpleControllerBinding = this.binding;
            if (videoSimpleControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TintHelper.setTint(videoSimpleControllerBinding.progressBar, AppHolder.getAppTheme().getColorAccent());
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelLow(1);
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        notifyReceiverEvent(-104, null);
    }
}
