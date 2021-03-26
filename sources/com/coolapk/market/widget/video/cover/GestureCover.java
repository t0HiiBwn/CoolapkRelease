package com.coolapk.market.widget.video.cover;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.VideoGestureBinding;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.receiver.PlayerStateGetter;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;
import com.kk.taurus.playerbase.utils.TimeUtil;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t*\u0002\u0016!\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020*H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0016J\b\u00102\u001a\u00020*H\u0016J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020*2\u0006\u00104\u001a\u00020\u000bH\u0002J\u001a\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020*H\u0016J\u0010\u0010;\u001a\u00020*2\u0006\u00104\u001a\u00020\u000bH\u0002J(\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u0002002\u0006\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bH\u0016J\u0010\u0010A\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\rH\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0013H\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010J\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0013H\u0002J\u0010\u0010K\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0002J\u000e\u0010L\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010M\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0013H\u0002J\u0010\u0010N\u001a\u00020*2\u0006\u0010O\u001a\u00020\rH\u0002J\u0010\u0010P\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/coolapk/market/widget/video/cover/GestureCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/touch/OnTouchGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioManager", "Landroid/media/AudioManager;", "binding", "Lcom/coolapk/market/databinding/VideoGestureBinding;", "brightness", "", "currentPosition", "", "getCurrentPosition", "()I", "duration", "getDuration", "firstTouch", "", "gestureEnable", "handler", "com/coolapk/market/widget/video/cover/GestureCover$handler$1", "Lcom/coolapk/market/widget/video/cover/GestureCover$handler$1;", "horizontalSlide", "ignoreFollowingTouch", "isHorizontalSlide", "isLandScape", "isRightVerticalSlide", "maxVolume", "newPosition", "", "onGroupValueUpdateListener", "com/coolapk/market/widget/video/cover/GestureCover$onGroupValueUpdateListener$1", "Lcom/coolapk/market/widget/video/cover/GestureCover$onGroupValueUpdateListener$1;", "seekEventRunnable", "Ljava/lang/Runnable;", "seekProgress", "volume", "getCoverLevel", "getCurrentVolume", "onCoverAttachedToWindow", "", "onCoverDetachedToWindow", "onCreateCoverView", "Landroid/view/View;", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onDown", "onEndGesture", "onHorizontalSlide", "percent", "onLeftVerticalSlide", "onPlayerEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onReceiverBind", "onRightVerticalSlide", "onScroll", "e1", "e2", "distanceX", "distanceY", "onSingleTapUp", "sendSeekEvent", "progress", "setBrightnessBoxState", "state", "setBrightnessText", "text", "", "setFastForwardProgressTime", "setFastForwardState", "setFastForwardStepTime", "setGestureEnable", "setVolumeBoxState", "setVolumeIcon", "resId", "setVolumeText", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GestureCover.kt */
public final class GestureCover extends ThemeableCover implements OnTouchGestureListener {
    private AudioManager audioManager;
    private VideoGestureBinding binding;
    private float brightness;
    private boolean firstTouch;
    private boolean gestureEnable;
    private final GestureCover$handler$1 handler;
    private boolean horizontalSlide;
    private boolean ignoreFollowingTouch;
    private boolean isHorizontalSlide;
    private boolean isLandScape;
    private boolean isRightVerticalSlide;
    private int maxVolume;
    private long newPosition;
    private final GestureCover$onGroupValueUpdateListener$1 onGroupValueUpdateListener;
    private final Runnable seekEventRunnable;
    private int seekProgress = -1;
    private int volume;

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GestureCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        this.gestureEnable = true;
        this.handler = new GestureCover$handler$1(Looper.getMainLooper());
        this.brightness = -1.0f;
        this.seekEventRunnable = new GestureCover$seekEventRunnable$1(this);
        this.onGroupValueUpdateListener = new GestureCover$onGroupValueUpdateListener$1(this);
    }

    private final int getDuration() {
        PlayerStateGetter playerStateGetter = getPlayerStateGetter();
        if (playerStateGetter != null) {
            return playerStateGetter.getDuration();
        }
        return 0;
    }

    private final int getCurrentPosition() {
        PlayerStateGetter playerStateGetter = getPlayerStateGetter();
        if (playerStateGetter != null) {
            return playerStateGetter.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        this.maxVolume = this.audioManager.getStreamMaxVolume(3);
    }

    private final void sendSeekEvent(int i) {
        getGroupValue().putBoolean("timer_update_enable", false);
        this.seekProgress = i;
        this.handler.removeCallbacks(this.seekEventRunnable);
        this.handler.postDelayed(this.seekEventRunnable, 300);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        getGroupValue().registerOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverDetachedToWindow() {
        super.onCoverDetachedToWindow();
        getGroupValue().unregisterOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
    }

    private final void setVolumeBoxState(boolean z) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoGestureBinding.volumeBoxView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.volumeBoxView");
        linearLayout.setVisibility(z ? 0 : 8);
    }

    private final void setVolumeIcon(int i) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoGestureBinding.volumeIconView.setImageResource(i);
    }

    private final void setVolumeText(String str) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoGestureBinding.volumeTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.volumeTextView");
        textView.setText(str);
    }

    private final void setBrightnessBoxState(boolean z) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoGestureBinding.brightnessBoxView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.brightnessBoxView");
        linearLayout.setVisibility(z ? 0 : 8);
    }

    private final void setBrightnessText(String str) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoGestureBinding.brightnessTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.brightnessTextView");
        textView.setText(str);
    }

    private final void setFastForwardState(boolean z) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoGestureBinding.fastForwardBoxView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.fastForwardBoxView");
        linearLayout.setVisibility(z ? 0 : 8);
    }

    private final void setFastForwardStepTime(String str) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoGestureBinding.fastForwardStepTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.fastForwardStepTimeView");
        textView.setText(str);
    }

    private final void setFastForwardProgressTime(String str) {
        VideoGestureBinding videoGestureBinding = this.binding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = videoGestureBinding.fastForwardProgressTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.fastForwardProgressTimeView");
        textView.setText(str);
    }

    public final void setGestureEnable(boolean z) {
        this.gestureEnable = z;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559303, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…deo_gesture, null, false)");
        VideoGestureBinding videoGestureBinding = (VideoGestureBinding) inflate;
        this.binding = videoGestureBinding;
        if (videoGestureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoGestureBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelLow(0);
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        if (i == -99015) {
            setGestureEnable(true);
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        boolean z = false;
        this.isHorizontalSlide = false;
        this.firstTouch = true;
        this.ignoreFollowingTouch = false;
        this.volume = getCurrentVolume();
        View view = getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        int width = view.getWidth();
        View view2 = getView();
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        int height = view2.getHeight();
        if (width <= 0 || height <= 0) {
            this.ignoreFollowingTouch = true;
            return;
        }
        float y = motionEvent.getY();
        motionEvent.getX();
        if (((float) width) / ((float) height) > 0.8f) {
            z = true;
        }
        this.isLandScape = z;
        if (z) {
            double d = (double) y;
            double d2 = (double) height;
            if (d < 0.1d * d2 || d > d2 * 0.9d) {
                this.ignoreFollowingTouch = true;
                return;
            }
            return;
        }
        double d3 = (double) y;
        double d4 = (double) height;
        if (d3 < 0.2d * d4 || d3 > d4 * 0.8d) {
            this.ignoreFollowingTouch = true;
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent, "e1");
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        if (!this.ignoreFollowingTouch && this.gestureEnable) {
            View view = getView();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            int width = view.getWidth();
            View view2 = getView();
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            int height = view2.getHeight();
            if (width > 0 && height > 0) {
                float y = motionEvent.getY() - motionEvent2.getY();
                float x = motionEvent.getX() - motionEvent2.getX();
                if (this.firstTouch) {
                    float f3 = (float) width;
                    boolean z = true;
                    this.isLandScape = f3 / ((float) height) > 0.8f;
                    this.horizontalSlide = Math.abs(f) >= Math.abs(f2);
                    if (motionEvent.getX() <= f3 * 0.5f) {
                        z = false;
                    }
                    this.isRightVerticalSlide = z;
                    this.firstTouch = false;
                }
                if (this.horizontalSlide) {
                    onHorizontalSlide((-x) / ((float) width));
                    return;
                }
                float f4 = this.isLandScape ? ((float) height) * 0.8f : ((float) height) * 0.6f;
                if (Math.abs(y) <= f4) {
                    if (this.isRightVerticalSlide) {
                        onRightVerticalSlide(y / f4);
                    } else {
                        onLeftVerticalSlide(y / f4);
                    }
                }
            }
        }
    }

    private final void onHorizontalSlide(float f) {
        StringBuilder sb;
        if (getDuration() > 0) {
            this.isHorizontalSlide = true;
            getGroupValue().putBoolean("timer_update_enable", false);
            long currentPosition = (long) getCurrentPosition();
            long duration = (long) getDuration();
            long min = (long) (((float) Math.min(duration / ((long) 2), duration - currentPosition)) * f);
            long j = min + currentPosition;
            this.newPosition = j;
            if (j > duration) {
                this.newPosition = duration;
            } else if (j <= 0) {
                this.newPosition = 0;
                min = -currentPosition;
            }
            int i = ((int) min) / 1000;
            if (i != 0) {
                Bundle obtain = BundlePool.obtain();
                obtain.putInt("int_arg1", (int) this.newPosition);
                obtain.putInt("int_arg2", (int) duration);
                notifyReceiverPrivateEvent("controller_cover", -201, obtain);
                notifyReceiverPrivateEvent("proxy_cover", -201, obtain);
                obtain.clear();
                setFastForwardState(true);
                if (i > 0) {
                    sb.append('+');
                } else {
                    sb = new StringBuilder();
                    sb.append("");
                }
                sb.append(i);
                String sb2 = sb.toString();
                setFastForwardStepTime(sb2 + "s");
                setFastForwardProgressTime(TimeUtil.getTimeSmartFormat(this.newPosition) + "/" + TimeUtil.getTimeSmartFormat(duration));
            }
        }
    }

    private final void onRightVerticalSlide(float f) {
        this.isHorizontalSlide = false;
        int i = this.maxVolume;
        int i2 = ((int) (f * ((float) i))) + this.volume;
        if (i2 <= i) {
            i = i2 < 0 ? 0 : i2;
        }
        this.audioManager.setStreamVolume(3, i, 0);
        int i3 = (int) (((((double) i) * 1.0d) / ((double) this.maxVolume)) * ((double) 100));
        String str = String.valueOf(i3) + "%";
        if (i3 == 0) {
            str = "OFF";
        }
        setVolumeIcon(i3 == 0 ? 2131231653 : 2131231654);
        setBrightnessBoxState(false);
        setFastForwardState(false);
        setVolumeBoxState(true);
        setVolumeText(str);
    }

    private final void onLeftVerticalSlide(float f) {
        this.isHorizontalSlide = false;
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity != null) {
            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity() ?: return");
            if (this.brightness < ((float) 0)) {
                Window window = currentActivity.getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                float f2 = window.getAttributes().screenBrightness;
                this.brightness = f2;
                if (f2 <= 0.0f) {
                    this.brightness = 0.5f;
                } else if (f2 < 0.01f) {
                    this.brightness = 0.01f;
                }
            }
            setVolumeBoxState(false);
            setFastForwardState(false);
            setBrightnessBoxState(true);
            Window window2 = currentActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "activity.window");
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.screenBrightness = this.brightness + f;
            if (attributes.screenBrightness > 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if (attributes.screenBrightness < 0.01f) {
                attributes.screenBrightness = 0.01f;
            }
            setBrightnessText(String.valueOf((int) (attributes.screenBrightness * ((float) 100))) + "%");
            Window window3 = currentActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window3, "activity.window");
            window3.setAttributes(attributes);
        }
    }

    private final int getCurrentVolume() {
        int streamVolume = this.audioManager.getStreamVolume(3);
        this.volume = streamVolume;
        if (streamVolume < 0) {
            this.volume = 0;
        }
        return this.volume;
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onEndGesture() {
        this.volume = -1;
        this.brightness = -1.0f;
        setVolumeBoxState(false);
        setBrightnessBoxState(false);
        setFastForwardState(false);
        long j = this.newPosition;
        if (j < 0 || !this.isHorizontalSlide) {
            getGroupValue().putBoolean("timer_update_enable", true);
        } else {
            sendSeekEvent((int) j);
            this.newPosition = 0;
        }
        this.isHorizontalSlide = false;
        this.ignoreFollowingTouch = false;
    }
}
