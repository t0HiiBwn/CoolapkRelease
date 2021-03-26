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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;

public abstract class ItemSimpleEntityHolderBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    public final LinearLayout rootView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    protected ItemSimpleEntityHolderBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView;
        this.logoView = imageView;
        this.rootView = linearLayout;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemSimpleEntityHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleEntityHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSimpleEntityHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558929, viewGroup, z, obj);
    }

    public static ItemSimpleEntityHolderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleEntityHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSimpleEntityHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558929, null, false, obj);
    }

    public static ItemSimpleEntityHolderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleEntityHolderBinding bind(View view, Object obj) {
        return (ItemSimpleEntityHolderBinding) bind(obj, view, 2131558929);
    }
}
