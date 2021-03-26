package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemIconMiniGridCardItemBinding extends ViewDataBinding {
    public final ImageView imageView1;
    public final ImageView imageView2;
    public final LinearLayout itemView1;
    public final LinearLayout itemView2;
    @Bindable
    protected Entity mEntity1;
    @Bindable
    protected Entity mEntity2;

    public abstract void setEntity1(Entity entity);

    public abstract void setEntity2(Entity entity);

    protected ItemIconMiniGridCardItemBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.imageView1 = imageView;
        this.imageView2 = imageView3;
        this.itemView1 = linearLayout;
        this.itemView2 = linearLayout2;
    }

    public Entity getEntity1() {
        return this.mEntity1;
    }

    public Entity getEntity2() {
        return this.mEntity2;
    }

    public static ItemIconMiniGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconMiniGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconMiniGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558783, viewGroup, z, obj);
    }

    public static ItemIconMiniGridCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconMiniGridCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconMiniGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558783, null, false, obj);
    }

    public static ItemIconMiniGridCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconMiniGridCardItemBinding bind(View view, Object obj) {
        return (ItemIconMiniGridCardItemBinding) bind(obj, view, 2131558783);
    }
}
