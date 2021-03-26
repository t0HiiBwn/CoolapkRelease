package com.coolapk.market.view.live;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/live/LiveAppBarBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "()V", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "disableTouchEvent", "", "getDisableTouchEvent", "()Z", "setDisableTouchEvent", "(Z)V", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "Lcom/google/android/material/appbar/AppBarLayout;", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveAppBarBehavior.kt */
public final class LiveAppBarBehavior extends AppBarLayout.Behavior {
    private boolean disableTouchEvent = true;

    public final boolean getDisableTouchEvent() {
        return this.disableTouchEvent;
    }

    public final void setDisableTouchEvent(boolean z) {
        this.disableTouchEvent = z;
    }

    public LiveAppBarBehavior() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveAppBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(appBarLayout, "child");
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (this.disableTouchEvent) {
            return false;
        }
        return super.onTouchEvent(coordinatorLayout, (CoordinatorLayout) appBarLayout, motionEvent);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(appBarLayout, "child");
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (this.disableTouchEvent) {
            return false;
        }
        return super.onInterceptTouchEvent(coordinatorLayout, (CoordinatorLayout) appBarLayout, motionEvent);
    }
}
