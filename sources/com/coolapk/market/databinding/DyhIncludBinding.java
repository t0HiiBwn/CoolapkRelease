package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.SlideUpView;
import com.flyco.tablayout.SlidingTabLayout;

public abstract class DyhIncludBinding extends ViewDataBinding {
    public final TextView actionDone;
    public final SlideUpView bottomSheet;
    public final ImageView clearButton;
    public final ImageView closeView;
    public final FrameLayout contentContainer;
    public final EditText editText;
    public final LinearLayout headContainer;
    public final TextView hintText;
    public final LinearLayout hintView;
    public final DrawSystemBarFrameLayout mainContent;
    public final ImageView searchButtonView;
    public final LinearLayout searchView;
    public final View searchViewDivider;
    public final SlidingTabLayout tabLayout;
    public final ImageView titleImgView;
    public final ScrollStateViewPager viewPager;

    protected DyhIncludBinding(Object obj, View view, int i, TextView textView, SlideUpView slideUpView, ImageView imageView, ImageView imageView2, FrameLayout frameLayout, EditText editText2, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, DrawSystemBarFrameLayout drawSystemBarFrameLayout, ImageView imageView3, LinearLayout linearLayout3, View view2, SlidingTabLayout slidingTabLayout, ImageView imageView4, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.actionDone = textView;
        this.bottomSheet = slideUpView;
        this.clearButton = imageView;
        this.closeView = imageView2;
        this.contentContainer = frameLayout;
        this.editText = editText2;
        this.headContainer = linearLayout;
        this.hintText = textView2;
        this.hintView = linearLayout2;
        this.mainContent = drawSystemBarFrameLayout;
        this.searchButtonView = imageView3;
        this.searchView = linearLayout3;
        this.searchViewDivider = view2;
        this.tabLayout = slidingTabLayout;
        this.titleImgView = imageView4;
        this.viewPager = scrollStateViewPager;
    }

    public static DyhIncludBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DyhIncludBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DyhIncludBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558544, viewGroup, z, obj);
    }

    public static DyhIncludBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DyhIncludBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DyhIncludBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558544, null, false, obj);
    }

    public static DyhIncludBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DyhIncludBinding bind(View view, Object obj) {
        return (DyhIncludBinding) bind(obj, view, 2131558544);
    }
}
