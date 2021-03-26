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
import com.coolapk.market.widget.TypeSwitchView;

public abstract class SecondHandExtraChildBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final TextView descriptionView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;
    public final TypeSwitchView typeSwitch;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SecondHandExtraChildBinding(Object obj, View view, int i, ImageView imageView2, TextView textView, ImageView imageView3, LinearLayout linearLayout, TextView textView2, TypeSwitchView typeSwitchView) {
        super(obj, view, i);
        this.arrowView = imageView2;
        this.descriptionView = textView;
        this.imageView = imageView3;
        this.itemView = linearLayout;
        this.titleView = textView2;
        this.typeSwitch = typeSwitchView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SecondHandExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SecondHandExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559134, viewGroup, z, obj);
    }

    public static SecondHandExtraChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandExtraChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SecondHandExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559134, null, false, obj);
    }

    public static SecondHandExtraChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandExtraChildBinding bind(View view, Object obj) {
        return (SecondHandExtraChildBinding) bind(obj, view, 2131559134);
    }
}
