package com.coolapk.market.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.coolapk.market.app.ImageLoaderAdapter;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.util.UiUtils;

public class GlideFragmentImageLoader implements ImageLoaderAdapter<Fragment> {
    private final GlideImageLoader glideImageLoader;

    public GlideFragmentImageLoader(GlideImageLoader glideImageLoader2) {
        this.glideImageLoader = glideImageLoader2;
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void init(Context context) {
        this.glideImageLoader.init(context);
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void destroy(Context context) {
        this.glideImageLoader.destroy(context);
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void clearMemoryCache(Context context) {
        this.glideImageLoader.clearMemoryCache(context);
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void clearDiskCache(Context context) {
        this.glideImageLoader.clearDiskCache(context);
    }

    public void cancel(Fragment fragment, String str) {
        this.glideImageLoader.cancel(new GlideRequestComponent(fragment.getActivity(), GlideApp.with(fragment)), str);
    }

    public void displayImage(Fragment fragment, String str, ImageView imageView) {
        displayImage(fragment, str, imageView, (ImageLoaderOptions) null, (OnImageLoadListener) null, (OnBitmapTransformListener) null);
    }

    public void displayImage(Fragment fragment, String str, ImageView imageView, OnImageLoadListener onImageLoadListener) {
        displayImage(fragment, str, imageView, (ImageLoaderOptions) null, onImageLoadListener, (OnBitmapTransformListener) null);
    }

    public void displayImage(Fragment fragment, String str, ImageView imageView, int i) {
        displayImage(fragment, str, imageView, ImageLoaderOptions.newBuilder().placeHolderRes(i).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
    }

    public void displayImage(Fragment fragment, String str, ImageView imageView, ImageLoaderOptions imageLoaderOptions, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener) {
        Activity activityNullable = UiUtils.getActivityNullable(fragment.getActivity());
        if (activityNullable != null && !activityNullable.isDestroyed()) {
            if (str == null) {
                str = "";
            }
            this.glideImageLoader.displayImage(new GlideRequestComponent(fragment.getActivity(), GlideApp.with(fragment)), str, imageView, imageLoaderOptions, onImageLoadListener, onBitmapTransformListener);
        }
    }

    public Bitmap loadBitmap(Fragment fragment, String str) throws Throwable {
        return this.glideImageLoader.loadBitmap(new GlideRequestComponent(fragment.getActivity(), GlideApp.with(fragment)), str);
    }
}
