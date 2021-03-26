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

public abstract class ItemSortSelectBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected Entity mModel;
    public final TextView selectTextView;
    public final LinearLayout selectView;
    public final TextView titleView;

    public abstract void setModel(Entity entity);

    protected ItemSortSelectBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.selectTextView = textView;
        this.selectView = linearLayout2;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public static ItemSortSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSortSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSortSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558936, viewGroup, z, obj);
    }

    public static ItemSortSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSortSelectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSortSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558936, null, false, obj);
    }

    public static ItemSortSelectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSortSelectBinding bind(View view, Object obj) {
        return (ItemSortSelectBinding) bind(obj, view, 2131558936);
    }
}
