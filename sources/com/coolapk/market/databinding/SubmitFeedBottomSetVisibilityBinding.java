package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedUIConfig;

public abstract class SubmitFeedBottomSetVisibilityBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final LinearLayout visibleToAll;
    public final LinearLayout visibleToMe;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SubmitFeedBottomSetVisibilityBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.visibleToAll = linearLayout;
        this.visibleToMe = linearLayout2;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedBottomSetVisibilityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedBottomSetVisibilityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedBottomSetVisibilityBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559164, viewGroup, z, obj);
    }

    public static SubmitFeedBottomSetVisibilityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedBottomSetVisibilityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedBottomSetVisibilityBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559164, null, false, obj);
    }

    public static SubmitFeedBottomSetVisibilityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedBottomSetVisibilityBinding bind(View view, Object obj) {
        return (SubmitFeedBottomSetVisibilityBinding) bind(obj, view, 2131559164);
    }
}
