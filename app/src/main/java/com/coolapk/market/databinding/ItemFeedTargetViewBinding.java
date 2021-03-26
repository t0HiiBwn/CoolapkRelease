package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemFeedTargetViewBinding extends ViewDataBinding {
    @Bindable
    protected Feed mModel;
    public final LinearLayout relativeView;

    public abstract void setModel(Feed feed);

    protected ItemFeedTargetViewBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.relativeView = linearLayout;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public static ItemFeedTargetViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedTargetViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedTargetViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558732, viewGroup, z, obj);
    }

    public static ItemFeedTargetViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedTargetViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedTargetViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558732, null, false, obj);
    }

    public static ItemFeedTargetViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedTargetViewBinding bind(View view, Object obj) {
        return (ItemFeedTargetViewBinding) bind(obj, view, 2131558732);
    }
}
