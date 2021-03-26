package com.coolapk.market.view.live;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$launch$3 implements Action0 {
    public static final LiveDiscussPoll$launch$3 INSTANCE = new LiveDiscussPoll$launch$3();

    LiveDiscussPoll$launch$3() {
    }

    @Override // rx.functions.Action0
    public final void call() {
        LiveDiscussPollKt.liveDiscussPollLogD("直播推送被取消订阅");
    }
}
