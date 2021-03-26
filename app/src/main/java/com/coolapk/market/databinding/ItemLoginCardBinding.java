package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemLoginCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final TextView loginView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mTitle;
    public final TextView regiestView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTitle(String str);

    protected ItemLoginCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.loginView = textView;
        this.regiestView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemLoginCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLoginCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558815, viewGroup, z, obj);
    }

    public static ItemLoginCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLoginCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558815, null, false, obj);
    }

    public static ItemLoginCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLoginCardBinding bind(View view, Object obj) {
        return (ItemLoginCardBinding) bind(obj, view, 2131558815);
    }
}
