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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemAlbumExpandCardBinding extends ViewDataBinding {
    public final ImageView avatarView;
    public final ImageView bgView;
    public final LinearLayout contentLayout;
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout iconList;
    public final RoundedImageView iconView5;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mIcon0;
    @Bindable
    protected String mIcon1;
    @Bindable
    protected String mIcon2;
    @Bindable
    protected String mIcon3;
    @Bindable
    protected String mIcon5;
    @Bindable
    protected AlbumDetailViewModel mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView moreCountView5;
    public final TextView titleView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setIcon0(String str);

    public abstract void setIcon1(String str);

    public abstract void setIcon2(String str);

    public abstract void setIcon3(String str);

    public abstract void setIcon5(String str);

    public abstract void setModel(AlbumDetailViewModel albumDetailViewModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemAlbumExpandCardBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, LinearLayout linearLayout2, RoundedImageView roundedImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.avatarView = imageView;
        this.bgView = imageView2;
        this.contentLayout = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.iconList = linearLayout2;
        this.iconView5 = roundedImageView;
        this.infoView = textView;
        this.moreCountView5 = textView2;
        this.titleView = textView3;
        this.userNameView = textView4;
    }

    public AlbumDetailViewModel getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public String getIcon0() {
        return this.mIcon0;
    }

    public String getIcon1() {
        return this.mIcon1;
    }

    public String getIcon2() {
        return this.mIcon2;
    }

    public String getIcon3() {
        return this.mIcon3;
    }

    public String getIcon5() {
        return this.mIcon5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAlbumExpandCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumExpandCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumExpandCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558586, viewGroup, z, obj);
    }

    public static ItemAlbumExpandCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumExpandCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumExpandCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558586, null, false, obj);
    }

    public static ItemAlbumExpandCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumExpandCardBinding bind(View view, Object obj) {
        return (ItemAlbumExpandCardBinding) bind(obj, view, 2131558586);
    }
}
