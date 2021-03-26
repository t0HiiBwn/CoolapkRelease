package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.User;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemVoteCommentEmptyBinding extends ViewDataBinding {
    public final MaxWidthFrameLayout cardView;
    @Bindable
    protected User mModel;
    public final TextView textView;

    public abstract void setModel(User user);

    protected ItemVoteCommentEmptyBinding(Object obj, View view, int i, MaxWidthFrameLayout maxWidthFrameLayout, TextView textView2) {
        super(obj, view, i);
        this.cardView = maxWidthFrameLayout;
        this.textView = textView2;
    }

    public User getModel() {
        return this.mModel;
    }

    public static ItemVoteCommentEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteCommentEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVoteCommentEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558994, viewGroup, z, obj);
    }

    public static ItemVoteCommentEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteCommentEmptyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVoteCommentEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558994, null, false, obj);
    }

    public static ItemVoteCommentEmptyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteCommentEmptyBinding bind(View view, Object obj) {
        return (ItemVoteCommentEmptyBinding) bind(obj, view, 2131558994);
    }
}
