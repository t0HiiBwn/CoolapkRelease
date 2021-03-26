package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public abstract class ItemDyhSimpleHeaderBinding extends ViewDataBinding {
    @Bindable
    protected DyhViewModel mViewModel;
    public final LinearLayout rootView;
    public final TextView timeView;

    public abstract void setViewModel(DyhViewModel dyhViewModel);

    protected ItemDyhSimpleHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.rootView = linearLayout;
        this.timeView = textView;
    }

    public DyhViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemDyhSimpleHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSimpleHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhSimpleHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558688, viewGroup, z, obj);
    }

    public static ItemDyhSimpleHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSimpleHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhSimpleHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558688, null, false, obj);
    }

    public static ItemDyhSimpleHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSimpleHeaderBinding bind(View view, Object obj) {
        return (ItemDyhSimpleHeaderBinding) bind(obj, view, 2131558688);
    }
}
