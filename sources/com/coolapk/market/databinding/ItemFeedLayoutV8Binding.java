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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;

public abstract class ItemFeedLayoutV8Binding extends ViewDataBinding {
    public final Space articleSourceSpaceView;
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final FrameLayout extraApkTypeContainer;
    public final Space extraEntityContainer;
    public final FrameLayout extraTypeContainer;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final Space headerSpaceView;
    public final Space hotReplySpaceView;
    public final ImageView imgSellView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final Space nineImageSpaceView;
    public final Space ratingDataSpaceView;
    public final Space ratingSpaceView;
    public final Space relativeSpaceView;
    public final Space secondHandHeaderSpaceView;
    public final Space sourceSpaceView;
    public final TextView textView;
    public final FrameLayout titleContainer;
    public final TextView titleTagView;
    public final TextView titleView;
    public final Space videoPlayerSpaceView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFeedLayoutV8Binding(Object obj, View view, int i, Space space, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, FrameLayout frameLayout, Space space2, FrameLayout frameLayout2, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, Space space3, Space space4, ImageView imageView, Space space5, Space space6, Space space7, Space space8, Space space9, Space space10, TextView textView2, FrameLayout frameLayout3, TextView textView3, TextView textView4, Space space11) {
        super(obj, view, i);
        this.articleSourceSpaceView = space;
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.extraApkTypeContainer = frameLayout;
        this.extraEntityContainer = space2;
        this.extraTypeContainer = frameLayout2;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.headerSpaceView = space3;
        this.hotReplySpaceView = space4;
        this.imgSellView = imageView;
        this.nineImageSpaceView = space5;
        this.ratingDataSpaceView = space6;
        this.ratingSpaceView = space7;
        this.relativeSpaceView = space8;
        this.secondHandHeaderSpaceView = space9;
        this.sourceSpaceView = space10;
        this.textView = textView2;
        this.titleContainer = frameLayout3;
        this.titleTagView = textView3;
        this.titleView = textView4;
        this.videoPlayerSpaceView = space11;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedLayoutV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedLayoutV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedLayoutV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558715, viewGroup, z, obj);
    }

    public static ItemFeedLayoutV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedLayoutV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedLayoutV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131558715, null, false, obj);
    }

    public static ItemFeedLayoutV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedLayoutV8Binding bind(View view, Object obj) {
        return (ItemFeedLayoutV8Binding) bind(obj, view, 2131558715);
    }
}
