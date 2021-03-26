package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemIconButtonGridCardBinding extends ViewDataBinding {
    public final FrameLayout cardView0;
    public final FrameLayout cardView1;
    public final CoolapkCardView coolapkCardView;
    public final ImageView iconView0;
    public final LinearLayout iconView0Layout;
    public final ImageView iconView1;
    public final LinearLayout iconView1Layout;
    public final AspectRatioImageView img0;
    public final AspectRatioImageView img1;
    public final LinearLayout itemView;
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

    protected ItemIconButtonGridCardBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, CoolapkCardView coolapkCardView2, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, AspectRatioImageView aspectRatioImageView, AspectRatioImageView aspectRatioImageView2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.cardView0 = frameLayout;
        this.cardView1 = frameLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.iconView0 = imageView;
        this.iconView0Layout = linearLayout;
        this.iconView1 = imageView2;
        this.iconView1Layout = linearLayout2;
        this.img0 = aspectRatioImageView;
        this.img1 = aspectRatioImageView2;
        this.itemView = linearLayout3;
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

    public static ItemIconButtonGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconButtonGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconButtonGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558784, viewGroup, z, obj);
    }

    public static ItemIconButtonGridCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconButtonGridCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconButtonGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558784, null, false, obj);
    }

    public static ItemIconButtonGridCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconButtonGridCardBinding bind(View view, Object obj) {
        return (ItemIconButtonGridCardBinding) bind(obj, view, 2131558784);
    }
}
