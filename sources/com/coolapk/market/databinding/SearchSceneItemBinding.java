package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SearchSceneItemBinding extends ViewDataBinding {
    public final TextView textView;

    protected SearchSceneItemBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public static SearchSceneItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchSceneItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchSceneItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559130, viewGroup, z, obj);
    }

    public static SearchSceneItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchSceneItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchSceneItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559130, null, false, obj);
    }

    public static SearchSceneItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchSceneItemBinding bind(View view, Object obj) {
        return (SearchSceneItemBinding) bind(obj, view, 2131559130);
    }
}
