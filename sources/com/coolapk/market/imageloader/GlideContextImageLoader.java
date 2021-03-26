package com.coolapk.market.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.coolapk.market.app.ImageLoaderAdapter;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.util.UiUtils;

public class GlideContextImageLoader implements ImageLoaderAdapter<Context> {
    private final GlideImageLoader glideImageLoader;

    public GlideContextImageLoader(GlideImageLoader glideImageLoader2) {
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

    public void cancel(Context context, String str) {
        this.glideImageLoader.cancel(new GlideRequestComponent(context, GlideApp.with(context)), str);
    }

    public void displayImage(Context context, String str, ImageView imageView) {
        displayImage(context, str, imageView, (ImageLoaderOptions) null, (OnImageLoadListener) null, (OnBitmapTransformListener) null);
    }

    public void displayImage(Context context, String str, ImageView imageView, int i) {
        displayImage(context, str, imageView, ImageLoaderOptions.newBuilder().placeHolderRes(i).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
    }

    public void displayImage(Context context, String str, ImageView imageView, ImageLoaderOptions imageLoaderOptions, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener) {
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null && !activityNullable.isDestroyed()) {
            if (str == null) {
                str = "";
            }
            this.glideImageLoader.displayImage(new GlideRequestComponent(context, GlideApp.with(context)), str, imageView, imageLoaderOptions, onImageLoadListener, onBitmapTransformListener);
        }
    }

    public Bitmap loadBitmap(Context context, String str) throws Throwable {
        return this.glideImageLoader.loadBitmap(new GlideRequestComponent(context, GlideApp.with(context)), str);
    }
}
