package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemMainCatogoryTypeBinding extends ViewDataBinding {
    public final LinearLayout click1;
    public final LinearLayout click2;
    public final CheckedTextView textView1;
    public final CheckedTextView textView2;

    protected ItemMainCatogoryTypeBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        super(obj, view, i);
        this.click1 = linearLayout;
        this.click2 = linearLayout2;
        this.textView1 = checkedTextView;
        this.textView2 = checkedTextView2;
    }

    public static ItemMainCatogoryTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCatogoryTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainCatogoryTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558828, viewGroup, z, obj);
    }

    public static ItemMainCatogoryTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCatogoryTypeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainCatogoryTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558828, null, false, obj);
    }

    public static ItemMainCatogoryTypeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCatogoryTypeBinding bind(View view, Object obj) {
        return (ItemMainCatogoryTypeBinding) bind(obj, view, 2131558828);
    }
}
