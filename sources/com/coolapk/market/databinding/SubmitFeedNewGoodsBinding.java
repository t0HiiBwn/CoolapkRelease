package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitFeedNewGoodsBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final ImageButton closeView;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView errorView;
    public final LinearLayout loadingView;
    public final TextView okButton;
    public final TextView subTitleView;
    public final TextView titleView;

    protected SubmitFeedNewGoodsBinding(Object obj, View view, int i, TextView textView, ImageButton imageButton, LinearLayout linearLayout, EditText editText2, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.closeView = imageButton;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.errorView = textView2;
        this.loadingView = linearLayout2;
        this.okButton = textView3;
        this.subTitleView = textView4;
        this.titleView = textView5;
    }

    public static SubmitFeedNewGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedNewGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedNewGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559160, viewGroup, z, obj);
    }

    public static SubmitFeedNewGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedNewGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedNewGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559160, null, false, obj);
    }

    public static SubmitFeedNewGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedNewGoodsBinding bind(View view, Object obj) {
        return (SubmitFeedNewGoodsBinding) bind(obj, view, 2131559160);
    }
}
