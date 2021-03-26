package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.VersionAppViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemVersionAppBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final TextView dateView;
    @Bindable
    protected VersionAppViewHolder mViewModel;
    public final TextView sizeView;
    public final TextView versionView;

    public abstract void setViewModel(VersionAppViewHolder versionAppViewHolder);

    protected ItemVersionAppBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.dateView = textView2;
        this.sizeView = textView3;
        this.versionView = textView4;
    }

    public VersionAppViewHolder getViewModel() {
        return this.mViewModel;
    }

    public static ItemVersionAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVersionAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVersionAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558983, viewGroup, z, obj);
    }

    public static ItemVersionAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVersionAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVersionAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558983, null, false, obj);
    }

    public static ItemVersionAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVersionAppBinding bind(View view, Object obj) {
        return (ItemVersionAppBinding) bind(obj, view, 2131558983);
    }
}
