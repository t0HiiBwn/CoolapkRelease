package com.coolapk.market.widget.video.cover;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.VideoLoadingBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.TintHelper;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.PlayerStateGetter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\u001a\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/widget/video/cover/LoadingCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup$OnGroupValueUpdateListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/coolapk/market/databinding/VideoLoadingBinding;", "handler", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "hideFrameContent", "", "setCoverVisibilityRunnable", "Ljava/lang/Runnable;", "filterKeys", "", "", "()[Ljava/lang/String;", "getCoverLevel", "", "isInPlaybackState", "playerStateGetter", "Lcom/kk/taurus/playerbase/receiver/PlayerStateGetter;", "onCoverAttachedToWindow", "", "onCreateCoverView", "Landroid/view/View;", "onErrorEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onReceiverBind", "onReceiverEvent", "onReceiverUnBind", "onValueUpdate", "key", "value", "", "setLoadingState", "show", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoadingCover.kt */
public final class LoadingCover extends ThemeableCover implements IReceiverGroup.OnGroupValueUpdateListener {
    private VideoLoadingBinding binding;
    private final Handler handler = AppHolder.getMainThreadHandler();
    private boolean hideFrameContent;
    private final Runnable setCoverVisibilityRunnable = new LoadingCover$setCoverVisibilityRunnable$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        getGroupValue().registerOnGroupValueUpdateListener(this);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        getGroupValue().unregisterOnGroupValueUpdateListener(this);
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public String[] filterKeys() {
        return new String[]{"hide_frame_content", "apply_windows_insets"};
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public void onValueUpdate(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        int hashCode = str.hashCode();
        if (hashCode != -488065757) {
            if (hashCode == 2051873642 && str.equals("hide_frame_content")) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.hideFrameContent = ((Boolean) obj).booleanValue();
                setLoadingState(getGroupValue().getBoolean("loading_show"));
            }
        } else if (str.equals("apply_windows_insets")) {
            if (!(obj instanceof Rect)) {
                obj = null;
            }
            Rect rect = (Rect) obj;
            if (rect == null) {
                rect = new Rect();
            }
            View view = getView();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
            if (marginParams != null) {
                marginParams.topMargin = rect.top;
            }
            getView().requestLayout();
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        setLoadingState(getGroupValue().getBoolean("loading_show", false));
        PlayerStateGetter playerStateGetter = getPlayerStateGetter();
        if (playerStateGetter != null && isInPlaybackState(playerStateGetter)) {
            setLoadingState(playerStateGetter.isBuffering());
        }
        if (getGroupValue().getBoolean("error_show", false)) {
            setLoadingState(false);
        }
        View view = getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
        if (marginParams != null) {
            marginParams.topMargin = 0;
        }
    }

    private final boolean isInPlaybackState(PlayerStateGetter playerStateGetter) {
        int state = playerStateGetter.getState();
        return (state == -2 || state == -1 || state == 0 || state == 1 || state == 5) ? false : true;
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        switch (i) {
            case -99052:
            case -99016:
            case -99015:
            case -99014:
            case -99011:
            case -99008:
            case -99007:
            case -99005:
                setLoadingState(false);
                return;
            case -99050:
            case -99013:
            case -99010:
            case -99001:
                setLoadingState(true);
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverEvent(int i, Bundle bundle) {
        if (i == -111) {
            setLoadingState(false);
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onErrorEvent(int i, Bundle bundle) {
        setLoadingState(false);
    }

    private final void setLoadingState(boolean z) {
        if (getGroupValue().getBoolean("loading_show") != z) {
            getGroupValue().putBoolean("loading_show", z);
        }
        this.handler.removeCallbacks(this.setCoverVisibilityRunnable);
        this.handler.postDelayed(this.setCoverVisibilityRunnable, 100);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559304, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…deo_loading, null, false)");
        VideoLoadingBinding videoLoadingBinding = (VideoLoadingBinding) inflate;
        this.binding = videoLoadingBinding;
        if (videoLoadingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(videoLoadingBinding.loadingView, -1, false);
        VideoLoadingBinding videoLoadingBinding2 = this.binding;
        if (videoLoadingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoLoadingBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelMedium(1);
    }
}
