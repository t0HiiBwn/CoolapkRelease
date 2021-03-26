package com.coolapk.market.widget.video.cover;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: LoadingCover.kt */
final class LoadingCover$setCoverVisibilityRunnable$1 implements Runnable {
    final /* synthetic */ LoadingCover this$0;

    LoadingCover$setCoverVisibilityRunnable$1(LoadingCover loadingCover) {
        this.this$0 = loadingCover;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        boolean z = this.this$0.getGroupValue().getBoolean("loading_show", false) && !(this.this$0.hideFrameContent);
        LoadingCover loadingCover = this.this$0;
        if (!z) {
            i = 8;
        }
        loadingCover.setCoverVisibility(i);
    }
}
