package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemEmptyViewBinding extends ViewDataBinding {
    public final TextView etTitle;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemEmptyViewBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.etTitle = textView;
        this.rootView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemEmptyViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmptyViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemEmptyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558687, viewGroup, z, obj);
    }

    public static ItemEmptyViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmptyViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemEmptyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558687, null, false, obj);
    }

    public static ItemEmptyViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmptyViewBinding bind(View view, Object obj) {
        return (ItemEmptyViewBinding) bind(obj, view, 2131558687);
    }
}
