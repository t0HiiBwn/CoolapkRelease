package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AddGoodsItemDialogBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final LinearLayout goodsLayout;
    public final ProgressBar loadingView;
    public final ImageView logoView;
    @Bindable
    protected String mDialogTitle;
    @Bindable
    protected String mLogo;
    @Bindable
    protected String mSubTitle;
    @Bindable
    protected String mTitle;
    public final TextView okButton;
    public final TextView textView;
    public final TextView titleView;

    public abstract void setDialogTitle(String str);

    public abstract void setLogo(String str);

    public abstract void setSubTitle(String str);

    public abstract void setTitle(String str);

    protected AddGoodsItemDialogBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, EditText editText2, LinearLayout linearLayout2, ProgressBar progressBar, ImageView imageView, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.cancelButton = textView2;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.goodsLayout = linearLayout2;
        this.loadingView = progressBar;
        this.logoView = imageView;
        this.okButton = textView3;
        this.textView = textView4;
        this.titleView = textView5;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getDialogTitle() {
        return this.mDialogTitle;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static AddGoodsItemDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddGoodsItemDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AddGoodsItemDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558437, viewGroup, z, obj);
    }

    public static AddGoodsItemDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddGoodsItemDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AddGoodsItemDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558437, null, false, obj);
    }

    public static AddGoodsItemDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddGoodsItemDialogBinding bind(View view, Object obj) {
        return (AddGoodsItemDialogBinding) bind(obj, view, 2131558437);
    }
}
