package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;

public abstract class ItemSimpleFeedBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final FeedActionView2 feedActionView;
    public final FrameLayout headerContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final Space spaceView;
    public final TextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemSimpleFeedBinding(Object obj, View view, int i, LinearLayout linearLayout, FeedActionView2 feedActionView2, FrameLayout frameLayout, Space space, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.feedActionView = feedActionView2;
        this.headerContainer = frameLayout;
        this.spaceView = space;
        this.textView = textView2;
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

    public static ItemSimpleFeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleFeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSimpleFeedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558930, viewGroup, z, obj);
    }

    public static ItemSimpleFeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleFeedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSimpleFeedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558930, null, false, obj);
    }

    public static ItemSimpleFeedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleFeedBinding bind(View view, Object obj) {
        return (ItemSimpleFeedBinding) bind(obj, view, 2131558930);
    }
}
