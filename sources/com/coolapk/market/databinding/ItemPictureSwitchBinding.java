package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemPictureSwitchBinding extends ViewDataBinding {
    public final LinearLayout click1;
    public final LinearLayout click2;
    public final LinearLayout click4;
    public final LinearLayout click5;
    public final CheckedTextView textView1;
    public final CheckedTextView textView2;
    public final CheckedTextView textView4;
    public final CheckedTextView textView5;

    protected ItemPictureSwitchBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4) {
        super(obj, view, i);
        this.click1 = linearLayout;
        this.click2 = linearLayout2;
        this.click4 = linearLayout3;
        this.click5 = linearLayout4;
        this.textView1 = checkedTextView;
        this.textView2 = checkedTextView2;
        this.textView4 = checkedTextView3;
        this.textView5 = checkedTextView4;
    }

    public static ItemPictureSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPictureSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPictureSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558857, viewGroup, z, obj);
    }

    public static ItemPictureSwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPictureSwitchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPictureSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558857, null, false, obj);
    }

    public static ItemPictureSwitchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPictureSwitchBinding bind(View view, Object obj) {
        return (ItemPictureSwitchBinding) bind(obj, view, 2131558857);
    }
}
