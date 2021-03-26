package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.io.File;

public abstract class ItemFileBinding extends ViewDataBinding {
    @Bindable
    protected File mFile;
    public final TextView textView;

    public abstract void setFile(File file);

    protected ItemFileBinding(Object obj, View view, int i, TextView textView2) {
        super(obj, view, i);
        this.textView = textView2;
    }

    public File getFile() {
        return this.mFile;
    }

    public static ItemFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFileBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558744, viewGroup, z, obj);
    }

    public static ItemFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFileBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558744, null, false, obj);
    }

    public static ItemFileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFileBinding bind(View view, Object obj) {
        return (ItemFileBinding) bind(obj, view, 2131558744);
    }
}
