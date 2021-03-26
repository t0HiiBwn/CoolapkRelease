package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemAnswerViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final Space nineImageSpaceView;
    public final Space relativeSpaceView;
    public final CoolEllipsizeTextView textView;
    public final FrameLayout titleContainer;
    public final CoolEllipsizeTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemAnswerViewBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, Space space, Space space2, Space space3, CoolEllipsizeTextView coolEllipsizeTextView, FrameLayout frameLayout, CoolEllipsizeTextView coolEllipsizeTextView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.headerSpaceView = space;
        this.nineImageSpaceView = space2;
        this.relativeSpaceView = space3;
        this.textView = coolEllipsizeTextView;
        this.titleContainer = frameLayout;
        this.titleView = coolEllipsizeTextView2;
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

    public static ItemAnswerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAnswerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAnswerViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558591, viewGroup, z, obj);
    }

    public static ItemAnswerViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAnswerViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAnswerViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558591, null, false, obj);
    }

    public static ItemAnswerViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAnswerViewBinding bind(View view, Object obj) {
        return (ItemAnswerViewBinding) bind(obj, view, 2131558591);
    }
}
