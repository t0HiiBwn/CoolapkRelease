package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FeedQuestion;

public abstract class ItemQuestionTitleViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedQuestion mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView nameView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedQuestion feedQuestion);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemQuestionTitleViewBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.nameView = textView;
        this.titleView = textView2;
    }

    public FeedQuestion getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemQuestionTitleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionTitleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemQuestionTitleViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558886, viewGroup, z, obj);
    }

    public static ItemQuestionTitleViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionTitleViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemQuestionTitleViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558886, null, false, obj);
    }

    public static ItemQuestionTitleViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionTitleViewBinding bind(View view, Object obj) {
        return (ItemQuestionTitleViewBinding) bind(obj, view, 2131558886);
    }
}