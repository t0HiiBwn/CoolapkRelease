package com.coolapk.market.view.splash;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFullScreenAdActivity.kt */
final class BaseFullScreenAdActivity$finishSplash$1 implements Runnable {
    final /* synthetic */ BaseFullScreenAdActivity this$0;

    BaseFullScreenAdActivity$finishSplash$1(BaseFullScreenAdActivity baseFullScreenAdActivity) {
        this.this$0 = baseFullScreenAdActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseFullScreenAdActivity.access$finishSplashInternal(this.this$0, true);
    }
}
