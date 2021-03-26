package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public abstract class ItemFeedHeaderViewBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final EllipsizeTextView fromWhereView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final TextView modifyView;
    public final ImageView moreView;
    public final TextView nameView;
    public final TextView timeView;
    public final View topDivider;
    public final FeedTopBinding topView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemFeedHeaderViewBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, EllipsizeTextView ellipsizeTextView, TextView textView, ImageView imageView, TextView textView2, TextView textView3, View view2, FeedTopBinding feedTopBinding, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.fromWhereView = ellipsizeTextView;
        this.modifyView = textView;
        this.moreView = imageView;
        this.nameView = textView2;
        this.timeView = textView3;
        this.topDivider = view2;
        this.topView = feedTopBinding;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558713, viewGroup, z, obj);
    }

    public static ItemFeedHeaderViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedHeaderViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558713, null, false, obj);
    }

    public static ItemFeedHeaderViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedHeaderViewBinding bind(View view, Object obj) {
        return (ItemFeedHeaderViewBinding) bind(obj, view, 2131558713);
    }
}
