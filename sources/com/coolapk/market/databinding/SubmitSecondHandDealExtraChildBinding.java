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

public abstract class SubmitSecondHandDealExtraChildBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final TextView descriptionView;
    public final ImageView imageView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final CheckedTextView switchCenter;
    public final LinearLayout switchContainer;
    public final CheckedTextView switchLeft;
    public final CheckedTextView switchRight;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SubmitSecondHandDealExtraChildBinding(Object obj, View view, int i, ImageView imageView2, TextView textView, ImageView imageView3, LinearLayout linearLayout, CheckedTextView checkedTextView, LinearLayout linearLayout2, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, TextView textView2) {
        super(obj, view, i);
        this.arrowView = imageView2;
        this.descriptionView = textView;
        this.imageView = imageView3;
        this.itemView = linearLayout;
        this.switchCenter = checkedTextView;
        this.switchContainer = linearLayout2;
        this.switchLeft = checkedTextView2;
        this.switchRight = checkedTextView3;
        this.titleView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitSecondHandDealExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitSecondHandDealExtraChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitSecondHandDealExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559177, viewGroup, z, obj);
    }

    public static SubmitSecondHandDealExtraChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitSecondHandDealExtraChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitSecondHandDealExtraChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559177, null, false, obj);
    }

    public static SubmitSecondHandDealExtraChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitSecondHandDealExtraChildBinding bind(View view, Object obj) {
        return (SubmitSecondHandDealExtraChildBinding) bind(obj, view, 2131559177);
    }
}
