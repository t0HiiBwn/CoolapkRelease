package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.HolderItem;

public abstract class ItemBlackListBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView descriptionView;
    @Bindable
    protected HolderItem mHolder;
    public final SwitchCompat switchView;
    public final TextView titleView;

    public abstract void setHolder(HolderItem holderItem);

    protected ItemBlackListBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.descriptionView = textView;
        this.switchView = switchCompat;
        this.titleView = textView2;
    }

    public HolderItem getHolder() {
        return this.mHolder;
    }

    public static ItemBlackListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlackListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBlackListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558624, viewGroup, z, obj);
    }

    public static ItemBlackListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlackListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBlackListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558624, null, false, obj);
    }

    public static ItemBlackListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBlackListBinding bind(View view, Object obj) {
        return (ItemBlackListBinding) bind(obj, view, 2131558624);
    }
}
