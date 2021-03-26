package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemPhotoDirectoryBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected String mPath;
    @Bindable
    protected Boolean mSelected;
    public final TextView textView;
    public final TextView titleView;

    public abstract void setPath(String str);

    public abstract void setSelected(Boolean bool);

    protected ItemPhotoDirectoryBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.textView = textView2;
        this.titleView = textView3;
    }

    public String getPath() {
        return this.mPath;
    }

    public Boolean getSelected() {
        return this.mSelected;
    }

    public static ItemPhotoDirectoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoDirectoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPhotoDirectoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558850, viewGroup, z, obj);
    }

    public static ItemPhotoDirectoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoDirectoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPhotoDirectoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558850, null, false, obj);
    }

    public static ItemPhotoDirectoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoDirectoryBinding bind(View view, Object obj) {
        return (ItemPhotoDirectoryBinding) bind(obj, view, 2131558850);
    }
}
