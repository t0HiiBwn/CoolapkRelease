package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.feedv8.util.ArticleEditText;

public abstract class SubmitFeedArticleTextPartBinding extends ViewDataBinding {
    public final ArticleEditText etTitle;
    public final LinearLayout lvTop;
    public final View quoteView;

    protected SubmitFeedArticleTextPartBinding(Object obj, View view, int i, ArticleEditText articleEditText, LinearLayout linearLayout, View view2) {
        super(obj, view, i);
        this.etTitle = articleEditText;
        this.lvTop = linearLayout;
        this.quoteView = view2;
    }

    public static SubmitFeedArticleTextPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTextPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedArticleTextPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559152, viewGroup, z, obj);
    }

    public static SubmitFeedArticleTextPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTextPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedArticleTextPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559152, null, false, obj);
    }

    public static SubmitFeedArticleTextPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedArticleTextPartBinding bind(View view, Object obj) {
        return (SubmitFeedArticleTextPartBinding) bind(obj, view, 2131559152);
    }
}
