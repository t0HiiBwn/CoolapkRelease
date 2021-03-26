package com.coolapk.market.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.coolapk.market.app.OnImageLoadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J4\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016JA\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u0006\u0012\u0002\b\u00030\u0013H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/imageloader/RequestListenerAdapter;", "R", "Lcom/bumptech/glide/request/RequestListener;", "uri", "", "onImageLoadListener", "Lcom/coolapk/market/app/OnImageLoadListener;", "(Ljava/lang/String;Lcom/coolapk/market/app/OnImageLoadListener;)V", "getOnImageLoadListener", "()Lcom/coolapk/market/app/OnImageLoadListener;", "getUri", "()Ljava/lang/String;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z", "getViewFromTarget", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GlideImageLoader.kt */
public final class RequestListenerAdapter<R> implements RequestListener<R> {
    private final OnImageLoadListener onImageLoadListener;
    private final String uri;

    public RequestListenerAdapter(String str, OnImageLoadListener onImageLoadListener2) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(onImageLoadListener2, "onImageLoadListener");
        this.uri = str;
        this.onImageLoadListener = onImageLoadListener2;
    }

    public final String getUri() {
        return this.uri;
    }

    public final OnImageLoadListener getOnImageLoadListener() {
        return this.onImageLoadListener;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.onImageLoadListener.onLoadComplete(this.uri, null, target != null ? getViewFromTarget(target) : null, false, glideException);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        View view = null;
        BitmapDrawable bitmapDrawable = null;
        if (r instanceof Drawable) {
            bitmapDrawable = r;
        } else if (r instanceof Bitmap) {
            bitmapDrawable = new BitmapDrawable((Bitmap) r);
        }
        OnImageLoadListener onImageLoadListener2 = this.onImageLoadListener;
        String str = this.uri;
        if (target != null) {
            view = getViewFromTarget(target);
        }
        onImageLoadListener2.onLoadComplete(str, bitmapDrawable, view, !z, null);
        return false;
    }

    private final View getViewFromTarget(Target<?> target) {
        if (!(target instanceof CustomViewTarget)) {
            target = null;
        }
        if (!(target instanceof CustomViewTarget)) {
            target = null;
        }
        CustomViewTarget customViewTarget = (CustomViewTarget) target;
        if (customViewTarget != null) {
            return customViewTarget.getView();
        }
        return null;
    }
}
