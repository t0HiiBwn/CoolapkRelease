package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemFeedSourcePartBinding extends ViewDataBinding {
    public final CoolEllipsizeTextView bottomTextView;
    @Bindable
    protected Feed mModel;
    public final Space secondHandInfoSpaceView;
    public final LinearLayout sourceContainer;
    public final Space spaceView;
    public final CoolEllipsizeTextView textView;
    public final Space videoPlayerSpaceView;

    public abstract void setModel(Feed feed);

    protected ItemFeedSourcePartBinding(Object obj, View view, int i, CoolEllipsizeTextView coolEllipsizeTextView, Space space, LinearLayout linearLayout, Space space2, CoolEllipsizeTextView coolEllipsizeTextView2, Space space3) {
        super(obj, view, i);
        this.bottomTextView = coolEllipsizeTextView;
        this.secondHandInfoSpaceView = space;
        this.sourceContainer = linearLayout;
        this.spaceView = space2;
        this.textView = coolEllipsizeTextView2;
        this.videoPlayerSpaceView = space3;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public static ItemFeedSourcePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSourcePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedSourcePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558730, viewGroup, z, obj);
    }

    public static ItemFeedSourcePartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSourcePartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedSourcePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558730, null, false, obj);
    }

    public static ItemFeedSourcePartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedSourcePartBinding bind(View view, Object obj) {
        return (ItemFeedSourcePartBinding) bind(obj, view, 2131558730);
    }
}
