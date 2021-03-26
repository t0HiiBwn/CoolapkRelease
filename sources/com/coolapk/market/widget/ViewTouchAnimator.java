package com.coolapk.market.widget;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/ViewTouchAnimator;", "Landroid/view/View$OnTouchListener;", "()V", "onPressDown", "", "v", "Landroid/view/View;", "onRaiseUp", "onTouch", "", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewTouchAnimator.kt */
public abstract class ViewTouchAnimator implements View.OnTouchListener {
    public abstract void onPressDown(View view);

    public abstract void onRaiseUp(View view);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            onPressDown(view);
            return false;
        } else if (action != 1 && action != 3) {
            return false;
        } else {
            onRaiseUp(view);
            return false;
        }
    }
}
