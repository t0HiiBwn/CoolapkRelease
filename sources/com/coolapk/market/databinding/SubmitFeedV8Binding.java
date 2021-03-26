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
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.view.KeyBoardLayout;

public abstract class SubmitFeedV8Binding extends ViewDataBinding {
    public final LinearLayout actionMenuContainer;
    public final LinearLayout bottomAreaView;
    public final ImageView closeView;
    public final FrameLayout contentView;
    public final FrameLayout fakeKeyboardExtraContainer;
    public final LinearLayout fakeKeyboardView;
    public final KeyBoardLayout keyBoardInteractLayout;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final FrameLayout menuAddGoods;
    public final View menuAddGoodsBandageView;
    public final ImageView menuAddMore;
    public final ImageView menuAddPhoto;
    public final ImageView menuAtItem;
    public final ImageView menuCloseKeyboard;
    public final ImageView menuEmotion;
    public final ImageView menuFont;
    public final ImageView menuShareApp;
    public final ImageView menuTopicItem;
    public final TextView previewView;
    public final TextView submitView;
    public final TextView subtitleView;
    public final TextView titleView;
    public final TextView toArticleView;
    public final LinearLayout toolbarLayout;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SubmitFeedV8Binding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout3, KeyBoardLayout keyBoardLayout, FrameLayout frameLayout3, View view2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.actionMenuContainer = linearLayout;
        this.bottomAreaView = linearLayout2;
        this.closeView = imageView;
        this.contentView = frameLayout;
        this.fakeKeyboardExtraContainer = frameLayout2;
        this.fakeKeyboardView = linearLayout3;
        this.keyBoardInteractLayout = keyBoardLayout;
        this.menuAddGoods = frameLayout3;
        this.menuAddGoodsBandageView = view2;
        this.menuAddMore = imageView2;
        this.menuAddPhoto = imageView3;
        this.menuAtItem = imageView4;
        this.menuCloseKeyboard = imageView5;
        this.menuEmotion = imageView6;
        this.menuFont = imageView7;
        this.menuShareApp = imageView8;
        this.menuTopicItem = imageView9;
        this.previewView = textView;
        this.submitView = textView2;
        this.subtitleView = textView3;
        this.titleView = textView4;
        this.toArticleView = textView5;
        this.toolbarLayout = linearLayout4;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559170, viewGroup, z, obj);
    }

    public static SubmitFeedV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559170, null, false, obj);
    }

    public static SubmitFeedV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedV8Binding bind(View view, Object obj) {
        return (SubmitFeedV8Binding) bind(obj, view, 2131559170);
    }
}
