package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public abstract class TestBinding extends ViewDataBinding {
    public final EllipsizeTextView ellipsizeView;

    protected TestBinding(Object obj, View view, int i, EllipsizeTextView ellipsizeTextView) {
        super(obj, view, i);
        this.ellipsizeView = ellipsizeTextView;
    }

    public static TestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TestBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559186, viewGroup, z, obj);
    }

    public static TestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TestBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559186, null, false, obj);
    }

    public static TestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TestBinding bind(View view, Object obj) {
        return (TestBinding) bind(obj, view, 2131559186);
    }
}
