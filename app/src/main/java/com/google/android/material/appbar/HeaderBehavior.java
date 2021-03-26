package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId = -1;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop = -1;
    private VelocityTracker velocityTracker;

    boolean canDragView(V v) {
        return false;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
    }

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i = this.activePointerId;
            if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.isBeingDragged = z;
            if (z) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker2;
        VelocityTracker velocityTracker3;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.lastMotionY = y;
                scroll(coordinatorLayout, v, this.lastMotionY - y, getMaxDragOffset(v), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.activePointerId = motionEvent.getPointerId(i);
                    this.lastMotionY = (int) (motionEvent.getY(i) + 0.5f);
                }
            }
            z = false;
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.isBeingDragged && !z) {
                return false;
            }
        }
        VelocityTracker velocityTracker4 = this.velocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEvent);
            this.velocityTracker.computeCurrentVelocity(1000);
            fling(coordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.velocityTracker.getYVelocity(this.activePointerId));
            z = true;
            this.isBeingDragged = false;
            this.activePointerId = -1;
            velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.velocityTracker = null;
            }
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
            }
            return !this.isBeingDragged ? true : true;
        }
        z = false;
        this.isBeingDragged = false;
        this.activePointerId = -1;
        velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
        }
        velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
        }
        if (!this.isBeingDragged) {
        }
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (clamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new OverScroller(v.getContext());
        }
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (this.scroller.computeScrollOffset()) {
            FlingRunnable flingRunnable2 = new FlingRunnable(coordinatorLayout, v);
            this.flingRunnable = flingRunnable2;
            ViewCompat.postOnAnimation(v, flingRunnable2);
            return true;
        }
        onFlingFinished(coordinatorLayout, v);
        return false;
    }

    int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    private class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.google.android.material.appbar.HeaderBehavior */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.google.android.material.appbar.HeaderBehavior */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.layout != null && HeaderBehavior.this.scroller != null) {
                if (HeaderBehavior.this.scroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    ViewCompat.postOnAnimation(this.layout, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
            }
        }
    }
}
