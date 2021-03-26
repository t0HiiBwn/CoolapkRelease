package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.DyhArticle;

public abstract class ItemCoverViewBinding extends ViewDataBinding {
    public final ImageView extraImageView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected DyhArticle mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(DyhArticle dyhArticle);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemCoverViewBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.extraImageView = imageView;
        this.rootView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public DyhArticle getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemCoverViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoverViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCoverViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558671, viewGroup, z, obj);
    }

    public static ItemCoverViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoverViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCoverViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558671, null, false, obj);
    }

    public static ItemCoverViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCoverViewBinding bind(View view, Object obj) {
        return (ItemCoverViewBinding) bind(obj, view, 2131558671);
    }
}
