package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemNoMoreDataViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final TextView textView;

    protected ItemNoMoreDataViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.textView = textView2;
    }

    public static ItemNoMoreDataViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNoMoreDataViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNoMoreDataViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558837, viewGroup, z, obj);
    }

    public static ItemNoMoreDataViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNoMoreDataViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNoMoreDataViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558837, null, false, obj);
    }

    public static ItemNoMoreDataViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNoMoreDataViewBinding bind(View view, Object obj) {
        return (ItemNoMoreDataViewBinding) bind(obj, view, 2131558837);
    }
}
