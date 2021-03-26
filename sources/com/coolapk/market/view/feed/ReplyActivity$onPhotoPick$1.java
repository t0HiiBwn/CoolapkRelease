package com.coolapk.market.view.feed;

import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/model/ImageUrl;", "kotlin.jvm.PlatformType", "it", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
final class ReplyActivity$onPhotoPick$1<T, R> implements Func1<String, Observable<? extends ImageUrl>> {
    final /* synthetic */ ReplyActivity this$0;

    ReplyActivity$onPhotoPick$1(ReplyActivity replyActivity) {
        this.this$0 = replyActivity;
    }

    public final Observable<? extends ImageUrl> call(String str) {
        return BitmapUtil.compressImage(this.this$0.getActivity(), CoolFileUtils.wrap(str), 0);
    }
}
