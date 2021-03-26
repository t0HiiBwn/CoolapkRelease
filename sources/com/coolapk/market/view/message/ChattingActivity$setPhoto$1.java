package com.coolapk.market.view.message;

import android.util.Pair;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ImageUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0001\u0012F\b\u0001\u0012B\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*L\u0012F\b\u0001\u0012B\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/ImageUrl;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
final class ChattingActivity$setPhoto$1<T, R> implements Func1<ImageUrl, Observable<? extends Pair<String, String>>> {
    final /* synthetic */ ChattingActivity this$0;

    ChattingActivity$setPhoto$1(ChattingActivity chattingActivity) {
        this.this$0 = chattingActivity;
    }

    public final Observable<? extends Pair<String, String>> call(ImageUrl imageUrl) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(imageUrl, "it");
        return instance.uploadMessageImage(imageUrl.getCompressedUrl(), this.this$0.userId);
    }
}
