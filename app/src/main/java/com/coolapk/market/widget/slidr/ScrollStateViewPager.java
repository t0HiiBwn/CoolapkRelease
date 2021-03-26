package com.coolapk.market.widget.slidr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.util.ReflectUtils;
import com.youth.banner.view.BannerViewPager;
import java.lang.reflect.Field;

public class ScrollStateViewPager extends ViewPager {
    private static Field bannerScrollableField;
    private int mCurrentState;

    static {
        try {
            bannerScrollableField = ReflectUtils.findField(BannerViewPager.class, "scrollable");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ScrollStateViewPager(Context context) {
        super(context);
        init();
    }

    public ScrollStateViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            /* class com.coolapk.market.widget.slidr.ScrollStateViewPager.AnonymousClass1 */

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                super.onPageScrollStateChanged(i);
                ScrollStateViewPager.this.mCurrentState = i;
            }
        });
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        Field field;
        if ((view instanceof BannerViewPager) && (field = bannerScrollableField) != null) {
            try {
                return field.getBoolean(view);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return super.canScroll(view, z, i, i2, i3);
    }
}
