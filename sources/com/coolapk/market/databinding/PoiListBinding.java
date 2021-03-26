package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;

public abstract class PoiListBinding extends ViewDataBinding {
    public final TextView emptyTextView;
    public final ProgressBar progressBar;
    public final PreventAutoScrollRecyclerView recyclerView;

    protected PoiListBinding(Object obj, View view, int i, TextView textView, ProgressBar progressBar2, PreventAutoScrollRecyclerView preventAutoScrollRecyclerView) {
        super(obj, view, i);
        this.emptyTextView = textView;
        this.progressBar = progressBar2;
        this.recyclerView = preventAutoScrollRecyclerView;
    }

    public static PoiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PoiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PoiListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559095, viewGroup, z, obj);
    }

    public static PoiListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PoiListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PoiListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559095, null, false, obj);
    }

    public static PoiListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PoiListBinding bind(View view, Object obj) {
        return (PoiListBinding) bind(obj, view, 2131559095);
    }
}
