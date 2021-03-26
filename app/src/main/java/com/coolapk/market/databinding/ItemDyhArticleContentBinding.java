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
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.widget.AutoLinkTextView;

public abstract class ItemDyhArticleContentBinding extends ViewDataBinding {
    public final LinearLayout contentLayout;
    @Bindable
    protected String mFoldText;
    @Bindable
    protected String mListType;
    @Bindable
    protected DyhViewModel mModel;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView realTitleView;
    public final LinearLayout rootView;
    public final AutoLinkTextView titleView;

    public abstract void setFoldText(String str);

    public abstract void setListType(String str);

    public abstract void setModel(DyhViewModel dyhViewModel);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemDyhArticleContentBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, AutoLinkTextView autoLinkTextView) {
        super(obj, view, i);
        this.contentLayout = linearLayout;
        this.realTitleView = textView;
        this.rootView = linearLayout2;
        this.titleView = autoLinkTextView;
    }

    public DyhViewModel getModel() {
        return this.mModel;
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

    public static ItemDyhArticleContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhArticleContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558676, viewGroup, z, obj);
    }

    public static ItemDyhArticleContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhArticleContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558676, null, false, obj);
    }

    public static ItemDyhArticleContentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleContentBinding bind(View view, Object obj) {
        return (ItemDyhArticleContentBinding) bind(obj, view, 2131558676);
    }
}
