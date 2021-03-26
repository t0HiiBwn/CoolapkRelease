package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemAppViewCommentTitleBinding extends ViewDataBinding {
    public final TextView filterTextView;
    public final LinearLayout filterView;
    @Bindable
    protected String mCommentNum;

    public abstract void setCommentNum(String str);

    protected ItemAppViewCommentTitleBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.filterTextView = textView;
        this.filterView = linearLayout;
    }

    public String getCommentNum() {
        return this.mCommentNum;
    }

    public static ItemAppViewCommentTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewCommentTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewCommentTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558606, viewGroup, z, obj);
    }

    public static ItemAppViewCommentTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewCommentTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewCommentTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558606, null, false, obj);
    }

    public static ItemAppViewCommentTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewCommentTitleBinding bind(View view, Object obj) {
        return (ItemAppViewCommentTitleBinding) bind(obj, view, 2131558606);
    }
}
