package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitProductArticleBottomBinding extends ViewDataBinding {
    public final LinearLayout itemView;

    protected SubmitProductArticleBottomBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.itemView = linearLayout;
    }

    public static SubmitProductArticleBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductArticleBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitProductArticleBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559172, viewGroup, z, obj);
    }

    public static SubmitProductArticleBottomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductArticleBottomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitProductArticleBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559172, null, false, obj);
    }

    public static SubmitProductArticleBottomBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductArticleBottomBinding bind(View view, Object obj) {
        return (SubmitProductArticleBottomBinding) bind(obj, view, 2131559172);
    }
}
