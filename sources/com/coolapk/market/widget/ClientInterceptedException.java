package com.coolapk.market.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/widget/ClientInterceptedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "e", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ClientInterceptedException.kt */
public final class ClientInterceptedException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClientInterceptedException(String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "e");
    }
}
