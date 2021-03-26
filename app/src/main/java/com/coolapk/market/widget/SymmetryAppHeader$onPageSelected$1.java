package com.coolapk.market.widget;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
/* compiled from: SymmetryAppHeader.kt */
final class SymmetryAppHeader$onPageSelected$1 implements View.OnTouchListener {
    final /* synthetic */ SymmetryAppHeader this$0;

    SymmetryAppHeader$onPageSelected$1(SymmetryAppHeader symmetryAppHeader) {
        this.this$0 = symmetryAppHeader;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SymmetryAppHeader.access$getDetector$p(this.this$0).onTouchEvent(motionEvent);
        return true;
    }
}
