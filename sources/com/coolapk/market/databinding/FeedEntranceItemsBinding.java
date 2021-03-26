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

public abstract class FeedEntranceItemsBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final View newBgView;
    public final TextView newTagView;
    public final TextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedEntranceItemsBinding(Object obj, View view, int i, ImageView imageView2, FrameLayout frameLayout, View view2, TextView textView2, TextView textView3) {
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

    public static FeedEntranceItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedEntranceItemsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558560, viewGroup, z, obj);
    }

    public static FeedEntranceItemsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceItemsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedEntranceItemsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558560, null, false, obj);
    }

    public static FeedEntranceItemsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceItemsBinding bind(View view, Object obj) {
        return (FeedEntranceItemsBinding) bind(obj, view, 2131558560);
    }
}
