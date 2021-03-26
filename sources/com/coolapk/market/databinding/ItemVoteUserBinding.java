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

public abstract class ItemVoteUserBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView loginTimeView;
    @Bindable
    protected User mModel;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setModel(User user);

    protected ItemVoteUserBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.loginTimeView = textView;
        this.titleView = textView2;
        this.userAvatarView = userAvatarView2;
    }

    public User getModel() {
        return this.mModel;
    }

    public static ItemVoteUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVoteUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558996, viewGroup, z, obj);
    }

    public static ItemVoteUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVoteUserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558996, null, false, obj);
    }

    public static ItemVoteUserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteUserBinding bind(View view, Object obj) {
        return (ItemVoteUserBinding) bind(obj, view, 2131558996);
    }
}
