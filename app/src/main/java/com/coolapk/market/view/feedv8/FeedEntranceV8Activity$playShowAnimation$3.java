package com.coolapk.market.view.feedv8;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$playShowAnimation$3 implements Runnable {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$playShowAnimation$3(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout frameLayout = FeedEntranceV8Activity.access$getBinding$p(this.this$0).itemView1;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.itemView1");
        long j = (long) 300;
        long j2 = (long) 30;
        ViewExtendsKt.showShakingAnimation(frameLayout, j, 0 * j2);
        FrameLayout frameLayout2 = FeedEntranceV8Activity.access$getBinding$p(this.this$0).itemView2;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.itemView2");
        ViewExtendsKt.showShakingAnimation(frameLayout2, j, 1 * j2);
        RecyclerView recyclerView = FeedEntranceV8Activity.access$getBinding$p(this.this$0).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = FeedEntranceV8Activity.access$getBinding$p(this.this$0).recyclerView.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "v");
            ViewExtendsKt.showShakingAnimation(childAt, j, ((long) (i + 2)) * j2);
        }
    }
}
