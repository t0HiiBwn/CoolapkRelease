package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.SlideUpView;
import com.flyco.tablayout.SlidingTabLayout;

public abstract class CollectionSelectBinding extends ViewDataBinding {
    public final TextView actionDone;
    public final SlideUpView bottomSheet;
    public final ImageView closeView;
    public final FrameLayout contentContainer;
    public final TextView createView;
    public final LinearLayout headContainer;
    public final ProgressBar loadingView;
    public final DrawSystemBarFrameLayout mainContent;
    public final View searchViewDivider;
    public final SlidingTabLayout tabLayout;
    public final ScrollStateViewPager viewPager;

    protected CollectionSelectBinding(Object obj, View view, int i, TextView textView, SlideUpView slideUpView, ImageView imageView, FrameLayout frameLayout, TextView textView2, LinearLayout linearLayout, ProgressBar progressBar, DrawSystemBarFrameLayout drawSystemBarFrameLayout, View view2, SlidingTabLayout slidingTabLayout, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.actionDone = textView;
        this.bottomSheet = slideUpView;
        this.closeView = imageView;
        this.contentContainer = frameLayout;
        this.createView = textView2;
        this.headContainer = linearLayout;
        this.loadingView = progressBar;
        this.mainContent = drawSystemBarFrameLayout;
        this.searchViewDivider = view2;
        this.tabLayout = slidingTabLayout;
        this.viewPager = scrollStateViewPager;
    }

    public static CollectionSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollectionSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CollectionSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558481, viewGroup, z, obj);
    }

    public static CollectionSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollectionSelectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CollectionSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558481, null, false, obj);
    }

    public static CollectionSelectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollectionSelectBinding bind(View view, Object obj) {
        return (CollectionSelectBinding) bind(obj, view, 2131558481);
    }
}
