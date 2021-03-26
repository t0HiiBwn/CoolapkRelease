package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.HolderItem;

public abstract class ItemUserDeleteRecentBinding extends ViewDataBinding {
    public final TextView actionView;
    @Bindable
    protected HolderItem mModel;
    public final TextView textView;

    public abstract void setModel(HolderItem holderItem);

    protected ItemUserDeleteRecentBinding(Object obj, View view, int i, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView2;
        this.textView = textView3;
    }

    public HolderItem getModel() {
        return this.mModel;
    }

    public static ItemUserDeleteRecentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserDeleteRecentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserDeleteRecentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558971, viewGroup, z, obj);
    }

    public static ItemUserDeleteRecentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserDeleteRecentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserDeleteRecentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558971, null, false, obj);
    }

    public static ItemUserDeleteRecentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserDeleteRecentBinding bind(View view, Object obj) {
        return (ItemUserDeleteRecentBinding) bind(obj, view, 2131558971);
    }
}
