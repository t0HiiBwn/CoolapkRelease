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
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleVH;

public abstract class ItemDyhMiniHeaderBinding extends ViewDataBinding {
    public final LinearLayout articleTemplateLayout;
    public final ImageView dyhLogoView;
    public final TextView dyhNameView;
    public final TextView dyhTimeView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mFoldText;
    @Bindable
    protected DyhArticleVH mHolder;
    @Bindable
    protected String mListType;
    @Bindable
    protected DyhViewModel mModel;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFoldText(String str);

    public abstract void setHolder(DyhArticleVH dyhArticleVH);

    public abstract void setListType(String str);

    public abstract void setModel(DyhViewModel dyhViewModel);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemDyhMiniHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.articleTemplateLayout = linearLayout;
        this.dyhLogoView = imageView;
        this.dyhNameView = textView;
        this.dyhTimeView = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public DyhViewModel getModel() {
        return this.mModel;
    }

    public DyhArticleVH getHolder() {
        return this.mHolder;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public String getSingleImg() {
        return this.mSingleImg;
    }

    public String getListType() {
        return this.mListType;
    }

    public String getFoldText() {
        return this.mFoldText;
    }

    public static ItemDyhMiniHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhMiniHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhMiniHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558681, viewGroup, z, obj);
    }

    public static ItemDyhMiniHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhMiniHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhMiniHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558681, null, false, obj);
    }

    public static ItemDyhMiniHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhMiniHeaderBinding bind(View view, Object obj) {
        return (ItemDyhMiniHeaderBinding) bind(obj, view, 2131558681);
    }
}
