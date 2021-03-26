package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FeedBlockItemsBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedBlockItemsBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedBlockItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedBlockItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedBlockItemsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558554, viewGroup, z, obj);
    }

    public static FeedBlockItemsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedBlockItemsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedBlockItemsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558554, null, false, obj);
    }

    public static FeedBlockItemsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedBlockItemsBinding bind(View view, Object obj) {
        return (FeedBlockItemsBinding) bind(obj, view, 2131558554);
    }
}
