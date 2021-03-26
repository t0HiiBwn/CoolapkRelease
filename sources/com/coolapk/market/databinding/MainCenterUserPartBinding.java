package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;

public abstract class MainCenterUserPartBinding extends ViewDataBinding {
    public final ImageView iconView;
    public final ImageView imageView;
    @Bindable
    protected String mAvatar;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView userName;

    public abstract void setAvatar(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected MainCenterUserPartBinding(Object obj, View view, int i, ImageView imageView2, ImageView imageView3, TextView textView) {
        super(obj, view, i);
        this.iconView = imageView2;
        this.imageView = imageView3;
        this.userName = textView;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static MainCenterUserPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainCenterUserPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MainCenterUserPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559017, viewGroup, z, obj);
    }

    public static MainCenterUserPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainCenterUserPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MainCenterUserPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559017, null, false, obj);
    }

    public static MainCenterUserPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MainCenterUserPartBinding bind(View view, Object obj) {
        return (MainCenterUserPartBinding) bind(obj, view, 2131559017);
    }
}
