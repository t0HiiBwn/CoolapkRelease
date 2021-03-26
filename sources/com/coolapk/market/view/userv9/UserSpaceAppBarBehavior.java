package com.coolapk.market.view.userv9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coolapk.market.AppHolder;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J@\u0010(\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0016JP\u0010/\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0016J(\u00104\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020\bH\u0016J \u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u00108\u001a\u000209H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activePointerId", "", "callback", "Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior$Callback;", "getCallback", "()Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior$Callback;", "setCallback", "(Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior$Callback;)V", "compatWithRefresh", "", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "isAboutToFling", "isBeingDragged", "isTouching", "()Z", "setTouching", "(Z)V", "lastMotionY", "lastPreConsumedDy", "touchSlop", "onNestedPreFling", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "Lcom/google/android/material/appbar/AppBarLayout;", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedPreScroll", "", "dx", "dy", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStopNestedScroll", "abl", "onTouchEvent", "parent", "ev", "Landroid/view/MotionEvent;", "Callback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceAppBarBehavior.kt */
public final class UserSpaceAppBarBehavior extends AppBarLayout.Behavior {
    private int activePointerId;
    private Callback callback;
    private final boolean compatWithRefresh;
    private final GestureDetector gestureDetector;
    private boolean isAboutToFling;
    private boolean isBeingDragged;
    private boolean isTouching;
    private int lastMotionY;
    private int lastPreConsumedDy;
    private int touchSlop = -1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior$Callback;", "", "hasPullDownOffset", "", "onOverScrollDown", "", "dyUnconsumed", "", "onPreScroll", "dy", "onSingleTap", "onStopScroll", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserSpaceAppBarBehavior.kt */
    public interface Callback {
        boolean hasPullDownOffset();

        void onOverScrollDown(int i);

        int onPreScroll(int i);

        void onSingleTap();

        void onStopScroll();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserSpaceAppBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureDetector = new GestureDetector(context, new UserSpaceAppBarBehavior$gestureDetector$1(this));
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final boolean isTouching() {
        return this.isTouching;
    }

    public final void setTouching(boolean z) {
        this.isTouching = z;
    }

    public final GestureDetector getGestureDetector() {
        return this.gestureDetector;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r2 != 3) goto L_0x00d2;
     */
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        int i;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "parent");
        Intrinsics.checkNotNullParameter(appBarLayout, "child");
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (this.touchSlop == 0) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(AppHolder.getApplication());
            Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(AppHolder.getApplication())");
            this.touchSlop = viewConfiguration.getScaledTouchSlop();
        }
        this.gestureDetector.onTouchEvent(motionEvent);
        int bottom = appBarLayout.getBottom();
        Boolean bool = null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.lastMotionY - y;
                    if (!this.isBeingDragged && Math.abs(i2) > (i = this.touchSlop)) {
                        this.isBeingDragged = true;
                        i2 = i2 > 0 ? i2 - i : i2 + i;
                    }
                    if (this.isBeingDragged) {
                        this.lastMotionY = y;
                        Callback callback2 = this.callback;
                        if (callback2 == null || !callback2.hasPullDownOffset()) {
                            Boolean valueOf = Boolean.valueOf(super.onTouchEvent(coordinatorLayout, (CoordinatorLayout) appBarLayout, motionEvent));
                            if (appBarLayout.getBottom() == bottom) {
                                int i3 = -i2;
                                if (callback2 != null && i3 > 0) {
                                    callback2.onOverScrollDown(i3);
                                }
                            }
                            bool = valueOf;
                        } else {
                            callback2.onPreScroll(i2);
                            bool = true;
                        }
                    }
                }
            }
            bool = Boolean.valueOf(super.onTouchEvent(coordinatorLayout, (CoordinatorLayout) appBarLayout, motionEvent));
            Callback callback3 = this.callback;
            if (callback3 != null) {
                callback3.onStopScroll();
            }
            this.isBeingDragged = false;
            this.lastMotionY = 0;
            this.activePointerId = 0;
        } else {
            motionEvent.getX();
            bool = Boolean.valueOf(super.onTouchEvent(coordinatorLayout, (CoordinatorLayout) appBarLayout, motionEvent));
            this.lastMotionY = (int) motionEvent.getY();
            this.activePointerId = motionEvent.getPointerId(0);
        }
        if (bool == null) {
            bool = Boolean.valueOf(super.onTouchEvent(coordinatorLayout, (CoordinatorLayout) appBarLayout, motionEvent));
        }
        return bool.booleanValue();
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(appBarLayout, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        Callback callback2 = this.callback;
        int i4 = 0;
        if (callback2 != null) {
            boolean z = !this.isTouching;
            this.isAboutToFling = z;
            if (!z || callback2.hasPullDownOffset()) {
                i4 = callback2.onPreScroll(i2);
                this.lastPreConsumedDy = i4;
            }
        }
        if (this.compatWithRefresh) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
            return;
        }
        iArr[1] = i4;
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2 - i4, iArr, i3);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(appBarLayout, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        int bottom = appBarLayout.getBottom();
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        if (this.compatWithRefresh) {
            i4 -= this.lastPreConsumedDy;
        }
        Callback callback2 = this.callback;
        if (i4 < 0 && callback2 != null && !this.isAboutToFling) {
            int abs = Math.abs(i4) - (appBarLayout.getBottom() - bottom);
            if (callback2.hasPullDownOffset() || abs >= this.touchSlop) {
                callback2.onOverScrollDown(abs);
            }
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(appBarLayout, "abl");
        Intrinsics.checkNotNullParameter(view, "target");
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onStopScroll();
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(appBarLayout, "child");
        Intrinsics.checkNotNullParameter(view, "target");
        Callback callback2 = this.callback;
        if (callback2 == null || !callback2.hasPullDownOffset()) {
            return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
        }
        return true;
    }
}
