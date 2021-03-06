package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.ShapedImageView;

public abstract class SplashViewBinding extends ViewDataBinding {
    public final ShapedImageView imageView;
    @Bindable
    protected Integer mTextColor;
    public final DrawSystemBarFrameLayout rootView;

    public abstract void setTextColor(Integer num);

    protected SplashViewBinding(Object obj, View view, int i, ShapedImageView shapedImageView, DrawSystemBarFrameLayout drawSystemBarFrameLayout) {
        super(obj, view, i);
        this.imageView = shapedImageView;
        this.rootView = drawSystemBarFrameLayout;
    }

    public Integer getTextColor() {
        return this.mTextColor;
    }

    public static SplashViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SplashViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559153, viewGroup, z, obj);
    }

    public static SplashViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SplashViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559153, null, false, obj);
    }

    public static SplashViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashViewBinding bind(View view, Object obj) {
        return (SplashViewBinding) bind(obj, view, 2131559153);
    }
}
