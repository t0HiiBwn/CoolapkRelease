package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class ItemNodeRatingBinding extends ViewDataBinding {
    public final CoolapkCardView itemView;
    @Bindable
    protected NodeRating mModel;
    public final TextView ownerTextView;
    public final BadBadRatingBar ratingBar;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    public abstract void setModel(NodeRating nodeRating);

    protected ItemNodeRatingBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView, TextView textView, BadBadRatingBar badBadRatingBar, UserAvatarView userAvatarView2, TextView textView2) {
        super(obj, view, i);
        this.itemView = coolapkCardView;
        this.ownerTextView = textView;
        this.ratingBar = badBadRatingBar;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView2;
    }

    public NodeRating getModel() {
        return this.mModel;
    }

    public static ItemNodeRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNodeRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558839, viewGroup, z, obj);
    }

    public static ItemNodeRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNodeRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558839, null, false, obj);
    }

    public static ItemNodeRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeRatingBinding bind(View view, Object obj) {
        return (ItemNodeRatingBinding) bind(obj, view, 2131558839);
    }
}
