package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogSeletorContainerBinding extends ViewDataBinding {
    public final LinearLayout actionContainer;
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final TextView okButton;
    public final RecyclerView recyclerView;
    public final TextView titleView;

    protected DialogSeletorContainerBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, RecyclerView recyclerView2, TextView textView3) {
        super(obj, view, i);
        this.actionContainer = linearLayout;
        this.cancelButton = textView;
        this.contentView = linearLayout2;
        this.okButton = textView2;
        this.recyclerView = recyclerView2;
        this.titleView = textView3;
    }

    public static DialogSeletorContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSeletorContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSeletorContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558538, viewGroup, z, obj);
    }

    public static DialogSeletorContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSeletorContainerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSeletorContainerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558538, null, false, obj);
    }

    public static DialogSeletorContainerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSeletorContainerBinding bind(View view, Object obj) {
        return (DialogSeletorContainerBinding) bind(obj, view, 2131558538);
    }
}
