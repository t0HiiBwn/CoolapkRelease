package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$pushTag$2 extends Lambda implements Function0<String> {
    final /* synthetic */ LiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivity$pushTag$2(LiveActivity liveActivity) {
        super(0);
        this.this$0 = liveActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "#/live/" + this.this$0.getLiveId();
    }
}