package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitFeedArticleBottomBinding extends ViewDataBinding {
    public final LinearLayout itemView;

    protected SubmitFeedArticleBottomBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.itemView = linearLayout;
    }

    public static SubmitFeedArticleBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedArticleBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559149, viewGroup, z, obj);
    }

    public static SubmitFeedArticleBottomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleBottomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedArticleBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559149, null, false, obj);
    }

    public static SubmitFeedArticleBottomBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleBottomBinding bind(View view, Object obj) {
        return (SubmitFeedArticleBottomBinding) bind(obj, view, 2131559149);
    }
}
