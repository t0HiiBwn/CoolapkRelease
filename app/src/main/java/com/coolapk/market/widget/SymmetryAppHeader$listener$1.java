package com.coolapk.market.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/widget/SymmetryAppHeader$listener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SymmetryAppHeader.kt */
public final class SymmetryAppHeader$listener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ SymmetryAppHeader this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SymmetryAppHeader$listener$1(SymmetryAppHeader symmetryAppHeader) {
        this.this$0 = symmetryAppHeader;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        SymmetryAppHeader.access$scrollToTopAndRefresh(this.this$0);
        return true;
    }
}
