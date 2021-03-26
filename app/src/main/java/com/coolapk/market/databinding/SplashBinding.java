package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SplashBinding extends ViewDataBinding {
    public final FrameLayout contentView;
    public final TextView countView;
    public final ImageView imageView;
    @Bindable
    protected Integer mTextColor;
    public final TextView userNameView;

    public abstract void setTextColor(Integer num);

    protected SplashBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.contentView = frameLayout;
        this.countView = textView;
        this.imageView = imageView2;
        this.userNameView = textView2;
    }

    public Integer getTextColor() {
        return this.mTextColor;
    }

    public static SplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SplashBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559144, viewGroup, z, obj);
    }

    public static SplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SplashBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559144, null, false, obj);
    }

    public static SplashBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashBinding bind(View view, Object obj) {
        return (SplashBinding) bind(obj, view, 2131559144);
    }
}
