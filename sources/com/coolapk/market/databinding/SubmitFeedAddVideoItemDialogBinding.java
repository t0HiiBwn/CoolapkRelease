package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitFeedAddVideoItemDialogBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView okButton;
    public final TextView textView;

    protected SubmitFeedAddVideoItemDialogBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, EditText editText2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.cancelButton = textView2;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.okButton = textView3;
        this.textView = textView4;
    }

    public static SubmitFeedAddVideoItemDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedAddVideoItemDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedAddVideoItemDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559156, viewGroup, z, obj);
    }

    public static SubmitFeedAddVideoItemDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedAddVideoItemDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedAddVideoItemDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559156, null, false, obj);
    }

    public static SubmitFeedAddVideoItemDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedAddVideoItemDialogBinding bind(View view, Object obj) {
        return (SubmitFeedAddVideoItemDialogBinding) bind(obj, view, 2131559156);
    }
}
