package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedSourceDeletedBinding extends ViewDataBinding {
    @Bindable
    protected Feed mModel;
    public final LinearLayout sourceContainer;
    public final TextView textView;

    public abstract void setModel(Feed feed);

    protected ItemFeedSourceDeletedBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.sourceContainer = linearLayout;
        this.textView = textView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public static ItemFeedSourceDeletedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSourceDeletedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedSourceDeletedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558729, viewGroup, z, obj);
    }

    public static ItemFeedSourceDeletedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSourceDeletedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedSourceDeletedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558729, null, false, obj);
    }

    public static ItemFeedSourceDeletedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSourceDeletedBinding bind(View view, Object obj) {
        return (ItemFeedSourceDeletedBinding) bind(obj, view, 2131558729);
    }
}
