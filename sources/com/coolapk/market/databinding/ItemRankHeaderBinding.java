package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemRankHeaderBinding extends ViewDataBinding {
    public final LinearLayout click1;
    public final LinearLayout click2;
    public final LinearLayout click3;
    public final CheckedTextView textView1;
    public final CheckedTextView textView2;
    public final CheckedTextView textView3;

    protected ItemRankHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3) {
        super(obj, view, i);
        this.click1 = linearLayout;
        this.click2 = linearLayout2;
        this.click3 = linearLayout3;
        this.textView1 = checkedTextView;
        this.textView2 = checkedTextView2;
        this.textView3 = checkedTextView3;
    }

    public static ItemRankHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRankHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRankHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558895, viewGroup, z, obj);
    }

    public static ItemRankHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRankHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRankHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558895, null, false, obj);
    }

    public static ItemRankHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRankHeaderBinding bind(View view, Object obj) {
        return (ItemRankHeaderBinding) bind(obj, view, 2131558895);
    }
}
