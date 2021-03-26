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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.User;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemUserBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final LinearLayout cardView;
    public final CheckBox checkBox;
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout detailContainerView;
    public final UserAvatarView iconView;
    public final TextView introduceView;
    public final TextView loginTimeView;
    @Bindable
    protected String mFans;
    @Bindable
    protected String mFollow;
    @Bindable
    protected User mModel;
    @Bindable
    protected View.OnClickListener mOnClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final ImageView messageView;
    public final TextView subtitleView;
    public final TextView titleView;

    public abstract void setFans(String str);

    public abstract void setFollow(String str);

    public abstract void setModel(User user);

    public abstract void setOnClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemUserBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, LinearLayout linearLayout, CheckBox checkBox2, CoolapkCardView coolapkCardView2, LinearLayout linearLayout2, UserAvatarView userAvatarView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.cardView = linearLayout;
        this.checkBox = checkBox2;
        this.coolapkCardView = coolapkCardView2;
        this.detailContainerView = linearLayout2;
        this.iconView = userAvatarView;
        this.introduceView = textView2;
        this.loginTimeView = textView3;
        this.messageView = imageView;
        this.subtitleView = textView4;
        this.titleView = textView5;
    }

    public View.OnClickListener getOnClick() {
        return this.mOnClick;
    }

    public User getModel() {
        return this.mModel;
    }

    public String getFollow() {
        return this.mFollow;
    }

    public String getFans() {
        return this.mFans;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558974, viewGroup, z, obj);
    }

    public static ItemUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558974, null, false, obj);
    }

    public static ItemUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserBinding bind(View view, Object obj) {
        return (ItemUserBinding) bind(obj, view, 2131558974);
    }
}
