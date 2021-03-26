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
import com.coolapk.market.model.Notification;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemNotificationBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Notification mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Notification notification);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemNotificationBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.infoView = textView;
        this.titleView = textView2;
        this.userAvatarView = userAvatarView2;
    }

    public Notification getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558842, viewGroup, z, obj);
    }

    public static ItemNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558842, null, false, obj);
    }

    public static ItemNotificationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationBinding bind(View view, Object obj) {
        return (ItemNotificationBinding) bind(obj, view, 2131558842);
    }
}
