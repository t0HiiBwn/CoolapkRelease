package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemFeedScrollItemBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final Space extraTypeContainer;
    public final FrameLayout headerContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final CoolEllipsizeTextView textView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFeedScrollItemBinding(Object obj, View view, int i, LinearLayout linearLayout, Space space, FrameLayout frameLayout, CoolEllipsizeTextView coolEllipsizeTextView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.extraTypeContainer = space;
        this.headerContainer = frameLayout;
        this.textView = coolEllipsizeTextView;
        this.titleView = textView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedScrollItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedScrollItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedScrollItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558723, viewGroup, z, obj);
    }

    public static ItemFeedScrollItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedScrollItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedScrollItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558723, null, false, obj);
    }

    public static ItemFeedScrollItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedScrollItemBinding bind(View view, Object obj) {
        return (ItemFeedScrollItemBinding) bind(obj, view, 2131558723);
    }
}
