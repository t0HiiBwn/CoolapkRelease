package com.coolapk.market.widget.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Live;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.CenterCropDrawable;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.cover.FloatingCover;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.window.FloatWindow;
import com.kk.taurus.playerbase.window.FloatWindowParams;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u0004\u0018\u00010(J'\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00142\u0010\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-H\u0016¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020*H\u0016J\u001a\u00104\u001a\u00020*2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0006\u00109\u001a\u00020*R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006:"}, d2 = {"Lcom/coolapk/market/widget/video/FloatWindowBridge;", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "context", "Landroid/content/Context;", "videoModel", "Lcom/coolapk/market/widget/video/VideoModel;", "ratio", "", "(Landroid/content/Context;Lcom/coolapk/market/widget/video/VideoModel;F)V", "audioManager", "Landroid/media/AudioManager;", "getContext", "()Landroid/content/Context;", "floatParams", "Lcom/kk/taurus/playerbase/window/FloatWindowParams;", "floatWindow", "Lcom/kk/taurus/playerbase/window/FloatWindow;", "isOpeningActivity", "", "lastSourceKey", "", "getLastSourceKey", "()Ljava/lang/String;", "setLastSourceKey", "(Ljava/lang/String;)V", "onAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "sharedPlayer", "Lcom/coolapk/market/widget/video/SharedPlayer;", "getSharedPlayer", "()Lcom/coolapk/market/widget/video/SharedPlayer;", "sourceKey", "getSourceKey", "videoContainer", "Landroid/widget/FrameLayout;", "getVideoModel", "()Lcom/coolapk/market/widget/video/VideoModel;", "getPlayerArg", "Lcom/coolapk/market/widget/video/PlayerArg;", "getWindowsRect", "Landroid/graphics/Rect;", "onAction", "", "actionType", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onAttach", "assist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "onDetach", "onEvent", "eventCode", "", "bundle", "Landroid/os/Bundle;", "show", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FloatWindowBridge.kt */
public final class FloatWindowBridge implements VideoPlayerBridge {
    private AudioManager audioManager;
    private final Context context;
    private final FloatWindowParams floatParams;
    private final FloatWindow floatWindow;
    private boolean isOpeningActivity;
    private String lastSourceKey;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
    private final FrameLayout videoContainer;
    private final VideoModel videoModel;

    public FloatWindowBridge(Context context2, VideoModel videoModel2, float f) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(videoModel2, "videoModel");
        this.context = context2;
        this.videoModel = videoModel2;
        int i = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        int min = Math.min(DisplayUtils.getHeightPixels(context2), DisplayUtils.getWidthPixels(context2));
        int max = Math.max(DisplayUtils.getHeightPixels(context2), DisplayUtils.getWidthPixels(context2));
        int i2 = (min * min) / 5;
        int sqrt = (int) Math.sqrt((double) (((float) i2) / f));
        int i3 = i2 / sqrt;
        FloatWindowParams height = new FloatWindowParams().setWindowType(i).setX((min - NumberExtendsKt.getDp((Number) 16)) - i3).setY((max - NumberExtendsKt.getDp((Number) 92)) - sqrt).setWidth(i3).setHeight(sqrt);
        Intrinsics.checkNotNullExpressionValue(height, "FloatWindowParams()\n    …       .setHeight(height)");
        this.floatParams = height;
        FrameLayout frameLayout = new FrameLayout(context2);
        this.videoContainer = frameLayout;
        FloatWindow floatWindow2 = new FloatWindow(context2, frameLayout, height);
        this.floatWindow = floatWindow2;
        floatWindow2.setDragEnable(true);
        floatWindow2.setBackgroundColor(-16777216);
        floatWindow2.setElevationShadow((float) NumberExtendsKt.getDp((Number) 4));
        floatWindow2.setRoundRectShape((float) NumberExtendsKt.getDp((Number) 4));
        Object systemService = context2.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
    }

    public final Context getContext() {
        return this.context;
    }

    public final VideoModel getVideoModel() {
        return this.videoModel;
    }

    public final String getLastSourceKey() {
        return this.lastSourceKey;
    }

    public final void setLastSourceKey(String str) {
        this.lastSourceKey = str;
    }

    public final String getSourceKey() {
        return getClass().getSimpleName() + hashCode() + this.videoModel.getKey();
    }

    private final SharedPlayer getSharedPlayer() {
        return VideoManager.INSTANCE.getSharedPlayer();
    }

    public final Rect getWindowsRect() {
        if (this.videoContainer.isAttachedToWindow()) {
            int[] iArr = new int[2];
            FrameLayout frameLayout = this.videoContainer;
            frameLayout.getLocationOnScreen(iArr);
            return new Rect(iArr[0], iArr[1], iArr[0] + frameLayout.getWidth(), iArr[1] + frameLayout.getHeight());
        }
        int statusBarHeight = UiUtils.getStatusBarHeight(AppHolder.getApplication());
        Rect rect = new Rect(0, 0, this.floatParams.getWidth(), this.floatParams.getHeight());
        rect.offset(this.floatParams.getX(), this.floatParams.getY());
        rect.offset(0, statusBarHeight);
        return rect;
    }

    public final void show() {
        getSharedPlayer().attachPlayerBridge(this);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onDetach() {
        this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
        getSharedPlayer().setFloatingScreen(false);
        Bitmap renderingBitmap = getSharedPlayer().getRenderingBitmap();
        if (renderingBitmap != null && Build.VERSION.SDK_INT >= 23) {
            this.videoContainer.setBackground(new CenterCropDrawable(new BitmapDrawable(renderingBitmap)));
            this.videoContainer.postDelayed(new FloatWindowBridge$onDetach$1(this), 300);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.floatWindow, View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(100L);
        this.floatWindow.close(ofFloat);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        if (!this.floatWindow.isWindowShow()) {
            this.floatWindow.show(null);
        }
        relationAssist.getReceiverGroup().addReceiver("floating_cover", new FloatingCover(this.context));
        getSharedPlayer().setFloatingScreen(true);
        this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 2);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onEvent(int i, Bundle bundle) {
        if (i != -104) {
            if (i == -101) {
                getSharedPlayer().detachPlayerBridge();
            }
        } else if (this.isOpeningActivity) {
            Toast.show$default(this.context, "正在打开... 请稍等", 0, false, 12, null);
        } else {
            this.isOpeningActivity = true;
            if (this.videoModel.getRelatedEntity() instanceof Live) {
                Entity relatedEntity = this.videoModel.getRelatedEntity();
                Objects.requireNonNull(relatedEntity, "null cannot be cast to non-null type com.coolapk.market.model.Live");
                ActionManager.startLiveActivity(this.context, ((Live) relatedEntity).getId());
                return;
            }
            ActionManager.startVideoDetailListActivity(this.context, this.videoModel, getWindowsRect(), this.lastSourceKey);
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public PlayerArg getPlayerArg() {
        return new PlayerArg(this.videoContainer, this.videoModel, SetsKt.setOf("loading_cover"), false);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAction(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "actionType");
        if (str.hashCode() == 647082476 && str.equals("show_pause_cover") && !this.floatWindow.isWindowShow()) {
            Bitmap renderingBitmap = getSharedPlayer().getRenderingBitmap();
            if (renderingBitmap != null && Build.VERSION.SDK_INT >= 23) {
                this.videoContainer.setBackground(new CenterCropDrawable(new BitmapDrawable(renderingBitmap)));
                this.videoContainer.postDelayed(new FloatWindowBridge$onAction$1(this), 1000);
            }
            if (!this.floatWindow.isWindowShow()) {
                this.floatWindow.show(null);
            }
        }
    }
}
