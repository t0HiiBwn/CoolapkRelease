package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Product;

public abstract class ItemProductSeriesErshouBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final LinearLayout itemView1;
    public final LinearLayout itemView2;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Product mModel1;
    @Bindable
    protected Product mModel2;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel1(Product product);

    public abstract void setModel2(Product product);

    protected ItemProductSeriesErshouBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.itemView1 = linearLayout2;
        this.itemView2 = linearLayout3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Product getModel1() {
        return this.mModel1;
    }

    public Product getModel2() {
        return this.mModel2;
    }

    public static ItemProductSeriesErshouBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesErshouBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductSeriesErshouBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558881, viewGroup, z, obj);
    }

    public static ItemProductSeriesErshouBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesErshouBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductSeriesErshouBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558881, null, false, obj);
    }

    public static ItemProductSeriesErshouBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductSeriesErshouBinding bind(View view, Object obj) {
        return (ItemProductSeriesErshouBinding) bind(obj, view, 2131558881);
    }
}
