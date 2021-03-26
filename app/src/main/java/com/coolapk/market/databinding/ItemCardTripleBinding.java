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

public abstract class ItemCardTripleBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ItemCardTripleItemBinding itemView1;
    public final ItemCardTripleItemBinding itemView2;
    public final ItemCardTripleItemBinding itemView3;
    @Bindable
    protected Card mCard;
    public final TextView moreView;
    public final TextView titleView;

    public abstract void setCard(Card card);

    protected ItemCardTripleBinding(Object obj, View view, int i, LinearLayout linearLayout, ItemCardTripleItemBinding itemCardTripleItemBinding, ItemCardTripleItemBinding itemCardTripleItemBinding2, ItemCardTripleItemBinding itemCardTripleItemBinding3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.itemView1 = itemCardTripleItemBinding;
        this.itemView2 = itemCardTripleItemBinding2;
        this.itemView3 = itemCardTripleItemBinding3;
        this.moreView = textView;
        this.titleView = textView2;
    }

    public Card getCard() {
        return this.mCard;
    }

    public static ItemCardTripleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardTripleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCardTripleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558634, viewGroup, z, obj);
    }

    public static ItemCardTripleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardTripleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCardTripleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558634, null, false, obj);
    }

    public static ItemCardTripleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCardTripleBinding bind(View view, Object obj) {
        return (ItemCardTripleBinding) bind(obj, view, 2131558634);
    }
}
