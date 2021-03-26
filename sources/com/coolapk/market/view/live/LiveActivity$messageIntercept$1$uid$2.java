package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$messageIntercept$1$uid$2 extends Lambda implements Function0<String> {
    final /* synthetic */ JSONObject $contentJson;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivity$messageIntercept$1$uid$2(JSONObject jSONObject) {
        super(0);
        this.$contentJson = jSONObject;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.$contentJson.optString("uid");
    }
}
