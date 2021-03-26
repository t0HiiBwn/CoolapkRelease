package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class TipLayoutBinding extends ViewDataBinding {
    public final ImageView horizontalGuideView;
    public final DrawSystemBarFrameLayout mainContent;
    public final ImageView verticalGuideView;

    protected TipLayoutBinding(Object obj, View view, int i, ImageView imageView, DrawSystemBarFrameLayout drawSystemBarFrameLayout, ImageView imageView2) {
        super(obj, view, i);
        this.horizontalGuideView = imageView;
        this.mainContent = drawSystemBarFrameLayout;
        this.verticalGuideView = imageView2;
    }

    public static TipLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TipLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TipLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559206, viewGroup, z, obj);
    }

    public static TipLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TipLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TipLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559206, null, false, obj);
    }

    public static TipLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TipLayoutBinding bind(View view, Object obj) {
        return (TipLayoutBinding) bind(obj, view, 2131559206);
    }
}
