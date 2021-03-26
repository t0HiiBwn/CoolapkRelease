package com.coolapk.market.widget.touchhelper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ItemSlideHelper implements RecyclerView.OnItemTouchListener, GestureDetector.OnGestureListener {
    private final int DEFAULT_DURATION = 200;
    private final Callback mCallback;
    private Animator mExpandAndCollapseAnim;
    private final GestureDetectorCompat mGestureDetector;
    private boolean mIsDragging;
    private int mLastX;
    private int mLastY;
    private final int mMaxVelocity;
    private final int mMinVelocity;
    private View mTargetView;
    private final int mTouchSlop;

    public interface Callback {
        View findTargetView(float f, float f2);

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int getHorizontalRange(RecyclerView.ViewHolder viewHolder);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public ItemSlideHelper(Context context, Callback callback) {
        this.mCallback = callback;
        this.mGestureDetector = new GestureDetectorCompat(context, this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r0 != 3) goto L_0x009a;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z = false;
        if (recyclerView.getScrollState() != 0) {
            if (this.mTargetView != null) {
                smoothHorizontalExpandOrCollapse(100.0f);
                this.mTargetView = null;
            }
            return false;
        }
        Animator animator = this.mExpandAndCollapseAnim;
        if (animator != null && animator.isRunning()) {
            return true;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = x - this.mLastX;
                    if (Math.abs(y - this.mLastY) > Math.abs(i)) {
                        return false;
                    }
                    if (this.mTargetView != null && Math.abs(i) >= this.mTouchSlop) {
                        z = true;
                    }
                    this.mIsDragging = z;
                }
            }
            if (isExpanded() && !inView(x, y)) {
                smoothHorizontalExpandOrCollapse(100.0f);
                z = true;
            }
            this.mTargetView = null;
        } else {
            MotionEventCompat.getPointerId(motionEvent, 0);
            this.mLastX = (int) motionEvent.getX();
            this.mLastY = (int) motionEvent.getY();
            if (this.mTargetView == null) {
                this.mTargetView = this.mCallback.findTargetView((float) x, (float) y);
            } else if (inView(x, y)) {
                return false;
            } else {
                smoothHorizontalExpandOrCollapse(1.0f);
                return true;
            }
        }
        return z;
    }

    private boolean isExpanded() {
        View view = this.mTargetView;
        return view != null && view.getScrollX() == getHorizontalRange();
    }

    /* access modifiers changed from: private */
    public boolean isCollapsed() {
        View view = this.mTargetView;
        return view != null && view.getScrollX() == 0;
    }

    private boolean inView(int i, int i2) {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        int scrollX = view.getScrollX();
        return new Rect(this.mTargetView.getLeft() + scrollX, this.mTargetView.getTop(), this.mTargetView.getRight() + scrollX, this.mTargetView.getBottom()).contains(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Animator animator = this.mExpandAndCollapseAnim;
        if ((animator != null && animator.isRunning()) || this.mTargetView == null) {
            return;
        }
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            this.mIsDragging = false;
            return;
        }
        int x = (int) motionEvent.getX();
        motionEvent.getY();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int x2 = (int) (((float) this.mLastX) - motionEvent.getX());
                if (this.mIsDragging) {
                    horizontalDrag(x2);
                }
                this.mLastX = x;
                return;
            } else if (actionMasked != 3) {
                return;
            }
        }
        if (this.mIsDragging) {
            if (!smoothHorizontalExpandOrCollapse(0.0f) && isCollapsed()) {
                this.mTargetView = null;
            }
            this.mIsDragging = false;
        }
    }

    private void horizontalDrag(int i) {
        int scrollX = this.mTargetView.getScrollX();
        int scrollY = this.mTargetView.getScrollY();
        int i2 = scrollX + i;
        if (i2 <= 0) {
            this.mTargetView.scrollTo(0, scrollY);
            return;
        }
        int horizontalRange = getHorizontalRange();
        if (Math.abs(i2) < horizontalRange) {
            this.mTargetView.scrollTo(i2, scrollY);
        } else {
            this.mTargetView.scrollTo(horizontalRange, scrollY);
        }
    }

    private boolean smoothHorizontalExpandOrCollapse(float f) {
        int scrollX = this.mTargetView.getScrollX();
        int horizontalRange = getHorizontalRange();
        if (this.mExpandAndCollapseAnim != null) {
            return false;
        }
        int i = 200;
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i2 != 0) {
            if (i2 > 0) {
                horizontalRange = 0;
            }
            i = (int) ((1.0f - (Math.abs(f) / ((float) this.mMaxVelocity))) * 200.0f);
        } else if (scrollX <= horizontalRange / 2) {
            horizontalRange = 0;
        }
        if (horizontalRange == scrollX) {
            return false;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mTargetView, "scrollX", horizontalRange);
        this.mExpandAndCollapseAnim = ofInt;
        ofInt.setDuration((long) i);
        this.mExpandAndCollapseAnim.addListener(new Animator.AnimatorListener() {
            /* class com.coolapk.market.widget.touchhelper.ItemSlideHelper.AnonymousClass1 */

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ItemSlideHelper.this.mExpandAndCollapseAnim = null;
                if (ItemSlideHelper.this.isCollapsed()) {
                    ItemSlideHelper.this.mTargetView = null;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ItemSlideHelper.this.mExpandAndCollapseAnim = null;
            }
        });
        this.mExpandAndCollapseAnim.start();
        return true;
    }

    public int getHorizontalRange() {
        return this.mCallback.getHorizontalRange(this.mCallback.getChildViewHolder(this.mTargetView));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f) <= ((float) this.mMinVelocity) || Math.abs(f) >= ((float) this.mMaxVelocity) || smoothHorizontalExpandOrCollapse(f)) {
            return false;
        }
        if (!isCollapsed()) {
            return true;
        }
        this.mTargetView = null;
        return true;
    }
}
