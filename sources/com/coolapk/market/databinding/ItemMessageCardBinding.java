package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemMessageCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    @Bindable
    protected String mMessage;
    @Bindable
    protected String mTitle;
    public final TextView textView;

    public abstract void setMessage(String str);

    public abstract void setTitle(String str);

    protected ItemMessageCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.textView = textView2;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public static ItemMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558832, viewGroup, z, obj);
    }

    public static ItemMessageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMessageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558832, null, false, obj);
    }

    public static ItemMessageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageCardBinding bind(View view, Object obj) {
        return (ItemMessageCardBinding) bind(obj, view, 2131558832);
    }
}
