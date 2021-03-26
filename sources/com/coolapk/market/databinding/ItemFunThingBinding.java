package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemFunThingBinding extends ViewDataBinding {
    public final CardView cardView;
    public final AspectRatioImageView coverView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mFollowNum;
    @Bindable
    protected FunThings mModel;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFollowNum(String str);

    public abstract void setModel(FunThings funThings);

    protected ItemFunThingBinding(Object obj, View view, int i, CardView cardView2, AspectRatioImageView aspectRatioImageView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.coverView = aspectRatioImageView;
        this.itemView = frameLayout;
    }

    public FunThings getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getFollowNum() {
        return this.mFollowNum;
    }

    public static ItemFunThingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFunThingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFunThingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558757, viewGroup, z, obj);
    }

    public static ItemFunThingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFunThingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFunThingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558757, null, false, obj);
    }

    public static ItemFunThingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFunThingBinding bind(View view, Object obj) {
        return (ItemFunThingBinding) bind(obj, view, 2131558757);
    }
}
