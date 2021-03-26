package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.splash.CountdownView;

public abstract class SplashV9Binding extends ViewDataBinding {
    public final FrameLayout adContainer;
    public final FrameLayout bottomContainer;
    public final ImageView logoView;
    public final ConstraintLayout rootView;
    public final CountdownView skipButton;
    public final ImageView sloganView;

    protected SplashV9Binding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ConstraintLayout constraintLayout, CountdownView countdownView, ImageView imageView2) {
        super(obj, view, i);
        this.adContainer = frameLayout;
        this.bottomContainer = frameLayout2;
        this.logoView = imageView;
        this.rootView = constraintLayout;
        this.skipButton = countdownView;
        this.sloganView = imageView2;
    }

    public static SplashV9Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashV9Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SplashV9Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559152, viewGroup, z, obj);
    }

    public static SplashV9Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashV9Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SplashV9Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559152, null, false, obj);
    }

    public static SplashV9Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SplashV9Binding bind(View view, Object obj) {
        return (SplashV9Binding) bind(obj, view, 2131559152);
    }
}
