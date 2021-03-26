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
import com.coolapk.market.widget.AlbumFeedActionView;
import com.coolapk.market.widget.UserAvatarView;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemAlbumWithAvatarBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final ImageView avatarView;
    public final ImageView bgView;
    public final LinearLayout cardLayout;
    public final LinearLayout contentLayout;
    public final CoolapkCardView coolapkAlbumCardView;
    public final CoolapkCardView coolapkCardView;
    public final AlbumFeedActionView feedActionView;
    public final EllipsizeTextView fromWhereView;
    public final LinearLayout headerInfo;
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
    protected boolean mShowFromView;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected String mVerifyLabel;
    @Bindable
    protected String mVerifyStatusIcon;
    public final TextView moreCountView5;
    public final ImageView moreView;
    public final TextView nameView;
    public final TextView timeView;
    public final TextView titleView;
    public final View topDivider;
    public final FeedTopBinding topView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setIcon0(String str);

    public abstract void setIcon1(String str);

    public abstract void setIcon2(String str);

    public abstract void setIcon3(String str);

    public abstract void setIcon5(String str);

    public abstract void setModel(AlbumDetailViewModel albumDetailViewModel);

    public abstract void setShowFromView(boolean z);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setVerifyLabel(String str);

    public abstract void setVerifyStatusIcon(String str);

    protected ItemAlbumWithAvatarBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, CoolapkCardView coolapkCardView3, AlbumFeedActionView albumFeedActionView, EllipsizeTextView ellipsizeTextView, LinearLayout linearLayout3, LinearLayout linearLayout4, RoundedImageView roundedImageView, TextView textView, TextView textView2, ImageView imageView3, TextView textView3, TextView textView4, TextView textView5, View view2, FeedTopBinding feedTopBinding, UserAvatarView userAvatarView2, TextView textView6) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.avatarView = imageView;
        this.bgView = imageView2;
        this.cardLayout = linearLayout;
        this.contentLayout = linearLayout2;
        this.coolapkAlbumCardView = coolapkCardView2;
        this.coolapkCardView = coolapkCardView3;
        this.feedActionView = albumFeedActionView;
        this.fromWhereView = ellipsizeTextView;
        this.headerInfo = linearLayout3;
        this.iconList = linearLayout4;
        this.iconView5 = roundedImageView;
        this.infoView = textView;
        this.moreCountView5 = textView2;
        this.moreView = imageView3;
        this.nameView = textView3;
        this.timeView = textView4;
        this.titleView = textView5;
        this.topDivider = view2;
        this.topView = feedTopBinding;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView6;
    }

    public AlbumDetailViewModel getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
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

    public String getVerifyLabel() {
        return this.mVerifyLabel;
    }

    public String getVerifyStatusIcon() {
        return this.mVerifyStatusIcon;
    }

    public boolean getShowFromView() {
        return this.mShowFromView;
    }

    public static ItemAlbumWithAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumWithAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumWithAvatarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558589, viewGroup, z, obj);
    }

    public static ItemAlbumWithAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumWithAvatarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumWithAvatarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558589, null, false, obj);
    }

    public static ItemAlbumWithAvatarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumWithAvatarBinding bind(View view, Object obj) {
        return (ItemAlbumWithAvatarBinding) bind(obj, view, 2131558589);
    }
}
