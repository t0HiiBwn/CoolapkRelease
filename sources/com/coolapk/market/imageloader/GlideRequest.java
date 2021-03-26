package com.coolapk.market.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;

public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    GlideRequest(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        super(glide, requestManager, cls, context);
    }

    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> sizeMultiplier(float f) {
        return (GlideRequest) super.sizeMultiplier(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideRequest) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> useAnimationPool(boolean z) {
        return (GlideRequest) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z) {
        return (GlideRequest) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return (GlideRequest) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> priority(Priority priority) {
        return (GlideRequest) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> placeholder(Drawable drawable) {
        return (GlideRequest) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> placeholder(int i) {
        return (GlideRequest) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> fallback(Drawable drawable) {
        return (GlideRequest) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> fallback(int i) {
        return (GlideRequest) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> error(Drawable drawable) {
        return (GlideRequest) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> error(int i) {
        return (GlideRequest) super.error(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> theme(Resources.Theme theme) {
        return (GlideRequest) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> skipMemoryCache(boolean z) {
        return (GlideRequest) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> override(int i, int i2) {
        return (GlideRequest) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> override(int i) {
        return (GlideRequest) super.override(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> signature(Key key) {
        return (GlideRequest) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> GlideRequest<TranscodeType> set(Option<Y> option, Y y) {
        return (GlideRequest) super.set((Option<Option<Y>>) option, (Option<Y>) y);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> decode(Class<?> cls) {
        return (GlideRequest) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideRequest) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> encodeQuality(int i) {
        return (GlideRequest) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> frame(long j) {
        return (GlideRequest) super.frame(j);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> format(DecodeFormat decodeFormat) {
        return (GlideRequest) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return (GlideRequest) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> timeout(int i) {
        return (GlideRequest) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return (GlideRequest) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> centerCrop() {
        return (GlideRequest) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> optionalFitCenter() {
        return (GlideRequest) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> fitCenter() {
        return (GlideRequest) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> optionalCenterInside() {
        return (GlideRequest) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> centerInside() {
        return (GlideRequest) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return (GlideRequest) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> circleCrop() {
        return (GlideRequest) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> transform(Transformation<Bitmap> transformation) {
        return (GlideRequest) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> transform(Transformation<Bitmap>... transformationArr) {
        return (GlideRequest) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @Deprecated
    public GlideRequest<TranscodeType> transforms(Transformation<Bitmap>... transformationArr) {
        return (GlideRequest) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> optionalTransform(Transformation<Bitmap> transformation) {
        return (GlideRequest) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> GlideRequest<TranscodeType> optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return (GlideRequest) super.optionalTransform((Class) cls, (Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> GlideRequest<TranscodeType> transform(Class<Y> cls, Transformation<Y> transformation) {
        return (GlideRequest) super.transform((Class) cls, (Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> dontTransform() {
        return (GlideRequest) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> dontAnimate() {
        return (GlideRequest) super.dontAnimate();
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public GlideRequest<TranscodeType> apply(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.transition((TransitionOptions) transitionOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.listener((RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<TranscodeType> addListener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.addListener((RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.error((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.thumbnail((RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @SafeVarargs
    public final GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (GlideRequest) super.thumbnail((RequestBuilder[]) requestBuilderArr);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public GlideRequest<TranscodeType> thumbnail(float f) {
        return (GlideRequest) super.thumbnail(f);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(Object obj) {
        return (GlideRequest) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(String str) {
        return (GlideRequest) super.load(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(File file) {
        return (GlideRequest) super.load(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(Integer num) {
        return (GlideRequest) super.load(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @Deprecated
    public GlideRequest<TranscodeType> load(URL url) {
        return (GlideRequest) super.load(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public GlideRequest<TranscodeType> load(byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions, java.lang.Object
    public GlideRequest<TranscodeType> clone() {
        return (GlideRequest) super.clone();
    }
}
