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

public abstract class SubmitFeedExtraLogoBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SubmitFeedExtraLogoBinding(Object obj, View view, int i, ImageView imageView2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.itemView = linearLayout;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedExtraLogoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedExtraLogoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedExtraLogoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559166, viewGroup, z, obj);
    }

    public static SubmitFeedExtraLogoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedExtraLogoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedExtraLogoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559166, null, false, obj);
    }

    public static SubmitFeedExtraLogoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedExtraLogoBinding bind(View view, Object obj) {
        return (SubmitFeedExtraLogoBinding) bind(obj, view, 2131559166);
    }
}
