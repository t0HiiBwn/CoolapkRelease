package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemCircleFeedTopBinding extends ViewDataBinding {
    public final ImageView cameraView;
    public final ImageView editView;
    public final ImageView filterView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemCircleFeedTopBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.cameraView = imageView;
        this.editView = imageView2;
        this.filterView = imageView3;
        this.titleView = textView;
        this.userAvatarView = userAvatarView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemCircleFeedTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCircleFeedTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCircleFeedTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558652, viewGroup, z, obj);
    }

    public static ItemCircleFeedTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCircleFeedTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCircleFeedTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558652, null, false, obj);
    }

    public static ItemCircleFeedTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCircleFeedTopBinding bind(View view, Object obj) {
        return (ItemCircleFeedTopBinding) bind(obj, view, 2131558652);
    }
}
