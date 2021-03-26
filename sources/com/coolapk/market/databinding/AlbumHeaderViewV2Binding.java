package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.AlbumActionView;
import com.coolapk.market.widget.AutoLinkTextView;

public abstract class AlbumHeaderViewV2Binding extends ViewDataBinding {
    public final AlbumActionView albumAction;
    public final FeedWarningBinding alertView;
    public final FrameLayout arcLayout;
    public final ImageView coverView;
    public final TextView infoView;
    public final AutoLinkTextView introduceShadowView;
    public final LinearLayout introduceView;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final ImageView recommendView;
    public final LinearLayout textContainer;
    public final TextView titleView;

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumHeaderViewV2Binding(Object obj, View view, int i, AlbumActionView albumActionView, FeedWarningBinding feedWarningBinding, FrameLayout frameLayout, ImageView imageView, TextView textView, AutoLinkTextView autoLinkTextView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, TextView textView2) {
        super(obj, view, i);
        this.albumAction = albumActionView;
        this.alertView = feedWarningBinding;
        this.arcLayout = frameLayout;
        this.coverView = imageView;
        this.infoView = textView;
        this.introduceShadowView = autoLinkTextView;
        this.introduceView = linearLayout;
        this.recommendView = imageView2;
        this.textContainer = linearLayout2;
        this.titleView = textView2;
    }

    public AlbumDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    public static AlbumHeaderViewV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumHeaderViewV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumHeaderViewV2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558447, viewGroup, z, obj);
    }

    public static AlbumHeaderViewV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumHeaderViewV2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumHeaderViewV2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558447, null, false, obj);
    }

    public static AlbumHeaderViewV2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumHeaderViewV2Binding bind(View view, Object obj) {
        return (AlbumHeaderViewV2Binding) bind(obj, view, 2131558447);
    }
}
