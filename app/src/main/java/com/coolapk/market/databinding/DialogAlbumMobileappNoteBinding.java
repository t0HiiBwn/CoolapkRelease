package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.MobileApp;

public abstract class DialogAlbumMobileappNoteBinding extends ViewDataBinding {
    public final EditText apkNoteEditView;
    public final TextView cacel;
    public final TextView dialogTitleView;
    @Bindable
    protected MobileApp mApp;
    public final TextView ok;

    public abstract void setApp(MobileApp mobileApp);

    protected DialogAlbumMobileappNoteBinding(Object obj, View view, int i, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.apkNoteEditView = editText;
        this.cacel = textView;
        this.dialogTitleView = textView2;
        this.ok = textView3;
    }

    public MobileApp getApp() {
        return this.mApp;
    }

    public static DialogAlbumMobileappNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumMobileappNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAlbumMobileappNoteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558514, viewGroup, z, obj);
    }

    public static DialogAlbumMobileappNoteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumMobileappNoteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAlbumMobileappNoteBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558514, null, false, obj);
    }

    public static DialogAlbumMobileappNoteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAlbumMobileappNoteBinding bind(View view, Object obj) {
        return (DialogAlbumMobileappNoteBinding) bind(obj, view, 2131558514);
    }
}
