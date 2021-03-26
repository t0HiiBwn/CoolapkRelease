package com.coolapk.market.wxapi;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.imageloader.GlideApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: WXEntryActivity.kt */
final class WXEntryActivity$loadBitmapAndShare$loadBitmapObservable$1<T> implements Action1<Emitter<byte[]>> {
    final /* synthetic */ String $logo;
    final /* synthetic */ WXEntryActivity this$0;

    WXEntryActivity$loadBitmapAndShare$loadBitmapObservable$1(WXEntryActivity wXEntryActivity, String str) {
        this.this$0 = wXEntryActivity;
        this.$logo = str;
    }

    public final void call(Emitter<byte[]> emitter) {
        byte[] bArr = null;
        try {
            Bitmap bitmap = (Bitmap) GlideApp.with((FragmentActivity) this.this$0).asBitmap().load(this.$logo).diskCacheStrategy(DiskCacheStrategy.DATA).submit(120, 120).get();
            WXEntryActivity wXEntryActivity = this.this$0;
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            bArr = wXEntryActivity.toValidWxThumbData(bitmap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        emitter.onNext(bArr);
    }
}
