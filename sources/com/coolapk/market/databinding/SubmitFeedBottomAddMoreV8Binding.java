package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedUIConfig;

public abstract class SubmitFeedBottomAddMoreV8Binding extends ViewDataBinding {
    public final LinearLayout buttonShareApp;
    public final LinearLayout buttonShareLink;
    public final LinearLayout buttonShareMusic;
    public final LinearLayout buttonShareVideo;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SubmitFeedBottomAddMoreV8Binding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.buttonShareApp = linearLayout;
        this.buttonShareLink = linearLayout2;
        this.buttonShareMusic = linearLayout3;
        this.buttonShareVideo = linearLayout4;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedBottomAddMoreV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedBottomAddMoreV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedBottomAddMoreV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559163, viewGroup, z, obj);
    }

    public static SubmitFeedBottomAddMoreV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedBottomAddMoreV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedBottomAddMoreV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559163, null, false, obj);
    }

    public static SubmitFeedBottomAddMoreV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedBottomAddMoreV8Binding bind(View view, Object obj) {
        return (SubmitFeedBottomAddMoreV8Binding) bind(obj, view, 2131559163);
    }
}
