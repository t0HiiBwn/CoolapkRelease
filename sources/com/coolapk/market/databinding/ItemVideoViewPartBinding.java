package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemVideoViewPartBinding extends ViewDataBinding {
    public final DividerLineView dividerView;
    public final MaxWidthFrameLayout itemView;
    public final TextView liveView;
    public final LinearLayout liveViewContainer;
    public final ImageView pauseImageView;
    public final ImageView playView;
    public final TextView remainTimeView;
    public final TextView tagView;
    public final ImageView videoCover;
    public final FrameLayout videoCoverContainer;
    public final FrameLayout videoPlayer;

    protected ItemVideoViewPartBinding(Object obj, View view, int i, DividerLineView dividerLineView, MaxWidthFrameLayout maxWidthFrameLayout, TextView textView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, ImageView imageView3, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.dividerView = dividerLineView;
        this.itemView = maxWidthFrameLayout;
        this.liveView = textView;
        this.liveViewContainer = linearLayout;
        this.pauseImageView = imageView;
        this.playView = imageView2;
        this.remainTimeView = textView2;
        this.tagView = textView3;
        this.videoCover = imageView3;
        this.videoCoverContainer = frameLayout;
        this.videoPlayer = frameLayout2;
    }

    public static ItemVideoViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558993, viewGroup, z, obj);
    }

    public static ItemVideoViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558993, null, false, obj);
    }

    public static ItemVideoViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoViewPartBinding bind(View view, Object obj) {
        return (ItemVideoViewPartBinding) bind(obj, view, 2131558993);
    }
}
