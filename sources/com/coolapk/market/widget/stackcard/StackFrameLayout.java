package com.coolapk.market.widget.stackcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/widget/stackcard/StackFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMove", "Lkotlin/Function0;", "", "getOnMove", "()Lkotlin/jvm/functions/Function0;", "setOnMove", "(Lkotlin/jvm/functions/Function0;)V", "startX", "", "startY", "touchSlop", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StackFrameLayout.kt */
public final class StackFrameLayout extends FrameLayout {
    private Function0<Boolean> onMove;
    private float startX;
    private float startY;
    private int touchSlop;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StackFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public final Function0<Boolean> getOnMove() {
        return this.onMove;
    }

    public final void setOnMove(Function0<Boolean> function0) {
        this.onMove = function0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Boolean invoke;
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0) {
            this.startX = motionEvent.getRawX();
            this.startY = motionEvent.getRawY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getActionMasked() == 2) {
            if (Math.max(Math.abs(motionEvent.getRawX() - this.startX), Math.abs(motionEvent.getRawY() - this.startY)) >= ((float) this.touchSlop)) {
                boolean z = false;
                getParent().requestDisallowInterceptTouchEvent(false);
                Function0<Boolean> function0 = this.onMove;
                if (!(function0 == null || (invoke = function0.invoke()) == null)) {
                    z = invoke.booleanValue();
                }
                if (!z) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
