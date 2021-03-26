package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.User;

public abstract class ItemVoteDetailSplitedTitleBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    @Bindable
    protected User mModel;
    public final TextView pkLeftTextView;
    public final TextView pkRightTextView;

    public abstract void setModel(User user);

    protected ItemVoteDetailSplitedTitleBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.pkLeftTextView = textView;
        this.pkRightTextView = textView2;
    }

    public User getModel() {
        return this.mModel;
    }

    public static ItemVoteDetailSplitedTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteDetailSplitedTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVoteDetailSplitedTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558988, viewGroup, z, obj);
    }

    public static ItemVoteDetailSplitedTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteDetailSplitedTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVoteDetailSplitedTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558988, null, false, obj);
    }

    public static ItemVoteDetailSplitedTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVoteDetailSplitedTitleBinding bind(View view, Object obj) {
        return (ItemVoteDetailSplitedTitleBinding) bind(obj, view, 2131558988);
    }
}
