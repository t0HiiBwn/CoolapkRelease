package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.viewholder.AlbumBaseViewHolder;
import com.coolapk.market.widget.AlbumActionView;

public abstract class AlbumItemBaseInfoBinding extends ViewDataBinding {
    public final AlbumActionView albumAction;
    public final TextView introduceShadowView;
    @Bindable
    protected AlbumBaseViewHolder mViewHolder;
    @Bindable
    protected AlbumDetailViewModel mViewModel;

    public abstract void setViewHolder(AlbumBaseViewHolder albumBaseViewHolder);

    public abstract void setViewModel(AlbumDetailViewModel albumDetailViewModel);

    protected AlbumItemBaseInfoBinding(Object obj, View view, int i, AlbumActionView albumActionView, TextView textView) {
        super(obj, view, i);
        this.albumAction = albumActionView;
        this.introduceShadowView = textView;
    }

    public AlbumDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    public AlbumBaseViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public static AlbumItemBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumItemBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumItemBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558448, viewGroup, z, obj);
    }

    public static AlbumItemBaseInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumItemBaseInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumItemBaseInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558448, null, false, obj);
    }

    public static AlbumItemBaseInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumItemBaseInfoBinding bind(View view, Object obj) {
        return (AlbumItemBaseInfoBinding) bind(obj, view, 2131558448);
    }
}
