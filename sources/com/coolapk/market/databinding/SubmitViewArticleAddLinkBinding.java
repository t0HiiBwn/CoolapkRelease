package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitViewArticleAddLinkBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText linkEditText;
    public final TextView okButton;
    public final EditText textEditText;

    protected SubmitViewArticleAddLinkBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, EditText editText, TextView textView2, EditText editText2) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.contentView = linearLayout;
        this.linkEditText = editText;
        this.okButton = textView2;
        this.textEditText = editText2;
    }

    public static SubmitViewArticleAddLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitViewArticleAddLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitViewArticleAddLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559181, viewGroup, z, obj);
    }

    public static SubmitViewArticleAddLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitViewArticleAddLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitViewArticleAddLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559181, null, false, obj);
    }

    public static SubmitViewArticleAddLinkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitViewArticleAddLinkBinding bind(View view, Object obj) {
        return (SubmitViewArticleAddLinkBinding) bind(obj, view, 2131559181);
    }
}
