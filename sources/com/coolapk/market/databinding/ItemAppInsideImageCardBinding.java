package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.viewholder.EntityItemModel;
import com.coolapk.market.widget.ActionButton;

public abstract class ItemAppInsideImageCardBinding extends ViewDataBinding {
    public final ImageView actionArrow;
    public final ActionButton actionContainer;
    public final ImageView iconView;
    @Bindable
    protected EntityItemModel mModel;
    public final TextView marketInfoView;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setModel(EntityItemModel entityItemModel);

    protected ItemAppInsideImageCardBinding(Object obj, View view, int i, ImageView imageView, ActionButton actionButton, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionArrow = imageView;
        this.actionContainer = actionButton;
        this.iconView = imageView2;
        this.marketInfoView = textView;
        this.subtitleView = textView2;
        this.titleView = textView3;
    }

    public EntityItemModel getModel() {
        return this.mModel;
    }

    public static ItemAppInsideImageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppInsideImageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppInsideImageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558596, viewGroup, z, obj);
    }

    public static ItemAppInsideImageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppInsideImageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppInsideImageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558596, null, false, obj);
    }

    public static ItemAppInsideImageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppInsideImageCardBinding bind(View view, Object obj) {
        return (ItemAppInsideImageCardBinding) bind(obj, view, 2131558596);
    }
}
