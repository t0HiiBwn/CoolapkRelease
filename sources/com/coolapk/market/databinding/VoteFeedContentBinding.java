package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.LinearMultiLayout;

public abstract class VoteFeedContentBinding extends ViewDataBinding {
    public final EditText editText;
    public final EditText editTitle;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final LinearMultiLayout moreContainer;
    public final LinearLayout moreSettingView;
    public final TextView multiModeView;
    public final TextView pkModeView;
    public final LinearLayout relativeView;
    public final TextView titleView;
    public final TextView voteHintView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected VoteFeedContentBinding(Object obj, View view, int i, EditText editText2, EditText editText3, LinearMultiLayout linearMultiLayout, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.editText = editText2;
        this.editTitle = editText3;
        this.moreContainer = linearMultiLayout;
        this.moreSettingView = linearLayout;
        this.multiModeView = textView;
        this.pkModeView = textView2;
        this.relativeView = linearLayout2;
        this.titleView = textView3;
        this.voteHintView = textView4;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static VoteFeedContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VoteFeedContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VoteFeedContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559309, viewGroup, z, obj);
    }

    public static VoteFeedContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VoteFeedContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VoteFeedContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559309, null, false, obj);
    }

    public static VoteFeedContentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VoteFeedContentBinding bind(View view, Object obj) {
        return (VoteFeedContentBinding) bind(obj, view, 2131559309);
    }
}
