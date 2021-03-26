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

public abstract class SubmitFeedExtraChildBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final TextView descriptionView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SubmitFeedExtraChildBinding(Object obj, View view, int i, ImageView imageView2, TextView textView, ImageView imageView3, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.arrowView = imageView2;
        this.descriptionView = textView;
        this.imageView = imageView3;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559165, viewGroup, z, obj);
    }

    public static SubmitFeedExtraChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedExtraChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559165, null, false, obj);
    }

    public static SubmitFeedExtraChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedExtraChildBinding bind(View view, Object obj) {
        return (SubmitFeedExtraChildBinding) bind(obj, view, 2131559165);
    }
}
