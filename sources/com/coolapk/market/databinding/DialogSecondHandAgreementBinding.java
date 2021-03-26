package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogSecondHandAgreementBinding extends ViewDataBinding {
    public final TextView cacelView;
    public final TextView contentText;
    @Bindable
    protected boolean mLoading;
    public final ProgressBar progressBar;
    public final LinearLayout rootView;
    public final TextView submitText;
    public final FrameLayout submitView;
    public final TextView titleText;

    public abstract void setLoading(boolean z);

    protected DialogSecondHandAgreementBinding(Object obj, View view, int i, TextView textView, TextView textView2, ProgressBar progressBar2, LinearLayout linearLayout, TextView textView3, FrameLayout frameLayout, TextView textView4) {
        super(obj, view, i);
        this.cacelView = textView;
        this.contentText = textView2;
        this.progressBar = progressBar2;
        this.rootView = linearLayout;
        this.submitText = textView3;
        this.submitView = frameLayout;
        this.titleText = textView4;
    }

    public boolean getLoading() {
        return this.mLoading;
    }

    public static DialogSecondHandAgreementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecondHandAgreementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSecondHandAgreementBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558534, viewGroup, z, obj);
    }

    public static DialogSecondHandAgreementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecondHandAgreementBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSecondHandAgreementBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558534, null, false, obj);
    }

    public static DialogSecondHandAgreementBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecondHandAgreementBinding bind(View view, Object obj) {
        return (DialogSecondHandAgreementBinding) bind(obj, view, 2131558534);
    }
}
