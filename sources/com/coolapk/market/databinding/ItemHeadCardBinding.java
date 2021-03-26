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
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemHeadCardBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final View coverViewMask;
    public final TextView descriptionView;
    public final View dividerView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Entity mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView timeView;
    public final LinearLayout titleContainer;
    public final TextView titleView;
    public final ScalingImageView topImageView;
    public final FrameLayout topImageViewContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Entity entity);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemHeadCardBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, View view2, TextView textView, View view3, TextView textView2, LinearLayout linearLayout2, TextView textView3, ScalingImageView scalingImageView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.coverViewMask = view2;
        this.descriptionView = textView;
        this.dividerView = view3;
        this.timeView = textView2;
        this.titleContainer = linearLayout2;
        this.titleView = textView3;
        this.topImageView = scalingImageView;
        this.topImageViewContainer = frameLayout;
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

    public static ItemHeadCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeadCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHeadCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558779, viewGroup, z, obj);
    }

    public static ItemHeadCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeadCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHeadCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558779, null, false, obj);
    }

    public static ItemHeadCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeadCardBinding bind(View view, Object obj) {
        return (ItemHeadCardBinding) bind(obj, view, 2131558779);
    }
}
