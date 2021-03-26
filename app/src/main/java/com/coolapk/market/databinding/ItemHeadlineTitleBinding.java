package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemHeadlineTitleBinding extends ViewDataBinding {
    public final TextView refreshTextView;
    public final ImageView refreshView;
    public final ImageView upView;

    protected ItemHeadlineTitleBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.refreshTextView = textView;
        this.refreshView = imageView;
        this.upView = imageView2;
    }

    public static ItemHeadlineTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeadlineTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHeadlineTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558773, viewGroup, z, obj);
    }

    public static ItemHeadlineTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeadlineTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHeadlineTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558773, null, false, obj);
    }

    public static ItemHeadlineTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeadlineTitleBinding bind(View view, Object obj) {
        return (ItemHeadlineTitleBinding) bind(obj, view, 2131558773);
    }
}
