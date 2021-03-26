package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.view.dyhv8.viewholder.DyhArticleVH;

public abstract class ItemDyhArticleV8Binding extends ViewDataBinding {
    public final FrameLayout contentContainer;
    public final LinearLayout contentLayout;
    public final FrameLayout coolPicPartContainer;
    public final CoolapkCardView coolapkCardView;
    public final FrameLayout coverView;
    public final LinearLayout headerBottomLayout;
    public final FrameLayout headerContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mFoldText;
    @Bindable
    protected DyhArticleVH mHolder;
    @Bindable
    protected String mListType;
    @Bindable
    protected DyhArticle mModel;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected DyhViewModel mViewModel;
    public final TextView newsFromWhereView;
    public final FrameLayout rightImageLayout;
    public final LinearLayout rootView;
    public final TextView sourceTimeView;
    public final TextView sourceTitleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFoldText(String str);

    public abstract void setHolder(DyhArticleVH dyhArticleVH);

    public abstract void setListType(String str);

    public abstract void setModel(DyhArticle dyhArticle);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(DyhViewModel dyhViewModel);

    protected ItemDyhArticleV8Binding(Object obj, View view, int i, FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, CoolapkCardView coolapkCardView2, FrameLayout frameLayout3, LinearLayout linearLayout2, FrameLayout frameLayout4, TextView textView, FrameLayout frameLayout5, LinearLayout linearLayout3, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.contentContainer = frameLayout;
        this.contentLayout = linearLayout;
        this.coolPicPartContainer = frameLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.coverView = frameLayout3;
        this.headerBottomLayout = linearLayout2;
        this.headerContainer = frameLayout4;
        this.newsFromWhereView = textView;
        this.rightImageLayout = frameLayout5;
        this.rootView = linearLayout3;
        this.sourceTimeView = textView2;
        this.sourceTitleView = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public DyhArticle getModel() {
        return this.mModel;
    }

    public DyhArticleVH getHolder() {
        return this.mHolder;
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

    public static ItemDyhArticleV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhArticleV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558678, viewGroup, z, obj);
    }

    public static ItemDyhArticleV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhArticleV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558678, null, false, obj);
    }

    public static ItemDyhArticleV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhArticleV8Binding bind(View view, Object obj) {
        return (ItemDyhArticleV8Binding) bind(obj, view, 2131558678);
    }
}
