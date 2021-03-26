package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.TabGroupCard;

public abstract class ItemTabGroupCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final RecyclerView gridView;
    @Bindable
    protected TabGroupCard mCard;
    public final FrameLayout moreView;
    public final LinearLayout tabView1;
    public final LinearLayout tabView2;
    public final ImageView tabViewIndicator1;
    public final ImageView tabViewIndicator2;
    public final TextView tabViewText1;
    public final TextView tabViewText2;

    public abstract void setCard(TabGroupCard tabGroupCard);

    protected ItemTabGroupCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, RecyclerView recyclerView, FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.gridView = recyclerView;
        this.moreView = frameLayout;
        this.tabView1 = linearLayout;
        this.tabView2 = linearLayout2;
        this.tabViewIndicator1 = imageView;
        this.tabViewIndicator2 = imageView2;
        this.tabViewText1 = textView;
        this.tabViewText2 = textView2;
    }

    public TabGroupCard getCard() {
        return this.mCard;
    }

    public static ItemTabGroupCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabGroupCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTabGroupCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558942, viewGroup, z, obj);
    }

    public static ItemTabGroupCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabGroupCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTabGroupCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558942, null, false, obj);
    }

    public static ItemTabGroupCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTabGroupCardBinding bind(View view, Object obj) {
        return (ItemTabGroupCardBinding) bind(obj, view, 2131558942);
    }
}
