package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogAlbumitemPxBinding extends ViewDataBinding {
    public final ImageView albumItemLogo;
    public final EditText apkNoteEditView;
    public final TextView dialogTitleView;

    protected DialogAlbumitemPxBinding(Object obj, View view, int i, ImageView imageView, EditText editText, TextView textView) {
        super(obj, view, i);
        this.albumItemLogo = imageView;
        this.apkNoteEditView = editText;
        this.dialogTitleView = textView;
    }

    public static DialogAlbumitemPxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumitemPxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAlbumitemPxBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558516, viewGroup, z, obj);
    }

    public static DialogAlbumitemPxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumitemPxBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAlbumitemPxBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558516, null, false, obj);
    }

    public static DialogAlbumitemPxBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumitemPxBinding bind(View view, Object obj) {
        return (DialogAlbumitemPxBinding) bind(obj, view, 2131558516);
    }
}
