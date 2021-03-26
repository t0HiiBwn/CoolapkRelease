package com.coolapk.market.viewholder;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: WebViewCardViewHolder.kt */
final class WebViewCardViewHolder$enterFullScreen$exitFullScreenAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseActivity $activity;
    final /* synthetic */ ObjectAnimator $animator;
    final /* synthetic */ FrameLayout $frameView;
    final /* synthetic */ int $originOrientation;
    final /* synthetic */ int $systemUiVisibility;
    final /* synthetic */ FrameLayout $webViewContainer;
    final /* synthetic */ WebViewCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewCardViewHolder$enterFullScreen$exitFullScreenAction$1(WebViewCardViewHolder webViewCardViewHolder, ObjectAnimator objectAnimator, FrameLayout frameLayout, FrameLayout frameLayout2, BaseActivity baseActivity, int i, int i2) {
        super(0);
        this.this$0 = webViewCardViewHolder;
        this.$animator = objectAnimator;
        this.$frameView = frameLayout;
        this.$webViewContainer = frameLayout2;
        this.$activity = baseActivity;
        this.$originOrientation = i;
        this.$systemUiVisibility = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$animator.cancel();
        ViewExtendsKt.detachFromParent(this.$frameView);
        ViewExtendsKt.detachFromParent(this.$webViewContainer);
        boolean z = true;
        this.$activity.setSlidrEnable(true);
        FrameLayout frameLayout = this.this$0.getBinding().webViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.webViewContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        FrameLayout frameLayout2 = this.this$0.getBinding().holderView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.holderView");
        layoutParams.height = frameLayout2.getLayoutParams().height;
        this.this$0.getBinding().holderView.addView(this.this$0.getBinding().webViewContainer);
        this.$activity.setRequestedOrientation(this.$originOrientation);
        this.$activity.getWindow().clearFlags(1024);
        Window window = this.$activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        decorView.setSystemUiVisibility(this.$systemUiVisibility);
        this.$activity.setOnBackPressListener(null);
        ImageView imageView = this.this$0.getBinding().fullScreenButtom;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.fullScreenButtom");
        imageView.setKeepScreenOn(false);
        this.this$0.getBinding().fullScreenButtom.setOnClickListener(this.this$0);
        this.this$0.getBinding().fullScreenButtom.setImageResource(2131230845);
        ImageView imageView2 = this.this$0.getBinding().fullScreenButtom;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.fullScreenButtom");
        imageView2.setAlpha(0.5f);
        if (EntityExtendsKt.getIntExtraData(WebViewCardViewHolder.access$getCard$p(this.this$0), "fixTop", 0) != 1) {
            z = false;
        }
        if (z) {
            EntityListFixTopHelper topHelper = this.this$0.getTopHelper();
            FrameLayout frameLayout3 = this.this$0.getBinding().webViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.webViewContainer");
            FrameLayout frameLayout4 = this.this$0.getBinding().holderView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.holderView");
            topHelper.setFixTopView(frameLayout3, frameLayout4, WebViewCardViewHolder.access$getCard$p(this.this$0));
        }
    }
}
