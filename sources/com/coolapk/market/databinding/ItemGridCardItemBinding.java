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
import com.coolapk.market.viewholder.GridCardViewHolder;

public abstract class ItemGridCardItemBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final TextView actionText;
    public final ImageView iconView;
    public final TextView infoView;
    public final LinearLayout itemView;
    @Bindable
    protected boolean mShowAction;
    @Bindable
    protected GridCardViewHolder.DataViewHolder mViewModel;
    public final LinearLayout strokeView;
    public final TextView titleView;

    public abstract void setShowAction(boolean z);

    public abstract void setViewModel(GridCardViewHolder.DataViewHolder dataViewHolder);

    protected ItemGridCardItemBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView4) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionText = textView2;
        this.iconView = imageView;
        this.infoView = textView3;
        this.itemView = linearLayout;
        this.strokeView = linearLayout2;
        this.titleView = textView4;
    }

    public GridCardViewHolder.DataViewHolder getViewModel() {
        return this.mViewModel;
    }

    public boolean getShowAction() {
        return this.mShowAction;
    }

    public static ItemGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558766, viewGroup, z, obj);
    }

    public static ItemGridCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558766, null, false, obj);
    }

    public static ItemGridCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardItemBinding bind(View view, Object obj) {
        return (ItemGridCardItemBinding) bind(obj, view, 2131558766);
    }
}
