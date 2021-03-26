package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.ForegroundTextView;

public abstract class ItemQuestionViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final TextView countView;
    public final ForegroundTextView foregroundTextView;
    public final LinearLayout headerBottomLayout;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space relativeSpaceView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemQuestionViewBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView, ForegroundTextView foregroundTextView2, LinearLayout linearLayout2, Space space, Space space2, Space space3, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.countView = textView;
        this.foregroundTextView = foregroundTextView2;
        this.headerBottomLayout = linearLayout2;
        this.headerSpaceView = space;
        this.nineImageSpaceView = space2;
        this.relativeSpaceView = space3;
        this.titleView = textView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemQuestionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemQuestionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558887, viewGroup, z, obj);
    }

    public static ItemQuestionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemQuestionViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558887, null, false, obj);
    }

    public static ItemQuestionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionViewBinding bind(View view, Object obj) {
        return (ItemQuestionViewBinding) bind(obj, view, 2131558887);
    }
}
