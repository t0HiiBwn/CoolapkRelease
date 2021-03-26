package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.HolderItem;

public abstract class ItemUserNavigationBinding extends ViewDataBinding {
    public final ImageView iconView;
    @Bindable
    protected HolderItem mHolderItem;

    public abstract void setHolderItem(HolderItem holderItem);

    protected ItemUserNavigationBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.iconView = imageView;
    }

    public HolderItem getHolderItem() {
        return this.mHolderItem;
    }

    public static ItemUserNavigationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserNavigationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserNavigationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558977, viewGroup, z, obj);
    }

    public static ItemUserNavigationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserNavigationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserNavigationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558977, null, false, obj);
    }

    public static ItemUserNavigationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserNavigationBinding bind(View view, Object obj) {
        return (ItemUserNavigationBinding) bind(obj, view, 2131558977);
    }
}
