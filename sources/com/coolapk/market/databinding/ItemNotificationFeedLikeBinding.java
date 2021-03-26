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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemNotificationFeedLikeBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final CoolapkCardView coolapkCardView;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView textView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemNotificationFeedLikeBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, TextView textView2, TextView textView3, UserAvatarView userAvatarView2, TextView textView4) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.contentView = linearLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.infoView = textView2;
        this.textView = textView3;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView4;
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

    public static ItemNotificationFeedLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationFeedLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNotificationFeedLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558851, viewGroup, z, obj);
    }

    public static ItemNotificationFeedLikeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationFeedLikeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNotificationFeedLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558851, null, false, obj);
    }

    public static ItemNotificationFeedLikeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationFeedLikeBinding bind(View view, Object obj) {
        return (ItemNotificationFeedLikeBinding) bind(obj, view, 2131558851);
    }
}
