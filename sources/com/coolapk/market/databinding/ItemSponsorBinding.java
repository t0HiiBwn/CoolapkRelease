package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.view.ADFrameLayout;

public abstract class ItemSponsorBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final ADFrameLayout itemView;
    @Bindable
    protected Entity mCard1;
    @Bindable
    protected Entity mCard2;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnImageLoadListener mLoadListener;

    public abstract void setCard1(Entity entity);

    public abstract void setCard2(Entity entity);

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setLoadListener(OnImageLoadListener onImageLoadListener);

    protected ItemSponsorBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, ADFrameLayout aDFrameLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.itemView = aDFrameLayout;
    }

    public Entity getCard1() {
        return this.mCard1;
    }

    public Entity getCard2() {
        return this.mCard2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnImageLoadListener getLoadListener() {
        return this.mLoadListener;
    }

    public static ItemSponsorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSponsorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558945, viewGroup, z, obj);
    }

    public static ItemSponsorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSponsorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558945, null, false, obj);
    }

    public static ItemSponsorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorBinding bind(View view, Object obj) {
        return (ItemSponsorBinding) bind(obj, view, 2131558945);
    }
}
