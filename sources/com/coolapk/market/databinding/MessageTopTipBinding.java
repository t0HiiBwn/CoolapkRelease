package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class MessageTopTipBinding extends ViewDataBinding {
    public final TextView tipTitle;
    public final RelativeLayout tipView;

    protected MessageTopTipBinding(Object obj, View view, int i, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.tipTitle = textView;
        this.tipView = relativeLayout;
    }

    public static MessageTopTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MessageTopTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MessageTopTipBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559027, viewGroup, z, obj);
    }

    public static MessageTopTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MessageTopTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MessageTopTipBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559027, null, false, obj);
    }

    public static MessageTopTipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MessageTopTipBinding bind(View view, Object obj) {
        return (MessageTopTipBinding) bind(obj, view, 2131559027);
    }
}
