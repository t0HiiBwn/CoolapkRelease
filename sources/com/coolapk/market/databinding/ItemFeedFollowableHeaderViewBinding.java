package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemFeedFollowableHeaderViewBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final TextView followView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView modifyView;
    public final TextView nameView;
    public final TextView timeView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedFollowableHeaderViewBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.followView = textView;
        this.modifyView = textView2;
        this.nameView = textView3;
        this.timeView = textView4;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedFollowableHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedFollowableHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedFollowableHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558700, viewGroup, z, obj);
    }

    public static ItemFeedFollowableHeaderViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedFollowableHeaderViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedFollowableHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558700, null, false, obj);
    }

    public static ItemFeedFollowableHeaderViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedFollowableHeaderViewBinding bind(View view, Object obj) {
        return (ItemFeedFollowableHeaderViewBinding) bind(obj, view, 2131558700);
    }
}
