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
import com.coolapk.market.viewholder.SmallScrollCardItemViewHolder;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemSmallScrollCardItemBinding extends ViewDataBinding {
    public final ActionButton actionContainer;
    public final UserAvatarView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected SmallScrollCardItemViewHolder mModel;
    public final TextView scoreView;
    public final ImageView scoreViewIcon;
    public final TextView titleView;

    public abstract void setModel(SmallScrollCardItemViewHolder smallScrollCardItemViewHolder);

    protected ItemSmallScrollCardItemBinding(Object obj, View view, int i, ActionButton actionButton, UserAvatarView userAvatarView, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView, TextView textView3) {
        super(obj, view, i);
        this.actionContainer = actionButton;
        this.iconView = userAvatarView;
        this.infoView = textView;
        this.itemView = linearLayout;
        this.scoreView = textView2;
        this.scoreViewIcon = imageView;
        this.titleView = textView3;
    }

    public SmallScrollCardItemViewHolder getModel() {
        return this.mModel;
    }

    public static ItemSmallScrollCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSmallScrollCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSmallScrollCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558942, viewGroup, z, obj);
    }

    public static ItemSmallScrollCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSmallScrollCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSmallScrollCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558942, null, false, obj);
    }

    public static ItemSmallScrollCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSmallScrollCardItemBinding bind(View view, Object obj) {
        return (ItemSmallScrollCardItemBinding) bind(obj, view, 2131558942);
    }
}
