package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSeeMoreBinding extends ViewDataBinding {
    public final TextView actionView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemSeeMoreBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = frameLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemSeeMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSeeMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSeeMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558922, viewGroup, z, obj);
    }

    public static ItemSeeMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSeeMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSeeMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558922, null, false, obj);
    }

    public static ItemSeeMoreBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSeeMoreBinding bind(View view, Object obj) {
        return (ItemSeeMoreBinding) bind(obj, view, 2131558922);
    }
}
