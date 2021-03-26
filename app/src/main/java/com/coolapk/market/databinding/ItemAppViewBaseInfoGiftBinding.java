package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;

public abstract class ItemAppViewBaseInfoGiftBinding extends ViewDataBinding {
    public final LinearLayout allGiftView;
    public final TextView fetchGiftView;
    public final TextView fetchGiftView2;
    public final LinearLayout giftView;
    public final LinearLayout giftView2;
    @Bindable
    protected AppViewViewModel mViewModel;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemAppViewBaseInfoGiftBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.allGiftView = linearLayout;
        this.fetchGiftView = textView;
        this.fetchGiftView2 = textView2;
        this.giftView = linearLayout2;
        this.giftView2 = linearLayout3;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppViewBaseInfoGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewBaseInfoGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558601, viewGroup, z, obj);
    }

    public static ItemAppViewBaseInfoGiftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewBaseInfoGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558601, null, false, obj);
    }

    public static ItemAppViewBaseInfoGiftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewBaseInfoGiftBinding bind(View view, Object obj) {
        return (ItemAppViewBaseInfoGiftBinding) bind(obj, view, 2131558601);
    }
}
