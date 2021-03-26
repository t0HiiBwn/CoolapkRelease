package com.coolapk.market.util;

import com.coolapk.market.util.UriActionUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/text/Regex;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
final class UriActionUtils$PathIdUriAction$regex$2 extends Lambda implements Function0<Regex> {
    final /* synthetic */ UriActionUtils.PathIdUriAction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UriActionUtils$PathIdUriAction$regex$2(UriActionUtils.PathIdUriAction pathIdUriAction) {
        super(0);
        this.this$0 = pathIdUriAction;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Regex invoke() {
        return new Regex("/{0,2}" + this.this$0.getPathKey() + "/.+");
    }
}
