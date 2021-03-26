package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AlbumActionViewBinding extends ViewDataBinding {
    public final TextView actionInfoviewEditView;
    public final TextView actionLocalappAddView;

    protected AlbumActionViewBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.actionInfoviewEditView = textView;
        this.actionLocalappAddView = textView2;
    }

    public static AlbumActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumActionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558441, viewGroup, z, obj);
    }

    public static AlbumActionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumActionViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumActionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558441, null, false, obj);
    }

    public static AlbumActionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumActionViewBinding bind(View view, Object obj) {
        return (AlbumActionViewBinding) bind(obj, view, 2131558441);
    }
}
