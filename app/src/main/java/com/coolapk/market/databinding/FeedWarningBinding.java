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

public abstract class FeedWarningBinding extends ViewDataBinding {
    public final ImageView alertImageView;
    public final TextView alertTextView;
    public final LinearLayout alertView;
    public final ImageView closeAlertView;
    @Bindable
    protected View.OnClickListener mClick;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedWarningBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView2) {
        super(obj, view, i);
        this.alertImageView = imageView;
        this.alertTextView = textView;
        this.alertView = linearLayout;
        this.closeAlertView = imageView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedWarningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedWarningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedWarningBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558563, viewGroup, z, obj);
    }

    public static FeedWarningBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedWarningBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedWarningBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558563, null, false, obj);
    }

    public static FeedWarningBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedWarningBinding bind(View view, Object obj) {
        return (FeedWarningBinding) bind(obj, view, 2131558563);
    }
}
