package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogAlbumitemNoteBinding extends ViewDataBinding {
    public final ImageView albumItemLogo;
    public final EditText apkNoteEditView;
    public final TextView cacel;
    public final TextView dialogTitleView;
    public final TextView ok;
    public final ProgressBar progressBar;

    protected DialogAlbumitemNoteBinding(Object obj, View view, int i, ImageView imageView, EditText editText, TextView textView, TextView textView2, TextView textView3, ProgressBar progressBar2) {
        super(obj, view, i);
        this.albumItemLogo = imageView;
        this.apkNoteEditView = editText;
        this.cacel = textView;
        this.dialogTitleView = textView2;
        this.ok = textView3;
        this.progressBar = progressBar2;
    }

    public static DialogAlbumitemNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumitemNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAlbumitemNoteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558515, viewGroup, z, obj);
    }

    public static DialogAlbumitemNoteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumitemNoteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAlbumitemNoteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558515, null, false, obj);
    }

    public static DialogAlbumitemNoteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumitemNoteBinding bind(View view, Object obj) {
        return (DialogAlbumitemNoteBinding) bind(obj, view, 2131558515);
    }
}
