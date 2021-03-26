package com.coolapk.market.app;

import android.graphics.drawable.Drawable;
import com.coolapk.market.app.AutoValue_ImageLoaderOptions;

public abstract class ImageLoaderOptions {

    public static abstract class Builder {
        public abstract Builder bitmapOnly(boolean z);

        public abstract ImageLoaderOptions build();

        public abstract Builder coolapkHeaderReqired(boolean z);

        public abstract Builder dontTransfer(boolean z);

        public abstract Builder errorRes(int i);

        public abstract Builder loadSource(boolean z);

        public abstract Builder placeHolder(Drawable drawable);

        public abstract Builder placeHolderRes(int i);

        public abstract Builder saveTransfer(boolean z);

        public abstract Builder thumbnail(String str);

        public abstract Builder useAnimate(boolean z);

        public abstract Builder useDiskCache(boolean z);

        public abstract Builder useMemoryCache(boolean z);
    }

    public abstract int getErrorRes();

    public abstract Drawable getPlaceHolder();

    public abstract int getPlaceHolderRes();

    public abstract String getThumbnail();

    public abstract boolean isBitmapOnly();

    public abstract boolean isCoolapkHeaderReqired();

    public abstract boolean isDontTransfer();

    public abstract boolean isLoadSource();

    public abstract boolean isSaveTransfer();

    public abstract boolean isUseAnimate();

    public abstract boolean isUseDiskCache();

    public abstract boolean isUseMemoryCache();

    public static Builder newBuilder() {
        return new AutoValue_ImageLoaderOptions.Builder().placeHolderRes(0).errorRes(0).useMemoryCache(true).useDiskCache(true).dontTransfer(false).useAnimate(false).saveTransfer(false).loadSource(false).bitmapOnly(false).coolapkHeaderReqired(false);
    }
}
