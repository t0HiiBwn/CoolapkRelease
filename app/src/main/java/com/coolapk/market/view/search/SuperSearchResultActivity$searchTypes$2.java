package com.coolapk.market.view.search;

import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchResultActivity.kt */
final class SuperSearchResultActivity$searchTypes$2 extends Lambda implements Function0<String[]> {
    public static final SuperSearchResultActivity$searchTypes$2 INSTANCE = new SuperSearchResultActivity$searchTypes$2();

    SuperSearchResultActivity$searchTypes$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String[] invoke() {
        String appMode = AppHolder.getAppMetadata().getAppMode();
        if (appMode != null && appMode.hashCode() == -1480249367 && appMode.equals("community")) {
            return new String[]{"all", "product", "user", "feed", "feedTopic", "goods", "ershou", "ask", "goods_list", "dyhMix"};
        }
        return new String[]{"all", "product", "apk", "game", "user", "feed", "feedTopic", "goods", "ershou", "ask", "goods_list", "dyhMix", "album"};
    }
}
