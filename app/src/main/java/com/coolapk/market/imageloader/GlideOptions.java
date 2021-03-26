package com.coolapk.market.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

public final class GlideOptions extends RequestOptions implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    public static GlideOptions sizeMultiplierOf(float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    public static GlideOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static GlideOptions priorityOf(Priority priority) {
        return new GlideOptions().priority(priority);
    }

    public static GlideOptions placeholderOf(Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    public static GlideOptions placeholderOf(int i) {
        return new GlideOptions().placeholder(i);
    }

    public static GlideOptions errorOf(Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    public static GlideOptions errorOf(int i) {
        return new GlideOptions().error(i);
    }

    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    public static GlideOptions overrideOf(int i, int i2) {
        return new GlideOptions().override(i, i2);
    }

    public static GlideOptions overrideOf(int i) {
        return new GlideOptions().override(i);
    }

    public static GlideOptions signatureOf(Key key) {
        return new GlideOptions().signature(key);
    }

    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    public static GlideOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new GlideOptions().transform(transformation);
    }

    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    public static <T> GlideOptions option(Option<T> option, T t) {
        return new GlideOptions().set((Option<Option<T>>) option, (Option<T>) t);
    }

    public static GlideOptions decodeTypeOf(Class<?> cls) {
        return new GlideOptions().decode(cls);
    }

    public static GlideOptions formatOf(DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    public static GlideOptions frameOf(long j) {
        return new GlideOptions().frame(j);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    public static GlideOptions timeoutOf(int i) {
        return new GlideOptions().timeout(i);
    }

    public static GlideOptions encodeQualityOf(int i) {
        return new GlideOptions().encodeQuality(i);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions sizeMultiplier(float f) {
        return (GlideOptions) super.sizeMultiplier(f);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideOptions) super.useUnlimitedSourceGeneratorsPool(z);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions useAnimationPool(boolean z) {
        return (GlideOptions) super.useAnimationPool(z);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions onlyRetrieveFromCache(boolean z) {
        return (GlideOptions) super.onlyRetrieveFromCache(z);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.diskCacheStrategy(diskCacheStrategy);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions priority(Priority priority) {
        return (GlideOptions) super.priority(priority);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions placeholder(Drawable drawable) {
        return (GlideOptions) super.placeholder(drawable);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions placeholder(int i) {
        return (GlideOptions) super.placeholder(i);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions fallback(Drawable drawable) {
        return (GlideOptions) super.fallback(drawable);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions fallback(int i) {
        return (GlideOptions) super.fallback(i);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions error(Drawable drawable) {
        return (GlideOptions) super.error(drawable);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions error(int i) {
        return (GlideOptions) super.error(i);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions theme(Resources.Theme theme) {
        return (GlideOptions) super.theme(theme);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions skipMemoryCache(boolean z) {
        return (GlideOptions) super.skipMemoryCache(z);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions override(int i, int i2) {
        return (GlideOptions) super.override(i, i2);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions override(int i) {
        return (GlideOptions) super.override(i);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions signature(Key key) {
        return (GlideOptions) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions, java.lang.Object
    public GlideOptions clone() {
        return (GlideOptions) super.clone();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> RequestOptions set(Option<Y> option, Y y) {
        return (GlideOptions) super.set((Option<Option<Y>>) option, (Option<Y>) y);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions decode(Class<?> cls) {
        return (GlideOptions) super.decode(cls);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideOptions) super.encodeFormat(compressFormat);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions encodeQuality(int i) {
        return (GlideOptions) super.encodeQuality(i);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions frame(long j) {
        return (GlideOptions) super.frame(j);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions format(DecodeFormat decodeFormat) {
        return (GlideOptions) super.format(decodeFormat);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions disallowHardwareConfig() {
        return (GlideOptions) super.disallowHardwareConfig();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.downsample(downsampleStrategy);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions timeout(int i) {
        return (GlideOptions) super.timeout(i);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions optionalCenterCrop() {
        return (GlideOptions) super.optionalCenterCrop();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions centerCrop() {
        return (GlideOptions) super.centerCrop();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions optionalFitCenter() {
        return (GlideOptions) super.optionalFitCenter();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions fitCenter() {
        return (GlideOptions) super.fitCenter();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions optionalCenterInside() {
        return (GlideOptions) super.optionalCenterInside();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions centerInside() {
        return (GlideOptions) super.centerInside();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions optionalCircleCrop() {
        return (GlideOptions) super.optionalCircleCrop();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions circleCrop() {
        return (GlideOptions) super.circleCrop();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions transform(Transformation<Bitmap> transformation) {
        return (GlideOptions) super.transform(transformation);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @SafeVarargs
    public final RequestOptions transform(Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transform(transformationArr);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    @SafeVarargs
    @Deprecated
    public final RequestOptions transforms(Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transforms(transformationArr);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions optionalTransform(Transformation<Bitmap> transformation) {
        return (GlideOptions) super.optionalTransform(transformation);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> RequestOptions optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return (GlideOptions) super.optionalTransform((Class) cls, (Transformation) transformation);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> RequestOptions transform(Class<Y> cls, Transformation<Y> transformation) {
        return (GlideOptions) super.transform((Class) cls, (Transformation) transformation);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions dontTransform() {
        return (GlideOptions) super.dontTransform();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions dontAnimate() {
        return (GlideOptions) super.dontAnimate();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions apply(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideOptions) super.apply(baseRequestOptions);
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions lock() {
        return (GlideOptions) super.lock();
    }

    /* Return type fixed from 'com.coolapk.market.imageloader.GlideOptions' to match base method */
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestOptions autoClone() {
        return (GlideOptions) super.autoClone();
    }
}
