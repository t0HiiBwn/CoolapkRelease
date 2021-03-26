package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;

public abstract class ItemSearchHotBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    @Bindable
    protected Entity mEntity;
    public final TextView textView;

    public abstract void setEntity(Entity entity);

    protected ItemSearchHotBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.textView = textView2;
    }

    public Entity getEntity() {
        return this.mEntity;
    }

    public static ItemSearchHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchHotBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558913, viewGroup, z, obj);
    }

    public static ItemSearchHotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchHotBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchHotBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558913, null, false, obj);
    }

    public static ItemSearchHotBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchHotBinding bind(View view, Object obj) {
        return (ItemSearchHotBinding) bind(obj, view, 2131558913);
    }
}
