package com.coolapk.market.view.ad.toutiao;

import com.bytedance.sdk.openadsdk.TTAdNative;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/sdk/openadsdk/TTAdNative;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TTFeedSelfDrawAd.kt */
final class TTFeedSelfDrawAd$ttAdNative$2 extends Lambda implements Function0<TTAdNative> {
    final /* synthetic */ TTFeedSelfDrawAd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TTFeedSelfDrawAd$ttAdNative$2(TTFeedSelfDrawAd tTFeedSelfDrawAd) {
        super(0);
        this.this$0 = tTFeedSelfDrawAd;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TTAdNative invoke() {
        return this.this$0.getTtAdManager().createAdNative(this.this$0.getContext());
    }
}
