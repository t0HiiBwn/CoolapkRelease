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
import com.coolapk.market.viewholder.CardDoubleViewHolder;

public abstract class ItemCardDoubleItemBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ImageView iconView;
    public final TextView infoView;
    @Bindable
    protected CardDoubleViewHolder.ChildItemViewModel mViewModel;
    public final LinearLayout strokeView;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setViewModel(CardDoubleViewHolder.ChildItemViewModel childItemViewModel);

    protected ItemCardDoubleItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.iconView = imageView;
        this.infoView = textView2;
        this.strokeView = linearLayout;
        this.subtitleView = textView3;
        this.titleView = textView4;
    }

    public CardDoubleViewHolder.ChildItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemCardDoubleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardDoubleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardDoubleItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558637, viewGroup, z, obj);
    }

    public static ItemCardDoubleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardDoubleItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardDoubleItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558637, null, false, obj);
    }

    public static ItemCardDoubleItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardDoubleItemBinding bind(View view, Object obj) {
        return (ItemCardDoubleItemBinding) bind(obj, view, 2131558637);
    }
}
