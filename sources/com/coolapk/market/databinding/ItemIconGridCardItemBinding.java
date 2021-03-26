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
import com.coolapk.market.viewholder.IconGridCardItemViewHolder;

public abstract class ItemIconGridCardItemBinding extends ViewDataBinding {
    public final TextView actionView;
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected IconGridCardItemViewHolder mModel;
    @Bindable
    protected Integer mPlaceHolder;
    public final TextView titleView;

    public abstract void setModel(IconGridCardItemViewHolder iconGridCardItemViewHolder);

    public abstract void setPlaceHolder(Integer num);

    protected ItemIconGridCardItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.iconView = imageView;
        this.infoView = textView2;
        this.itemView = linearLayout;
        this.titleView = textView3;
    }

    public IconGridCardItemViewHolder getModel() {
        return this.mModel;
    }

    public Integer getPlaceHolder() {
        return this.mPlaceHolder;
    }

    public static ItemIconGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558785, viewGroup, z, obj);
    }

    public static ItemIconGridCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconGridCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558785, null, false, obj);
    }

    public static ItemIconGridCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconGridCardItemBinding bind(View view, Object obj) {
        return (ItemIconGridCardItemBinding) bind(obj, view, 2131558785);
    }
}
