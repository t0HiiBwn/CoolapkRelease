package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemDeveloperCardBinding extends ViewDataBinding {
    public final Button atView;
    public final RoundedImageView avatarView;
    public final LinearLayout developerView;
    public final Button followView;
    @Bindable
    protected AppViewViewModel mViewModel;
    public final Button sendView;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemDeveloperCardBinding(Object obj, View view, int i, Button button, RoundedImageView roundedImageView, LinearLayout linearLayout, Button button2, Button button3) {
        super(obj, view, i);
        this.atView = button;
        this.avatarView = roundedImageView;
        this.developerView = linearLayout;
        this.followView = button2;
        this.sendView = button3;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemDeveloperCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeveloperCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDeveloperCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558668, viewGroup, z, obj);
    }

    public static ItemDeveloperCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeveloperCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDeveloperCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558668, null, false, obj);
    }

    public static ItemDeveloperCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDeveloperCardBinding bind(View view, Object obj) {
        return (ItemDeveloperCardBinding) bind(obj, view, 2131558668);
    }
}
