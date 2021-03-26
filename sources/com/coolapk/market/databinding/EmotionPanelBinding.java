package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;

public abstract class EmotionPanelBinding extends ViewDataBinding {
    public final LinearLayout emotionPanelBottom;
    public final FrameLayout emotionPanelHeader;
    public final LinearLayout emotionPanelIndicator;
    public final ScrollStateViewPager emotionPanelViewPager;

    protected EmotionPanelBinding(Object obj, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.emotionPanelBottom = linearLayout;
        this.emotionPanelHeader = frameLayout;
        this.emotionPanelIndicator = linearLayout2;
        this.emotionPanelViewPager = scrollStateViewPager;
    }

    public static EmotionPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmotionPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EmotionPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558548, viewGroup, z, obj);
    }

    public static EmotionPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmotionPanelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EmotionPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558548, null, false, obj);
    }

    public static EmotionPanelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EmotionPanelBinding bind(View view, Object obj) {
        return (EmotionPanelBinding) bind(obj, view, 2131558548);
    }
}
