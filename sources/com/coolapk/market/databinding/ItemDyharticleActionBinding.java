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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.DyhArticle;

public abstract class ItemDyharticleActionBinding extends ViewDataBinding {
    public final ImageView commentIcon;
    public final TextView commentNum;
    public final LinearLayout commentView;
    public final ImageView forwardIcon;
    public final TextView forwardNum;
    public final LinearLayout forwardView;
    public final ImageView likeIcon;
    public final TextView likeNum;
    public final LinearLayout likeView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected DyhArticle mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(DyhArticle dyhArticle);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemDyharticleActionBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView2, TextView textView2, LinearLayout linearLayout2, ImageView imageView3, TextView textView3, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.commentIcon = imageView;
        this.commentNum = textView;
        this.commentView = linearLayout;
        this.forwardIcon = imageView2;
        this.forwardNum = textView2;
        this.forwardView = linearLayout2;
        this.likeIcon = imageView3;
        this.likeNum = textView3;
        this.likeView = linearLayout3;
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

    public static ItemDyharticleActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyharticleActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyharticleActionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558685, viewGroup, z, obj);
    }

    public static ItemDyharticleActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyharticleActionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyharticleActionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558685, null, false, obj);
    }

    public static ItemDyharticleActionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyharticleActionBinding bind(View view, Object obj) {
        return (ItemDyharticleActionBinding) bind(obj, view, 2131558685);
    }
}
