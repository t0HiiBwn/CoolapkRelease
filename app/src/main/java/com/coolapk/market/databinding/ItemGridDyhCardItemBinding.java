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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public abstract class ItemGridDyhCardItemBinding extends ViewDataBinding {
    public final TextView actionText;
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected DyhViewModel mViewModel;
    public final LinearLayout strokeView;
    public final TextView titleView;

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(DyhViewModel dyhViewModel);

    protected ItemGridDyhCardItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, i);
        this.actionText = textView;
        this.iconView = imageView;
        this.infoView = textView2;
        this.itemView = linearLayout;
        this.strokeView = linearLayout2;
        this.titleView = textView3;
    }

    public DyhViewModel getViewModel() {
        return this.mViewModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemGridDyhCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridDyhCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridDyhCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558769, viewGroup, z, obj);
    }

    public static ItemGridDyhCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridDyhCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridDyhCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558769, null, false, obj);
    }

    public static ItemGridDyhCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridDyhCardItemBinding bind(View view, Object obj) {
        return (ItemGridDyhCardItemBinding) bind(obj, view, 2131558769);
    }
}
