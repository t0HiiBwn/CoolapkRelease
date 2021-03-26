package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FeedTopBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout topContainer;
    public final ImageView topImageView;
    public final TextView topTextView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedTopBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.topContainer = linearLayout;
        this.topImageView = imageView;
        this.topTextView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558562, viewGroup, z, obj);
    }

    public static FeedTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558562, null, false, obj);
    }

    public static FeedTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedTopBinding bind(View view, Object obj) {
        return (FeedTopBinding) bind(obj, view, 2131558562);
    }
}
