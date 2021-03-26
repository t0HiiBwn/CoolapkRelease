package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemTripleCoolPicBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final AspectRatioImageView imageView1;
    public final AspectRatioImageView imageView2;
    public final AspectRatioImageView imageView3;
    public final LinearLayout imgUpView1;
    public final LinearLayout imgUpView2;
    public final LinearLayout imgUpView3;
    public final LinearLayout itemView1;
    public final LinearLayout itemView2;
    public final LinearLayout itemView3;
    public final LinearLayout itemWallpaperView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mFeed1;
    @Bindable
    protected Feed mFeed2;
    @Bindable
    protected Feed mFeed3;
    @Bindable
    protected View.OnLongClickListener mLongClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final ImageView multiPicView1;
    public final ImageView multiPicView2;
    public final ImageView multiPicView3;
    public final CoolEllipsizeTextView textView1;
    public final CoolEllipsizeTextView textView2;
    public final CoolEllipsizeTextView textView3;
    public final UserAvatarView userAvatarView1;
    public final UserAvatarView userAvatarView2;
    public final UserAvatarView userAvatarView3;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFeed1(Feed feed);

    public abstract void setFeed2(Feed feed);

    public abstract void setFeed3(Feed feed);

    public abstract void setLongClick(View.OnLongClickListener onLongClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemTripleCoolPicBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, AspectRatioImageView aspectRatioImageView, AspectRatioImageView aspectRatioImageView2, AspectRatioImageView aspectRatioImageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, ImageView imageView, ImageView imageView4, ImageView imageView5, CoolEllipsizeTextView coolEllipsizeTextView, CoolEllipsizeTextView coolEllipsizeTextView2, CoolEllipsizeTextView coolEllipsizeTextView3, UserAvatarView userAvatarView, UserAvatarView userAvatarView4, UserAvatarView userAvatarView5) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.imageView1 = aspectRatioImageView;
        this.imageView2 = aspectRatioImageView2;
        this.imageView3 = aspectRatioImageView3;
        this.imgUpView1 = linearLayout;
        this.imgUpView2 = linearLayout2;
        this.imgUpView3 = linearLayout3;
        this.itemView1 = linearLayout4;
        this.itemView2 = linearLayout5;
        this.itemView3 = linearLayout6;
        this.itemWallpaperView = linearLayout7;
        this.multiPicView1 = imageView;
        this.multiPicView2 = imageView4;
        this.multiPicView3 = imageView5;
        this.textView1 = coolEllipsizeTextView;
        this.textView2 = coolEllipsizeTextView2;
        this.textView3 = coolEllipsizeTextView3;
        this.userAvatarView1 = userAvatarView;
        this.userAvatarView2 = userAvatarView4;
        this.userAvatarView3 = userAvatarView5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public View.OnLongClickListener getLongClick() {
        return this.mLongClick;
    }

    public Feed getFeed1() {
        return this.mFeed1;
    }

    public Feed getFeed2() {
        return this.mFeed2;
    }

    public Feed getFeed3() {
        return this.mFeed3;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemTripleCoolPicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTripleCoolPicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTripleCoolPicBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558964, viewGroup, z, obj);
    }

    public static ItemTripleCoolPicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTripleCoolPicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTripleCoolPicBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558964, null, false, obj);
    }

    public static ItemTripleCoolPicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTripleCoolPicBinding bind(View view, Object obj) {
        return (ItemTripleCoolPicBinding) bind(obj, view, 2131558964);
    }
}
