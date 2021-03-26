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
import com.coolapk.market.view.live.LiveViewModel;

public abstract class LiveIntroduceBinding extends ViewDataBinding {
    public final LinearLayout containerView;
    public final TextView liveIntroduceView;
    public final TextView liveTime;
    public final TextView liveType;
    @Bindable
    protected LiveViewModel mViewModel;
    public final FrameLayout presenterFrame;
    public final TextView titleView;

    public abstract void setViewModel(LiveViewModel liveViewModel);

    protected LiveIntroduceBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, TextView textView4) {
        super(obj, view, i);
        this.containerView = linearLayout;
        this.liveIntroduceView = textView;
        this.liveTime = textView2;
        this.liveType = textView3;
        this.presenterFrame = frameLayout;
        this.titleView = textView4;
    }

    public LiveViewModel getViewModel() {
        return this.mViewModel;
    }

    public static LiveIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveIntroduceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LiveIntroduceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559011, viewGroup, z, obj);
    }

    public static LiveIntroduceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveIntroduceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LiveIntroduceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559011, null, false, obj);
    }

    public static LiveIntroduceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LiveIntroduceBinding bind(View view, Object obj) {
        return (LiveIntroduceBinding) bind(obj, view, 2131559011);
    }
}
