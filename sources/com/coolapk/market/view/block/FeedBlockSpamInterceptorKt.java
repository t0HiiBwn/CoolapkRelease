package com.coolapk.market.view.block;

import com.coolapk.market.model.FeedTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toBlockNode", "Lcom/coolapk/market/view/block/BlockItem;", "Lcom/coolapk/market/model/FeedTarget;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: FeedBlockSpamInterceptor.kt */
public final class FeedBlockSpamInterceptorKt {
    public static final BlockItem toBlockNode(FeedTarget feedTarget) {
        String str;
        Intrinsics.checkNotNullParameter(feedTarget, "$this$toBlockNode");
        String url = feedTarget.getUrl();
        if (url == null) {
            url = "";
        }
        String id = feedTarget.getId();
        if (id == null) {
            id = "";
        }
        int parseInt = Integer.parseInt(id);
        String title = feedTarget.getTitle();
        if (title != null) {
            str = title;
        } else {
            str = "";
        }
        if (StringsKt.startsWith$default(url, "/product", false, 2, (Object) null)) {
            return new BlockItem(String.valueOf(((long) parseInt) + 7000000000L), str, "「数码」" + str, null, false, null, "node", 56, null);
        } else if (StringsKt.startsWith$default(url, "/topic", false, 2, (Object) null)) {
            return new BlockItem(null, '#' + str + "}#", "「话题」" + str, null, false, null, "node", 57, null);
        } else if (StringsKt.startsWith$default(url, "/apk", false, 2, (Object) null)) {
            return new BlockItem(String.valueOf(parseInt + 1000000000), str, "「应用」" + str, null, false, null, "node", 56, null);
        } else if (!StringsKt.startsWith$default(url, "/game", false, 2, (Object) null)) {
            return null;
        } else {
            return new BlockItem(String.valueOf(parseInt + 1000000000), str, "「游戏」" + str, null, false, null, "node", 56, null);
        }
    }
}
