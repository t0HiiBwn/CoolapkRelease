package com.coolapk.market.view.wallpaper.coolpic;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicViewPager$mGestureListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicViewPager.kt */
public final class CoolPicViewPager$mGestureListener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ CoolPicViewPager this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicViewPager$mGestureListener$1(CoolPicViewPager coolPicViewPager) {
        this.this$0 = coolPicViewPager;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.this$0.click == null) {
            return false;
        }
        CoolPicViewPager.VpClick vpClick = this.this$0.click;
        Intrinsics.checkNotNull(vpClick);
        vpClick.clickItem(this.this$0);
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.this$0.click == null) {
            return false;
        }
        CoolPicViewPager.VpClick vpClick = this.this$0.click;
        Intrinsics.checkNotNull(vpClick);
        Intrinsics.checkNotNull(motionEvent);
        vpClick.doubleClickItem(this.this$0, motionEvent.getX(), motionEvent.getY());
        return false;
    }
}
