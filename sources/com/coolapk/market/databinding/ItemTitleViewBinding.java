package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemTitleViewBinding extends ViewDataBinding {
    public final View bottomDivider;
    public final ImageView bottomImageView;
    public final LinearLayout bottomTitleContainer;
    public final TextView bottomTitleView;
    public final FrameLayout bottomView;
    public final ImageView closeView;
    public final ImageView enterView;
    public final ImageView imageView;
    public final TextView moreTextView;
    public final FrameLayout moreView;
    public final Space spaceView;
    public final LinearLayout titleContainer;
    public final TextView titleView;
    public final View topDivider;
    public final LinearLayout wrapperView;

    protected ItemTitleViewBinding(Object obj, View view, int i, View view2, ImageView imageView2, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView2, FrameLayout frameLayout2, Space space, LinearLayout linearLayout2, TextView textView3, View view3, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.bottomDivider = view2;
        this.bottomImageView = imageView2;
        this.bottomTitleContainer = linearLayout;
        this.bottomTitleView = textView;
        this.bottomView = frameLayout;
        this.closeView = imageView3;
        this.enterView = imageView4;
        this.imageView = imageView5;
        this.moreTextView = textView2;
        this.moreView = frameLayout2;
        this.spaceView = space;
        this.titleContainer = linearLayout2;
        this.titleView = textView3;
        this.topDivider = view3;
        this.wrapperView = linearLayout3;
    }

    public static ItemTitleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTitleViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558958, viewGroup, z, obj);
    }

    public static ItemTitleViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTitleViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558958, null, false, obj);
    }

    public static ItemTitleViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleViewBinding bind(View view, Object obj) {
        return (ItemTitleViewBinding) bind(obj, view, 2131558958);
    }
}
