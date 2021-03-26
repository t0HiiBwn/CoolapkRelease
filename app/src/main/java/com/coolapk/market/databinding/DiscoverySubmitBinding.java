package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;

public abstract class DiscoverySubmitBinding extends ViewDataBinding {
    public final LinearLayout actionMenuContainer;
    public final LinearLayout contentView;
    public final EditText editText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Boolean mPosting;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final ImageView menuPost;
    public final ProgressBar progressBar;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setPosting(Boolean bool);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected DiscoverySubmitBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText2, ImageView imageView, ProgressBar progressBar2) {
        super(obj, view, i);
        this.actionMenuContainer = linearLayout;
        this.contentView = linearLayout2;
        this.editText = editText2;
        this.menuPost = imageView;
        this.progressBar = progressBar2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Boolean getPosting() {
        return this.mPosting;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static DiscoverySubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiscoverySubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DiscoverySubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558540, viewGroup, z, obj);
    }

    public static DiscoverySubmitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiscoverySubmitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DiscoverySubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558540, null, false, obj);
    }

    public static DiscoverySubmitBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiscoverySubmitBinding bind(View view, Object obj) {
        return (DiscoverySubmitBinding) bind(obj, view, 2131558540);
    }
}
