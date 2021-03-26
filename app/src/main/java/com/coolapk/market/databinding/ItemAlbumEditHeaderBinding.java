package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.album.AlbumDetailViewModel;

public abstract class ItemAlbumEditHeaderBinding extends ViewDataBinding {
    public final ImageView editIntroView;
    public final ImageView editTitleView;
    public final TextView introDetailView;
    public final RelativeLayout introLayout;
    public final TextView introView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected AlbumDetailViewModel mModel;
    public final LinearLayout rootView;
    public final TextView titleDetailView;
    public final RelativeLayout titleLayout;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(AlbumDetailViewModel albumDetailViewModel);

    protected ItemAlbumEditHeaderBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, RelativeLayout relativeLayout, TextView textView2, LinearLayout linearLayout, TextView textView3, RelativeLayout relativeLayout2, TextView textView4) {
        super(obj, view, i);
        this.editIntroView = imageView;
        this.editTitleView = imageView2;
        this.introDetailView = textView;
        this.introLayout = relativeLayout;
        this.introView = textView2;
        this.rootView = linearLayout;
        this.titleDetailView = textView3;
        this.titleLayout = relativeLayout2;
        this.titleView = textView4;
    }

    public AlbumDetailViewModel getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAlbumEditHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumEditHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumEditHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558581, viewGroup, z, obj);
    }

    public static ItemAlbumEditHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumEditHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumEditHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558581, null, false, obj);
    }

    public static ItemAlbumEditHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumEditHeaderBinding bind(View view, Object obj) {
        return (ItemAlbumEditHeaderBinding) bind(obj, view, 2131558581);
    }
}
