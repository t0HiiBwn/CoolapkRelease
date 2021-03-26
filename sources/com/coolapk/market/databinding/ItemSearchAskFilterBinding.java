package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchAskFilterBinding extends ViewDataBinding {
    public final RadioButton feedTypeAll;
    public final RadioButton feedTypeAnswer;
    public final RadioButton feedTypeQuestion;
    public final RadioGroup radioGroup;

    protected ItemSearchAskFilterBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup2) {
        super(obj, view, i);
        this.feedTypeAll = radioButton;
        this.feedTypeAnswer = radioButton2;
        this.feedTypeQuestion = radioButton3;
        this.radioGroup = radioGroup2;
    }

    public static ItemSearchAskFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchAskFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchAskFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558913, viewGroup, z, obj);
    }

    public static ItemSearchAskFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchAskFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchAskFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558913, null, false, obj);
    }

    public static ItemSearchAskFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchAskFilterBinding bind(View view, Object obj) {
        return (ItemSearchAskFilterBinding) bind(obj, view, 2131558913);
    }
}
