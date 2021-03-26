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
import com.coolapk.market.model.Contacts;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemContactBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final LinearLayout cardView;
    public final CheckBox checkBox;
    public final LinearLayout detailContainerView;
    public final UserAvatarView iconView;
    public final TextView introduceView;
    public final TextView loginTimeView;
    @Bindable
    protected String mFans;
    @Bindable
    protected String mFollow;
    @Bindable
    protected int mListType;
    @Bindable
    protected String mLoginTime;
    @Bindable
    protected Contacts mModel;
    @Bindable
    protected View.OnClickListener mOnClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected String mUid;
    public final ImageView messageView;
    public final TextView titleView;

    public abstract void setFans(String str);

    public abstract void setFollow(String str);

    public abstract void setListType(int i);

    public abstract void setLoginTime(String str);

    public abstract void setModel(Contacts contacts);

    public abstract void setOnClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setUid(String str);

    protected ItemContactBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, LinearLayout linearLayout, CheckBox checkBox2, LinearLayout linearLayout2, UserAvatarView userAvatarView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.cardView = linearLayout;
        this.checkBox = checkBox2;
        this.detailContainerView = linearLayout2;
        this.iconView = userAvatarView;
        this.introduceView = textView2;
        this.loginTimeView = textView3;
        this.messageView = imageView;
        this.titleView = textView4;
    }

    public View.OnClickListener getOnClick() {
        return this.mOnClick;
    }

    public String getUid() {
        return this.mUid;
    }

    public int getListType() {
        return this.mListType;
    }

    public String getFollow() {
        return this.mFollow;
    }

    public String getLoginTime() {
        return this.mLoginTime;
    }

    public String getFans() {
        return this.mFans;
    }

    public Contacts getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemContactBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558666, viewGroup, z, obj);
    }

    public static ItemContactBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemContactBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemContactBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558666, null, false, obj);
    }

    public static ItemContactBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemContactBinding bind(View view, Object obj) {
        return (ItemContactBinding) bind(obj, view, 2131558666);
    }
}
