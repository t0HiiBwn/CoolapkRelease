package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.reflect.Field;

public class MyNestedScrollView extends NestedScrollView {
    public boolean isFling = false;
    private OverScroller mScroller = getOverScroller();

    public MyNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int i) {
        super.fling(i);
        if (getChildCount() > 0) {
            ViewCompat.postInvalidateOnAnimation(this);
            this.isFling = true;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.isFling) {
            return;
        }
        if (Math.abs(i2 - i4) <= 3 || i2 == 0 || i2 == getChildAt(0).getMeasuredHeight() - getMeasuredHeight()) {
            this.isFling = false;
            OverScroller overScroller = this.mScroller;
            if (overScroller != null) {
                overScroller.abortAnimation();
            }
        }
    }

    private OverScroller getOverScroller() {
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            return (OverScroller) declaredField.get(this);
        } catch (Throwable unused) {
            return null;
        }
    }
}
