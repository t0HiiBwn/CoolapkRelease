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
import com.coolapk.market.model.Entity;

public abstract class ItemIconLinkGridCardItemBinding extends ViewDataBinding {
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected Entity mEntity;
    public final TextView titleView;

    public abstract void setEntity(Entity entity);

    protected ItemIconLinkGridCardItemBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.iconView = imageView;
        this.itemView = linearLayout;
        this.titleView = textView;
    }

    public Entity getEntity() {
        return this.mEntity;
    }

    public static ItemIconLinkGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconLinkGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconLinkGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558780, viewGroup, z, obj);
    }

    public static ItemIconLinkGridCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconLinkGridCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconLinkGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558780, null, false, obj);
    }

    public static ItemIconLinkGridCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconLinkGridCardItemBinding bind(View view, Object obj) {
        return (ItemIconLinkGridCardItemBinding) bind(obj, view, 2131558780);
    }
}
