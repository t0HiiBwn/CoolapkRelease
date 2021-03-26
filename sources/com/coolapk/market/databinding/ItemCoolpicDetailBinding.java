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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.wallpaper.coolpic.CoolPicViewPager;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.ImageIndicatorView;

public abstract class ItemCoolpicDetailBinding extends ViewDataBinding {
    public final LinearLayout actionContainer;
    public final TextView actionView;
    public final UserAvatarView avatarView;
    public final LinearLayout bottomContainer;
    public final View bottomShadeCover;
    public final FrameLayout commentContainer;
    public final TextView commentText;
    public final LinearLayout commentView;
    public final TextView contentView;
    public final TextView desView;
    public final ImageView favoriteImageView;
    public final TextView favoriteTextView;
    public final LinearLayout favoriteView;
    public final ImageIndicatorView indicatorView;
    public final FrameLayout itemView;
    public final ImageView likeImageView;
    public final TextView likeText;
    public final LinearLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final ImageView moreView;
    public final ImageView navigationView;
    public final TextView shareText;
    public final LinearLayout shareView;
    public final TextView sizeView;
    public final LinearLayout sizeViewContainer;
    public final LinearLayout textContainer;
    public final LinearLayout topContainer;
    public final View topShadeCover;
    public final LinearLayout userInfoView;
    public final TextView usernameView;
    public final CoolPicViewPager viewPager;
    public final TextView wallpaperSetView;
    public final TextView wallpaperSourceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemCoolpicDetailBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, UserAvatarView userAvatarView, LinearLayout linearLayout2, View view2, FrameLayout frameLayout, TextView textView2, LinearLayout linearLayout3, TextView textView3, TextView textView4, ImageView imageView, TextView textView5, LinearLayout linearLayout4, ImageIndicatorView imageIndicatorView, FrameLayout frameLayout2, ImageView imageView2, TextView textView6, LinearLayout linearLayout5, ImageView imageView3, ImageView imageView4, TextView textView7, LinearLayout linearLayout6, TextView textView8, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, View view3, LinearLayout linearLayout10, TextView textView9, CoolPicViewPager coolPicViewPager, TextView textView10, TextView textView11) {
        super(obj, view, i);
        this.actionContainer = linearLayout;
        this.actionView = textView;
        this.avatarView = userAvatarView;
        this.bottomContainer = linearLayout2;
        this.bottomShadeCover = view2;
        this.commentContainer = frameLayout;
        this.commentText = textView2;
        this.commentView = linearLayout3;
        this.contentView = textView3;
        this.desView = textView4;
        this.favoriteImageView = imageView;
        this.favoriteTextView = textView5;
        this.favoriteView = linearLayout4;
        this.indicatorView = imageIndicatorView;
        this.itemView = frameLayout2;
        this.likeImageView = imageView2;
        this.likeText = textView6;
        this.likeView = linearLayout5;
        this.moreView = imageView3;
        this.navigationView = imageView4;
        this.shareText = textView7;
        this.shareView = linearLayout6;
        this.sizeView = textView8;
        this.sizeViewContainer = linearLayout7;
        this.textContainer = linearLayout8;
        this.topContainer = linearLayout9;
        this.topShadeCover = view3;
        this.userInfoView = linearLayout10;
        this.usernameView = textView9;
        this.viewPager = coolPicViewPager;
        this.wallpaperSetView = textView10;
        this.wallpaperSourceView = textView11;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemCoolpicDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolpicDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCoolpicDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558669, viewGroup, z, obj);
    }

    public static ItemCoolpicDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolpicDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCoolpicDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558669, null, false, obj);
    }

    public static ItemCoolpicDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolpicDetailBinding bind(View view, Object obj) {
        return (ItemCoolpicDetailBinding) bind(obj, view, 2131558669);
    }
}
