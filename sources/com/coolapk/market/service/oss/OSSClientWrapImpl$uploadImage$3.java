package com.coolapk.market.service.oss;

import com.coolapk.market.model.ImageUploadOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005 \u0002*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/coolapk/market/service/oss/OSSUploadImageProcessor;", "kotlin.jvm.PlatformType", "it", "", "Lcom/coolapk/market/model/ImageUploadOption;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$uploadImage$3<T, R> implements Func1<List<? extends ImageUploadOption>, OSSUploadImageProcessor> {
    public static final OSSClientWrapImpl$uploadImage$3 INSTANCE = new OSSClientWrapImpl$uploadImage$3();

    OSSClientWrapImpl$uploadImage$3() {
    }

    public final OSSUploadImageProcessor call(List<? extends ImageUploadOption> list) {
        Intrinsics.checkNotNullExpressionValue(list, "it");
        return new OSSUploadImageProcessor(list);
    }
}
