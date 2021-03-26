package com.kk.taurus.playerbase.touch;

import android.view.MotionEvent;

public interface OnTouchGestureListener {
    void onDoubleTap(MotionEvent motionEvent);

    void onDown(MotionEvent motionEvent);

    void onEndGesture();

    void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    void onSingleTapUp(MotionEvent motionEvent);
}
