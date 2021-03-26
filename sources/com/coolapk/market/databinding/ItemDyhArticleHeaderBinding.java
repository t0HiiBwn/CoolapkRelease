package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public abstract class ItemDyhArticleHeaderBinding extends ViewDataBinding {
    public final LinearLayout dyhTitleView;
    public final TextView fromWhereView;
    public final ImageView gotoView;
    public final TextView headerActionView;
    public final TextView headerTimeView;
    public final TextView headerTitleView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mEntity;
    @Bindable
    protected String mFoldText;
    @Bindable
    protected String mListType;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected DyhViewModel mViewModel;
    public final ProgressBar progressView;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setEntity(Entity entity);

    public abstract void setFoldText(String str);

    public abstract void setListType(String str);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(DyhViewModel dyhViewModel);

    protected ItemDyhArticleHeaderBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, ProgressBar progressBar, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.dyhTitleView = linearLayout;
        this.fromWhereView = textView;
        this.gotoView = imageView;
        this.headerActionView = textView2;
        this.headerTimeView = textView3;
        this.headerTitleView = textView4;
        this.logoView = imageView2;
        this.progressView = progressBar;
        this.rootView = linearLayout2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Entity getEntity() {
        return this.mEntity;
    }

    public DyhViewModel getViewModel() {
        return this.mViewModel;
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

    public static ItemDyhArticleHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhArticleHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558677, viewGroup, z, obj);
    }

    public static ItemDyhArticleHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhArticleHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558677, null, false, obj);
    }

    public static ItemDyhArticleHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleHeaderBinding bind(View view, Object obj) {
        return (ItemDyhArticleHeaderBinding) bind(obj, view, 2131558677);
    }
}
