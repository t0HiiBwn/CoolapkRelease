package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;

public abstract class ItemVideoViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final FrameLayout holderView;
    @Bindable
    protected Entity mCard;
    public final FrameLayout videoContainer;
    public final Space videoPlayerSpaceView;

    public abstract void setCard(Entity entity);

    protected ItemVideoViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, FrameLayout frameLayout, FrameLayout frameLayout2, Space space) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.holderView = frameLayout;
        this.videoContainer = frameLayout2;
        this.videoPlayerSpaceView = space;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemVideoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558985, viewGroup, z, obj);
    }

    public static ItemVideoViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558985, null, false, obj);
    }

    public static ItemVideoViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoViewBinding bind(View view, Object obj) {
        return (ItemVideoViewBinding) bind(obj, view, 2131558985);
    }
}
