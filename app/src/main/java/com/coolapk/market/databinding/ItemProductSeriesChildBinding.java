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

public abstract class ItemProductSeriesChildBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final LinearLayout itemView;
    @Bindable
    protected Entity mCard;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setCard(Entity entity);

    protected ItemProductSeriesChildBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.arrowView = imageView;
        this.itemView = linearLayout;
        this.subtitleView = textView;
        this.titleView = textView2;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemProductSeriesChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558873, viewGroup, z, obj);
    }

    public static ItemProductSeriesChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558873, null, false, obj);
    }

    public static ItemProductSeriesChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesChildBinding bind(View view, Object obj) {
        return (ItemProductSeriesChildBinding) bind(obj, view, 2131558873);
    }
}
