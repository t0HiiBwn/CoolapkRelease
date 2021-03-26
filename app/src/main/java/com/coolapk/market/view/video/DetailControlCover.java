package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemEntityVideoDetailViewPartBinding;
import com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBinding;
import com.coolapk.market.databinding.ItemVideoDetailViewPartBinding;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.video.cover.BaseControlCover;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001aJ\b\u00106\u001a\u000207H\u0014J\u0010\u00108\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u00109\u001a\u000207H\u0016J\u001a\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016R\u000e\u0010\u001b\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$¨\u0006@"}, d2 = {"Lcom/coolapk/market/view/video/DetailControlCover;", "Lcom/coolapk/market/widget/video/cover/BaseControlCover;", "context", "Landroid/content/Context;", "topContainer", "Landroid/view/ViewGroup;", "bottomContainer", "seekBar", "Landroid/widget/SeekBar;", "progressBar", "Landroid/widget/ProgressBar;", "playView", "Landroid/widget/ImageView;", "fullScreenView", "currentTimeView", "Landroid/widget/TextView;", "liveViewContainer", "Landroid/view/View;", "replayView", "totalTimeView", "navigationView", "refreshView", "shareView", "moreView", "pipView", "volumeView", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Landroid/widget/SeekBar;Landroid/widget/ProgressBar;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;)V", "FLAG_BOTH_DISAPPEAR", "", "FLAG_BOTH_EXIST", "getBottomContainer", "()Landroid/view/ViewGroup;", "getCurrentTimeView$presentation_coolapkAppRelease", "()Landroid/widget/TextView;", "defaultSystemUIFlag", "getFullScreenView$presentation_coolapkAppRelease", "()Landroid/widget/ImageView;", "hideSystemUIFlag", "getLiveViewContainer$presentation_coolapkAppRelease", "()Landroid/view/View;", "getMoreView$presentation_coolapkAppRelease", "getNavigationView$presentation_coolapkAppRelease", "getPipView$presentation_coolapkAppRelease", "getPlayView$presentation_coolapkAppRelease", "getProgressBar$presentation_coolapkAppRelease", "()Landroid/widget/ProgressBar;", "getRefreshView$presentation_coolapkAppRelease", "getReplayView$presentation_coolapkAppRelease", "getSeekBar$presentation_coolapkAppRelease", "()Landroid/widget/SeekBar;", "getShareView$presentation_coolapkAppRelease", "getTopContainer", "getTotalTimeView$presentation_coolapkAppRelease", "getVolumeView$presentation_coolapkAppRelease", "onCoverAttachedToWindow", "", "onCreateCoverView", "onReceiverBind", "setControllerState", "state", "", "animator", "Landroid/animation/ValueAnimator;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DetailControlCover.kt */
public final class DetailControlCover extends BaseControlCover {
    public static final Companion Companion = new Companion(null);
    private final int FLAG_BOTH_DISAPPEAR = 5894;
    private final int FLAG_BOTH_EXIST = 4102;
    private final ViewGroup bottomContainer;
    private final TextView currentTimeView;
    private int defaultSystemUIFlag;
    private final ImageView fullScreenView;
    private int hideSystemUIFlag;
    private final View liveViewContainer;
    private final View moreView;
    private final View navigationView;
    private final View pipView;
    private final ImageView playView;
    private final ProgressBar progressBar;
    private final View refreshView;
    private final View replayView;
    private final SeekBar seekBar;
    private final View shareView;
    private final ViewGroup topContainer;
    private final TextView totalTimeView;
    private final ImageView volumeView;

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ViewGroup getTopContainer() {
        return this.topContainer;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ViewGroup getBottomContainer() {
        return this.bottomContainer;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public SeekBar getSeekBar$presentation_coolapkAppRelease() {
        return this.seekBar;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ProgressBar getProgressBar$presentation_coolapkAppRelease() {
        return this.progressBar;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ImageView getPlayView$presentation_coolapkAppRelease() {
        return this.playView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ImageView getFullScreenView$presentation_coolapkAppRelease() {
        return this.fullScreenView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public TextView getCurrentTimeView$presentation_coolapkAppRelease() {
        return this.currentTimeView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getLiveViewContainer$presentation_coolapkAppRelease() {
        return this.liveViewContainer;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getReplayView$presentation_coolapkAppRelease() {
        return this.replayView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public TextView getTotalTimeView$presentation_coolapkAppRelease() {
        return this.totalTimeView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getNavigationView$presentation_coolapkAppRelease() {
        return this.navigationView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getRefreshView$presentation_coolapkAppRelease() {
        return this.refreshView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getShareView$presentation_coolapkAppRelease() {
        return this.shareView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getMoreView$presentation_coolapkAppRelease() {
        return this.moreView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public View getPipView$presentation_coolapkAppRelease() {
        return this.pipView;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public ImageView getVolumeView$presentation_coolapkAppRelease() {
        return this.volumeView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DetailControlCover(Context context, ViewGroup viewGroup, ViewGroup viewGroup2, SeekBar seekBar2, ProgressBar progressBar2, ImageView imageView, ImageView imageView2, TextView textView, View view, View view2, TextView textView2, View view3, View view4, View view5, View view6, View view7, ImageView imageView3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "topContainer");
        Intrinsics.checkNotNullParameter(viewGroup2, "bottomContainer");
        this.topContainer = viewGroup;
        this.bottomContainer = viewGroup2;
        this.seekBar = seekBar2;
        this.progressBar = progressBar2;
        this.playView = imageView;
        this.fullScreenView = imageView2;
        this.currentTimeView = textView;
        this.liveViewContainer = view;
        this.replayView = view2;
        this.totalTimeView = textView2;
        this.navigationView = view3;
        this.refreshView = view4;
        this.shareView = view5;
        this.moreView = view6;
        this.pipView = view7;
        this.volumeView = imageView3;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover, com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        this.defaultSystemUIFlag = getTopContainer().getWindowSystemUiVisibility();
        this.hideSystemUIFlag = this.FLAG_BOTH_DISAPPEAR;
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover
    public void setControllerState(boolean z, ValueAnimator valueAnimator) {
        Window window;
        View decorView;
        super.setControllerState(z, valueAnimator);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null && (window = activityNullable.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            Intrinsics.checkNotNullExpressionValue(decorView, "context.findActivity()?.…ndow?.decorView ?: return");
            if (z) {
                decorView.setSystemUiVisibility(this.defaultSystemUIFlag);
            } else {
                decorView.setSystemUiVisibility(this.hideSystemUIFlag);
            }
        }
    }

    @Override // com.coolapk.market.widget.video.cover.BaseControlCover, com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        BaseControlCover.setControllerState$default(this, false, null, 2, null);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/video/DetailControlCover$Companion;", "", "()V", "createWith", "Lcom/coolapk/market/view/video/DetailControlCover;", "binding", "Lcom/coolapk/market/databinding/ItemEntityVideoDetailViewPartBinding;", "Lcom/coolapk/market/databinding/ItemFeedVideoDetailViewPartBinding;", "Lcom/coolapk/market/databinding/ItemVideoDetailViewPartBinding;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DetailControlCover.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DetailControlCover createWith(ItemVideoDetailViewPartBinding itemVideoDetailViewPartBinding) {
            Intrinsics.checkNotNullParameter(itemVideoDetailViewPartBinding, "binding");
            View root = itemVideoDetailViewPartBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            LinearLayout linearLayout = itemVideoDetailViewPartBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            LinearLayout linearLayout2 = itemVideoDetailViewPartBinding.bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
            return new DetailControlCover(context, linearLayout, linearLayout2, itemVideoDetailViewPartBinding.seekBar, itemVideoDetailViewPartBinding.progressBar, itemVideoDetailViewPartBinding.playView, itemVideoDetailViewPartBinding.fullScreenView, itemVideoDetailViewPartBinding.currentTimeView, itemVideoDetailViewPartBinding.liveViewContainer, itemVideoDetailViewPartBinding.replayView, itemVideoDetailViewPartBinding.totalTimeView, itemVideoDetailViewPartBinding.navigationView, null, null, itemVideoDetailViewPartBinding.moreView, itemVideoDetailViewPartBinding.pipView, itemVideoDetailViewPartBinding.volumeView);
        }

        public final DetailControlCover createWith(ItemFeedVideoDetailViewPartBinding itemFeedVideoDetailViewPartBinding) {
            Intrinsics.checkNotNullParameter(itemFeedVideoDetailViewPartBinding, "binding");
            View root = itemFeedVideoDetailViewPartBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            LinearLayout linearLayout = itemFeedVideoDetailViewPartBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            LinearLayout linearLayout2 = itemFeedVideoDetailViewPartBinding.bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
            return new DetailControlCover(context, linearLayout, linearLayout2, itemFeedVideoDetailViewPartBinding.seekBar, itemFeedVideoDetailViewPartBinding.progressBar, itemFeedVideoDetailViewPartBinding.playView, itemFeedVideoDetailViewPartBinding.fullScreenView, itemFeedVideoDetailViewPartBinding.currentTimeView, itemFeedVideoDetailViewPartBinding.liveViewContainer, itemFeedVideoDetailViewPartBinding.replayView, itemFeedVideoDetailViewPartBinding.totalTimeView, itemFeedVideoDetailViewPartBinding.navigationView, null, null, itemFeedVideoDetailViewPartBinding.moreView, itemFeedVideoDetailViewPartBinding.pipView, itemFeedVideoDetailViewPartBinding.volumeView);
        }

        public final DetailControlCover createWith(ItemEntityVideoDetailViewPartBinding itemEntityVideoDetailViewPartBinding) {
            Intrinsics.checkNotNullParameter(itemEntityVideoDetailViewPartBinding, "binding");
            View root = itemEntityVideoDetailViewPartBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            LinearLayout linearLayout = itemEntityVideoDetailViewPartBinding.topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            LinearLayout linearLayout2 = itemEntityVideoDetailViewPartBinding.bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
            return new DetailControlCover(context, linearLayout, linearLayout2, itemEntityVideoDetailViewPartBinding.seekBar, itemEntityVideoDetailViewPartBinding.progressBar, itemEntityVideoDetailViewPartBinding.playView, itemEntityVideoDetailViewPartBinding.fullScreenView, itemEntityVideoDetailViewPartBinding.currentTimeView, itemEntityVideoDetailViewPartBinding.liveViewContainer, itemEntityVideoDetailViewPartBinding.replayView, itemEntityVideoDetailViewPartBinding.totalTimeView, itemEntityVideoDetailViewPartBinding.navigationView, null, null, itemEntityVideoDetailViewPartBinding.moreView, itemEntityVideoDetailViewPartBinding.pipView, itemEntityVideoDetailViewPartBinding.volumeView);
        }
    }
}
