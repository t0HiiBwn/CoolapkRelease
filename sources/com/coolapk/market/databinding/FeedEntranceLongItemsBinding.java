package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FeedEntranceLongItemsBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final View newBgView;
    public final TextView newTagView;
    public final TextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedEntranceLongItemsBinding(Object obj, View view, int i, ImageView imageView2, FrameLayout frameLayout, View view2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.itemView = frameLayout;
        this.newBgView = view2;
        this.newTagView = textView2;
        this.textView = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedEntranceLongItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceLongItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedEntranceLongItemsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558561, viewGroup, z, obj);
    }

    public static FeedEntranceLongItemsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceLongItemsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedEntranceLongItemsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558561, null, false, obj);
    }

    public static FeedEntranceLongItemsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceLongItemsBinding bind(View view, Object obj) {
        return (FeedEntranceLongItemsBinding) bind(obj, view, 2131558561);
    }
}
