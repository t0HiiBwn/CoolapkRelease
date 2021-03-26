package com.coolapk.market.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.ViewTarget;
import com.coolapk.market.app.ImageLoaderAdapter;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.widget.ScaleImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J>\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/imageloader/GlideImageLoader;", "Lcom/coolapk/market/app/ImageLoaderAdapter;", "Lcom/coolapk/market/imageloader/GlideRequestComponent;", "()V", "cancel", "", "component", "uri", "", "clearDiskCache", "context", "Landroid/content/Context;", "clearMemoryCache", "destroy", "displayImage", "imageView", "Landroid/widget/ImageView;", "options", "Lcom/coolapk/market/app/ImageLoaderOptions;", "onImageLoadListener", "Lcom/coolapk/market/app/OnImageLoadListener;", "onBitmapTransformListener", "Lcom/coolapk/market/app/OnBitmapTransformListener;", "init", "loadBitmap", "Landroid/graphics/Bitmap;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GlideImageLoader.kt */
public final class GlideImageLoader implements ImageLoaderAdapter<GlideRequestComponent> {
    public void cancel(GlideRequestComponent glideRequestComponent, String str) {
        Intrinsics.checkNotNullParameter(glideRequestComponent, "component");
        Intrinsics.checkNotNullParameter(str, "uri");
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void destroy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public Bitmap loadBitmap(GlideRequestComponent glideRequestComponent, String str) {
        return null;
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void clearMemoryCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GlideApp.get(context).clearMemory();
    }

    @Override // com.coolapk.market.app.ImageLoaderAdapter
    public void clearDiskCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GlideApp.get(context).clearDiskCache();
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void displayImage(GlideRequestComponent glideRequestComponent, String str, ImageView imageView, ImageLoaderOptions imageLoaderOptions, OnImageLoadListener onImageLoadListener, OnBitmapTransformListener onBitmapTransformListener) {
        ImageLoaderOptions imageLoaderOptions2;
        RequestBuilder<Drawable> requestBuilder;
        RequestBuilder<Drawable> requestBuilder2;
        RequestBuilder<Drawable> requestBuilder3;
        Request request;
        Intrinsics.checkNotNullParameter(glideRequestComponent, "component");
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        RequestManager requestManager = glideRequestComponent.getRequestManager();
        if (imageLoaderOptions != null) {
            imageLoaderOptions2 = imageLoaderOptions;
        } else {
            imageLoaderOptions2 = ImageLoaderOptions.newBuilder().build();
        }
        RequestBuilder<Drawable> requestBuilder4 = null;
        Intrinsics.checkNotNullExpressionValue(imageLoaderOptions2, "localOptions");
        if (imageLoaderOptions2.isBitmapOnly()) {
            requestBuilder3 = requestManager.asBitmap();
            requestBuilder2 = requestBuilder3;
            requestBuilder = requestBuilder4;
        } else {
            requestBuilder3 = requestManager.asDrawable();
            requestBuilder = requestBuilder3;
            requestBuilder2 = requestBuilder4;
        }
        if (imageLoaderOptions2.isCoolapkHeaderReqired()) {
            LazyHeaders.Builder createGlideCoolApkHeader = KotlinExtendKt.createGlideCoolApkHeader();
            KotlinExtendKt.appendCoolApkCookies(createGlideCoolApkHeader);
            Intrinsics.checkNotNullExpressionValue(requestBuilder3.load((Object) new GlideUrl(str, createGlideCoolApkHeader.build())), "requestBuilder.load(Glid…, headerBuilder.build()))");
        } else if (StringsKt.startsWith$default(str, "file", false, 2, (Object) null)) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(uri)");
            Intrinsics.checkNotNullExpressionValue(requestBuilder3.load(UtilExtendsKt.toSafeFileUri(parse)), "requestBuilder.load(Uri.…rse(uri).toSafeFileUri())");
        } else {
            Intrinsics.checkNotNullExpressionValue(requestBuilder3.load(str), "requestBuilder.load(uri)");
        }
        if (!GlideImageHelper.shouldLoadRightNow(imageView)) {
            GlideImageHelper.saveArgumentsAndSetListener(this, glideRequestComponent, str, imageView, imageLoaderOptions2, onImageLoadListener, onBitmapTransformListener);
            requestBuilder3.onlyRetrieveFromCache(true);
        }
        if (imageView instanceof ScaleImageView) {
            requestBuilder3.fitCenter();
        }
        if (onBitmapTransformListener != null && (onBitmapTransformListener instanceof BitmapTransformation)) {
            requestBuilder3.transform((Transformation) onBitmapTransformListener);
        }
        if (imageLoaderOptions2.isLoadSource()) {
            requestBuilder3.override(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        if (imageLoaderOptions2.getPlaceHolder() != null) {
            ((RequestBuilder) requestBuilder3.placeholder(imageLoaderOptions2.getPlaceHolder())).error(imageLoaderOptions2.getPlaceHolder());
        }
        int placeHolderRes = imageLoaderOptions2.getPlaceHolderRes();
        if (placeHolderRes != 0) {
            placeHolderRes = ResourceUtils.getDayNightPlaceHolder(placeHolderRes);
            ((RequestBuilder) requestBuilder3.placeholder(placeHolderRes)).error(placeHolderRes);
        }
        if (imageLoaderOptions2.getErrorRes() != 0) {
            requestBuilder3.error(imageLoaderOptions2.getErrorRes());
        }
        DiskCacheStrategy diskCacheStrategy = imageLoaderOptions2.isUseDiskCache() ? DiskCacheStrategy.AUTOMATIC : DiskCacheStrategy.NONE;
        ((RequestBuilder) requestBuilder3.skipMemoryCache(!imageLoaderOptions2.isUseMemoryCache())).diskCacheStrategy(diskCacheStrategy);
        if (imageLoaderOptions2.getThumbnail() != null) {
            GlideApp.with(imageView).load(imageLoaderOptions2.getThumbnail()).diskCacheStrategy(diskCacheStrategy);
        }
        imageLoaderOptions2.isUseAnimate();
        if (onImageLoadListener != null) {
            if (requestBuilder2 != null) {
                requestBuilder2.listener(new RequestListenerAdapter(str, onImageLoadListener));
            }
            if (requestBuilder != null) {
                requestBuilder.listener(new RequestListenerAdapter(str, onImageLoadListener));
            }
        }
        ViewTarget<ImageView, Drawable> into = requestBuilder3.into(imageView);
        Intrinsics.checkNotNullExpressionValue(into, "requestBuilder.into(imageView)");
        if (imageView.getDrawable() == null && (request = into.getRequest()) != null && !request.isRunning() && !request.isComplete()) {
            if (imageLoaderOptions2.getPlaceHolder() != null) {
                imageView.setImageDrawable(imageLoaderOptions2.getPlaceHolder());
            } else if (placeHolderRes != 0) {
                imageView.setImageResource(placeHolderRes);
            }
        }
    }
}
