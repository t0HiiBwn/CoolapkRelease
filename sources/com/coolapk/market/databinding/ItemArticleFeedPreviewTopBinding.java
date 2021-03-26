package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemArticleFeedPreviewTopBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout cardView;
    public final View coverViewMask;
    public final TextView fromWhereView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView nameView;
    public final TextView timeView;
    public final TextView titleView;
    public final ScalingImageView topImageView;
    public final UserAvatarView userAvatarView;
    public final LinearLayout userViewContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemArticleFeedPreviewTopBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, View view2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ScalingImageView scalingImageView, UserAvatarView userAvatarView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.actionView = textView;
        this.cardView = linearLayout;
        this.coverViewMask = view2;
        this.fromWhereView = textView2;
        this.nameView = textView3;
        this.timeView = textView4;
        this.titleView = textView5;
        this.topImageView = scalingImageView;
        this.userAvatarView = userAvatarView2;
        this.userViewContainer = linearLayout2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemArticleFeedPreviewTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleFeedPreviewTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleFeedPreviewTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558618, viewGroup, z, obj);
    }

    public static ItemArticleFeedPreviewTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleFeedPreviewTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleFeedPreviewTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558618, null, false, obj);
    }

    public static ItemArticleFeedPreviewTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleFeedPreviewTopBinding bind(View view, Object obj) {
        return (ItemArticleFeedPreviewTopBinding) bind(obj, view, 2131558618);
    }
}
