package com.coolapk.market.widget.touchhelper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ItemSwipeHelper implements RecyclerView.OnItemTouchListener, GestureDetector.OnGestureListener {
    private Animator mAnimator;
    private final Callback mCallback;
    private final GestureDetectorCompat mGestureDetector;
    private boolean mIsDragging;
    private float mLastX;
    private float mLastY;
    private final int mMaxVelocity;
    private final int mMinVelocity;
    private View mTargetView;
    private final int mTouchSlop;

    public interface Callback {
        boolean canSwipe(View view);

        void onDismiss(View view);
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

    public ItemSwipeHelper(Context context, Callback callback) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mCallback = callback;
        this.mGestureDetector = new GestureDetectorCompat(context, this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r0 != 3) goto L_0x008c;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Animator animator = this.mAnimator;
        boolean z = false;
        if (animator != null && animator.isRunning()) {
            return false;
        }
        if (recyclerView.getScrollState() != 0) {
            if (this.mTargetView != null) {
                this.mTargetView = null;
            }
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float f = x - this.mLastX;
                    if (Math.abs(y - this.mLastY) > Math.abs(f) || f > 0.0f) {
                        return false;
                    }
                    View view = this.mTargetView;
                    if (view != null && !this.mCallback.canSwipe(view)) {
                        return false;
                    }
                    if (this.mTargetView != null && (-f) >= ((float) this.mTouchSlop)) {
                        z = true;
                    }
                    this.mIsDragging = z;
                    if (z) {
                        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            this.mTargetView = null;
            this.mIsDragging = false;
        } else {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            if (this.mTargetView == null) {
                this.mTargetView = recyclerView.findChildViewUnder(x, y);
            }
        }
        return z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Animator animator = this.mAnimator;
        if (animator != null && animator.isRunning()) {
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
                int x2 = (int) (this.mLastX - motionEvent.getX());
                if (this.mIsDragging) {
                    float translationX = ((float) (-x2)) + this.mTargetView.getTranslationX();
                    if (translationX > 0.0f) {
                        translationX = 0.0f;
                    }
                    this.mTargetView.setTranslationX(translationX);
                }
                this.mLastX = (float) x;
                return;
            } else if (actionMasked != 3) {
                return;
            }
        }
        if (this.mIsDragging) {
            if ((-this.mTargetView.getTranslationX()) > ((float) (this.mTargetView.getWidth() / 2))) {
                doDismissAction(this.mTargetView);
            } else {
                doRestoreAction(this.mTargetView);
            }
        }
        this.mTargetView = null;
        this.mIsDragging = false;
    }

    private void doDismissAction(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, view.getTranslationX(), (float) (-view.getWidth()));
        this.mAnimator = ofFloat;
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.touchhelper.ItemSwipeHelper.AnonymousClass1 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ItemSwipeHelper.this.mAnimator = null;
                ItemSwipeHelper.this.mCallback.onDismiss(view);
            }
        });
        this.mAnimator.start();
    }

    private void doRestoreAction(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, view.getTranslationX(), 0.0f);
        this.mAnimator = ofFloat;
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.coolapk.market.widget.touchhelper.ItemSwipeHelper.AnonymousClass2 */

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ItemSwipeHelper.this.mAnimator = null;
            }
        });
        this.mAnimator.start();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f) <= ((float) this.mMinVelocity) || Math.abs(f) >= ((float) this.mMaxVelocity)) {
            return false;
        }
        if (f >= 0.0f || f + this.mTargetView.getTranslationX() >= ((float) (this.mTargetView.getWidth() / 2))) {
            doRestoreAction(this.mTargetView);
        } else {
            doDismissAction(this.mTargetView);
        }
        this.mTargetView = null;
        return true;
    }
}
