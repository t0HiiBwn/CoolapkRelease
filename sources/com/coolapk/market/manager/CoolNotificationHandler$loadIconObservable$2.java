package com.coolapk.market.manager;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.util.CircleTransform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0014\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "subscriber", "Lrx/Subscriber;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolNotificationHandler.kt */
final class CoolNotificationHandler$loadIconObservable$2<T> implements Observable.OnSubscribe<Bitmap> {
    final /* synthetic */ String $url;

    CoolNotificationHandler$loadIconObservable$2(String str) {
        this.$url = str;
    }

    public final void call(Subscriber<? super Bitmap> subscriber) {
        Bitmap bitmap = null;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        try {
            bitmap = (Bitmap) GlideApp.with(application).asBitmap().load(Uri.parse(this.$url)).diskCacheStrategy(DiskCacheStrategy.DATA).transform((Transformation<Bitmap>) new CircleTransform(false, 0, 3, null)).submit(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
        } catch (Throwable unused) {
        }
        subscriber.onNext(bitmap);
    }
}
