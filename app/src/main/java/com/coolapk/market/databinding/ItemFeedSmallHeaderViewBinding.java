package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemFeedSmallHeaderViewBinding extends ViewDataBinding {
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView nameView;
    public final TextView timeView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFeedSmallHeaderViewBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.infoView = textView;
        this.nameView = textView2;
        this.timeView = textView3;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedSmallHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSmallHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedSmallHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558727, viewGroup, z, obj);
    }

    public static ItemFeedSmallHeaderViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSmallHeaderViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedSmallHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558727, null, false, obj);
    }

    public static ItemFeedSmallHeaderViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSmallHeaderViewBinding bind(View view, Object obj) {
        return (ItemFeedSmallHeaderViewBinding) bind(obj, view, 2131558727);
    }
}
