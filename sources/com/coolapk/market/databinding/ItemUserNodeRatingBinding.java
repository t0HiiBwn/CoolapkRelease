package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class ItemUserNodeRatingBinding extends ViewDataBinding {
    public final ImageView iconView;
    public final CoolapkCardView itemView;
    @Bindable
    protected NodeRating mModel;
    public final BadBadRatingBar ratingBar;
    public final TextView userNameView;

    public abstract void setModel(NodeRating nodeRating);

    protected ItemUserNodeRatingBinding(Object obj, View view, int i, ImageView imageView, CoolapkCardView coolapkCardView, BadBadRatingBar badBadRatingBar, TextView textView) {
        super(obj, view, i);
        this.iconView = imageView;
        this.itemView = coolapkCardView;
        this.ratingBar = badBadRatingBar;
        this.userNameView = textView;
    }

    public NodeRating getModel() {
        return this.mModel;
    }

    public static ItemUserNodeRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserNodeRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserNodeRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558985, viewGroup, z, obj);
    }

    public static ItemUserNodeRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserNodeRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserNodeRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558985, null, false, obj);
    }

    public static ItemUserNodeRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserNodeRatingBinding bind(View view, Object obj) {
        return (ItemUserNodeRatingBinding) bind(obj, view, 2131558985);
    }
}
