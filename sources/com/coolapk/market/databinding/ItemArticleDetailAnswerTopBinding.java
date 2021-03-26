package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;

public abstract class ItemArticleDetailAnswerTopBinding extends ViewDataBinding {
    public final ImageView addAnswerImage;
    public final ProgressBar addAnswerProgress;
    public final TextView addAnswerText;
    public final LinearLayout addAnswerView;
    public final TextView countView;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final LinearLayout titleContainer;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemArticleDetailAnswerTopBinding(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar, TextView textView, LinearLayout linearLayout, TextView textView2, Space space, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, i);
        this.addAnswerImage = imageView;
        this.addAnswerProgress = progressBar;
        this.addAnswerText = textView;
        this.addAnswerView = linearLayout;
        this.countView = textView2;
        this.headerSpaceView = space;
        this.titleContainer = linearLayout2;
        this.titleView = textView3;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemArticleDetailAnswerTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleDetailAnswerTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleDetailAnswerTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558614, viewGroup, z, obj);
    }

    public static ItemArticleDetailAnswerTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleDetailAnswerTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleDetailAnswerTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558614, null, false, obj);
    }

    public static ItemArticleDetailAnswerTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleDetailAnswerTopBinding bind(View view, Object obj) {
        return (ItemArticleDetailAnswerTopBinding) bind(obj, view, 2131558614);
    }
}
