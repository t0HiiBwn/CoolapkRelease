package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemGoodsFallBinding extends ViewDataBinding {
    public final TextView buyTextView;
    public final MaxWidthFrameLayout imageContainer;
    public final ScalingImageView imageView;
    public final LinearLayout imgUpView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mImageUrl;
    @Bindable
    protected Feed mModel;
    public final CoolEllipsizeTextView messageView;
    public final BadBadRatingBar ratingBar;
    public final TextView timeView;
    public final CoolEllipsizeTextView titleView;
    public final UserAvatarView userAvatarView;
    public final LinearLayout userInfoView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setImageUrl(String str);

    public abstract void setModel(Feed feed);

    protected ItemGoodsFallBinding(Object obj, View view, int i, TextView textView, MaxWidthFrameLayout maxWidthFrameLayout, ScalingImageView scalingImageView, LinearLayout linearLayout, LinearLayout linearLayout2, CoolEllipsizeTextView coolEllipsizeTextView, BadBadRatingBar badBadRatingBar, TextView textView2, CoolEllipsizeTextView coolEllipsizeTextView2, UserAvatarView userAvatarView2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.buyTextView = textView;
        this.imageContainer = maxWidthFrameLayout;
        this.imageView = scalingImageView;
        this.imgUpView = linearLayout;
        this.itemView = linearLayout2;
        this.messageView = coolEllipsizeTextView;
        this.ratingBar = badBadRatingBar;
        this.timeView = textView2;
        this.titleView = coolEllipsizeTextView2;
        this.userAvatarView = userAvatarView2;
        this.userInfoView = linearLayout3;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGoodsFallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsFallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsFallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558756, viewGroup, z, obj);
    }

    public static ItemGoodsFallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsFallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsFallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558756, null, false, obj);
    }

    public static ItemGoodsFallBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsFallBinding bind(View view, Object obj) {
        return (ItemGoodsFallBinding) bind(obj, view, 2131558756);
    }
}
