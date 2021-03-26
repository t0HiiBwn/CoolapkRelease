package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.block.BlockItem;

public abstract class ItemBlockWordBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final LinearLayout cardView;
    @Bindable
    protected BlockItem mModel;
    public final TextView titleView;

    public abstract void setModel(BlockItem blockItem);

    protected ItemBlockWordBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.actionButton = textView;
        this.cardView = linearLayout;
        this.titleView = textView2;
    }

    public BlockItem getModel() {
        return this.mModel;
    }

    public static ItemBlockWordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockWordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBlockWordBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558628, viewGroup, z, obj);
    }

    public static ItemBlockWordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockWordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBlockWordBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558628, null, false, obj);
    }

    public static ItemBlockWordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlockWordBinding bind(View view, Object obj) {
        return (ItemBlockWordBinding) bind(obj, view, 2131558628);
    }
}
