package com.coolapk.market.widget.photoview;

import android.view.MotionEvent;

public class RotateGestureDetector {
    private static final int MAX_DEGREES_STEP = 120;
    private float mCurrSlope;
    private OnRotateListener mListener;
    private float mPrevSlope;
    private float x1;
    private float x2;
    private float y1;
    private float y2;

    public RotateGestureDetector(OnRotateListener onRotateListener) {
        this.mListener = onRotateListener;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 2) {
            if ((actionMasked == 5 || actionMasked == 6) && motionEvent.getPointerCount() == 2) {
                this.mPrevSlope = caculateSlope(motionEvent);
            }
        } else if (motionEvent.getPointerCount() > 1) {
            float caculateSlope = caculateSlope(motionEvent);
            this.mCurrSlope = caculateSlope;
            double degrees = Math.toDegrees(Math.atan((double) caculateSlope)) - Math.toDegrees(Math.atan((double) this.mPrevSlope));
            if (Math.abs(degrees) <= 120.0d) {
                this.mListener.onRotate((float) degrees, (this.x2 + this.x1) / 2.0f, (this.y2 + this.y1) / 2.0f);
            }
            this.mPrevSlope = this.mCurrSlope;
        }
    }

    private float caculateSlope(MotionEvent motionEvent) {
        this.x1 = motionEvent.getX(0);
        this.y1 = motionEvent.getY(0);
        this.x2 = motionEvent.getX(1);
        float y = motionEvent.getY(1);
        this.y2 = y;
        return (y - this.y1) / (this.x2 - this.x1);
    }
}
