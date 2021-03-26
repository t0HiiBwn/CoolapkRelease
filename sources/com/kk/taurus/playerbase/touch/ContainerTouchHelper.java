package com.kk.taurus.playerbase.touch;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class ContainerTouchHelper {
    private BaseGestureCallbackHandler mGestureCallback;
    private GestureDetector mGestureDetector;

    public ContainerTouchHelper(Context context, BaseGestureCallbackHandler baseGestureCallbackHandler) {
        this.mGestureCallback = baseGestureCallbackHandler;
        this.mGestureDetector = new GestureDetector(context, baseGestureCallbackHandler);
    }

    public boolean onTouch(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            onEndGesture(motionEvent);
        }
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    public void setGestureEnable(boolean z) {
        this.mGestureCallback.setGestureEnable(z);
    }

    public void setGestureScrollEnable(boolean z) {
        this.mGestureCallback.setGestureScrollEnable(z);
    }

    public void onEndGesture(MotionEvent motionEvent) {
        this.mGestureCallback.onEndGesture(motionEvent);
    }
}
