package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemAppViewDownloadBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final LinearLayout followView;
    public final TextView historyVersionView;
    @Bindable
    protected AppViewViewModel mViewModel;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemAppViewDownloadBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.followView = linearLayout;
        this.historyVersionView = textView2;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppViewDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558603, viewGroup, z, obj);
    }

    public static ItemAppViewDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewDownloadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558603, null, false, obj);
    }

    public static ItemAppViewDownloadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewDownloadBinding bind(View view, Object obj) {
        return (ItemAppViewDownloadBinding) bind(obj, view, 2131558603);
    }
}
