package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Entity;

public abstract class ItemGridItemLongTitleBinding extends ViewDataBinding {
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected Entity mViewModel;
    public final LinearLayout strokeView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(Entity entity);

    protected ItemGridItemLongTitleBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2) {
        super(obj, view, i);
        this.iconView = imageView;
        this.infoView = textView;
        this.itemView = linearLayout;
        this.strokeView = linearLayout2;
        this.titleView = textView2;
    }

    public Entity getViewModel() {
        return this.mViewModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGridItemLongTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridItemLongTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridItemLongTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558777, viewGroup, z, obj);
    }

    public static ItemGridItemLongTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridItemLongTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridItemLongTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558777, null, false, obj);
    }

    public static ItemGridItemLongTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridItemLongTitleBinding bind(View view, Object obj) {
        return (ItemGridItemLongTitleBinding) bind(obj, view, 2131558777);
    }
}
