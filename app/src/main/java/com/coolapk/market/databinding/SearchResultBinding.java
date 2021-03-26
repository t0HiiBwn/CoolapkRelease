package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class SearchResultBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final DrawSystemBarFrameLayout mainContent;
    public final FrameLayout navigationButton;
    public final ImageView navigationIcon;
    public final ImageView qrIcon;
    public final FrameLayout qrView;
    public final LinearLayout searchBoxLayout;
    public final FrameLayout searchButton;
    public final ImageView searchIcon;
    public final TextView searchResultTextView;
    public final TabLayout tabs;
    public final ScrollStateViewPager viewPager;

    protected SearchResultBinding(Object obj, View view, int i, AppBarLayout appBarLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, LinearLayout linearLayout, FrameLayout frameLayout3, ImageView imageView3, TextView textView, TabLayout tabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.mainContent = drawSystemBarFrameLayout;
        this.navigationButton = frameLayout;
        this.navigationIcon = imageView;
        this.qrIcon = imageView2;
        this.qrView = frameLayout2;
        this.searchBoxLayout = linearLayout;
        this.searchButton = frameLayout3;
        this.searchIcon = imageView3;
        this.searchResultTextView = textView;
        this.tabs = tabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static SearchResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchResultBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559129, viewGroup, z, obj);
    }

    public static SearchResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchResultBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559129, null, false, obj);
    }

    public static SearchResultBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchResultBinding bind(View view, Object obj) {
        return (SearchResultBinding) bind(obj, view, 2131559129);
    }
}
