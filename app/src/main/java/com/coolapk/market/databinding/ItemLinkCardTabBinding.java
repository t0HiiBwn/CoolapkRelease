package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemLinkCardTabBinding extends ViewDataBinding {
    @Bindable
    protected String mTitle;
    public final TextView textView;

    public abstract void setTitle(String str);

    protected ItemLinkCardTabBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemLinkCardTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLinkCardTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558801, viewGroup, z, obj);
    }

    public static ItemLinkCardTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardTabBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLinkCardTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558801, null, false, obj);
    }

    public static ItemLinkCardTabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLinkCardTabBinding bind(View view, Object obj) {
        return (ItemLinkCardTabBinding) bind(obj, view, 2131558801);
    }
}
