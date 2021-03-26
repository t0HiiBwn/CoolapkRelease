package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.SlideUpView;

public abstract class ShareWebviewBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout mainContent;
    public final SlideUpView slideUpView;
    public final Toolbar toolbar;
    public final FrameLayout toolbarContentFragment;

    protected ShareWebviewBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout, SlideUpView slideUpView2, Toolbar toolbar2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.mainContent = drawSystemBarFrameLayout;
        this.slideUpView = slideUpView2;
        this.toolbar = toolbar2;
        this.toolbarContentFragment = frameLayout;
    }

    public static ShareWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShareWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559142, viewGroup, z, obj);
    }

    public static ShareWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareWebviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShareWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559142, null, false, obj);
    }

    public static ShareWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareWebviewBinding bind(View view, Object obj) {
        return (ShareWebviewBinding) bind(obj, view, 2131559142);
    }
}
