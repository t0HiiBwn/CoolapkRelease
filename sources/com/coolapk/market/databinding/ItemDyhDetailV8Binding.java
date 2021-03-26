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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.widget.AutoLinkTextView;

public abstract class ItemDyhDetailV8Binding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout cardView;
    public final LinearLayout contentLayout;
    public final FrameLayout coolPicPartContainer;
    public final FrameLayout coverView;
    public final LinearLayout dyhTitleView;
    public final ImageView extendIcon;
    public final LinearLayout extendLayout;
    public final TextView extendSubTitle;
    public final TextView extendTitle;
    public final TextView fromWhereView;
    public final LinearLayout headerBottomLayout;
    public final TextView headerTimeView;
    public final TextView headerTitleView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected DyhViewModel mModel;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView realTitleView;
    public final FrameLayout rightImageLayout;
    public final AutoLinkTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(DyhViewModel dyhViewModel);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemDyhDetailV8Binding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout3, ImageView imageView, LinearLayout linearLayout4, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout5, TextView textView5, TextView textView6, ImageView imageView2, TextView textView7, FrameLayout frameLayout3, AutoLinkTextView autoLinkTextView) {
        super(obj, view, i);
        this.actionView = textView;
        this.cardView = linearLayout;
        this.contentLayout = linearLayout2;
        this.coolPicPartContainer = frameLayout;
        this.coverView = frameLayout2;
        this.dyhTitleView = linearLayout3;
        this.extendIcon = imageView;
        this.extendLayout = linearLayout4;
        this.extendSubTitle = textView2;
        this.extendTitle = textView3;
        this.fromWhereView = textView4;
        this.headerBottomLayout = linearLayout5;
        this.headerTimeView = textView5;
        this.headerTitleView = textView6;
        this.logoView = imageView2;
        this.realTitleView = textView7;
        this.rightImageLayout = frameLayout3;
        this.titleView = autoLinkTextView;
    }

    public DyhViewModel getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public String getSingleImg() {
        return this.mSingleImg;
    }

    public static ItemDyhDetailV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhDetailV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhDetailV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558685, viewGroup, z, obj);
    }

    public static ItemDyhDetailV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhDetailV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhDetailV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558685, null, false, obj);
    }

    public static ItemDyhDetailV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhDetailV8Binding bind(View view, Object obj) {
        return (ItemDyhDetailV8Binding) bind(obj, view, 2131558685);
    }
}
