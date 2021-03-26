package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.SwipeScaleView;

public abstract class CoolPicFullScreenBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout contentView;
    public final FrameLayout coolPicListContainer;
    public final TextView hintView;
    public final FrameLayout loadingContainer;
    public final ProgressBar loadingView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final SwipeScaleView swipeScaleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected CoolPicFullScreenBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, ProgressBar progressBar, SwipeScaleView swipeScaleView2) {
        super(obj, view, i);
        this.contentView = drawSystemBarFrameLayout;
        this.coolPicListContainer = frameLayout;
        this.hintView = textView;
        this.loadingContainer = frameLayout2;
        this.loadingView = progressBar;
        this.swipeScaleView = swipeScaleView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public static CoolPicFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolPicFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CoolPicFullScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558488, viewGroup, z, obj);
    }

    public static CoolPicFullScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolPicFullScreenBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CoolPicFullScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558488, null, false, obj);
    }

    public static CoolPicFullScreenBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolPicFullScreenBinding bind(View view, Object obj) {
        return (CoolPicFullScreenBinding) bind(obj, view, 2131558488);
    }
}
