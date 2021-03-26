package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ArticleDetailTextPartBinding extends ViewDataBinding {
    public final TextView etTitle;
    public final LinearLayout lvTop;
    public final View quoteView;

    protected ArticleDetailTextPartBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, View view2) {
        super(obj, view, i);
        this.etTitle = textView;
        this.lvTop = linearLayout;
        this.quoteView = view2;
    }

    public static ArticleDetailTextPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ArticleDetailTextPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ArticleDetailTextPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558472, viewGroup, z, obj);
    }

    public static ArticleDetailTextPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ArticleDetailTextPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ArticleDetailTextPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558472, null, false, obj);
    }

    public static ArticleDetailTextPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ArticleDetailTextPartBinding bind(View view, Object obj) {
        return (ArticleDetailTextPartBinding) bind(obj, view, 2131558472);
    }
}
