package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;

public abstract class ItemAppViewGiftBinding extends ViewDataBinding {
    public final ImageView arrowView;
    @Bindable
    protected AppViewViewModel mViewModel;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemAppViewGiftBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.arrowView = imageView;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppViewGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558608, viewGroup, z, obj);
    }

    public static ItemAppViewGiftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558608, null, false, obj);
    }

    public static ItemAppViewGiftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewGiftBinding bind(View view, Object obj) {
        return (ItemAppViewGiftBinding) bind(obj, view, 2131558608);
    }
}
