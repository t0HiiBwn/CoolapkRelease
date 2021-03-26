package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Message;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.FatTextView;

public abstract class ItemMessageBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CheckBox checkBox;
    public final CoolEllipsizeTextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Message mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;
    public final FatTextView unreadView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Message message);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemMessageBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox2, CoolEllipsizeTextView coolEllipsizeTextView, TextView textView, FatTextView fatTextView, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.checkBox = checkBox2;
        this.infoView = coolEllipsizeTextView;
        this.titleView = textView;
        this.unreadView = fatTextView;
        this.userAvatarView = userAvatarView2;
    }

    public Message getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558824, viewGroup, z, obj);
    }

    public static ItemMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558824, null, false, obj);
    }

    public static ItemMessageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageBinding bind(View view, Object obj) {
        return (ItemMessageBinding) bind(obj, view, 2131558824);
    }
}
