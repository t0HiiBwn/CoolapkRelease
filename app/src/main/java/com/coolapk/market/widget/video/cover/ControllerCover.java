package com.coolapk.market.widget.video.cover;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.VideoControllerBinding;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.widget.video.util.PIPUtils;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.player.OnTimerUpdateListener;
import com.kk.taurus.playerbase.receiver.PlayerStateGetter;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;
import com.kk.taurus.playerbase.utils.TimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t*\u0003\u0012\u001a\u001d\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020\fH\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020'H\u0014J\b\u0010.\u001a\u00020'H\u0014J\u0010\u0010/\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u00101\u001a\u000202H\u0016J\b\u00104\u001a\u00020'H\u0016J\u001a\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u00109\u001a\u00020'2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001c\u0010:\u001a\u0004\u0018\u0001082\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020'H\u0016J\u001a\u0010<\u001a\u00020'2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010=\u001a\u00020'H\u0016J(\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010D\u001a\u00020'2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0016J \u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010K\u001a\u00020'H\u0002J\b\u0010L\u001a\u00020'H\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\fH\u0002J\u0010\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020\u000eH\u0002J\u0010\u0010Q\u001a\u00020'2\u0006\u0010P\u001a\u00020\u000eH\u0002J\u0010\u0010R\u001a\u00020'2\u0006\u0010I\u001a\u00020\fH\u0002J\u0010\u0010S\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010T\u001a\u00020'2\u0006\u0010P\u001a\u00020\u000eH\u0002J\u0010\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020\u000eH\u0002J\u0010\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\fH\u0002J\u0018\u0010Y\u001a\u00020'2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0002J\u0010\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020\u000eH\u0002J\u0012\u0010\\\u001a\u00020'2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0012\u0010\\\u001a\u00020'2\b\u0010_\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010`\u001a\u00020'2\u0006\u0010P\u001a\u00020\u000eH\u0002J\u0010\u0010a\u001a\u00020'2\u0006\u0010J\u001a\u00020\fH\u0002J\u0010\u0010b\u001a\u00020'2\u0006\u0010c\u001a\u00020,H\u0002J\b\u0010d\u001a\u00020'H\u0002J\u0018\u0010e\u001a\u00020'2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/coolapk/market/widget/video/cover/ControllerCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/player/OnTimerUpdateListener;", "Lcom/kk/taurus/playerbase/touch/OnTouchGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/coolapk/market/databinding/VideoControllerBinding;", "bottomAnimator", "Landroid/animation/ObjectAnimator;", "bufferPercentage", "", "controllerTopEnable", "", "defaultSystemUIFlag", "gestureEnable", "handler", "com/coolapk/market/widget/video/cover/ControllerCover$handler$1", "Lcom/coolapk/market/widget/video/cover/ControllerCover$handler$1;", "hideFrameContent", "isControllerShow", "()Z", "isTouchingSeekBar", "isUnseekable", "onGroupValueUpdateListener", "com/coolapk/market/widget/video/cover/ControllerCover$onGroupValueUpdateListener$1", "Lcom/coolapk/market/widget/video/cover/ControllerCover$onGroupValueUpdateListener$1;", "onSeekBarChangeListener", "com/coolapk/market/widget/video/cover/ControllerCover$onSeekBarChangeListener$1", "Lcom/coolapk/market/widget/video/cover/ControllerCover$onSeekBarChangeListener$1;", "seekEventRunnable", "Ljava/lang/Runnable;", "seekProgress", "timeFormat", "", "timerUpdateProgressEnable", "topAnimator", "cancelBottomAnimation", "", "cancelTopAnimation", "getCoverLevel", "onClick", "v", "Landroid/view/View;", "onCoverAttachedToWindow", "onCoverDetachedToWindow", "onCreateCoverView", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onDown", "onEndGesture", "onErrorEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onPrivateEvent", "onReceiverBind", "onReceiverEvent", "onReceiverUnBind", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "onThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onTimerUpdate", "curr", "duration", "removeDelayHiddenMessage", "sendDelayHiddenMessage", "sendSeekEvent", "progress", "setBottomContainerState", "state", "setControllerState", "setCurrTime", "setGestureEnable", "setPlayCompleteState", "setScreenSwitchEnable", "screenSwitchEnable", "setSecondProgress", "secondProgress", "setSeekProgress", "setSwitchScreenIcon", "isFullScreen", "setTitle", "dataSource", "Lcom/kk/taurus/playerbase/entity/DataSource;", "text", "setTopContainerState", "setTotalTime", "showMoreOptionMenu", "anchor", "toggleController", "updateUI", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ControllerCover.kt */
public final class ControllerCover extends ThemeableCover implements OnTimerUpdateListener, OnTouchGestureListener {
    public static final Companion Companion = new Companion(null);
    public static final int HIDE_SYSTEM_UI_FLAG = 5638;
    private static final int MSG_CODE_DELAY_HIDDEN_CONTROLLER = 101;
    private VideoControllerBinding binding;
    private ObjectAnimator bottomAnimator;
    private int bufferPercentage;
    private boolean controllerTopEnable;
    private int defaultSystemUIFlag;
    private boolean gestureEnable = true;
    private final ControllerCover$handler$1 handler = new ControllerCover$handler$1(this, Looper.getMainLooper());
    private boolean hideFrameContent;
    private boolean isTouchingSeekBar;
    private boolean isUnseekable;
    private final ControllerCover$onGroupValueUpdateListener$1 onGroupValueUpdateListener = new ControllerCover$onGroupValueUpdateListener$1(this);
    private final ControllerCover$onSeekBarChangeListener$1 onSeekBarChangeListener = new ControllerCover$onSeekBarChangeListener$1(this);
    private final Runnable seekEventRunnable = new ControllerCover$seekEventRunnable$1(this);
    private int seekProgress = -1;
    private String timeFormat;
    private boolean timerUpdateProgressEnable = true;
    private ObjectAnimator topAnimator;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ControllerCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ VideoControllerBinding access$getBinding$p(ControllerCover controllerCover) {
        VideoControllerBinding videoControllerBinding = controllerCover.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return videoControllerBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/video/cover/ControllerCover$Companion;", "", "()V", "HIDE_SYSTEM_UI_FLAG", "", "MSG_CODE_DELAY_HIDDEN_CONTROLLER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ControllerCover.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean isControllerShow() {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoControllerBinding.bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
        return linearLayout.getVisibility() == 0;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        updateUI(0, 0);
        this.gestureEnable = true;
        this.timeFormat = null;
        this.controllerTopEnable = false;
        this.timerUpdateProgressEnable = true;
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoControllerBinding.playView.setImageResource(2131231467);
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoControllerBinding2.seekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        VideoControllerBinding videoControllerBinding3 = this.binding;
        if (videoControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = videoControllerBinding3.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(4);
        getGroupValue().registerOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
        setSwitchScreenIcon(true);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        setTitle((DataSource) getGroupValue().get("data_source"));
        boolean z = getGroupValue().getBoolean("controller_top_enable", false);
        this.controllerTopEnable = z;
        if (!z) {
            setTopContainerState(false);
        }
        setScreenSwitchEnable(getGroupValue().getBoolean("screen_switch_enable", true));
        if (getGroupValue().getBoolean("complete_show")) {
            setPlayCompleteState(true);
        } else {
            setPlayCompleteState(false);
        }
        requestNotifyTimer();
        boolean z2 = getGroupValue().getBoolean("share_view_visible", true);
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = videoControllerBinding.shareView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.shareView");
        int i = 8;
        imageView.setVisibility(z2 ? 0 : 8);
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoControllerBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.defaultSystemUIFlag = root.getWindowSystemUiVisibility();
        if (this.topAnimator == null && this.controllerTopEnable) {
            VideoControllerBinding videoControllerBinding3 = this.binding;
            if (videoControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoControllerBinding3.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            if (linearLayout.getVisibility() != 0) {
                VideoControllerBinding videoControllerBinding4 = this.binding;
                if (videoControllerBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                View root2 = videoControllerBinding4.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                root2.setSystemUiVisibility(5638);
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(UiUtils.getContentView(AppHolder.getCurrentActivity()), new ControllerCover$onCoverAttachedToWindow$1(this));
        boolean z3 = getGroupValue().getBoolean("isLive");
        VideoControllerBinding videoControllerBinding5 = this.binding;
        if (videoControllerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = videoControllerBinding5.liveViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.liveViewContainer");
        linearLayout2.setVisibility(z3 ? 0 : 8);
        boolean supportPicInPicMode = PIPUtils.INSTANCE.supportPicInPicMode();
        VideoControllerBinding videoControllerBinding6 = this.binding;
        if (videoControllerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = videoControllerBinding6.pipView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pipView");
        if (supportPicInPicMode) {
            i = 0;
        }
        imageView2.setVisibility(i);
        this.hideFrameContent = false;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverDetachedToWindow() {
        super.onCoverDetachedToWindow();
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoControllerBinding.topContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
        linearLayout.setVisibility(8);
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = videoControllerBinding2.bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
        linearLayout2.setVisibility(8);
        removeDelayHiddenMessage();
        requestStopTimer();
        ViewCompat.setOnApplyWindowInsetsListener(UiUtils.getContentView(AppHolder.getCurrentActivity()), null);
        VideoControllerBinding videoControllerBinding3 = this.binding;
        if (videoControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoControllerBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setSystemUiVisibility(this.defaultSystemUIFlag);
        VideoControllerBinding videoControllerBinding4 = this.binding;
        if (videoControllerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout3 = videoControllerBinding4.liveViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.liveViewContainer");
        linearLayout3.setVisibility(8);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        cancelTopAnimation();
        cancelBottomAnimation();
        this.gestureEnable = false;
        getGroupValue().unregisterOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
        removeDelayHiddenMessage();
        this.handler.removeCallbacks(this.seekEventRunnable);
    }

    /* access modifiers changed from: private */
    public final void sendSeekEvent(int i) {
        this.timerUpdateProgressEnable = false;
        this.seekProgress = i;
        this.handler.removeCallbacks(this.seekEventRunnable);
        this.handler.postDelayed(this.seekEventRunnable, 300);
    }

    /* access modifiers changed from: private */
    public final void setTitle(DataSource dataSource) {
        if (dataSource != null) {
            String title = dataSource.getTitle();
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
            } else {
                setTitle(dataSource.getData());
            }
        } else {
            setTitle("");
        }
    }

    private final void setTitle(String str) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoControllerBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    /* access modifiers changed from: private */
    public final void setSwitchScreenIcon(boolean z) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoControllerBinding.fullScreenView.setImageResource(z ? 2131230846 : 2131230845);
    }

    private final void setScreenSwitchEnable(boolean z) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = videoControllerBinding.fullScreenView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.fullScreenView");
        imageView.setVisibility(z ? 0 : 8);
    }

    private final void setGestureEnable(boolean z) {
        this.gestureEnable = z;
    }

    private final void cancelTopAnimation() {
        ObjectAnimator objectAnimator = this.topAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            objectAnimator.removeAllListeners();
            objectAnimator.removeAllUpdateListeners();
            this.topAnimator = null;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002b: APUT  (r1v2 float[]), (0 ??[int, short, byte, char]), (r5v0 float) */
    /* access modifiers changed from: private */
    public final void setTopContainerState(boolean z) {
        if (this.controllerTopEnable) {
            VideoControllerBinding videoControllerBinding = this.binding;
            if (videoControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            videoControllerBinding.topContainer.clearAnimation();
            cancelTopAnimation();
            VideoControllerBinding videoControllerBinding2 = this.binding;
            if (videoControllerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoControllerBinding2.topContainer;
            float[] fArr = new float[2];
            float f = 0.0f;
            fArr[0] = z ? 0.0f : 1.0f;
            if (z) {
                f = 1.0f;
            }
            fArr[1] = f;
            ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout, "alpha", fArr).setDuration(300L);
            Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(b…else 0f).setDuration(300)");
            duration.addListener(new ControllerCover$setTopContainerState$1(this, z));
            duration.start();
            this.topAnimator = duration;
            return;
        }
        VideoControllerBinding videoControllerBinding3 = this.binding;
        if (videoControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = videoControllerBinding3.topContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.topContainer");
        linearLayout2.setVisibility(8);
    }

    private final void cancelBottomAnimation() {
        ObjectAnimator objectAnimator = this.bottomAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            objectAnimator.removeAllListeners();
            objectAnimator.removeAllUpdateListeners();
            this.bottomAnimator = null;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  (r1v2 float[]), (0 ??[int, short, byte, char]), (r5v0 float) */
    private final void setBottomContainerState(boolean z) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoControllerBinding.bottomContainer.clearAnimation();
        cancelBottomAnimation();
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoControllerBinding2.bottomContainer;
        float[] fArr = new float[2];
        float f = 0.0f;
        fArr[0] = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        fArr[1] = f;
        ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout, "alpha", fArr).setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(b…else 0f).setDuration(300)");
        duration.addListener(new ControllerCover$setBottomContainerState$1(this, z));
        duration.start();
        this.bottomAnimator = duration;
    }

    /* access modifiers changed from: private */
    public final void setControllerState(boolean z) {
        if (!z || !this.hideFrameContent) {
            if (z) {
                sendDelayHiddenMessage();
            } else {
                removeDelayHiddenMessage();
            }
            setTopContainerState(z);
            setBottomContainerState(z);
        }
    }

    private final void toggleController() {
        if (isControllerShow()) {
            setControllerState(false);
        } else {
            setControllerState(true);
        }
    }

    /* access modifiers changed from: private */
    public final void sendDelayHiddenMessage() {
        removeDelayHiddenMessage();
        this.handler.sendEmptyMessageDelayed(MSG_CODE_DELAY_HIDDEN_CONTROLLER, 5000);
    }

    /* access modifiers changed from: private */
    public final void removeDelayHiddenMessage() {
        this.handler.removeMessages(MSG_CODE_DELAY_HIDDEN_CONTROLLER);
    }

    private final void setCurrTime(int i) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoControllerBinding.currentTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.currentTimeView");
        textView.setText(TimeUtil.getTime(this.timeFormat, (long) i));
    }

    private final void setTotalTime(int i) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoControllerBinding.totalTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.totalTimeView");
        textView.setText(TimeUtil.getTime(this.timeFormat, (long) i));
    }

    private final void setSeekProgress(int i, int i2) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SeekBar seekBar = videoControllerBinding.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "binding.seekBar");
        seekBar.setMax(i2);
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SeekBar seekBar2 = videoControllerBinding2.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar2, "binding.seekBar");
        seekBar2.setProgress(i);
        setSecondProgress((int) (((((float) this.bufferPercentage) * 1.0f) / ((float) 100)) * ((float) i2)));
    }

    private final void setSecondProgress(int i) {
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SeekBar seekBar = videoControllerBinding.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "binding.seekBar");
        seekBar.setSecondaryProgress(i);
    }

    @Override // com.kk.taurus.playerbase.player.OnTimerUpdateListener
    public void onTimerUpdate(int i, int i2, int i3) {
        if (this.timerUpdateProgressEnable) {
            if (this.timeFormat == null) {
                this.timeFormat = TimeUtil.getFormat((long) i2);
            }
            this.bufferPercentage = i3;
            updateUI(i, i2);
        }
    }

    /* access modifiers changed from: private */
    public final void updateUI(int i, int i2) {
        int i3 = 0;
        boolean z = i == 0 && i2 == 0;
        this.isUnseekable = z;
        int i4 = z ? 4 : 0;
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoControllerBinding.currentTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.currentTimeView");
        textView.setVisibility(i4);
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SeekBar seekBar = videoControllerBinding2.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "binding.seekBar");
        seekBar.setVisibility(i4);
        VideoControllerBinding videoControllerBinding3 = this.binding;
        if (videoControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = videoControllerBinding3.totalTimeView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.totalTimeView");
        textView2.setVisibility(i4);
        VideoControllerBinding videoControllerBinding4 = this.binding;
        if (videoControllerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = videoControllerBinding4.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        if (this.isUnseekable || isControllerShow()) {
            i3 = 4;
        }
        progressBar.setVisibility(i3);
        if (!this.isTouchingSeekBar && !this.isUnseekable) {
            VideoControllerBinding videoControllerBinding5 = this.binding;
            if (videoControllerBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar2 = videoControllerBinding5.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
            progressBar2.setMax(i2);
            VideoControllerBinding videoControllerBinding6 = this.binding;
            if (videoControllerBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar3 = videoControllerBinding6.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar3, "binding.progressBar");
            progressBar3.setProgress(i);
            VideoControllerBinding videoControllerBinding7 = this.binding;
            if (videoControllerBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar4 = videoControllerBinding7.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar4, "binding.progressBar");
            progressBar4.setSecondaryProgress((int) (((((float) this.bufferPercentage) * 1.0f) / ((float) 100)) * ((float) i2)));
            setSeekProgress(i, i2);
            setCurrTime(i);
            setTotalTime(i2);
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        Integer num = null;
        boolean z = true;
        switch (i) {
            case -99031:
                if (bundle != null) {
                    num = Integer.valueOf(bundle.getInt("int_data"));
                }
                if (num != null && num.intValue() == 4) {
                    VideoControllerBinding videoControllerBinding = this.binding;
                    if (videoControllerBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    videoControllerBinding.playView.setImageResource(2131231486);
                } else if (num != null && num.intValue() == 3) {
                    VideoControllerBinding videoControllerBinding2 = this.binding;
                    if (videoControllerBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    videoControllerBinding2.playView.setImageResource(2131231467);
                } else if ((num != null && num.intValue() == 0) || ((num != null && num.intValue() == -1) || ((num != null && num.intValue() == 5) || (num != null && num.intValue() == 6)))) {
                    VideoControllerBinding videoControllerBinding3 = this.binding;
                    if (videoControllerBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    videoControllerBinding3.playView.setImageResource(2131231486);
                }
                if (num == null || num.intValue() != 6) {
                    z = false;
                }
                setPlayCompleteState(z);
                return;
            case -99015:
            case -99014:
                this.timerUpdateProgressEnable = true;
                setPlayCompleteState(false);
                return;
            case -99006:
                if (this.topAnimator == null && this.controllerTopEnable) {
                    VideoControllerBinding videoControllerBinding4 = this.binding;
                    if (videoControllerBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    LinearLayout linearLayout = videoControllerBinding4.topContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
                    if (linearLayout.getVisibility() == 0) {
                        VideoControllerBinding videoControllerBinding5 = this.binding;
                        if (videoControllerBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        View root = videoControllerBinding5.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        root.setSystemUiVisibility(this.defaultSystemUIFlag);
                        return;
                    }
                    VideoControllerBinding videoControllerBinding6 = this.binding;
                    if (videoControllerBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    View root2 = videoControllerBinding6.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                    root2.setSystemUiVisibility(5638);
                    return;
                }
                return;
            case -99001:
                this.bufferPercentage = 0;
                this.timeFormat = null;
                updateUI(0, 0);
                return;
            default:
                return;
        }
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
                setControllerState(false);
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
                            sendDelayHiddenMessage();
                            return;
                        } else if (state == 4) {
                            requestResume(null);
                            notifyReceiverEvent(-121, null);
                            return;
                        } else if (!(state == 5 || state == 6)) {
                            return;
                        }
                    }
                    requestReplay(null);
                    sendDelayHiddenMessage();
                    return;
                }
                return;
            case 2131363240:
                requestReplay(null);
                setPlayCompleteState(false);
                return;
            case 2131363358:
                notifyReceiverEvent(-107, null);
                return;
            default:
                return;
        }
    }

    private final void showMoreOptionMenu(View view) {
        BasePopMenu basePopMenu = new BasePopMenu(AppHolder.getCurrentActivity(), view);
        basePopMenu.getMenu().add(0, 2131361981, 101, 2131887153);
        basePopMenu.setOnMenuItemClickListener(new ControllerCover$showMoreOptionMenu$1(this));
        basePopMenu.show();
    }

    private final void setPlayCompleteState(boolean z) {
        if (z) {
            VideoControllerBinding videoControllerBinding = this.binding;
            if (videoControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            videoControllerBinding.itemView.setBackgroundColor(1711276032);
            VideoControllerBinding videoControllerBinding2 = this.binding;
            if (videoControllerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoControllerBinding2.replayView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.replayView");
            linearLayout.setVisibility(0);
            setControllerState(true);
        } else {
            VideoControllerBinding videoControllerBinding3 = this.binding;
            if (videoControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = videoControllerBinding3.itemView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.itemView");
            frameLayout.setBackground(null);
            VideoControllerBinding videoControllerBinding4 = this.binding;
            if (videoControllerBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = videoControllerBinding4.replayView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.replayView");
            linearLayout2.setVisibility(8);
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
        updateUI(bundle.getInt("int_arg1"), bundle.getInt("int_arg2"));
        return null;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559289, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…_controller, null, false)");
        VideoControllerBinding videoControllerBinding = (VideoControllerBinding) inflate;
        this.binding = videoControllerBinding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoControllerBinding.topContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
        linearLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 0}));
        VideoControllerBinding videoControllerBinding2 = this.binding;
        if (videoControllerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = videoControllerBinding2.bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
        linearLayout2.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{1711276032, 0}));
        VideoControllerBinding videoControllerBinding3 = this.binding;
        if (videoControllerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SeekBar seekBar = videoControllerBinding3.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "binding.seekBar");
        seekBar.getThumb().setTint(-1);
        VideoControllerBinding videoControllerBinding4 = this.binding;
        if (videoControllerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SeekBar seekBar2 = videoControllerBinding4.seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar2, "binding.seekBar");
        seekBar2.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        VideoControllerBinding videoControllerBinding5 = this.binding;
        if (videoControllerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = videoControllerBinding5.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        VideoControllerBinding videoControllerBinding6 = this.binding;
        if (videoControllerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoControllerBinding6.setClick(this);
        VideoControllerBinding videoControllerBinding7 = this.binding;
        if (videoControllerBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoControllerBinding7.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover
    public void onThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        super.onThemeChange(appTheme);
        if (this.binding != null) {
            VideoControllerBinding videoControllerBinding = this.binding;
            if (videoControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SeekBar seekBar = videoControllerBinding.seekBar;
            Intrinsics.checkNotNullExpressionValue(seekBar, "binding.seekBar");
            seekBar.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
            VideoControllerBinding videoControllerBinding2 = this.binding;
            if (videoControllerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = videoControllerBinding2.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
            progressBar.setProgressTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelLow(1);
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (this.gestureEnable) {
            toggleController();
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        VideoControllerBinding videoControllerBinding = this.binding;
        if (videoControllerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoControllerBinding.playView.performClick();
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent, "e1");
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        if (!this.gestureEnable) {
        }
    }
}
