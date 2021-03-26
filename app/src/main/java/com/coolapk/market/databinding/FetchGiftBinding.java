package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FetchGiftBinding extends ViewDataBinding {
    public final LinearLayout contentLayout;
    public final Button copyView;
    public final TextView downloadGameView;
    public final ProgressBar loadingView;
    @Bindable
    protected String mKey;
    public final Button myGiftView;

    public abstract void setKey(String str);

    protected FetchGiftBinding(Object obj, View view, int i, LinearLayout linearLayout, Button button, TextView textView, ProgressBar progressBar, Button button2) {
        super(obj, view, i);
        this.contentLayout = linearLayout;
        this.copyView = button;
        this.downloadGameView = textView;
        this.loadingView = progressBar;
        this.myGiftView = button2;
    }

    public String getKey() {
        return this.mKey;
    }

    public static FetchGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FetchGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FetchGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558564, viewGroup, z, obj);
    }

    public static FetchGiftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FetchGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FetchGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558564, null, false, obj);
    }

    public static FetchGiftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FetchGiftBinding bind(View view, Object obj) {
        return (FetchGiftBinding) bind(obj, view, 2131558564);
    }
}
