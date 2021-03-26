package com.kk.taurus.playerbase.event;

import android.os.Bundle;
import android.view.MotionEvent;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;

public interface IEventDispatcher {
    void dispatchErrorEvent(int i, Bundle bundle);

    void dispatchPlayEvent(int i, Bundle bundle);

    void dispatchProducerData(String str, Object obj, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void dispatchProducerEvent(int i, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void dispatchReceiverEvent(int i, Bundle bundle);

    void dispatchReceiverEvent(int i, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter);

    void dispatchTouchEventOnDoubleTabUp(MotionEvent motionEvent);

    void dispatchTouchEventOnDown(MotionEvent motionEvent);

    void dispatchTouchEventOnEndGesture();

    void dispatchTouchEventOnScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    void dispatchTouchEventOnSingleTabUp(MotionEvent motionEvent);
}
