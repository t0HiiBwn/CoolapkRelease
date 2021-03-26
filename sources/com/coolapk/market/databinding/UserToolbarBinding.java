package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.UserAvatarView;

public abstract class UserToolbarBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mUserAvatar;
    @Bindable
    protected String mUserName;
    @Bindable
    protected String mUserVerifyStatusIcon;
    public final LinearLayout toolbarActionContainer;
    public final TextView toolbarActionView;
    public final TextView toolbarNameView;
    public final UserAvatarView toolbarUserAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUserAvatar(String str);

    public abstract void setUserName(String str);

    public abstract void setUserVerifyStatusIcon(String str);

    protected UserToolbarBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, UserAvatarView userAvatarView) {
        super(obj, view, i);
        this.toolbarActionContainer = linearLayout;
        this.toolbarActionView = textView;
        this.toolbarNameView = textView2;
        this.toolbarUserAvatarView = userAvatarView;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getUserAvatar() {
        return this.mUserAvatar;
    }

    public String getUserVerifyStatusIcon() {
        return this.mUserVerifyStatusIcon;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static UserToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559296, viewGroup, z, obj);
    }

    public static UserToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserToolbarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559296, null, false, obj);
    }

    public static UserToolbarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserToolbarBinding bind(View view, Object obj) {
        return (UserToolbarBinding) bind(obj, view, 2131559296);
    }
}
