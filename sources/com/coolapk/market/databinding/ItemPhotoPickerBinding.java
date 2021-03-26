package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemPhotoPickerBinding extends ViewDataBinding {
    public final FrameLayout cardView;
    public final FrameLayout checkBox;
    @Bindable
    protected String mPath;
    @Bindable
    protected Boolean mSelected;
    public final ImageView pickView;
    public final FrameLayout presenterView;

    public abstract void setPath(String str);

    public abstract void setSelected(Boolean bool);

    protected ItemPhotoPickerBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, FrameLayout frameLayout3) {
        super(obj, view, i);
        this.cardView = frameLayout;
        this.checkBox = frameLayout2;
        this.pickView = imageView;
        this.presenterView = frameLayout3;
    }

    public String getPath() {
        return this.mPath;
    }

    public Boolean getSelected() {
        return this.mSelected;
    }

    public static ItemPhotoPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPhotoPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558851, viewGroup, z, obj);
    }

    public static ItemPhotoPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPhotoPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558851, null, false, obj);
    }

    public static ItemPhotoPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoPickerBinding bind(View view, Object obj) {
        return (ItemPhotoPickerBinding) bind(obj, view, 2131558851);
    }
}
