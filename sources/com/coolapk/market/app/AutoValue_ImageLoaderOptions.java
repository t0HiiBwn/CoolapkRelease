package com.coolapk.market.app;

import android.graphics.drawable.Drawable;
import com.coolapk.market.app.ImageLoaderOptions;

final class AutoValue_ImageLoaderOptions extends ImageLoaderOptions {
    private final boolean bitmapOnly;
    private final boolean coolapkHeaderReqired;
    private final boolean dontTransfer;
    private final int errorRes;
    private final boolean loadSource;
    private final Drawable placeHolder;
    private final int placeHolderRes;
    private final boolean saveTransfer;
    private final String thumbnail;
    private final boolean useAnimate;
    private final boolean useDiskCache;
    private final boolean useMemoryCache;

    private AutoValue_ImageLoaderOptions(Drawable drawable, String str, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.placeHolder = drawable;
        this.thumbnail = str;
        this.placeHolderRes = i;
        this.errorRes = i2;
        this.loadSource = z;
        this.useMemoryCache = z2;
        this.useDiskCache = z3;
        this.dontTransfer = z4;
        this.useAnimate = z5;
        this.saveTransfer = z6;
        this.bitmapOnly = z7;
        this.coolapkHeaderReqired = z8;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public Drawable getPlaceHolder() {
        return this.placeHolder;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public String getThumbnail() {
        return this.thumbnail;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public int getPlaceHolderRes() {
        return this.placeHolderRes;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public int getErrorRes() {
        return this.errorRes;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isLoadSource() {
        return this.loadSource;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isUseMemoryCache() {
        return this.useMemoryCache;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isUseDiskCache() {
        return this.useDiskCache;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isDontTransfer() {
        return this.dontTransfer;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isUseAnimate() {
        return this.useAnimate;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isSaveTransfer() {
        return this.saveTransfer;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isBitmapOnly() {
        return this.bitmapOnly;
    }

    @Override // com.coolapk.market.app.ImageLoaderOptions
    public boolean isCoolapkHeaderReqired() {
        return this.coolapkHeaderReqired;
    }

    public String toString() {
        return "ImageLoaderOptions{placeHolder=" + this.placeHolder + ", thumbnail=" + this.thumbnail + ", placeHolderRes=" + this.placeHolderRes + ", errorRes=" + this.errorRes + ", loadSource=" + this.loadSource + ", useMemoryCache=" + this.useMemoryCache + ", useDiskCache=" + this.useDiskCache + ", dontTransfer=" + this.dontTransfer + ", useAnimate=" + this.useAnimate + ", saveTransfer=" + this.saveTransfer + ", bitmapOnly=" + this.bitmapOnly + ", coolapkHeaderReqired=" + this.coolapkHeaderReqired + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageLoaderOptions)) {
            return false;
        }
        ImageLoaderOptions imageLoaderOptions = (ImageLoaderOptions) obj;
        Drawable drawable = this.placeHolder;
        if (drawable != null ? drawable.equals(imageLoaderOptions.getPlaceHolder()) : imageLoaderOptions.getPlaceHolder() == null) {
            String str = this.thumbnail;
            if (str != null ? str.equals(imageLoaderOptions.getThumbnail()) : imageLoaderOptions.getThumbnail() == null) {
                if (this.placeHolderRes == imageLoaderOptions.getPlaceHolderRes() && this.errorRes == imageLoaderOptions.getErrorRes() && this.loadSource == imageLoaderOptions.isLoadSource() && this.useMemoryCache == imageLoaderOptions.isUseMemoryCache() && this.useDiskCache == imageLoaderOptions.isUseDiskCache() && this.dontTransfer == imageLoaderOptions.isDontTransfer() && this.useAnimate == imageLoaderOptions.isUseAnimate() && this.saveTransfer == imageLoaderOptions.isSaveTransfer() && this.bitmapOnly == imageLoaderOptions.isBitmapOnly() && this.coolapkHeaderReqired == imageLoaderOptions.isCoolapkHeaderReqired()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Drawable drawable = this.placeHolder;
        int i = 0;
        int hashCode = ((drawable == null ? 0 : drawable.hashCode()) ^ 1000003) * 1000003;
        String str = this.thumbnail;
        if (str != null) {
            i = str.hashCode();
        }
        int i2 = 1231;
        int i3 = (((((((((((((((((((hashCode ^ i) * 1000003) ^ this.placeHolderRes) * 1000003) ^ this.errorRes) * 1000003) ^ (this.loadSource ? 1231 : 1237)) * 1000003) ^ (this.useMemoryCache ? 1231 : 1237)) * 1000003) ^ (this.useDiskCache ? 1231 : 1237)) * 1000003) ^ (this.dontTransfer ? 1231 : 1237)) * 1000003) ^ (this.useAnimate ? 1231 : 1237)) * 1000003) ^ (this.saveTransfer ? 1231 : 1237)) * 1000003) ^ (this.bitmapOnly ? 1231 : 1237)) * 1000003;
        if (!this.coolapkHeaderReqired) {
            i2 = 1237;
        }
        return i3 ^ i2;
    }

    static final class Builder extends ImageLoaderOptions.Builder {
        private Boolean bitmapOnly;
        private Boolean coolapkHeaderReqired;
        private Boolean dontTransfer;
        private Integer errorRes;
        private Boolean loadSource;
        private Drawable placeHolder;
        private Integer placeHolderRes;
        private Boolean saveTransfer;
        private String thumbnail;
        private Boolean useAnimate;
        private Boolean useDiskCache;
        private Boolean useMemoryCache;

        Builder() {
        }

        Builder(ImageLoaderOptions imageLoaderOptions) {
            this.placeHolder = imageLoaderOptions.getPlaceHolder();
            this.thumbnail = imageLoaderOptions.getThumbnail();
            this.placeHolderRes = Integer.valueOf(imageLoaderOptions.getPlaceHolderRes());
            this.errorRes = Integer.valueOf(imageLoaderOptions.getErrorRes());
            this.loadSource = Boolean.valueOf(imageLoaderOptions.isLoadSource());
            this.useMemoryCache = Boolean.valueOf(imageLoaderOptions.isUseMemoryCache());
            this.useDiskCache = Boolean.valueOf(imageLoaderOptions.isUseDiskCache());
            this.dontTransfer = Boolean.valueOf(imageLoaderOptions.isDontTransfer());
            this.useAnimate = Boolean.valueOf(imageLoaderOptions.isUseAnimate());
            this.saveTransfer = Boolean.valueOf(imageLoaderOptions.isSaveTransfer());
            this.bitmapOnly = Boolean.valueOf(imageLoaderOptions.isBitmapOnly());
            this.coolapkHeaderReqired = Boolean.valueOf(imageLoaderOptions.isCoolapkHeaderReqired());
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder placeHolder(Drawable drawable) {
            this.placeHolder = drawable;
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder thumbnail(String str) {
            this.thumbnail = str;
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder placeHolderRes(int i) {
            this.placeHolderRes = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder errorRes(int i) {
            this.errorRes = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder loadSource(boolean z) {
            this.loadSource = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder useMemoryCache(boolean z) {
            this.useMemoryCache = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder useDiskCache(boolean z) {
            this.useDiskCache = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder dontTransfer(boolean z) {
            this.dontTransfer = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder useAnimate(boolean z) {
            this.useAnimate = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder saveTransfer(boolean z) {
            this.saveTransfer = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder bitmapOnly(boolean z) {
            this.bitmapOnly = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions.Builder coolapkHeaderReqired(boolean z) {
            this.coolapkHeaderReqired = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.app.ImageLoaderOptions.Builder
        public ImageLoaderOptions build() {
            String str = "";
            if (this.placeHolderRes == null) {
                str = str + " placeHolderRes";
            }
            if (this.errorRes == null) {
                str = str + " errorRes";
            }
            if (this.loadSource == null) {
                str = str + " loadSource";
            }
            if (this.useMemoryCache == null) {
                str = str + " useMemoryCache";
            }
            if (this.useDiskCache == null) {
                str = str + " useDiskCache";
            }
            if (this.dontTransfer == null) {
                str = str + " dontTransfer";
            }
            if (this.useAnimate == null) {
                str = str + " useAnimate";
            }
            if (this.saveTransfer == null) {
                str = str + " saveTransfer";
            }
            if (this.bitmapOnly == null) {
                str = str + " bitmapOnly";
            }
            if (this.coolapkHeaderReqired == null) {
                str = str + " coolapkHeaderReqired";
            }
            if (str.isEmpty()) {
                return new AutoValue_ImageLoaderOptions(this.placeHolder, this.thumbnail, this.placeHolderRes.intValue(), this.errorRes.intValue(), this.loadSource.booleanValue(), this.useMemoryCache.booleanValue(), this.useDiskCache.booleanValue(), this.dontTransfer.booleanValue(), this.useAnimate.booleanValue(), this.saveTransfer.booleanValue(), this.bitmapOnly.booleanValue(), this.coolapkHeaderReqired.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
