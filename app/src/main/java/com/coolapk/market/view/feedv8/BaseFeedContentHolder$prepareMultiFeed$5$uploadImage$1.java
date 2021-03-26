package com.coolapk.market.view.feedv8;

import android.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "s", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$1<T> implements Action1<Pair<String, String>> {
    public static final BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$1 INSTANCE = new BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$1();

    BaseFeedContentHolder$prepareMultiFeed$5$uploadImage$1() {
    }

    public final void call(Pair<String, String> pair) {
        if (pair.second != null) {
            Object obj = pair.second;
            Intrinsics.checkNotNullExpressionValue(obj, "s.second");
            if (StringsKt.startsWith$default((String) obj, "http", false, 2, (Object) null)) {
                return;
            }
        }
        throw new RuntimeException("图片上传失败，请重试");
    }
}
