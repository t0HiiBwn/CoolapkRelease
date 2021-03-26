package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;

public abstract class PostMorePanelBinding extends ViewDataBinding {
    public final FrameLayout morePanelHeader;
    public final LinearLayout morePanelIndicator;
    public final ScrollStateViewPager morePanelViewPager;

    protected PostMorePanelBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.morePanelHeader = frameLayout;
        this.morePanelIndicator = linearLayout;
        this.morePanelViewPager = scrollStateViewPager;
    }

    public static PostMorePanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostMorePanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PostMorePanelBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559090, viewGroup, z, obj);
    }

    public static PostMorePanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostMorePanelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PostMorePanelBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559090, null, false, obj);
    }

    public static PostMorePanelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostMorePanelBinding bind(View view, Object obj) {
        return (PostMorePanelBinding) bind(obj, view, 2131559090);
    }
}
