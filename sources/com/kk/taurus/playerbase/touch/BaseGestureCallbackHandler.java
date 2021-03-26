package com.kk.taurus.playerbase.touch;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kk.taurus.playerbase.log.PLog;

public class BaseGestureCallbackHandler extends GestureDetector.SimpleOnGestureListener {
    private final String TAG = "GestureCallbackHandler";
    private boolean mGestureEnable = true;
    private boolean mGestureScrollEnable = true;
    protected OnTouchGestureListener mOnTouchGestureListener;

    public BaseGestureCallbackHandler(OnTouchGestureListener onTouchGestureListener) {
        this.mOnTouchGestureListener = onTouchGestureListener;
    }

    public void setGestureEnable(boolean z) {
        this.mGestureEnable = z;
    }

    public void setGestureScrollEnable(boolean z) {
        this.mGestureScrollEnable = z;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        OnTouchGestureListener onTouchGestureListener = this.mOnTouchGestureListener;
        if (onTouchGestureListener != null) {
            onTouchGestureListener.onSingleTapUp(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        OnTouchGestureListener onTouchGestureListener = this.mOnTouchGestureListener;
        if (onTouchGestureListener != null) {
            onTouchGestureListener.onDoubleTap(motionEvent);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        PLog.d("GestureCallbackHandler", "onDown...");
        OnTouchGestureListener onTouchGestureListener = this.mOnTouchGestureListener;
        if (onTouchGestureListener != null) {
            onTouchGestureListener.onDown(motionEvent);
        }
        return this.mGestureEnable;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        OnTouchGestureListener onTouchGestureListener = this.mOnTouchGestureListener;
        if (onTouchGestureListener != null && this.mGestureScrollEnable) {
            onTouchGestureListener.onScroll(motionEvent, motionEvent2, f, f2);
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    public void onEndGesture(MotionEvent motionEvent) {
        OnTouchGestureListener onTouchGestureListener = this.mOnTouchGestureListener;
        if (onTouchGestureListener != null) {
            onTouchGestureListener.onEndGesture();
        }
    }
}
