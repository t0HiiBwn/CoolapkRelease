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

public abstract class ItemColorfulFatScrollCardChildBinding extends ViewDataBinding {
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemColorfulFatScrollCardChildBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.iconView = imageView;
        this.infoView = textView;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemColorfulFatScrollCardChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemColorfulFatScrollCardChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemColorfulFatScrollCardChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558657, viewGroup, z, obj);
    }

    public static ItemColorfulFatScrollCardChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemColorfulFatScrollCardChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemColorfulFatScrollCardChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558657, null, false, obj);
    }

    public static ItemColorfulFatScrollCardChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemColorfulFatScrollCardChildBinding bind(View view, Object obj) {
        return (ItemColorfulFatScrollCardChildBinding) bind(obj, view, 2131558657);
    }
}
