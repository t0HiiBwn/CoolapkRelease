package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class MainCategoryLayoutBinding extends ViewDataBinding {
    public final LinearLayout apkContainer;
    public final LinearLayout gameContainer;
    public final FrameLayout linkCardContainer;
    public final NestedScrollView scrollView;

    protected MainCategoryLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, NestedScrollView nestedScrollView) {
        super(obj, view, i);
        this.apkContainer = linearLayout;
        this.gameContainer = linearLayout2;
        this.linkCardContainer = frameLayout;
        this.scrollView = nestedScrollView;
    }

    public static MainCategoryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainCategoryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MainCategoryLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559023, viewGroup, z, obj);
    }

    public static MainCategoryLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainCategoryLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MainCategoryLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559023, null, false, obj);
    }

    public static MainCategoryLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainCategoryLayoutBinding bind(View view, Object obj) {
        return (MainCategoryLayoutBinding) bind(obj, view, 2131559023);
    }
}
