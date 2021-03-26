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
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.widget.RoundProgress;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemCenterUserInfoBinding extends ViewDataBinding {
    public final TextView allExperience;
    public final TextView curExperience;
    public final LinearLayout levelBarView;
    public final TextView levelTextView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected UserProfile mModel;
    public final TextView nameView;
    public final RoundProgress progressBar;
    public final ImageView qrCodeView;
    public final UserAvatarView userAvatarView;
    public final LinearLayout userInfoItem;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(UserProfile userProfile);

    protected ItemCenterUserInfoBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4, RoundProgress roundProgress, ImageView imageView, UserAvatarView userAvatarView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.allExperience = textView;
        this.curExperience = textView2;
        this.levelBarView = linearLayout;
        this.levelTextView = textView3;
        this.nameView = textView4;
        this.progressBar = roundProgress;
        this.qrCodeView = imageView;
        this.userAvatarView = userAvatarView2;
        this.userInfoItem = linearLayout2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public UserProfile getModel() {
        return this.mModel;
    }

    public static ItemCenterUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558643, viewGroup, z, obj);
    }

    public static ItemCenterUserInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterUserInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterUserInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558643, null, false, obj);
    }

    public static ItemCenterUserInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterUserInfoBinding bind(View view, Object obj) {
        return (ItemCenterUserInfoBinding) bind(obj, view, 2131558643);
    }
}
