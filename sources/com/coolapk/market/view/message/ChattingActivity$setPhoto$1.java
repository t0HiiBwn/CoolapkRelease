package com.coolapk.market.view.message;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ImageUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/ImageUrl;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
final class ChattingActivity$setPhoto$1<T, R> implements Func1<ImageUrl, Observable<? extends ResponseBody>> {
    final /* synthetic */ ChattingActivity this$0;

    ChattingActivity$setPhoto$1(ChattingActivity chattingActivity) {
        this.this$0 = chattingActivity;
    }

    public final Observable<? extends ResponseBody> call(ImageUrl imageUrl) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(imageUrl, "it");
        return instance.uploadMessageImage(imageUrl.getCompressedUrl(), this.this$0.userId);
    }
}
