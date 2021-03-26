package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.ShapedImageView;

public abstract class ItemCoolpicFallBinding extends ViewDataBinding {
    public final ShapedImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mFeed;
    public final ImageView multiPicView;
    public final TextView timeView;
    public final CoolEllipsizeTextView titleView;
    public final UserAvatarView userAvatarView;
    public final LinearLayout userInfoView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFeed(Feed feed);

    protected ItemCoolpicFallBinding(Object obj, View view, int i, ShapedImageView shapedImageView, FrameLayout frameLayout, ImageView imageView2, TextView textView, CoolEllipsizeTextView coolEllipsizeTextView, UserAvatarView userAvatarView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.imageView = shapedImageView;
        this.itemView = frameLayout;
        this.multiPicView = imageView2;
        this.timeView = textView;
        this.titleView = coolEllipsizeTextView;
        this.userAvatarView = userAvatarView2;
        this.userInfoView = linearLayout;
    }

    public Feed getFeed() {
        return this.mFeed;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCoolpicFallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolpicFallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCoolpicFallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558670, viewGroup, z, obj);
    }

    public static ItemCoolpicFallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolpicFallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCoolpicFallBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558670, null, false, obj);
    }

    public static ItemCoolpicFallBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoolpicFallBinding bind(View view, Object obj) {
        return (ItemCoolpicFallBinding) bind(obj, view, 2131558670);
    }
}
