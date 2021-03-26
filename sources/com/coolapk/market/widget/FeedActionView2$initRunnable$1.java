package com.coolapk.market.widget;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedActionView2.kt */
final class FeedActionView2$initRunnable$1 implements Runnable {
    final /* synthetic */ FeedActionView2 this$0;

    FeedActionView2$initRunnable$1(FeedActionView2 feedActionView2) {
        this.this$0 = feedActionView2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.holderArray.size() == 0) {
            LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
            FeedActionView2 feedActionView2 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(from, "inflater");
            feedActionView2.addView(feedActionView2.newItemView(from, FeedActionView2.Companion.getLIKE()));
            FeedActionView2 feedActionView22 = this.this$0;
            feedActionView22.addView(feedActionView22.newItemView(from, FeedActionView2.Companion.getREPLY()));
            if (!(this.this$0.isSimple)) {
                FeedActionView2 feedActionView23 = this.this$0;
                feedActionView23.addView(feedActionView23.newItemView(from, FeedActionView2.Companion.getSHARE()));
            }
        }
        if (this.this$0.feed != null) {
            FeedActionView2 feedActionView24 = this.this$0;
            feedActionView24.updateFeed(feedActionView24.feed);
        }
    }
}
