package com.coolapk.market.widget.video.util;

import android.view.MotionEvent;
import com.kk.taurus.playerbase.touch.BaseGestureCallbackHandler;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/widget/video/util/FixTouchSuperContainer$getGestureCallBackHandler$1", "Lcom/kk/taurus/playerbase/touch/BaseGestureCallbackHandler;", "onSingleTapConfirmed", "", "e", "Landroid/view/MotionEvent;", "onSingleTapUp", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FixTouchSuperContainer.kt */
public final class FixTouchSuperContainer$getGestureCallBackHandler$1 extends BaseGestureCallbackHandler {
    final /* synthetic */ FixTouchSuperContainer this$0;

    @Override // com.kk.taurus.playerbase.touch.BaseGestureCallbackHandler, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FixTouchSuperContainer$getGestureCallBackHandler$1(FixTouchSuperContainer fixTouchSuperContainer, OnTouchGestureListener onTouchGestureListener) {
        super(onTouchGestureListener);
        this.this$0 = fixTouchSuperContainer;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.this$0.onSingleTapUp(motionEvent);
        return false;
    }
}
