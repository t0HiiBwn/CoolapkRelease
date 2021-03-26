package com.coolapk.market.event;

import com.coolapk.market.util.KotlinExtendKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003*\"\u0010\u0004\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005*&\u0010\u0007\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u00052\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0005¨\u0006\t"}, d2 = {"handleOnStateChange", "", "startValue", "", "ErrorHandle", "Lkotlin/Function1;", "", "SuccessHandler", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ProductEvent.kt */
public final class ProductEventKt {
    public static final int handleOnStateChange(int i, boolean z) {
        return z ? KotlinExtendKt.constrain$default(i - 1, 0, 0, 1, (Object) null) : i + 1;
    }
}
