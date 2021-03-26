package com.coolapk.market.widget.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.VideoFloatingBinding;
import com.coolapk.market.util.TintHelper;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.player.OnTimerUpdateListener;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;
import com.kk.taurus.playerbase.utils.TimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J,\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016J\u0012\u0010&\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\nH\u0002J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/coolapk/market/widget/video/cover/FloatingCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/player/OnTimerUpdateListener;", "Lcom/kk/taurus/playerbase/touch/OnTouchGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/coolapk/market/databinding/VideoFloatingBinding;", "bufferPercentage", "", "currentPosition", "timeFormat", "", "getCoverLevel", "onClick", "", "v", "Landroid/view/View;", "onCoverAttachedToWindow", "onCoverDetachedToWindow", "onCreateCoverView", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onDown", "onEndGesture", "onErrorEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "onTimerUpdate", "curr", "duration", "setErrorViewVisible", "visible", "", "status", "setProgressBarUI", "setReplayViewVisible", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FloatingCover.kt */
public final class FloatingCover extends ThemeableCover implements OnTimerUpdateListener, OnTouchGestureListener {
    private VideoFloatingBinding binding;
    private int bufferPercentage;
    private int currentPosition;
    private String timeFormat;

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDown(MotionEvent motionEvent) {
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onEndGesture() {
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        requestNotifyTimer();
        setReplayViewVisible(getGroupValue().getBoolean("complete_show"));
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverDetachedToWindow() {
        super.onCoverDetachedToWindow();
        requestStopTimer();
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131362262) {
            notifyReceiverEvent(-101, null);
        } else if (id == 2131363254) {
            requestReplay(null);
            setReplayViewVisible(false);
            setProgressBarUI(0, 0);
            setErrorViewVisible$default(this, false, 0, 2, null);
        } else if (id == 2131363259) {
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_data", this.currentPosition);
            requestResume(obtain);
            setReplayViewVisible(false);
            setProgressBarUI(0, 0);
            setErrorViewVisible$default(this, false, 0, 2, null);
        }
    }

    static /* synthetic */ void setErrorViewVisible$default(FloatingCover floatingCover, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        floatingCover.setErrorViewVisible(z, i);
    }

    private final void setErrorViewVisible(boolean z, int i) {
        if (z) {
            VideoFloatingBinding videoFloatingBinding = this.binding;
            if (videoFloatingBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoFloatingBinding.errorView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
            linearLayout.setVisibility(0);
        } else {
            VideoFloatingBinding videoFloatingBinding2 = this.binding;
            if (videoFloatingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = videoFloatingBinding2.errorView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
            linearLayout2.setVisibility(8);
        }
        getGroupValue().putBoolean("error_show", z);
        getGroupValue().putInt("last_error_state", i);
        getGroupValue().putInt("last_error_extra", 0);
    }

    private final void setReplayViewVisible(boolean z) {
        if (z) {
            VideoFloatingBinding videoFloatingBinding = this.binding;
            if (videoFloatingBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoFloatingBinding.replayView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.replayView");
            linearLayout.setVisibility(0);
        } else {
            VideoFloatingBinding videoFloatingBinding2 = this.binding;
            if (videoFloatingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = videoFloatingBinding2.replayView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.replayView");
            linearLayout2.setVisibility(8);
        }
        getGroupValue().putBoolean("complete_show", z);
    }

    private final void setProgressBarUI(int i, int i2) {
        int i3 = 0;
        boolean z = i == 0 && i2 == 0;
        if (z) {
            i3 = 4;
        }
        if (this.timeFormat == null) {
            this.timeFormat = TimeUtil.getFormat((long) i2);
        }
        VideoFloatingBinding videoFloatingBinding = this.binding;
        if (videoFloatingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = videoFloatingBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(i3);
        if (!z) {
            VideoFloatingBinding videoFloatingBinding2 = this.binding;
            if (videoFloatingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar2 = videoFloatingBinding2.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.progressBar");
            progressBar2.setMax(i2);
            VideoFloatingBinding videoFloatingBinding3 = this.binding;
            if (videoFloatingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar3 = videoFloatingBinding3.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar3, "binding.progressBar");
            progressBar3.setProgress(i);
            VideoFloatingBinding videoFloatingBinding4 = this.binding;
            if (videoFloatingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar4 = videoFloatingBinding4.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar4, "binding.progressBar");
            progressBar4.setSecondaryProgress((int) (((((float) this.bufferPercentage) * 1.0f) / ((float) 100)) * ((float) i2)));
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559301, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…eo_floating, null, false)");
        VideoFloatingBinding videoFloatingBinding = (VideoFloatingBinding) inflate;
        this.binding = videoFloatingBinding;
        if (videoFloatingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FloatingCover floatingCover = this;
        videoFloatingBinding.closeView.setOnClickListener(floatingCover);
        VideoFloatingBinding videoFloatingBinding2 = this.binding;
        if (videoFloatingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoFloatingBinding2.replayView.setOnClickListener(floatingCover);
        VideoFloatingBinding videoFloatingBinding3 = this.binding;
        if (videoFloatingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoFloatingBinding3.retryView.setOnClickListener(floatingCover);
        VideoFloatingBinding videoFloatingBinding4 = this.binding;
        if (videoFloatingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(videoFloatingBinding4.progressBar, AppHolder.getAppTheme().getColorAccent());
        VideoFloatingBinding videoFloatingBinding5 = this.binding;
        if (videoFloatingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoFloatingBinding5.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.kk.taurus.playerbase.player.OnTimerUpdateListener
    public void onTimerUpdate(int i, int i2, int i3) {
        this.bufferPercentage = i3;
        setProgressBarUI(i, i2);
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        if (i != -99019) {
            if (i == -99016) {
                this.bufferPercentage = 0;
                this.timeFormat = null;
                setProgressBarUI(0, 0);
                setErrorViewVisible$default(this, false, 0, 2, null);
                setReplayViewVisible(true);
            } else if (i == -99001) {
                this.bufferPercentage = 0;
                this.timeFormat = null;
                setProgressBarUI(0, 0);
                setErrorViewVisible$default(this, false, 0, 2, null);
                setReplayViewVisible(false);
            }
        } else if (bundle != null) {
            this.currentPosition = bundle.getInt("int_arg1");
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onErrorEvent(int i, Bundle bundle) {
        setProgressBarUI(0, 0);
        setReplayViewVisible(false);
        setErrorViewVisible(true, -1);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelMedium(10);
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
        notifyReceiverEvent(-104, null);
    }
}
