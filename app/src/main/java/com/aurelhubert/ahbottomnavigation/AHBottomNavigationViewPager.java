package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class AHBottomNavigationViewPager extends ViewPager {
    private boolean enabled = false;

    public AHBottomNavigationViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.enabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPagingEnabled(boolean z) {
        this.enabled = z;
    }
}
