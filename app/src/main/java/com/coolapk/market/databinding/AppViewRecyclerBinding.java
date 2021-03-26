package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;

public abstract class AppViewRecyclerBinding extends ViewDataBinding {
    @Bindable
    protected AppViewViewModel mViewModel;
    public final PreventAutoScrollRecyclerView recyclerView;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected AppViewRecyclerBinding(Object obj, View view, int i, PreventAutoScrollRecyclerView preventAutoScrollRecyclerView) {
        super(obj, view, i);
        this.recyclerView = preventAutoScrollRecyclerView;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static AppViewRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppViewRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558468, viewGroup, z, obj);
    }

    public static AppViewRecyclerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewRecyclerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppViewRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558468, null, false, obj);
    }

    public static AppViewRecyclerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewRecyclerBinding bind(View view, Object obj) {
        return (AppViewRecyclerBinding) bind(obj, view, 2131558468);
    }
}
