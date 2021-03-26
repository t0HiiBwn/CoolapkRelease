package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.collectionList.CollectionViewModel;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemCollectionHeaderBinding extends ViewDataBinding {
    public final UserAvatarView avatarView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected CollectionViewModel mViewModel;
    public final View spaceHolder;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(CollectionViewModel collectionViewModel);

    protected ItemCollectionHeaderBinding(Object obj, View view, int i, UserAvatarView userAvatarView, LinearLayout linearLayout, View view2) {
        super(obj, view, i);
        this.avatarView = userAvatarView;
        this.itemView = linearLayout;
        this.spaceHolder = view2;
    }

    public CollectionViewModel getViewModel() {
        return this.mViewModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemCollectionHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCollectionHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558661, viewGroup, z, obj);
    }

    public static ItemCollectionHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCollectionHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558661, null, false, obj);
    }

    public static ItemCollectionHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCollectionHeaderBinding bind(View view, Object obj) {
        return (ItemCollectionHeaderBinding) bind(obj, view, 2131558661);
    }
}
