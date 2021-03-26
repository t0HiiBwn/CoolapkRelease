package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;

public abstract class ItemTextImageCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout itemView;
    public final LinearLayout linearView;
    @Bindable
    protected EntityCard mCard;
    public final TextView textView7;

    public abstract void setCard(EntityCard entityCard);

    protected ItemTextImageCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.itemView = linearLayout;
        this.linearView = linearLayout2;
        this.textView7 = textView;
    }

    public EntityCard getCard() {
        return this.mCard;
    }

    public static ItemTextImageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextImageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextImageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558949, viewGroup, z, obj);
    }

    public static ItemTextImageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextImageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextImageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558949, null, false, obj);
    }

    public static ItemTextImageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextImageCardBinding bind(View view, Object obj) {
        return (ItemTextImageCardBinding) bind(obj, view, 2131558949);
    }
}
