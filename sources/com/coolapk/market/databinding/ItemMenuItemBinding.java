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
import com.coolapk.market.model.Entity;

public abstract class ItemMenuItemBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final ImageView enterView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView moreTextView;
    public final LinearLayout rootView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemMenuItemBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, ImageView imageView, ImageView imageView2, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.enterView = imageView;
        this.logoView = imageView2;
        this.moreTextView = textView;
        this.rootView = linearLayout;
        this.titleView = textView2;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMenuItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558823, viewGroup, z, obj);
    }

    public static ItemMenuItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMenuItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMenuItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558823, null, false, obj);
    }

    public static ItemMenuItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMenuItemBinding bind(View view, Object obj) {
        return (ItemMenuItemBinding) bind(obj, view, 2131558823);
    }
}
