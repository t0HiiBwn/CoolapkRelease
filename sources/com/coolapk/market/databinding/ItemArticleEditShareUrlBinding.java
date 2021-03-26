package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.feedv8.ArticleShareUrl;

public abstract class ItemArticleEditShareUrlBinding extends ViewDataBinding {
    public final ImageView extendIcon;
    public final LinearLayout extendLayout;
    public final TextView extendSubtitle;
    public final TextView extendTitle;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected ArticleShareUrl mModel;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(ArticleShareUrl articleShareUrl);

    protected ItemArticleEditShareUrlBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.extendIcon = imageView;
        this.extendLayout = linearLayout;
        this.extendSubtitle = textView;
        this.extendTitle = textView2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public ArticleShareUrl getModel() {
        return this.mModel;
    }

    public static ItemArticleEditShareUrlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleEditShareUrlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleEditShareUrlBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558616, viewGroup, z, obj);
    }

    public static ItemArticleEditShareUrlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleEditShareUrlBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleEditShareUrlBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558616, null, false, obj);
    }

    public static ItemArticleEditShareUrlBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleEditShareUrlBinding bind(View view, Object obj) {
        return (ItemArticleEditShareUrlBinding) bind(obj, view, 2131558616);
    }
}
