package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemMyEmptyCardBinding extends ViewDataBinding {
    public final ImageView bgView;
    public final CoolapkCardView coolapkCardView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemMyEmptyCardBinding(Object obj, View view, int i, ImageView imageView, CoolapkCardView coolapkCardView2, TextView textView) {
        super(obj, view, i);
        this.bgView = imageView;
        this.coolapkCardView = coolapkCardView2;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemMyEmptyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMyEmptyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMyEmptyCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558839, viewGroup, z, obj);
    }

    public static ItemMyEmptyCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMyEmptyCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMyEmptyCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558839, null, false, obj);
    }

    public static ItemMyEmptyCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMyEmptyCardBinding bind(View view, Object obj) {
        return (ItemMyEmptyCardBinding) bind(obj, view, 2131558839);
    }
}
