package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.design.CoolapkCardView;
import com.rd.PageIndicatorView;

public abstract class ItemSearchSceneBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final PageIndicatorView pageIndicatorView;
    public final TextView titleView;
    public final ViewPager viewPager;

    protected ItemSearchSceneBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, PageIndicatorView pageIndicatorView2, TextView textView, ViewPager viewPager2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.pageIndicatorView = pageIndicatorView2;
        this.titleView = textView;
        this.viewPager = viewPager2;
    }

    public static ItemSearchSceneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchSceneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchSceneBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558922, viewGroup, z, obj);
    }

    public static ItemSearchSceneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchSceneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchSceneBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558922, null, false, obj);
    }

    public static ItemSearchSceneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchSceneBinding bind(View view, Object obj) {
        return (ItemSearchSceneBinding) bind(obj, view, 2131558922);
    }
}
