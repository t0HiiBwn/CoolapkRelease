package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedShareActionViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final ImageView moreView;
    public final ImageView qqView;
    public final ImageView wechatTimeLineView;
    public final ImageView wechatView;
    public final ImageView weiboView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedShareActionViewBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.moreView = imageView;
        this.qqView = imageView2;
        this.wechatTimeLineView = imageView3;
        this.wechatView = imageView4;
        this.weiboView = imageView5;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedShareActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedShareActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedShareActionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558726, viewGroup, z, obj);
    }

    public static ItemFeedShareActionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedShareActionViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedShareActionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558726, null, false, obj);
    }

    public static ItemFeedShareActionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedShareActionViewBinding bind(View view, Object obj) {
        return (ItemFeedShareActionViewBinding) bind(obj, view, 2131558726);
    }
}
