package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.base.refresh.RefreshRecyclerViewModel;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.ScrollChildSwipeRefreshLayout;

public abstract class RefreshRecyclerBinding extends ViewDataBinding {
    public final Space centerPlaceHolder2View;
    public final ImageView emptyImageView;
    public final TextView emptyTextView;
    public final RelativeLayout emptyView;
    public final ProgressBar loadingView;
    @Bindable
    protected RefreshRecyclerViewModel mViewModel;
    public final PreventAutoScrollRecyclerView recyclerView;
    public final ScrollChildSwipeRefreshLayout swipeRefreshView;

    public abstract void setViewModel(RefreshRecyclerViewModel refreshRecyclerViewModel);

    protected RefreshRecyclerBinding(Object obj, View view, int i, Space space, ImageView imageView, TextView textView, RelativeLayout relativeLayout, ProgressBar progressBar, PreventAutoScrollRecyclerView preventAutoScrollRecyclerView, ScrollChildSwipeRefreshLayout scrollChildSwipeRefreshLayout) {
        super(obj, view, i);
        this.centerPlaceHolder2View = space;
        this.emptyImageView = imageView;
        this.emptyTextView = textView;
        this.emptyView = relativeLayout;
        this.loadingView = progressBar;
        this.recyclerView = preventAutoScrollRecyclerView;
        this.swipeRefreshView = scrollChildSwipeRefreshLayout;
    }

    public RefreshRecyclerViewModel getViewModel() {
        return this.mViewModel;
    }

    public static RefreshRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RefreshRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559114, viewGroup, z, obj);
    }

    public static RefreshRecyclerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshRecyclerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RefreshRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559114, null, false, obj);
    }

    public static RefreshRecyclerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RefreshRecyclerBinding bind(View view, Object obj) {
        return (RefreshRecyclerBinding) bind(obj, view, 2131559114);
    }
}
