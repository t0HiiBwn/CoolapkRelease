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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.viewholder.UserHistoryViewHolder;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public abstract class ItemUserHistoryBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final CoolEllipsizeTextView descriptionView;
    public final LinearLayout itemView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected UserHistory mUserHistory;
    @Bindable
    protected UserHistoryViewHolder mViewHolder;
    public final TextView titleView;
    public final TextView typeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setUserHistory(UserHistory userHistory);

    public abstract void setViewHolder(UserHistoryViewHolder userHistoryViewHolder);

    protected ItemUserHistoryBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, CoolEllipsizeTextView coolEllipsizeTextView, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = coolEllipsizeTextView;
        this.itemView = linearLayout;
        this.logoView = imageView;
        this.titleView = textView;
        this.typeView = textView2;
    }

    public UserHistoryViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public UserHistory getUserHistory() {
        return this.mUserHistory;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemUserHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558973, viewGroup, z, obj);
    }

    public static ItemUserHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserHistoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserHistoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558973, null, false, obj);
    }

    public static ItemUserHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserHistoryBinding bind(View view, Object obj) {
        return (ItemUserHistoryBinding) bind(obj, view, 2131558973);
    }
}
