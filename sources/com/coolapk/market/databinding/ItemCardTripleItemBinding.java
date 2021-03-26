package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.viewholder.CardTripleViewHolder;

public abstract class ItemCardTripleItemBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ImageView iconView;
    public final TextView infoView;
    @Bindable
    protected CardTripleViewHolder.ChildItemViewModel mViewModel;
    public final TextView titleView;

    public abstract void setViewModel(CardTripleViewHolder.ChildItemViewModel childItemViewModel);

    protected ItemCardTripleItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionButton = textView;
        this.iconView = imageView;
        this.infoView = textView2;
        this.titleView = textView3;
    }

    public CardTripleViewHolder.ChildItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemCardTripleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardTripleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardTripleItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558635, viewGroup, z, obj);
    }

    public static ItemCardTripleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardTripleItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardTripleItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558635, null, false, obj);
    }

    public static ItemCardTripleItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardTripleItemBinding bind(View view, Object obj) {
        return (ItemCardTripleItemBinding) bind(obj, view, 2131558635);
    }
}
