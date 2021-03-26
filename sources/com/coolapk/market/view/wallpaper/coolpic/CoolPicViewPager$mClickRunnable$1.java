package com.coolapk.market.view.wallpaper.coolpic;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicViewPager.kt */
final class CoolPicViewPager$mClickRunnable$1 implements Runnable {
    final /* synthetic */ CoolPicViewPager this$0;

    CoolPicViewPager$mClickRunnable$1(CoolPicViewPager coolPicViewPager) {
        this.this$0 = coolPicViewPager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.mClickListener != null) {
            View.OnClickListener onClickListener = this.this$0.mClickListener;
            Intrinsics.checkNotNull(onClickListener);
            onClickListener.onClick(this.this$0);
        }
    }
}
