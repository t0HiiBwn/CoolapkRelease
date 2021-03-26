package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.HolderItem;

public abstract class ItemUserProfileItemBinding extends ViewDataBinding {
    public final ImageView imageView;
    @Bindable
    protected HolderItem mHolderItem;
    public final TextView titleView;

    public abstract void setHolderItem(HolderItem holderItem);

    protected ItemUserProfileItemBinding(Object obj, View view, int i, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.titleView = textView;
    }

    public HolderItem getHolderItem() {
        return this.mHolderItem;
    }

    public static ItemUserProfileItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserProfileItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserProfileItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558987, viewGroup, z, obj);
    }

    public static ItemUserProfileItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserProfileItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserProfileItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558987, null, false, obj);
    }

    public static ItemUserProfileItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserProfileItemBinding bind(View view, Object obj) {
        return (ItemUserProfileItemBinding) bind(obj, view, 2131558987);
    }
}
