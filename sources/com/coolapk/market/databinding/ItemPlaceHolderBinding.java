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
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemPlaceHolderBinding extends ViewDataBinding {
    public final UserAvatarView avatarView;
    public final TextView deleteView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected ItemPlaceHolder mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;
    public final LinearLayout userInfo;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(ItemPlaceHolder itemPlaceHolder);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemPlaceHolderBinding(Object obj, View view, int i, UserAvatarView userAvatarView, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.avatarView = userAvatarView;
        this.deleteView = textView;
        this.itemView = linearLayout;
        this.titleView = textView2;
        this.userInfo = linearLayout2;
    }

    public ItemPlaceHolder getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemPlaceHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPlaceHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPlaceHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558858, viewGroup, z, obj);
    }

    public static ItemPlaceHolderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPlaceHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPlaceHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558858, null, false, obj);
    }

    public static ItemPlaceHolderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPlaceHolderBinding bind(View view, Object obj) {
        return (ItemPlaceHolderBinding) bind(obj, view, 2131558858);
    }
}
