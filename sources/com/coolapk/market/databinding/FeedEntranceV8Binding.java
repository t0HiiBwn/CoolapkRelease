package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class FeedEntranceV8Binding extends ViewDataBinding {
    public final ImageView closeView;
    public final TextView draftTextView;
    public final LinearLayout draftView;
    public final ImageView imageBackground;
    public final ImageView imageView1;
    public final ImageView imageView2;
    public final FrameLayout itemView1;
    public final FrameLayout itemView2;
    public final Space leftSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    public final View maskView;
    public final LinearLayout qrView;
    public final RecyclerView recyclerView;
    public final Space rightSpaceView;
    public final DrawSystemBarFrameLayout rootView;
    public final ImageView searchView;
    public final Space spaceView;
    public final LinearLayout toolbar;
    public final TextView toolbarSearchText;
    public final LinearLayout topView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected FeedEntranceV8Binding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, FrameLayout frameLayout, FrameLayout frameLayout2, Space space, View view2, LinearLayout linearLayout2, RecyclerView recyclerView2, Space space2, DrawSystemBarFrameLayout drawSystemBarFrameLayout, ImageView imageView6, Space space3, LinearLayout linearLayout3, TextView textView2, LinearLayout linearLayout4) {
        super(obj, view, i);
        this.closeView = imageView;
        this.draftTextView = textView;
        this.draftView = linearLayout;
        this.imageBackground = imageView3;
        this.imageView1 = imageView4;
        this.imageView2 = imageView5;
        this.itemView1 = frameLayout;
        this.itemView2 = frameLayout2;
        this.leftSpaceView = space;
        this.maskView = view2;
        this.qrView = linearLayout2;
        this.recyclerView = recyclerView2;
        this.rightSpaceView = space2;
        this.rootView = drawSystemBarFrameLayout;
        this.searchView = imageView6;
        this.spaceView = space3;
        this.toolbar = linearLayout3;
        this.toolbarSearchText = textView2;
        this.topView = linearLayout4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static FeedEntranceV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedEntranceV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558562, viewGroup, z, obj);
    }

    public static FeedEntranceV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedEntranceV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558562, null, false, obj);
    }

    public static FeedEntranceV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedEntranceV8Binding bind(View view, Object obj) {
        return (FeedEntranceV8Binding) bind(obj, view, 2131558562);
    }
}
