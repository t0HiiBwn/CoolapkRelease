package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;

public abstract class MarketBinding extends ViewDataBinding {
    public final ImageView fabRefreshIcon;
    public final View fabRefreshIconDividerView;
    public final FrameLayout fabRefreshIconOverView;
    public final View fabRefreshTextOverView;
    public final TextView fabRefreshTextView;
    public final FrameLayout fabRefreshTextWrapView;
    public final FrameLayout fabRefreshView;
    public final ItemHeadlineTitleBinding floatHeadlineTitleView;
    public final FrameLayout floatHeadlineView;
    public final RelativeLayout refreshView;
    public final FrameLayout refreshViewMaskLayer;
    public final RelativeLayout rootView;
    public final TabLayout tabs;
    public final FrameLayout tabsWrap;
    public final ScrollStateViewPager viewPager;

    protected MarketBinding(Object obj, View view, int i, ImageView imageView, View view2, FrameLayout frameLayout, View view3, TextView textView, FrameLayout frameLayout2, FrameLayout frameLayout3, ItemHeadlineTitleBinding itemHeadlineTitleBinding, FrameLayout frameLayout4, RelativeLayout relativeLayout, FrameLayout frameLayout5, RelativeLayout relativeLayout2, TabLayout tabLayout, FrameLayout frameLayout6, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.fabRefreshIcon = imageView;
        this.fabRefreshIconDividerView = view2;
        this.fabRefreshIconOverView = frameLayout;
        this.fabRefreshTextOverView = view3;
        this.fabRefreshTextView = textView;
        this.fabRefreshTextWrapView = frameLayout2;
        this.fabRefreshView = frameLayout3;
        this.floatHeadlineTitleView = itemHeadlineTitleBinding;
        this.floatHeadlineView = frameLayout4;
        this.refreshView = relativeLayout;
        this.refreshViewMaskLayer = frameLayout5;
        this.rootView = relativeLayout2;
        this.tabs = tabLayout;
        this.tabsWrap = frameLayout6;
        this.viewPager = scrollStateViewPager;
    }

    public static MarketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MarketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MarketBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559026, viewGroup, z, obj);
    }

    public static MarketBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MarketBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MarketBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559026, null, false, obj);
    }

    public static MarketBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MarketBinding bind(View view, Object obj) {
        return (MarketBinding) bind(obj, view, 2131559026);
    }
}
