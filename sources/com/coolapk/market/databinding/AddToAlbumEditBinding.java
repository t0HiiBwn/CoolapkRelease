package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class AddToAlbumEditBinding extends ViewDataBinding {
    public final TextView cacelView;
    public final EditText editText;
    @Bindable
    protected boolean mLoading;
    public final ProgressBar progressBar;
    public final TextView submitView;

    public abstract void setLoading(boolean z);

    protected AddToAlbumEditBinding(Object obj, View view, int i, TextView textView, EditText editText2, ProgressBar progressBar2, TextView textView2) {
        super(obj, view, i);
        this.cacelView = textView;
        this.editText = editText2;
        this.progressBar = progressBar2;
        this.submitView = textView2;
    }

    public boolean getLoading() {
        return this.mLoading;
    }

    public static AddToAlbumEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddToAlbumEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AddToAlbumEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558437, viewGroup, z, obj);
    }

    public static AddToAlbumEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddToAlbumEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AddToAlbumEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558437, null, false, obj);
    }

    public static AddToAlbumEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddToAlbumEditBinding bind(View view, Object obj) {
        return (AddToAlbumEditBinding) bind(obj, view, 2131558437);
    }
}
