package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.util.CircleTransform;

public abstract class ItemTopGroupCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final RecyclerView gridView;
    public final ImageView itemViewImageTopLeft;
    public final ImageView itemViewImageTopRight;
    public final LinearLayout itemViewTopLeft;
    public final LinearLayout itemViewTopRight;
    @Bindable
    protected TopGroupCard mCard;
    @Bindable
    protected CircleTransform mOnBitmapTransform;

    public abstract void setCard(TopGroupCard topGroupCard);

    public abstract void setOnBitmapTransform(CircleTransform circleTransform);

    protected ItemTopGroupCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.gridView = recyclerView;
        this.itemViewImageTopLeft = imageView;
        this.itemViewImageTopRight = imageView2;
        this.itemViewTopLeft = linearLayout;
        this.itemViewTopRight = linearLayout2;
    }

    public TopGroupCard getCard() {
        return this.mCard;
    }

    public CircleTransform getOnBitmapTransform() {
        return this.mOnBitmapTransform;
    }

    public static ItemTopGroupCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopGroupCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTopGroupCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558959, viewGroup, z, obj);
    }

    public static ItemTopGroupCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopGroupCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTopGroupCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558959, null, false, obj);
    }

    public static ItemTopGroupCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTopGroupCardBinding bind(View view, Object obj) {
        return (ItemTopGroupCardBinding) bind(obj, view, 2131558959);
    }
}
