package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogBackupCreateBinding extends ViewDataBinding {
    public final TextView dialogCancel;
    public final TextView dialogConfirm;
    public final TextView dialogTitleView;
    public final EditText titleEditText;

    protected DialogBackupCreateBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, EditText editText) {
        super(obj, view, i);
        this.dialogCancel = textView;
        this.dialogConfirm = textView2;
        this.dialogTitleView = textView3;
        this.titleEditText = editText;
    }

    public static DialogBackupCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBackupCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogBackupCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558520, viewGroup, z, obj);
    }

    public static DialogBackupCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBackupCreateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogBackupCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558520, null, false, obj);
    }

    public static DialogBackupCreateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBackupCreateBinding bind(View view, Object obj) {
        return (DialogBackupCreateBinding) bind(obj, view, 2131558520);
    }
}
