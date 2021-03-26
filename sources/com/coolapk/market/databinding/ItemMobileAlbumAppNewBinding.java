package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.album.AlbumPickAPKViewModel;
import com.coolapk.market.view.album.pick.NewAlbumPickFragment;

public abstract class ItemMobileAlbumAppNewBinding extends ViewDataBinding {
    public final TextView apkSizeView;
    public final TextView apkSystemView;
    public final LinearLayout appCommentView;
    public final TextView appEditText;
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final ImageView iconView;
    @Bindable
    protected MobileApp mApp;
    @Bindable
    protected NewAlbumPickFragment.AlbumMobileAPPViewHolder mViewHolder;
    @Bindable
    protected AlbumPickAPKViewModel mViewModel;
    public final CheckBox mobileAppCheckView;
    public final TextView titleView;
    public final TableLayout versionInfoView;
    public final TextView versionView;

    public abstract void setApp(MobileApp mobileApp);

    public abstract void setViewHolder(NewAlbumPickFragment.AlbumMobileAPPViewHolder albumMobileAPPViewHolder);

    public abstract void setViewModel(AlbumPickAPKViewModel albumPickAPKViewModel);

    protected ItemMobileAlbumAppNewBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, CheckBox checkBox, TextView textView4, TableLayout tableLayout, TextView textView5) {
        super(obj, view, i);
        this.apkSizeView = textView;
        this.apkSystemView = textView2;
        this.appCommentView = linearLayout;
        this.appEditText = textView3;
        this.cardView = linearLayout2;
        this.contentView = linearLayout3;
        this.iconView = imageView;
        this.mobileAppCheckView = checkBox;
        this.titleView = textView4;
        this.versionInfoView = tableLayout;
        this.versionView = textView5;
    }

    public NewAlbumPickFragment.AlbumMobileAPPViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public MobileApp getApp() {
        return this.mApp;
    }

    public AlbumPickAPKViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemMobileAlbumAppNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAlbumAppNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMobileAlbumAppNewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558835, viewGroup, z, obj);
    }

    public static ItemMobileAlbumAppNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAlbumAppNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMobileAlbumAppNewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558835, null, false, obj);
    }

    public static ItemMobileAlbumAppNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMobileAlbumAppNewBinding bind(View view, Object obj) {
        return (ItemMobileAlbumAppNewBinding) bind(obj, view, 2131558835);
    }
}
