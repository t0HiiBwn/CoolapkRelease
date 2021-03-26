package com.coolapk.market.service.oss;

import android.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aZ\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003 \u0004*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*,\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003 \u0004*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$uploadImage$5<T, R> implements Func1<OSSUploadImageProcessor, Observable<? extends Pair<String, String>>> {
    public static final OSSClientWrapImpl$uploadImage$5 INSTANCE = new OSSClientWrapImpl$uploadImage$5();

    OSSClientWrapImpl$uploadImage$5() {
    }

    public final Observable<? extends Pair<String, String>> call(OSSUploadImageProcessor oSSUploadImageProcessor) {
        if (oSSUploadImageProcessor.getUploadPrepareInfo$presentation_coolapkAppRelease() == null) {
            OSSClientWrapImpl oSSClientWrapImpl = OSSClientWrapImpl.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(oSSUploadImageProcessor, "it");
            return oSSClientWrapImpl.sendImageResultFromFileInfo(oSSUploadImageProcessor);
        }
        OSSClientWrapImpl oSSClientWrapImpl2 = OSSClientWrapImpl.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(oSSUploadImageProcessor, "it");
        return oSSClientWrapImpl2.sendImageResultAfterUpload(oSSUploadImageProcessor);
    }
}
