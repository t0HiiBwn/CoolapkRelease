package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class TextViewBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout rootView;
    public final NestedScrollView scrollView;
    public final TextView textView;

    protected TextViewBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout, NestedScrollView nestedScrollView, TextView textView2) {
        super(obj, view, i);
        this.rootView = drawSystemBarFrameLayout;
        this.scrollView = nestedScrollView;
        this.textView = textView2;
    }

    public static TextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TextViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TextViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559188, viewGroup, z, obj);
    }

    public static TextViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TextViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TextViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559188, null, false, obj);
    }

    public static TextViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TextViewBinding bind(View view, Object obj) {
        return (TextViewBinding) bind(obj, view, 2131559188);
    }
}
