package com.coolapk.market.view.ad;

import com.coolapk.market.util.LogUtils;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ActivityADScope.kt */
final class ActivityADScope$addOnItsActivityDestroyCallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $fragmentStateID;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityADScope$addOnItsActivityDestroyCallback$1(String str) {
        super(0);
        this.$fragmentStateID = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        HashMap hashMap = (HashMap) ActivityADScope.access$getFragmentFeedAdSourceMap$p(ActivityADScope.INSTANCE).get(this.$fragmentStateID);
        if (hashMap != null) {
            LogUtils.d("销毁广告 " + this.$fragmentStateID + " ，广告个数 " + hashMap.size() + (char) 20010, new Object[0]);
            Collection<FeedAdSource> values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "it.values");
            for (FeedAdSource feedAdSource : values) {
                feedAdSource.release();
            }
            hashMap.clear();
        }
        ActivityADScope.access$getFragmentFeedAdSourceMap$p(ActivityADScope.INSTANCE).remove(this.$fragmentStateID);
    }
}
