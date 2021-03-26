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

public abstract class SubmitFeedRelativeInfoPickerBinding extends ViewDataBinding {
    public final ImageView addImageView;
    public final LinearLayout addRelativeView;
    public final ImageView closeView;
    public final ImageView imageView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout relativeView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SubmitFeedRelativeInfoPickerBinding(Object obj, View view, int i, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.addImageView = imageView2;
        this.addRelativeView = linearLayout;
        this.closeView = imageView3;
        this.imageView = imageView4;
        this.relativeView = linearLayout2;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedRelativeInfoPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedRelativeInfoPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedRelativeInfoPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559169, viewGroup, z, obj);
    }

    public static SubmitFeedRelativeInfoPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedRelativeInfoPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedRelativeInfoPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559169, null, false, obj);
    }

    public static SubmitFeedRelativeInfoPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedRelativeInfoPickerBinding bind(View view, Object obj) {
        return (SubmitFeedRelativeInfoPickerBinding) bind(obj, view, 2131559169);
    }
}
