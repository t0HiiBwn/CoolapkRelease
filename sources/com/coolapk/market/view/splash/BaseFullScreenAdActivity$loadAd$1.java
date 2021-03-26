package com.coolapk.market.view.splash;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.coolapk.market.view.ad.AdSource;
import com.coolapk.market.view.ad.OnAdLoadListener;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/splash/BaseFullScreenAdActivity$loadAd$1", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "onLoadError", "", "e", "", "onLoadSuccess", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFullScreenAdActivity.kt */
public final class BaseFullScreenAdActivity$loadAd$1 implements OnAdLoadListener {
    final /* synthetic */ BaseFullScreenAdActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFullScreenAdActivity$loadAd$1(BaseFullScreenAdActivity baseFullScreenAdActivity) {
        this.this$0 = baseFullScreenAdActivity;
    }

    @Override // com.coolapk.market.view.ad.OnAdLoadListener
    public void onLoadSuccess(Object obj) {
        Integer second;
        Integer first;
        FullScreenAdUtils.INSTANCE.logFile("广告加载成功");
        View splashView = BaseFullScreenAdActivity.access$getAdSource$p(this.this$0).getSplashView();
        AdSource access$getAdSource$p = BaseFullScreenAdActivity.access$getAdSource$p(this.this$0);
        ViewGroup viewGroup = (ViewGroup) (!(splashView instanceof ViewGroup) ? null : splashView);
        if (viewGroup == null) {
            Window window = this.this$0.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            View decorView = window.getDecorView();
            Objects.requireNonNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewGroup = (ViewGroup) decorView;
        }
        Pair<Integer, Integer> splashSize = access$getAdSource$p.getSplashSize(viewGroup);
        int calculateBottomHeight = FullScreenAdUtils.INSTANCE.calculateBottomHeight(this.this$0, Intrinsics.areEqual(BaseFullScreenAdActivity.access$getAdSource$p(this.this$0).getName(), "COOLAPK_SPLASH"), (splashSize == null || (first = splashSize.getFirst()) == null) ? 1080 : first.intValue(), (splashSize == null || (second = splashSize.getSecond()) == null) ? 1920 : second.intValue());
        if (calculateBottomHeight > 0) {
            FrameLayout frameLayout = BaseFullScreenAdActivity.access$getBinding$p(this.this$0).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomContainer");
            frameLayout.setVisibility(0);
            BaseFullScreenAdActivity.access$animLogoCenterIfNeed(this.this$0, calculateBottomHeight);
        } else {
            FrameLayout frameLayout2 = BaseFullScreenAdActivity.access$getBinding$p(this.this$0).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.bottomContainer");
            frameLayout2.setVisibility(8);
        }
        if (splashView != null) {
            FrameLayout frameLayout3 = BaseFullScreenAdActivity.access$getBinding$p(this.this$0).adContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.adContainer");
            if (frameLayout3.getChildCount() > 0) {
                BaseFullScreenAdActivity.access$getBinding$p(this.this$0).adContainer.removeAllViews();
            }
            BaseFullScreenAdActivity.access$getBinding$p(this.this$0).adContainer.addView(splashView);
        }
        BaseFullScreenAdActivity.access$markAdLastShowTimestamp(this.this$0);
    }

    @Override // com.coolapk.market.view.ad.OnAdLoadListener
    public void onLoadError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        FullScreenAdUtils.INSTANCE.logFile(th);
        BaseFullScreenAdActivity.access$markAdLastShowTimestamp(this.this$0);
        BaseFullScreenAdActivity.access$markAdErrorTimestamp(this.this$0, th);
        BaseFullScreenAdActivity.access$finishSplash(this.this$0, false, true);
    }
}
