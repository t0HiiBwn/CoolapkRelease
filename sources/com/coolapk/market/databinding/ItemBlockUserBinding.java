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
import com.coolapk.market.view.block.BlockItem;

public abstract class ItemBlockUserBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected BlockItem mModel;
    public final TextView titleView;

    public abstract void setModel(BlockItem blockItem);

    protected ItemBlockUserBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.actionButton = textView;
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.titleView = textView2;
    }

    public BlockItem getModel() {
        return this.mModel;
    }

    public static ItemBlockUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBlockUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558627, viewGroup, z, obj);
    }

    public static ItemBlockUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBlockUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558627, null, false, obj);
    }

    public static ItemBlockUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockUserBinding bind(View view, Object obj) {
        return (ItemBlockUserBinding) bind(obj, view, 2131558627);
    }
}
