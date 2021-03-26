package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class TouchInterceptionFrameLayout extends FrameLayout {
    private boolean mBeganFromDownMotionEvent;
    private boolean mChildrenEventsCanceled;
    private boolean mDownMotionEventPended;
    private PointF mInitialPoint;
    private boolean mIntercepting;
    private MotionEvent mPendingDownMotionEvent;
    private TouchInterceptionListener mTouchInterceptionListener;

    public interface TouchInterceptionListener {
        void onDownMotionEvent(MotionEvent motionEvent);

        void onMoveMotionEvent(MotionEvent motionEvent, float f, float f2);

        void onUpOrCancelMotionEvent(MotionEvent motionEvent);

        boolean shouldInterceptTouchEvent(MotionEvent motionEvent, boolean z, float f, float f2);
    }

    public TouchInterceptionFrameLayout(Context context) {
        super(context);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setScrollInterceptionListener(TouchInterceptionListener touchInterceptionListener) {
        this.mTouchInterceptionListener = touchInterceptionListener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchInterceptionListener == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mInitialPoint = new PointF(motionEvent.getX(), motionEvent.getY());
            this.mPendingDownMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
            this.mDownMotionEventPended = true;
            boolean shouldInterceptTouchEvent = this.mTouchInterceptionListener.shouldInterceptTouchEvent(motionEvent, false, 0.0f, 0.0f);
            this.mIntercepting = shouldInterceptTouchEvent;
            this.mBeganFromDownMotionEvent = shouldInterceptTouchEvent;
            this.mChildrenEventsCanceled = false;
            return shouldInterceptTouchEvent;
        } else if (actionMasked != 2) {
            return false;
        } else {
            if (this.mInitialPoint == null) {
                this.mInitialPoint = new PointF(motionEvent.getX(), motionEvent.getY());
            }
            boolean shouldInterceptTouchEvent2 = this.mTouchInterceptionListener.shouldInterceptTouchEvent(motionEvent, true, motionEvent.getX() - this.mInitialPoint.x, motionEvent.getY() - this.mInitialPoint.y);
            this.mIntercepting = shouldInterceptTouchEvent2;
            return shouldInterceptTouchEvent2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0 != 3) goto L_0x00f7;
     */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchInterceptionListener != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (this.mInitialPoint == null) {
                            this.mInitialPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                        }
                        float x = motionEvent.getX() - this.mInitialPoint.x;
                        float y = motionEvent.getY() - this.mInitialPoint.y;
                        boolean shouldInterceptTouchEvent = this.mTouchInterceptionListener.shouldInterceptTouchEvent(motionEvent, true, x, y);
                        this.mIntercepting = shouldInterceptTouchEvent;
                        if (shouldInterceptTouchEvent) {
                            if (!this.mBeganFromDownMotionEvent) {
                                this.mBeganFromDownMotionEvent = true;
                                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(this.mPendingDownMotionEvent);
                                obtainNoHistory.setLocation(motionEvent.getX(), motionEvent.getY());
                                this.mTouchInterceptionListener.onDownMotionEvent(obtainNoHistory);
                                this.mInitialPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                                x = 0.0f;
                                y = 0.0f;
                            }
                            if (!this.mChildrenEventsCanceled) {
                                this.mChildrenEventsCanceled = true;
                                duplicateTouchEventForChildren(obtainMotionEvent(motionEvent, 3), new MotionEvent[0]);
                            }
                            this.mTouchInterceptionListener.onMoveMotionEvent(motionEvent, x, y);
                            this.mDownMotionEventPended = true;
                            return true;
                        }
                        if (this.mDownMotionEventPended) {
                            this.mDownMotionEventPended = false;
                            MotionEvent obtainNoHistory2 = MotionEvent.obtainNoHistory(this.mPendingDownMotionEvent);
                            obtainNoHistory2.setLocation(motionEvent.getX(), motionEvent.getY());
                            duplicateTouchEventForChildren(motionEvent, obtainNoHistory2);
                        } else {
                            duplicateTouchEventForChildren(motionEvent, new MotionEvent[0]);
                        }
                        this.mBeganFromDownMotionEvent = false;
                        this.mChildrenEventsCanceled = false;
                    }
                }
                this.mBeganFromDownMotionEvent = false;
                if (this.mIntercepting) {
                    this.mTouchInterceptionListener.onUpOrCancelMotionEvent(motionEvent);
                }
                if (!this.mChildrenEventsCanceled) {
                    this.mChildrenEventsCanceled = true;
                    if (this.mDownMotionEventPended) {
                        this.mDownMotionEventPended = false;
                        MotionEvent obtainNoHistory3 = MotionEvent.obtainNoHistory(this.mPendingDownMotionEvent);
                        obtainNoHistory3.setLocation(motionEvent.getX(), motionEvent.getY());
                        duplicateTouchEventForChildren(motionEvent, obtainNoHistory3);
                    } else {
                        duplicateTouchEventForChildren(motionEvent, new MotionEvent[0]);
                    }
                }
                return true;
            } else if (this.mIntercepting) {
                this.mTouchInterceptionListener.onDownMotionEvent(motionEvent);
                duplicateTouchEventForChildren(motionEvent, new MotionEvent[0]);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private MotionEvent obtainMotionEvent(MotionEvent motionEvent, int i) {
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        obtainNoHistory.setAction(i);
        return obtainNoHistory;
    }

    private void duplicateTouchEventForChildren(MotionEvent motionEvent, MotionEvent... motionEventArr) {
        if (motionEvent != null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt != null) {
                    Rect rect = new Rect();
                    childAt.getHitRect(rect);
                    MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                    if (!rect.contains((int) obtainNoHistory.getX(), (int) obtainNoHistory.getY())) {
                        continue;
                    } else {
                        float f = (float) (-childAt.getLeft());
                        float f2 = (float) (-childAt.getTop());
                        int i = 0;
                        if (motionEventArr != null) {
                            int length = motionEventArr.length;
                            int i2 = 0;
                            while (i < length) {
                                MotionEvent motionEvent2 = motionEventArr[i];
                                if (motionEvent2 != null) {
                                    MotionEvent obtainNoHistory2 = MotionEvent.obtainNoHistory(motionEvent2);
                                    obtainNoHistory2.offsetLocation(f, f2);
                                    i2 |= childAt.dispatchTouchEvent(obtainNoHistory2);
                                }
                                i++;
                            }
                            i = i2;
                        }
                        obtainNoHistory.offsetLocation(f, f2);
                        if ((childAt.dispatchTouchEvent(obtainNoHistory) | i) != 0) {
                            return;
                        }
                    }
                }
            }
        }
    }
}
