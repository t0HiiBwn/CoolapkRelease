package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.base.BaseChatActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.google.android.material.appbar.AppBarLayout;

public abstract class BaseChattingBinding extends ViewDataBinding {
    public final LinearLayout actionMenuContainer;
    public final AppBarLayout appBar;
    public final LinearLayout contentView;
    public final EditText editText;
    public final EmotionPanel emotionPanel;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected BaseChatActivity.ViewMode mViewModel;
    public final CoordinatorLayout mainContent;
    public final ImageView menuEmotion;
    public final ImageView menuPost;
    public final ProgressBar progressBar;
    public final Toolbar toolbar;
    public final FrameLayout toolbarContentFragment;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setViewModel(BaseChatActivity.ViewMode viewMode);

    protected BaseChattingBinding(Object obj, View view, int i, LinearLayout linearLayout, AppBarLayout appBarLayout, LinearLayout linearLayout2, EditText editText2, EmotionPanel emotionPanel2, CoordinatorLayout coordinatorLayout, ImageView imageView, ImageView imageView2, ProgressBar progressBar2, Toolbar toolbar2, FrameLayout frameLayout) {
        super(obj, view, i);
        this.actionMenuContainer = linearLayout;
        this.appBar = appBarLayout;
        this.contentView = linearLayout2;
        this.editText = editText2;
        this.emotionPanel = emotionPanel2;
        this.mainContent = coordinatorLayout;
        this.menuEmotion = imageView;
        this.menuPost = imageView2;
        this.progressBar = progressBar2;
        this.toolbar = toolbar2;
        this.toolbarContentFragment = frameLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public BaseChatActivity.ViewMode getViewModel() {
        return this.mViewModel;
    }

    public static BaseChattingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BaseChattingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseChattingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558474, viewGroup, z, obj);
    }

    public static BaseChattingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BaseChattingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseChattingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558474, null, false, obj);
    }

    public static BaseChattingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BaseChattingBinding bind(View view, Object obj) {
        return (BaseChattingBinding) bind(obj, view, 2131558474);
    }
}
