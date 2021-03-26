package com.coolapk.market.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

public interface ImageLoaderAdapter<T> {
    void cancel(T t, String str);

    void clearDiskCache(Context context);

    void clearMemoryCache(Context context);

    void destroy(Context context);

    void displayImage(T t, String str, ImageView imageView, ImageLoaderOptions imageLoaderOptions, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener);

    void init(Context context);

    Bitmap loadBitmap(T t, String str) throws Throwable;
}
