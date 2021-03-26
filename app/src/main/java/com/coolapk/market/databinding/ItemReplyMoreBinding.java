package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemReplyMoreBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout itemView;

    protected ItemReplyMoreBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = linearLayout;
    }

    public static ItemReplyMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemReplyMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558899, viewGroup, z, obj);
    }

    public static ItemReplyMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemReplyMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558899, null, false, obj);
    }

    public static ItemReplyMoreBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyMoreBinding bind(View view, Object obj) {
        return (ItemReplyMoreBinding) bind(obj, view, 2131558899);
    }
}
