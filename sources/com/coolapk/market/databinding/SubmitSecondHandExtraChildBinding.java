package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitSecondHandExtraChildBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final TextView descriptionView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    public final CheckedTextView leftLable;
    @Bindable
    protected View.OnClickListener mClick;
    public final CheckedTextView rightLable;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SubmitSecondHandExtraChildBinding(Object obj, View view, int i, ImageView imageView2, TextView textView, ImageView imageView3, LinearLayout linearLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, TextView textView2) {
        super(obj, view, i);
        this.arrowView = imageView2;
        this.descriptionView = textView;
        this.imageView = imageView3;
        this.itemView = linearLayout;
        this.leftLable = checkedTextView;
        this.rightLable = checkedTextView2;
        this.titleView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitSecondHandExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitSecondHandExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitSecondHandExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559178, viewGroup, z, obj);
    }

    public static SubmitSecondHandExtraChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitSecondHandExtraChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitSecondHandExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559178, null, false, obj);
    }

    public static SubmitSecondHandExtraChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitSecondHandExtraChildBinding bind(View view, Object obj) {
        return (SubmitSecondHandExtraChildBinding) bind(obj, view, 2131559178);
    }
}
