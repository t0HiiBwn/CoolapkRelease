package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Album;
import com.coolapk.market.viewholder.AlbumViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemAlbumBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final RoundedImageView iconView;
    public final LinearLayout itemAlbumView;
    @Bindable
    protected Album mAlbum;
    @Bindable
    protected AlbumViewHolder mViewHolder;
    public final TextView recommendView;
    public final LinearLayout strokeView;
    public final TextView textView;
    public final View topDivider;
    public final FeedTopBinding topView;
    public final TextView userNameView;

    public abstract void setAlbum(Album album);

    public abstract void setViewHolder(AlbumViewHolder albumViewHolder);

    protected ItemAlbumBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, RoundedImageView roundedImageView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, TextView textView3, View view2, FeedTopBinding feedTopBinding, TextView textView4) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.iconView = roundedImageView;
        this.itemAlbumView = linearLayout;
        this.recommendView = textView2;
        this.strokeView = linearLayout2;
        this.textView = textView3;
        this.topDivider = view2;
        this.topView = feedTopBinding;
        this.userNameView = textView4;
    }

    public AlbumViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public Album getAlbum() {
        return this.mAlbum;
    }

    public static ItemAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558578, viewGroup, z, obj);
    }

    public static ItemAlbumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558578, null, false, obj);
    }

    public static ItemAlbumBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumBinding bind(View view, Object obj) {
        return (ItemAlbumBinding) bind(obj, view, 2131558578);
    }
}
