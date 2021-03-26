package com.coolapk.market.view.feedv8;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/FeedEntranceV8Activity$playShowAnimation$6", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "lastView", "Landroid/view/View;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
public final class FeedEntranceV8Activity$playShowAnimation$6 extends RecyclerView.SimpleOnItemTouchListener {
    private View lastView;
    final /* synthetic */ FeedEntranceV8Activity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedEntranceV8Activity$playShowAnimation$6(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View view;
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                Intrinsics.checkNotNullExpressionValue(findChildViewUnder, "rv.findChildViewUnder(ev… event.y) ?: return false");
                FeedEntranceV8Activity.zoomBig$default(this.this$0, findChildViewUnder, 0.0f, 2, null);
                this.lastView = findChildViewUnder;
            }
        } else if ((action != 1 && action != 3) || (view = this.lastView) == null) {
            return false;
        } else {
            this.this$0.zoomSmall(view);
            this.lastView = null;
        }
        return false;
    }
}
