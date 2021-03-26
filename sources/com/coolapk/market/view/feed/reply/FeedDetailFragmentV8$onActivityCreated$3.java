package com.coolapk.market.view.feed.reply;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"com/coolapk/market/view/feed/reply/FeedDetailFragmentV8$onActivityCreated$3", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "didMove", "", "getDidMove", "()Z", "setDidMove", "(Z)V", "needIntercept", "getNeedIntercept", "setNeedIntercept", "startX", "", "getStartX", "()F", "setStartX", "(F)V", "startY", "getStartY", "setStartY", "touchSlop", "", "getTouchSlop", "()I", "onInterceptTouchEvent", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailFragmentV8.kt */
public final class FeedDetailFragmentV8$onActivityCreated$3 extends RecyclerView.SimpleOnItemTouchListener {
    private boolean didMove;
    private boolean needIntercept = true;
    private float startX;
    private float startY;
    final /* synthetic */ FeedDetailFragmentV8 this$0;
    private final int touchSlop;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedDetailFragmentV8$onActivityCreated$3(FeedDetailFragmentV8 feedDetailFragmentV8) {
        this.this$0 = feedDetailFragmentV8;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(feedDetailFragmentV8.getActivity());
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(activity)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public final boolean getNeedIntercept() {
        return this.needIntercept;
    }

    public final void setNeedIntercept(boolean z) {
        this.needIntercept = z;
    }

    public final float getStartX() {
        return this.startX;
    }

    public final void setStartX(float f) {
        this.startX = f;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final void setStartY(float f) {
        this.startY = f;
    }

    public final boolean getDidMove() {
        return this.didMove;
    }

    public final void setDidMove(boolean z) {
        this.didMove = z;
    }

    public final int getTouchSlop() {
        return this.touchSlop;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
            this.needIntercept = true;
            this.didMove = false;
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                this.didMove = true;
                if (this.needIntercept && (Math.abs(motionEvent.getX() - this.startX) > ((float) this.touchSlop) || Math.abs(motionEvent.getY() - this.startY) > ((float) this.touchSlop))) {
                    this.needIntercept = false;
                }
            }
        } else if (this.needIntercept || !this.didMove) {
            return true;
        }
        return false;
    }
}
