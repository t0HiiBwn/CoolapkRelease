package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.CatchErrorViewPager;
import com.coolapk.market.widget.view.SwipeScaleView;

public abstract class PhotoBinding extends ViewDataBinding {
    public final TextView infoView;
    public final FrameLayout mainContent;
    public final SwipeScaleView swipeScaleView;
    public final CatchErrorViewPager viewPager;

    protected PhotoBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, SwipeScaleView swipeScaleView2, CatchErrorViewPager catchErrorViewPager) {
        super(obj, view, i);
        this.infoView = textView;
        this.mainContent = frameLayout;
        this.swipeScaleView = swipeScaleView2;
        this.viewPager = catchErrorViewPager;
    }

    public static PhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559079, viewGroup, z, obj);
    }

    public static PhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhotoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559079, null, false, obj);
    }

    public static PhotoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhotoBinding bind(View view, Object obj) {
        return (PhotoBinding) bind(obj, view, 2131559079);
    }
}
