package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;

public abstract class ItemTextCardBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final View dividerView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemTextCardBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView, View view2, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView;
        this.dividerView = view2;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemTextCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558954, viewGroup, z, obj);
    }

    public static ItemTextCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558954, null, false, obj);
    }

    public static ItemTextCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextCardBinding bind(View view, Object obj) {
        return (ItemTextCardBinding) bind(obj, view, 2131558954);
    }
}
