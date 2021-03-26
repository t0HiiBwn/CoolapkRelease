package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.viewholder.AlbumBaseViewHolder;
import com.coolapk.market.widget.AutoLinkTextView;

public abstract class AlbumBaseInfoBinding extends ViewDataBinding {
    public final AutoLinkTextView introduceShadowView;
    public final LinearLayout introduceView;
    @Bindable
    protected AlbumBaseViewHolder mViewHolder;
    @Bindable
    protected AlbumDetailViewModel mViewModel;
    public final ImageView recommendView;

    public abstract void setViewHolder(AlbumBaseViewHolder albumBaseViewHolder);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumBaseInfoBinding(Object obj, View view, int i, AutoLinkTextView autoLinkTextView, LinearLayout linearLayout, ImageView imageView) {
        super(obj, view, i);
        this.introduceShadowView = autoLinkTextView;
        this.introduceView = linearLayout;
        this.recommendView = imageView;
    }

    public AlbumDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    public AlbumBaseViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public static AlbumBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558441, viewGroup, z, obj);
    }

    public static AlbumBaseInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumBaseInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558441, null, false, obj);
    }

    public static AlbumBaseInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumBaseInfoBinding bind(View view, Object obj) {
        return (AlbumBaseInfoBinding) bind(obj, view, 2131558441);
    }
}
