package com.coolapk.market.service.oss;

import com.coolapk.market.model.ImageUploadOption;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012&\u0010\u0005\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/ImageUploadOption;", "kotlin.jvm.PlatformType", "it", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class OSSClientWrapImpl$uploadImage$2<T, R> implements Func1<List<? extends List<? extends ImageUploadOption>>, Observable<? extends List<? extends ImageUploadOption>>> {
    public static final OSSClientWrapImpl$uploadImage$2 INSTANCE = new OSSClientWrapImpl$uploadImage$2();

    OSSClientWrapImpl$uploadImage$2() {
    }

    public final Observable<? extends List<ImageUploadOption>> call(List<? extends List<? extends ImageUploadOption>> list) {
        return Observable.from(list);
    }
}
