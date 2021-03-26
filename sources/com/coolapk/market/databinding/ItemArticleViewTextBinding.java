package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemArticleViewTextBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView etTitle;
    public final Space relativeSpaceView;

    protected ItemArticleViewTextBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, Space space) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.etTitle = textView;
        this.relativeSpaceView = space;
    }

    public static ItemArticleViewTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleViewTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleViewTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558617, viewGroup, z, obj);
    }

    public static ItemArticleViewTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleViewTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleViewTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558617, null, false, obj);
    }

    public static ItemArticleViewTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleViewTextBinding bind(View view, Object obj) {
        return (ItemArticleViewTextBinding) bind(obj, view, 2131558617);
    }
}
