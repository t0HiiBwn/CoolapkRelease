package com.coolapk.market.widget;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"com/coolapk/market/widget/FastReturnView$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "clear", "", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
public final class FastReturnView$onPageChangeListener$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ FastReturnView this$0;
    private ViewPager viewPager;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FastReturnView$onPageChangeListener$1(FastReturnView fastReturnView) {
        this.this$0 = fastReturnView;
    }

    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    public final void setViewPager(ViewPager viewPager2) {
        this.viewPager = viewPager2;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.this$0.post(new FastReturnView$onPageChangeListener$1$onPageSelected$1(this));
    }

    public final void clear() {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
        }
    }
}
