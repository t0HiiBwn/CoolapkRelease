package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogSecondHandPriceBinding extends ViewDataBinding {
    public final TextView cacelView;
    public final RadioButton dealTypeBtn;
    public final LinearLayout dealTypeLayout;
    public final EditText editText;
    public final EditText faceDealEdit;
    @Bindable
    protected boolean mLoading;
    public final EditText moneyMe;
    public final RadioButton moneyMeBtn;
    public final LinearLayout moneyMeLayout;
    public final EditText moneyYou;
    public final RadioButton moneyYouBtn;
    public final LinearLayout moneyYouLayout;
    public final RadioButton normalPriceBtn;
    public final LinearLayout normalPriceView;
    public final ProgressBar progressBar;
    public final TextView submitView;
    public final TextView titleView;

    public abstract void setLoading(boolean z);

    protected DialogSecondHandPriceBinding(Object obj, View view, int i, TextView textView, RadioButton radioButton, LinearLayout linearLayout, EditText editText2, EditText editText3, EditText editText4, RadioButton radioButton2, LinearLayout linearLayout2, EditText editText5, RadioButton radioButton3, LinearLayout linearLayout3, RadioButton radioButton4, LinearLayout linearLayout4, ProgressBar progressBar2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cacelView = textView;
        this.dealTypeBtn = radioButton;
        this.dealTypeLayout = linearLayout;
        this.editText = editText2;
        this.faceDealEdit = editText3;
        this.moneyMe = editText4;
        this.moneyMeBtn = radioButton2;
        this.moneyMeLayout = linearLayout2;
        this.moneyYou = editText5;
        this.moneyYouBtn = radioButton3;
        this.moneyYouLayout = linearLayout3;
        this.normalPriceBtn = radioButton4;
        this.normalPriceView = linearLayout4;
        this.progressBar = progressBar2;
        this.submitView = textView2;
        this.titleView = textView3;
    }

    public boolean getLoading() {
        return this.mLoading;
    }

    public static DialogSecondHandPriceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecondHandPriceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSecondHandPriceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558534, viewGroup, z, obj);
    }

    public static DialogSecondHandPriceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecondHandPriceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSecondHandPriceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558534, null, false, obj);
    }

    public static DialogSecondHandPriceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecondHandPriceBinding bind(View view, Object obj) {
        return (DialogSecondHandPriceBinding) bind(obj, view, 2131558534);
    }
}
