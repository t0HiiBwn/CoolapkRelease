package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.LinearAdapterLayout;

public abstract class ItemProductSeriesBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final LinearAdapterLayout linearAdapterView;
    @Bindable
    protected Entity mCard;

    public abstract void setCard(Entity entity);

    protected ItemProductSeriesBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearAdapterLayout linearAdapterLayout) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.linearAdapterView = linearAdapterLayout;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemProductSeriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558872, viewGroup, z, obj);
    }

    public static ItemProductSeriesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558872, null, false, obj);
    }

    public static ItemProductSeriesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesBinding bind(View view, Object obj) {
        return (ItemProductSeriesBinding) bind(obj, view, 2131558872);
    }
}
