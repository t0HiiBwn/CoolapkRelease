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
import com.coolapk.market.model.ItemModel;

public abstract class ItemShareAppBinding extends ViewDataBinding {
    public final ImageView iconView;
    @Bindable
    protected ItemModel mModel;
    public final LinearLayout rootView;
    public final TextView titleView;

    public abstract void setModel(ItemModel itemModel);

    protected ItemShareAppBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.iconView = imageView;
        this.rootView = linearLayout;
        this.titleView = textView;
    }

    public ItemModel getModel() {
        return this.mModel;
    }

    public static ItemShareAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemShareAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemShareAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558934, viewGroup, z, obj);
    }

    public static ItemShareAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemShareAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemShareAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558934, null, false, obj);
    }

    public static ItemShareAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemShareAppBinding bind(View view, Object obj) {
        return (ItemShareAppBinding) bind(obj, view, 2131558934);
    }
}
