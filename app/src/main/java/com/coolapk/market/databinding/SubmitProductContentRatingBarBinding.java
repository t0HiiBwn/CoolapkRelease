package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitProductContentRatingBarBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    public final RatingBar ratingBar;
    public final TextView ratingScoreView;
    public final TextView ratingTextView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected SubmitProductContentRatingBarBinding(Object obj, View view, int i, RatingBar ratingBar2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ratingBar = ratingBar2;
        this.ratingScoreView = textView;
        this.ratingTextView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitProductContentRatingBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductContentRatingBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitProductContentRatingBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559166, viewGroup, z, obj);
    }

    public static SubmitProductContentRatingBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductContentRatingBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitProductContentRatingBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559166, null, false, obj);
    }

    public static SubmitProductContentRatingBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductContentRatingBarBinding bind(View view, Object obj) {
        return (SubmitProductContentRatingBarBinding) bind(obj, view, 2131559166);
    }
}
