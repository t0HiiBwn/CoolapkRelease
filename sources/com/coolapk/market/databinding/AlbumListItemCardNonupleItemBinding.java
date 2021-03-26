package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Album;
import com.coolapk.market.viewholder.GridAlbumCardViewHolder;

public abstract class AlbumListItemCardNonupleItemBinding extends ViewDataBinding {
    public final TextView apkNumView;
    public final ImageView iconView;
    @Bindable
    protected Album mAlbum;
    @Bindable
    protected GridAlbumCardViewHolder.DataViewHolder mViewHolder;
    public final TextView titleView;

    public abstract void setAlbum(Album album);

    public abstract void setViewHolder(GridAlbumCardViewHolder.DataViewHolder dataViewHolder);

    protected AlbumListItemCardNonupleItemBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.apkNumView = textView;
        this.iconView = imageView;
        this.titleView = textView2;
    }

    public Album getAlbum() {
        return this.mAlbum;
    }

    public GridAlbumCardViewHolder.DataViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public static AlbumListItemCardNonupleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumListItemCardNonupleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AlbumListItemCardNonupleItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558450, viewGroup, z, obj);
    }

    public static AlbumListItemCardNonupleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumListItemCardNonupleItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AlbumListItemCardNonupleItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558450, null, false, obj);
    }

    public static AlbumListItemCardNonupleItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AlbumListItemCardNonupleItemBinding bind(View view, Object obj) {
        return (AlbumListItemCardNonupleItemBinding) bind(obj, view, 2131558450);
    }
}
