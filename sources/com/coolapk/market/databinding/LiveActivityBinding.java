package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class LiveActivityBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final CollapsingToolbarFixLayout collapsingToolbar;
    public final DrawSystemBarFrameLayout contentView;
    public final FrameLayout playerHolder;
    public final ImageView postIconView;
    public final TextView postTextView;
    public final FrameLayout postView;
    public final TabLayout tabLayout;
    public final Toolbar toolbar;
    public final LinearLayout videoContainer;
    public final ViewPager viewPager;

    protected LiveActivityBinding(Object obj, View view, int i, AppBarLayout appBarLayout, CollapsingToolbarFixLayout collapsingToolbarFixLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, FrameLayout frameLayout2, TabLayout tabLayout2, Toolbar toolbar2, LinearLayout linearLayout, ViewPager viewPager2) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.collapsingToolbar = collapsingToolbarFixLayout;
        this.contentView = drawSystemBarFrameLayout;
        this.playerHolder = frameLayout;
        this.postIconView = imageView;
        this.postTextView = textView;
        this.postView = frameLayout2;
        this.tabLayout = tabLayout2;
        this.toolbar = toolbar2;
        this.videoContainer = linearLayout;
        this.viewPager = viewPager2;
    }

    public static LiveActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LiveActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559009, viewGroup, z, obj);
    }

    public static LiveActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LiveActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559009, null, false, obj);
    }

    public static LiveActivityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveActivityBinding bind(View view, Object obj) {
        return (LiveActivityBinding) bind(obj, view, 2131559009);
    }
}
