package com.coolapk.market.service.oss;

import com.coolapk.market.model.ImageUploadOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u0010\u0000\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001 \u0003*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u00010\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/ImageUploadOption;", "kotlin.jvm.PlatformType", "it", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$uploadImage$1<T, R> implements Func1<List<ImageUploadOption>, List<? extends List<? extends ImageUploadOption>>> {
    public static final OSSClientWrapImpl$uploadImage$1 INSTANCE = new OSSClientWrapImpl$uploadImage$1();

    OSSClientWrapImpl$uploadImage$1() {
    }

    public final List<List<ImageUploadOption>> call(List<ImageUploadOption> list) {
        OSSClientWrapImpl oSSClientWrapImpl = OSSClientWrapImpl.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(list, "it");
        return oSSClientWrapImpl.createSpiltImageGroup(list);
    }
}
