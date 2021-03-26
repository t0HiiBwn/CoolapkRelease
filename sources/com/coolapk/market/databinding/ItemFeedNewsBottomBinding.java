package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;

public abstract class ItemFeedNewsBottomBinding extends ViewDataBinding {
    public final FeedActionView2 feedSimpleActionView;
    public final TextView leftBottomText;
    @Bindable
    protected Feed mModel;

    public abstract void setModel(Feed feed);

    protected ItemFeedNewsBottomBinding(Object obj, View view, int i, FeedActionView2 feedActionView2, TextView textView) {
        super(obj, view, i);
        this.feedSimpleActionView = feedActionView2;
        this.leftBottomText = textView;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public static ItemFeedNewsBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedNewsBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedNewsBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558716, viewGroup, z, obj);
    }

    public static ItemFeedNewsBottomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedNewsBottomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedNewsBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558716, null, false, obj);
    }

    public static ItemFeedNewsBottomBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedNewsBottomBinding bind(View view, Object obj) {
        return (ItemFeedNewsBottomBinding) bind(obj, view, 2131558716);
    }
}
