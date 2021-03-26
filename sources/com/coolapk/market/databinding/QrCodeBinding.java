package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.camera.CameraPreview;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class QrCodeBinding extends ViewDataBinding {
    public final Button actionCopy;
    public final Button actionOpen;
    public final AppBarLayout appBar;
    public final ImageView bottomMask;
    public final RelativeLayout captureContainer;
    public final MaxWidthFrameLayout cropLayout;
    public final ImageView imageView;
    public final ImageView leftMask;
    public final DrawSystemBarFrameLayout mainContent;
    public final ImageView myQrView;
    public final CameraPreview qrView;
    public final ImageView readImageView;
    public final FrameLayout resultMaskView;
    public final RelativeLayout resultView;
    public final ImageView rightMask;
    public final View scanLineView;
    public final TextView textView;
    public final Toolbar toolbar;
    public final ImageView topMask;

    protected QrCodeBinding(Object obj, View view, int i, Button button, Button button2, AppBarLayout appBarLayout, ImageView imageView2, RelativeLayout relativeLayout, MaxWidthFrameLayout maxWidthFrameLayout, ImageView imageView3, ImageView imageView4, DrawSystemBarFrameLayout drawSystemBarFrameLayout, ImageView imageView5, CameraPreview cameraPreview, ImageView imageView6, FrameLayout frameLayout, RelativeLayout relativeLayout2, ImageView imageView7, View view2, TextView textView2, Toolbar toolbar2, ImageView imageView8) {
        super(obj, view, i);
        this.actionCopy = button;
        this.actionOpen = button2;
        this.appBar = appBarLayout;
        this.bottomMask = imageView2;
        this.captureContainer = relativeLayout;
        this.cropLayout = maxWidthFrameLayout;
        this.imageView = imageView3;
        this.leftMask = imageView4;
        this.mainContent = drawSystemBarFrameLayout;
        this.myQrView = imageView5;
        this.qrView = cameraPreview;
        this.readImageView = imageView6;
        this.resultMaskView = frameLayout;
        this.resultView = relativeLayout2;
        this.rightMask = imageView7;
        this.scanLineView = view2;
        this.textView = textView2;
        this.toolbar = toolbar2;
        this.topMask = imageView8;
    }

    public static QrCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QrCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (QrCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559119, viewGroup, z, obj);
    }

    public static QrCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QrCodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (QrCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559119, null, false, obj);
    }

    public static QrCodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QrCodeBinding bind(View view, Object obj) {
        return (QrCodeBinding) bind(obj, view, 2131559119);
    }
}
