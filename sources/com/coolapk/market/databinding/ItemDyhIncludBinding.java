package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public abstract class ItemDyhIncludBinding extends ViewDataBinding {
    public final CheckBox checkBox;
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final TextView editStatusView;
    public final TextView editTypeView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected DyhViewModel mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(DyhViewModel dyhViewModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemDyhIncludBinding(Object obj, View view, int i, CheckBox checkBox2, CoolapkCardView coolapkCardView2, TextView textView, TextView textView2, TextView textView3, ImageView imageView, LinearLayout linearLayout, TextView textView4) {
        super(obj, view, i);
        this.checkBox = checkBox2;
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView;
        this.editStatusView = textView2;
        this.editTypeView = textView3;
        this.logoView = imageView;
        this.rootView = linearLayout;
        this.titleView = textView4;
    }

    public DyhViewModel getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemDyhIncludBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhIncludBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhIncludBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558686, viewGroup, z, obj);
    }

    public static ItemDyhIncludBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhIncludBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhIncludBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558686, null, false, obj);
    }

    public static ItemDyhIncludBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhIncludBinding bind(View view, Object obj) {
        return (ItemDyhIncludBinding) bind(obj, view, 2131558686);
    }
}
