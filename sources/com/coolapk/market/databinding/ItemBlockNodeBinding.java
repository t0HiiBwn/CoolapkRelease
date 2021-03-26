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

public abstract class ItemBlockNodeBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected BlockItem mModel;
    public final TextView tagView;
    public final TextView titleView;

    public abstract void setModel(BlockItem blockItem);

    protected ItemBlockNodeBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionButton = textView;
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.tagView = textView2;
        this.titleView = textView3;
    }

    public BlockItem getModel() {
        return this.mModel;
    }

    public static ItemBlockNodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockNodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBlockNodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558631, viewGroup, z, obj);
    }

    public static ItemBlockNodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockNodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBlockNodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558631, null, false, obj);
    }

    public static ItemBlockNodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockNodeBinding bind(View view, Object obj) {
        return (ItemBlockNodeBinding) bind(obj, view, 2131558631);
    }
}
