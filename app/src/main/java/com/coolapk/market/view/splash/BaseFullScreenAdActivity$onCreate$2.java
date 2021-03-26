package com.coolapk.market.view.splash;

import android.view.View;
import com.coolapk.market.view.ad.OnAdEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/splash/BaseFullScreenAdActivity$onCreate$2", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "onAdClick", "", "view", "Landroid/view/View;", "data", "", "onAdShow", "shouldGoMainActivity", "message", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFullScreenAdActivity.kt */
public final class BaseFullScreenAdActivity$onCreate$2 extends OnAdEventListener {
    final /* synthetic */ BaseFullScreenAdActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFullScreenAdActivity$onCreate$2(BaseFullScreenAdActivity baseFullScreenAdActivity) {
        this.this$0 = baseFullScreenAdActivity;
    }

    @Override // com.coolapk.market.view.ad.OnAdEventListener
    public void onAdClick(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        FullScreenAdUtils.INSTANCE.logFile("点击广告");
    }

    @Override // com.coolapk.market.view.ad.OnAdEventListener
    public void onAdShow(Object obj) {
        FullScreenAdUtils.INSTANCE.logFile("展示广告");
        if (!this.this$0.isDisplayOnly()) {
            BaseFullScreenAdActivity.access$getBinding$p(this.this$0).skipButton.setNumber(Integer.valueOf((int) 5));
            CountdownView countdownView = BaseFullScreenAdActivity.access$getBinding$p(this.this$0).skipButton;
            Intrinsics.checkNotNullExpressionValue(countdownView, "binding.skipButton");
            countdownView.setVisibility(0);
            CountdownView countdownView2 = BaseFullScreenAdActivity.access$getBinding$p(this.this$0).skipButton;
            Intrinsics.checkNotNullExpressionValue(countdownView2, "binding.skipButton");
            countdownView2.setAlpha(1.0f);
            this.this$0.startCountdownIfAdShow();
        }
    }

    @Override // com.coolapk.market.view.ad.OnAdEventListener
    public void shouldGoMainActivity(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        FullScreenAdUtils.INSTANCE.logFile(str);
        BaseFullScreenAdActivity.finishSplash$default(this.this$0, true, false, 2, null);
    }
}
