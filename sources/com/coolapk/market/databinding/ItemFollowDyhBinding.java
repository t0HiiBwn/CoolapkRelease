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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.view.dyhv8.DyhViewModel;

public abstract class ItemFollowDyhBinding extends ViewDataBinding {
    public final TextView actionView;
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected DyhViewModel mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;
    public final View statusView;
    public final TextView timeView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(DyhViewModel dyhViewModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFollowDyhBinding(Object obj, View view, int i, TextView textView, CoolapkCardView coolapkCardView2, TextView textView2, ImageView imageView, LinearLayout linearLayout, View view2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.actionView = textView;
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView2;
        this.logoView = imageView;
        this.rootView = linearLayout;
        this.statusView = view2;
        this.timeView = textView3;
        this.titleView = textView4;
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

    public static ItemFollowDyhBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFollowDyhBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFollowDyhBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558747, viewGroup, z, obj);
    }

    public static ItemFollowDyhBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFollowDyhBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFollowDyhBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558747, null, false, obj);
    }

    public static ItemFollowDyhBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFollowDyhBinding bind(View view, Object obj) {
        return (ItemFollowDyhBinding) bind(obj, view, 2131558747);
    }
}
