package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class SubmitRatingNoramlContentBinding extends ViewDataBinding {
    public final LinearLayout advantageAddPhotoView;
    public final EditText advantageEditText;
    public final RelativeLayout advantagePhotoContainer;
    public final RecyclerView advantageRecyclerView;
    public final FeedWarningBinding alertView;
    public final CheckBox buyStateView;
    public final LinearLayout contentContainer;
    public final LinearLayout disadvantageAddPhotoView;
    public final EditText disadvantageEditText;
    public final RelativeLayout disadvantagePhotoContainer;
    public final RecyclerView disadvantageRecyclerView;
    public final ImageView expandImageView;
    public final TextView expandTextView;
    public final LinearLayout expandView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final BadBadRatingBar ratingBar;
    public final TextView ratingHint;
    public final LinearLayout relativeView;
    public final TextView scoreTextView;
    public final Space spaceView;
    public final LinearLayout summaryAddPhotoView;
    public final EditText summaryEditText;
    public final RelativeLayout summaryPhotoContainer;
    public final RecyclerView summaryRecyclerView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SubmitRatingNoramlContentBinding(Object obj, View view, int i, LinearLayout linearLayout, EditText editText, RelativeLayout relativeLayout, RecyclerView recyclerView, FeedWarningBinding feedWarningBinding, CheckBox checkBox, LinearLayout linearLayout2, LinearLayout linearLayout3, EditText editText2, RelativeLayout relativeLayout2, RecyclerView recyclerView2, ImageView imageView, TextView textView, LinearLayout linearLayout4, BadBadRatingBar badBadRatingBar, TextView textView2, LinearLayout linearLayout5, TextView textView3, Space space, LinearLayout linearLayout6, EditText editText3, RelativeLayout relativeLayout3, RecyclerView recyclerView3) {
        super(obj, view, i);
        this.advantageAddPhotoView = linearLayout;
        this.advantageEditText = editText;
        this.advantagePhotoContainer = relativeLayout;
        this.advantageRecyclerView = recyclerView;
        this.alertView = feedWarningBinding;
        this.buyStateView = checkBox;
        this.contentContainer = linearLayout2;
        this.disadvantageAddPhotoView = linearLayout3;
        this.disadvantageEditText = editText2;
        this.disadvantagePhotoContainer = relativeLayout2;
        this.disadvantageRecyclerView = recyclerView2;
        this.expandImageView = imageView;
        this.expandTextView = textView;
        this.expandView = linearLayout4;
        this.ratingBar = badBadRatingBar;
        this.ratingHint = textView2;
        this.relativeView = linearLayout5;
        this.scoreTextView = textView3;
        this.spaceView = space;
        this.summaryAddPhotoView = linearLayout6;
        this.summaryEditText = editText3;
        this.summaryPhotoContainer = relativeLayout3;
        this.summaryRecyclerView = recyclerView3;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitRatingNoramlContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitRatingNoramlContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitRatingNoramlContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559176, viewGroup, z, obj);
    }

    public static SubmitRatingNoramlContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitRatingNoramlContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitRatingNoramlContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559176, null, false, obj);
    }

    public static SubmitRatingNoramlContentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitRatingNoramlContentBinding bind(View view, Object obj) {
        return (SubmitRatingNoramlContentBinding) bind(obj, view, 2131559176);
    }
}
