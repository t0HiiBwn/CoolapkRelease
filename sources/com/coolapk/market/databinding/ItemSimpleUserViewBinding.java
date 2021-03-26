package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.User;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemSimpleUserViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final UserAvatarView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected User mModel;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(User user);

    protected ItemSimpleUserViewBinding(Object obj, View view, int i, LinearLayout linearLayout, UserAvatarView userAvatarView, TextView textView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.iconView = userAvatarView;
        this.titleView = textView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public User getModel() {
        return this.mModel;
    }

    public static ItemSimpleUserViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleUserViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSimpleUserViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558933, viewGroup, z, obj);
    }

    public static ItemSimpleUserViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleUserViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSimpleUserViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558933, null, false, obj);
    }

    public static ItemSimpleUserViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSimpleUserViewBinding bind(View view, Object obj) {
        return (ItemSimpleUserViewBinding) bind(obj, view, 2131558933);
    }
}
