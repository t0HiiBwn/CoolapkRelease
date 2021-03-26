package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.FeedUIConfig;

public abstract class SecondHandContentV8Binding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final TextView commentBoardTip1;
    public final TextView commentBoardTip2;
    public final EditText editText;
    public final EditText editTitle;
    public final TextView editTitleFreeNum;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final RecyclerView optionsView;
    public final RelativeLayout photoContainer;
    public final RecyclerView recyclerView;
    public final LinearLayout relativeView;
    public final Space spaceView;
    public final LinearLayout warningView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SecondHandContentV8Binding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, TextView textView, TextView textView2, EditText editText2, EditText editText3, TextView textView3, RecyclerView recyclerView2, RelativeLayout relativeLayout, RecyclerView recyclerView3, LinearLayout linearLayout, Space space, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.commentBoardTip1 = textView;
        this.commentBoardTip2 = textView2;
        this.editText = editText2;
        this.editTitle = editText3;
        this.editTitleFreeNum = textView3;
        this.optionsView = recyclerView2;
        this.photoContainer = relativeLayout;
        this.recyclerView = recyclerView3;
        this.relativeView = linearLayout;
        this.spaceView = space;
        this.warningView = linearLayout2;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SecondHandContentV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandContentV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SecondHandContentV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559133, viewGroup, z, obj);
    }

    public static SecondHandContentV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandContentV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SecondHandContentV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559133, null, false, obj);
    }

    public static SecondHandContentV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SecondHandContentV8Binding bind(View view, Object obj) {
        return (SecondHandContentV8Binding) bind(obj, view, 2131559133);
    }
}
