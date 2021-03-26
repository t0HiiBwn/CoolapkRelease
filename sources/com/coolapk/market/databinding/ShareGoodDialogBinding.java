package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedGoods;

public abstract class ShareGoodDialogBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final TextView goodsTitleView;
    public final LinearLayout itemView;
    public final ProgressBar loadingView;
    @Bindable
    protected FeedGoods mModel;
    public final TextView okButton;
    public final TextView subTitleView;
    public final TextView titleView;

    public abstract void setModel(FeedGoods feedGoods);

    protected ShareGoodDialogBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, ProgressBar progressBar, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.contentView = linearLayout;
        this.goodsTitleView = textView2;
        this.itemView = linearLayout2;
        this.loadingView = progressBar;
        this.okButton = textView3;
        this.subTitleView = textView4;
        this.titleView = textView5;
    }

    public FeedGoods getModel() {
        return this.mModel;
    }

    public static ShareGoodDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareGoodDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShareGoodDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559146, viewGroup, z, obj);
    }

    public static ShareGoodDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareGoodDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShareGoodDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559146, null, false, obj);
    }

    public static ShareGoodDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareGoodDialogBinding bind(View view, Object obj) {
        return (ShareGoodDialogBinding) bind(obj, view, 2131559146);
    }
}
