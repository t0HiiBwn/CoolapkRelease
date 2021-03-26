package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.HolderItem;

public abstract class ItemSettingBinding extends ViewDataBinding {
    public final ImageView imageView;
    @Bindable
    protected HolderItem mHolderItem;
    public final LinearLayout rootView;
    public final TextView subTitleView;
    public final TextView titleView;

    public abstract void setHolderItem(HolderItem holderItem);

    protected ItemSettingBinding(Object obj, View view, int i, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.rootView = linearLayout;
        this.subTitleView = textView;
        this.titleView = textView2;
    }

    public HolderItem getHolderItem() {
        return this.mHolderItem;
    }

    public static ItemSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558926, viewGroup, z, obj);
    }

    public static ItemSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558926, null, false, obj);
    }

    public static ItemSettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSettingBinding bind(View view, Object obj) {
        return (ItemSettingBinding) bind(obj, view, 2131558926);
    }
}
