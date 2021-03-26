package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemMessageExtraBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected Entity mEntity;
    public final Space marginView;
    public final TextView titleView;

    public abstract void setEntity(Entity entity);

    protected ItemMessageExtraBinding(Object obj, View view, int i, LinearLayout linearLayout, Space space, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.marginView = space;
        this.titleView = textView;
    }

    public Entity getEntity() {
        return this.mEntity;
    }

    public static ItemMessageExtraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageExtraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMessageExtraBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558826, viewGroup, z, obj);
    }

    public static ItemMessageExtraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageExtraBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMessageExtraBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558826, null, false, obj);
    }

    public static ItemMessageExtraBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageExtraBinding bind(View view, Object obj) {
        return (ItemMessageExtraBinding) bind(obj, view, 2131558826);
    }
}
