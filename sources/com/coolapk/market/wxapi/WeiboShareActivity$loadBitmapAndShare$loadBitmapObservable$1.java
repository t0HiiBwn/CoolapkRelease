package com.coolapk.market.wxapi;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.imageloader.GlideApp;
import kotlin.Metadata;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lrx/Emitter;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: WeiboShareActivity.kt */
final class WeiboShareActivity$loadBitmapAndShare$loadBitmapObservable$1<T> implements Action1<Emitter<Bitmap>> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $logo;

    WeiboShareActivity$loadBitmapAndShare$loadBitmapObservable$1(Context context, String str) {
        this.$context = context;
        this.$logo = str;
    }

    public final void call(Emitter<Bitmap> emitter) {
        try {
            emitter.onNext((Bitmap) GlideApp.with(this.$context).asBitmap().load(this.$logo).diskCacheStrategy(DiskCacheStrategy.DATA).submit(Integer.MIN_VALUE, Integer.MIN_VALUE).get());
        } catch (Throwable th) {
            th.printStackTrace();
            emitter.onNext(null);
        }
    }
}
