package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.view.album.AlbumItemViewModel;

public abstract class ItemAlbumAppEditBinding extends ViewDataBinding {
    public final CheckBox appCheckView;
    public final LinearLayout appCommentView;
    public final TextView appEditText;
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final ImageView iconView;
    @Bindable
    protected AlbumItem mApp;
    @Bindable
    protected AlbumItemViewModel mModel;
    public final ImageView noteEdit;
    public final ImageView orderEdit;
    public final TextView titleView;
    public final TextView versionView;

    public abstract void setApp(AlbumItem albumItem);

    public abstract void setModel(AlbumItemViewModel albumItemViewModel);

    protected ItemAlbumAppEditBinding(Object obj, View view, int i, CheckBox checkBox, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.appCheckView = checkBox;
        this.appCommentView = linearLayout;
        this.appEditText = textView;
        this.cardView = linearLayout2;
        this.contentView = linearLayout3;
        this.iconView = imageView;
        this.noteEdit = imageView2;
        this.orderEdit = imageView3;
        this.titleView = textView2;
        this.versionView = textView3;
    }

    public AlbumItemViewModel getModel() {
        return this.mModel;
    }

    public AlbumItem getApp() {
        return this.mApp;
    }

    public static ItemAlbumAppEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumAppEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumAppEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558584, viewGroup, z, obj);
    }

    public static ItemAlbumAppEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumAppEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumAppEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558584, null, false, obj);
    }

    public static ItemAlbumAppEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumAppEditBinding bind(View view, Object obj) {
        return (ItemAlbumAppEditBinding) bind(obj, view, 2131558584);
    }
}
