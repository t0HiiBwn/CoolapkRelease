package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class DialogAlbumCreateBinding extends ViewDataBinding {
    public final TextView dialogCancel;
    public final TextView dialogConfirm;
    public final TextView dialogTitleView;
    public final TextInputEditText introEditText;
    public final TextInputLayout introInputLayout;
    public final TextInputEditText titleEditText;
    public final TextInputLayout titleInputLayout;

    protected DialogAlbumCreateBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2) {
        super(obj, view, i);
        this.dialogCancel = textView;
        this.dialogConfirm = textView2;
        this.dialogTitleView = textView3;
        this.introEditText = textInputEditText;
        this.introInputLayout = textInputLayout;
        this.titleEditText = textInputEditText2;
        this.titleInputLayout = textInputLayout2;
    }

    public static DialogAlbumCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAlbumCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558515, viewGroup, z, obj);
    }

    public static DialogAlbumCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumCreateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAlbumCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558515, null, false, obj);
    }

    public static DialogAlbumCreateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumCreateBinding bind(View view, Object obj) {
        return (DialogAlbumCreateBinding) bind(obj, view, 2131558515);
    }
}
