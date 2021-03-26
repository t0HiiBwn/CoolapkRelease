package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$messageIntercept$1$isLiveStream$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ JSONObject $contentJson;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivity$messageIntercept$1$isLiveStream$2(JSONObject jSONObject) {
        super(0);
        this.$contentJson = jSONObject;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Intrinsics.areEqual(this.$contentJson.optString("broadcast"), "1");
    }
}
