package com.coolapk.market.view.ad.toutiao;

import com.bytedance.sdk.openadsdk.TTAdManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/sdk/openadsdk/TTAdManager;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TTFeedAd.kt */
final class TTFeedAd$ttAdManager$2 extends Lambda implements Function0<TTAdManager> {
    public static final TTFeedAd$ttAdManager$2 INSTANCE = new TTFeedAd$ttAdManager$2();

    TTFeedAd$ttAdManager$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final TTAdManager invoke() {
        return TTAdManagerHolder.INSTANCE.get();
    }
}
