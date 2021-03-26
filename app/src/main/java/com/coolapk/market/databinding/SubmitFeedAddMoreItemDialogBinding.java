package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitFeedAddMoreItemDialogBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView okButton;
    public final TextView subTitleView;

    protected SubmitFeedAddMoreItemDialogBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, EditText editText2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.okButton = textView2;
        this.subTitleView = textView3;
    }

    public static SubmitFeedAddMoreItemDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedAddMoreItemDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedAddMoreItemDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559147, viewGroup, z, obj);
    }

    public static SubmitFeedAddMoreItemDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedAddMoreItemDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedAddMoreItemDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559147, null, false, obj);
    }

    public static SubmitFeedAddMoreItemDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedAddMoreItemDialogBinding bind(View view, Object obj) {
        return (SubmitFeedAddMoreItemDialogBinding) bind(obj, view, 2131559147);
    }
}
