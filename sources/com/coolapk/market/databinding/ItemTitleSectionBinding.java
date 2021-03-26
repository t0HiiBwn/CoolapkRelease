package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemTitleSectionBinding extends ViewDataBinding {
    @Bindable
    protected String mTitle;
    public final TextView textView;

    public abstract void setTitle(String str);

    protected ItemTitleSectionBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemTitleSectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleSectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTitleSectionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558957, viewGroup, z, obj);
    }

    public static ItemTitleSectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleSectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTitleSectionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558957, null, false, obj);
    }

    public static ItemTitleSectionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleSectionBinding bind(View view, Object obj) {
        return (ItemTitleSectionBinding) bind(obj, view, 2131558957);
    }
}
