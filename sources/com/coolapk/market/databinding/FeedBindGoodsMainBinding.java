package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FeedBindGoodsMainBinding extends ViewDataBinding {
    public final TextView actionDone;
    public final LinearLayout containerView;
    public final TextView emptyTextView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout manualGoodsView;
    public final RecyclerView recyclerView;
    public final LinearLayout searchGoodsView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedBindGoodsMainBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, RecyclerView recyclerView2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.actionDone = textView;
        this.containerView = linearLayout;
        this.emptyTextView = textView2;
        this.manualGoodsView = linearLayout2;
        this.recyclerView = recyclerView2;
        this.searchGoodsView = linearLayout3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedBindGoodsMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedBindGoodsMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedBindGoodsMainBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558556, viewGroup, z, obj);
    }

    public static FeedBindGoodsMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedBindGoodsMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedBindGoodsMainBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558556, null, false, obj);
    }

    public static FeedBindGoodsMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedBindGoodsMainBinding bind(View view, Object obj) {
        return (FeedBindGoodsMainBinding) bind(obj, view, 2131558556);
    }
}
