package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedDetailViewV8Binding extends ViewDataBinding {
    public final FrameLayout cardView;
    public final FrameLayout extraApkTypeContainer;
    public final Space extraEntityContainer;
    public final FrameLayout extraTypeContainer;
    public final Space headerSpaceView;
    public final ImageView imgSellView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space ratingSpaceView;
    public final Space relativeSpaceView;
    public final Space secondHandHeaderSpaceView;
    public final Space secondHandInfoSpaceView;
    public final Space sourceSpaceView;
    public final TextView textDividerView;
    public final TextView textView;
    public final FrameLayout textViewContainer;
    public final FrameLayout titleContainer;
    public final TextView titleTagView;
    public final TextView titleView;
    public final Space videoPlayerSpaceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedDetailViewV8Binding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, Space space, FrameLayout frameLayout3, Space space2, ImageView imageView, Space space3, Space space4, Space space5, Space space6, Space space7, Space space8, TextView textView2, TextView textView3, FrameLayout frameLayout4, FrameLayout frameLayout5, TextView textView4, TextView textView5, Space space9) {
        super(obj, view, i);
        this.cardView = frameLayout;
        this.extraApkTypeContainer = frameLayout2;
        this.extraEntityContainer = space;
        this.extraTypeContainer = frameLayout3;
        this.headerSpaceView = space2;
        this.imgSellView = imageView;
        this.nineImageSpaceView = space3;
        this.ratingSpaceView = space4;
        this.relativeSpaceView = space5;
        this.secondHandHeaderSpaceView = space6;
        this.secondHandInfoSpaceView = space7;
        this.sourceSpaceView = space8;
        this.textDividerView = textView2;
        this.textView = textView3;
        this.textViewContainer = frameLayout4;
        this.titleContainer = frameLayout5;
        this.titleTagView = textView4;
        this.titleView = textView5;
        this.videoPlayerSpaceView = space9;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedDetailViewV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedDetailViewV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedDetailViewV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558703, viewGroup, z, obj);
    }

    public static ItemFeedDetailViewV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedDetailViewV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedDetailViewV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558703, null, false, obj);
    }

    public static ItemFeedDetailViewV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedDetailViewV8Binding bind(View view, Object obj) {
        return (ItemFeedDetailViewV8Binding) bind(obj, view, 2131558703);
    }
}
