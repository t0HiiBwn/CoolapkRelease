package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SearchHistoryBinding extends ViewDataBinding {
    public final ImageView chevronView;
    public final LinearLayout closeView;
    public final RecyclerView recyclerView;
    public final TextView titleView;
    public final TextView toggleHistoryTextView;
    public final LinearLayout toggleHistoryView;

    protected SearchHistoryBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView2, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.chevronView = imageView;
        this.closeView = linearLayout;
        this.recyclerView = recyclerView2;
        this.titleView = textView;
        this.toggleHistoryTextView = textView2;
        this.toggleHistoryView = linearLayout2;
    }

    public static SearchHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559125, viewGroup, z, obj);
    }

    public static SearchHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559125, null, false, obj);
    }

    public static SearchHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchHistoryBinding bind(View view, Object obj) {
        return (SearchHistoryBinding) bind(obj, view, 2131559125);
    }
}
