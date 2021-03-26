package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.viewholder.LargeScrollCardItemViewHolder;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemLargeScrollCardItemBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout itemView;
    public final UserAvatarView logoView;
    @Bindable
    protected LargeScrollCardItemViewHolder mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView subTitleView;
    public final TextView titleView;

    public abstract void setModel(LargeScrollCardItemViewHolder largeScrollCardItemViewHolder);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemLargeScrollCardItemBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, UserAvatarView userAvatarView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = linearLayout;
        this.logoView = userAvatarView;
        this.subTitleView = textView2;
        this.titleView = textView3;
    }

    public LargeScrollCardItemViewHolder getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemLargeScrollCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeScrollCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLargeScrollCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558803, viewGroup, z, obj);
    }

    public static ItemLargeScrollCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeScrollCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLargeScrollCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558803, null, false, obj);
    }

    public static ItemLargeScrollCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLargeScrollCardItemBinding bind(View view, Object obj) {
        return (ItemLargeScrollCardItemBinding) bind(obj, view, 2131558803);
    }
}
