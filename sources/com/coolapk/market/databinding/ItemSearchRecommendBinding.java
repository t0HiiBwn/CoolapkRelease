package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchRecommendBinding extends ViewDataBinding {
    public final ImageView iconView;
    @Bindable
    protected String mText;
    public final TextView textView;

    public abstract void setText(String str);

    protected ItemSearchRecommendBinding(Object obj, View view, int i, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.iconView = imageView;
        this.textView = textView2;
    }

    public String getText() {
        return this.mText;
    }

    public static ItemSearchRecommendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchRecommendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchRecommendBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558921, viewGroup, z, obj);
    }

    public static ItemSearchRecommendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchRecommendBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchRecommendBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558921, null, false, obj);
    }

    public static ItemSearchRecommendBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchRecommendBinding bind(View view, Object obj) {
        return (ItemSearchRecommendBinding) bind(obj, view, 2131558921);
    }
}
