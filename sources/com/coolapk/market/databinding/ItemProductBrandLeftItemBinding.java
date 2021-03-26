package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemProductBrandLeftItemBinding extends ViewDataBinding {
    public final View indicatorView;
    public final FrameLayout itemView;
    @Bindable
    protected Entity mCard;
    public final TextView titleView;

    public abstract void setCard(Entity entity);

    protected ItemProductBrandLeftItemBinding(Object obj, View view, int i, View view2, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i);
        this.indicatorView = view2;
        this.itemView = frameLayout;
        this.titleView = textView;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemProductBrandLeftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBrandLeftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductBrandLeftItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558868, viewGroup, z, obj);
    }

    public static ItemProductBrandLeftItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBrandLeftItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductBrandLeftItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558868, null, false, obj);
    }

    public static ItemProductBrandLeftItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductBrandLeftItemBinding bind(View view, Object obj) {
        return (ItemProductBrandLeftItemBinding) bind(obj, view, 2131558868);
    }
}
