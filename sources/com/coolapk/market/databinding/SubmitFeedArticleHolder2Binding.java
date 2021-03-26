package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.feedv8.util.HandleFocusRecyclerView;

public abstract class SubmitFeedArticleHolder2Binding extends ViewDataBinding {
    public final HandleFocusRecyclerView recyclerView;

    protected SubmitFeedArticleHolder2Binding(Object obj, View view, int i, HandleFocusRecyclerView handleFocusRecyclerView) {
        super(obj, view, i);
        this.recyclerView = handleFocusRecyclerView;
    }

    public static SubmitFeedArticleHolder2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleHolder2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedArticleHolder2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559158, viewGroup, z, obj);
    }

    public static SubmitFeedArticleHolder2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleHolder2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedArticleHolder2Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559158, null, false, obj);
    }

    public static SubmitFeedArticleHolder2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleHolder2Binding bind(View view, Object obj) {
        return (SubmitFeedArticleHolder2Binding) bind(obj, view, 2131559158);
    }
}
