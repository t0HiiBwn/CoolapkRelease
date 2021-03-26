package com.coolapk.market.widget.multitype;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J3\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u000fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/widget/multitype/LinkedCardStyleRule;", "Lcom/coolapk/market/widget/multitype/CardStyleRule;", "thisLoader", "nextLoader", "(Lcom/coolapk/market/widget/multitype/CardStyleRule;Lcom/coolapk/market/widget/multitype/CardStyleRule;)V", "getNextLoader", "()Lcom/coolapk/market/widget/multitype/CardStyleRule;", "getThisLoader", "getCardStyleRule", "", "position", "previous", "", "current", "next", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Integer;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BindDataInterceptor.kt */
final class LinkedCardStyleRule implements CardStyleRule {
    private final CardStyleRule nextLoader;
    private final CardStyleRule thisLoader;

    public LinkedCardStyleRule(CardStyleRule cardStyleRule, CardStyleRule cardStyleRule2) {
        Intrinsics.checkNotNullParameter(cardStyleRule, "thisLoader");
        this.thisLoader = cardStyleRule;
        this.nextLoader = cardStyleRule2;
    }

    public final CardStyleRule getNextLoader() {
        return this.nextLoader;
    }

    public final CardStyleRule getThisLoader() {
        return this.thisLoader;
    }

    @Override // com.coolapk.market.widget.multitype.CardStyleRule
    public Integer getCardStyleRule(int i, Object obj, Object obj2, Object obj3) {
        Intrinsics.checkNotNullParameter(obj2, "current");
        Integer cardStyleRule = this.thisLoader.getCardStyleRule(i, obj, obj2, obj3);
        if (cardStyleRule != null) {
            return cardStyleRule;
        }
        CardStyleRule cardStyleRule2 = this.nextLoader;
        if (cardStyleRule2 != null) {
            return cardStyleRule2.getCardStyleRule(i, obj, obj2, obj3);
        }
        return null;
    }
}
