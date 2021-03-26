package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemFeedAlbumLayoutBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final FeedActionView2 feedActionView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView newTagView;
    public final TextView textView;
    public final CoolEllipsizeTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFeedAlbumLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, FeedActionView2 feedActionView2, Space space, TextView textView2, TextView textView3, CoolEllipsizeTextView coolEllipsizeTextView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.feedActionView = feedActionView2;
        this.headerSpaceView = space;
        this.newTagView = textView2;
        this.textView = textView3;
        this.titleView = coolEllipsizeTextView;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedAlbumLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedAlbumLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedAlbumLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558691, viewGroup, z, obj);
    }

    public static ItemFeedAlbumLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedAlbumLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedAlbumLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558691, null, false, obj);
    }

    public static ItemFeedAlbumLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedAlbumLayoutBinding bind(View view, Object obj) {
        return (ItemFeedAlbumLayoutBinding) bind(obj, view, 2131558691);
    }
}
