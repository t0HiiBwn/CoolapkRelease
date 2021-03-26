package com.coolapk.market.view.feedv8;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$playShowAnimation$4 implements View.OnTouchListener {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$playShowAnimation$4(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            FeedEntranceV8Activity feedEntranceV8Activity = this.this$0;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            feedEntranceV8Activity.zoomBig(view, 1.1f);
            return false;
        } else if (action != 1 && action != 3) {
            return false;
        } else {
            FeedEntranceV8Activity feedEntranceV8Activity2 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            feedEntranceV8Activity2.zoomSmall(view);
            return false;
        }
    }
}
