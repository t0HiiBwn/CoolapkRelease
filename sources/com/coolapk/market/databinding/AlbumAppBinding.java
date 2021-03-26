package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.view.album.AlbumItemViewModel;
import com.coolapk.market.viewholder.AlbumItemViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.AutoLinkTextView;

public abstract class AlbumAppBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final LinearLayout albumAppView;
    public final TextView apkSizeView;
    public final ImageView iconView;
    public final AutoLinkTextView introductionView;
    @Bindable
    protected AlbumItem mApp;
    @Bindable
    protected AlbumItemViewHolder mViewHolder;
    @Bindable
    protected AlbumItemViewModel mViewModel;
    public final TextView sourceNameView;
    public final TextView titleView;

    public abstract void setApp(AlbumItem albumItem);

    public abstract void setViewHolder(AlbumItemViewHolder albumItemViewHolder);

    public abstract void setViewModel(AlbumItemViewModel albumItemViewModel);

    protected AlbumAppBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, LinearLayout linearLayout, TextView textView2, ImageView imageView, AutoLinkTextView autoLinkTextView, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.albumAppView = linearLayout;
        this.apkSizeView = textView2;
        this.iconView = imageView;
        this.introductionView = autoLinkTextView;
        this.sourceNameView = textView3;
        this.titleView = textView4;
    }

    public AlbumItemViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public AlbumItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public AlbumItem getApp() {
        return this.mApp;
    }

    public static AlbumAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558579, viewGroup, z, obj);
    }

    public static AlbumAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558579, null, false, obj);
    }

    public static AlbumAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumAppBinding bind(View view, Object obj) {
        return (AlbumAppBinding) bind(obj, view, 2131558579);
    }
}
