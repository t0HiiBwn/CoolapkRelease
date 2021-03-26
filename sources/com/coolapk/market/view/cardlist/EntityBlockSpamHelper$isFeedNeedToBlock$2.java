package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"checkMatch", "", "text", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityBlockSpamHelper.kt */
final class EntityBlockSpamHelper$isFeedNeedToBlock$2 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ Regex $regex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityBlockSpamHelper$isFeedNeedToBlock$2(Regex regex) {
        super(1);
        this.$regex = regex;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke(str));
    }

    public final boolean invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        String str2 = str;
        if (str2.length() == 0) {
            return false;
        }
        return this.$regex.containsMatchIn(str2);
    }
}
