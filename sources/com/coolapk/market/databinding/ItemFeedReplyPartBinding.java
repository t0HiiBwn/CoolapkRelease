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
import com.coolapk.market.widget.LinearAdapterLayout;

public abstract class ItemFeedReplyPartBinding extends ViewDataBinding {
    public final LinearAdapterLayout feedReplyContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView moreCommentView;
    public final LinearLayout replayLayout;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedReplyPartBinding(Object obj, View view, int i, LinearAdapterLayout linearAdapterLayout, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.feedReplyContainer = linearAdapterLayout;
        this.moreCommentView = textView;
        this.replayLayout = linearLayout;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedReplyPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedReplyPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558726, viewGroup, z, obj);
    }

    public static ItemFeedReplyPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedReplyPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558726, null, false, obj);
    }

    public static ItemFeedReplyPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyPartBinding bind(View view, Object obj) {
        return (ItemFeedReplyPartBinding) bind(obj, view, 2131558726);
    }
}
