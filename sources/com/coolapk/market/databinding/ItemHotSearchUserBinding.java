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
import com.coolapk.market.model.User;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemHotSearchUserBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final UserAvatarView iconView;
    @Bindable
    protected User mModel;
    @Bindable
    protected View.OnClickListener mOnClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView subTitleView;
    public final TextView titleView;

    public abstract void setModel(User user);

    public abstract void setOnClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemHotSearchUserBinding(Object obj, View view, int i, LinearLayout linearLayout, UserAvatarView userAvatarView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = userAvatarView;
        this.subTitleView = textView;
        this.titleView = textView2;
    }

    public View.OnClickListener getOnClick() {
        return this.mOnClick;
    }

    public User getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemHotSearchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotSearchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHotSearchUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558783, viewGroup, z, obj);
    }

    public static ItemHotSearchUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotSearchUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHotSearchUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558783, null, false, obj);
    }

    public static ItemHotSearchUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHotSearchUserBinding bind(View view, Object obj) {
        return (ItemHotSearchUserBinding) bind(obj, view, 2131558783);
    }
}
