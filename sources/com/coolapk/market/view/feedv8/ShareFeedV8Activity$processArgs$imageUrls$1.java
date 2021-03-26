package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.ImageUrl;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/ImageUrl;", "kotlin.jvm.PlatformType", "s", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ShareFeedV8Activity.kt */
final class ShareFeedV8Activity$processArgs$imageUrls$1<T, R> implements Func1<String, ImageUrl> {
    public static final ShareFeedV8Activity$processArgs$imageUrls$1 INSTANCE = new ShareFeedV8Activity$processArgs$imageUrls$1();

    ShareFeedV8Activity$processArgs$imageUrls$1() {
    }

    public final ImageUrl call(String str) {
        return ImageUrl.create(str, str);
    }
}
