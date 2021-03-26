package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AppMainModelSelectBinding extends ViewDataBinding {
    public final ImageView imageMarket;
    public final ImageView imageSocial;
    public final RadioGroup radioGroup;
    public final RadioButton radioMarket;
    public final RadioButton radioSocial;

    protected AppMainModelSelectBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RadioGroup radioGroup2, RadioButton radioButton, RadioButton radioButton2) {
        super(obj, view, i);
        this.imageMarket = imageView;
        this.imageSocial = imageView2;
        this.radioGroup = radioGroup2;
        this.radioMarket = radioButton;
        this.radioSocial = radioButton2;
    }

    public static AppMainModelSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppMainModelSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppMainModelSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558463, viewGroup, z, obj);
    }

    public static AppMainModelSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppMainModelSelectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppMainModelSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558463, null, false, obj);
    }

    public static AppMainModelSelectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppMainModelSelectBinding bind(View view, Object obj) {
        return (AppMainModelSelectBinding) bind(obj, view, 2131558463);
    }
}
