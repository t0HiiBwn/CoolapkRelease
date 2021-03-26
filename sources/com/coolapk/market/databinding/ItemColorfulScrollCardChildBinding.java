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

public abstract class ItemColorfulScrollCardChildBinding extends ViewDataBinding {
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

    protected ItemColorfulScrollCardChildBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2) {
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

    public static ItemColorfulScrollCardChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemColorfulScrollCardChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemColorfulScrollCardChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558664, viewGroup, z, obj);
    }

    public static ItemColorfulScrollCardChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemColorfulScrollCardChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemColorfulScrollCardChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558664, null, false, obj);
    }

    public static ItemColorfulScrollCardChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemColorfulScrollCardChildBinding bind(View view, Object obj) {
        return (ItemColorfulScrollCardChildBinding) bind(obj, view, 2131558664);
    }
}
