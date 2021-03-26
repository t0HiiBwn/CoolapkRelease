package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.RatioImageView;

public abstract class ArticleDetailImagePartBinding extends ViewDataBinding {
    public final TextView descriptionView;
    public final RatioImageView ivCover;
    public final RelativeLayout lvTop;

    protected ArticleDetailImagePartBinding(Object obj, View view, int i, TextView textView, RatioImageView ratioImageView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.descriptionView = textView;
        this.ivCover = ratioImageView;
        this.lvTop = relativeLayout;
    }

    public static ArticleDetailImagePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ArticleDetailImagePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ArticleDetailImagePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558471, viewGroup, z, obj);
    }

    public static ArticleDetailImagePartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ArticleDetailImagePartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ArticleDetailImagePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558471, null, false, obj);
    }

    public static ArticleDetailImagePartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ArticleDetailImagePartBinding bind(View view, Object obj) {
        return (ArticleDetailImagePartBinding) bind(obj, view, 2131558471);
    }
}
