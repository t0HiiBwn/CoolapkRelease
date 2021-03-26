package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Card;

public abstract class ItemCardDoubleBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ItemCardDoubleItemBinding itemView1;
    public final ItemCardDoubleItemBinding itemView2;
    @Bindable
    protected Card mCard;
    public final TextView moreView;
    public final TextView titleView;

    public abstract void setCard(Card card);

    protected ItemCardDoubleBinding(Object obj, View view, int i, LinearLayout linearLayout, ItemCardDoubleItemBinding itemCardDoubleItemBinding, ItemCardDoubleItemBinding itemCardDoubleItemBinding2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.itemView1 = itemCardDoubleItemBinding;
        this.itemView2 = itemCardDoubleItemBinding2;
        this.moreView = textView;
        this.titleView = textView2;
    }

    public Card getCard() {
        return this.mCard;
    }

    public static ItemCardDoubleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardDoubleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardDoubleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558630, viewGroup, z, obj);
    }

    public static ItemCardDoubleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardDoubleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardDoubleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558630, null, false, obj);
    }

    public static ItemCardDoubleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardDoubleBinding bind(View view, Object obj) {
        return (ItemCardDoubleBinding) bind(obj, view, 2131558630);
    }
}
