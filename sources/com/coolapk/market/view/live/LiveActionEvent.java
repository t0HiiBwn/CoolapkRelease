package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/live/LiveActionEvent;", "", "id", "", "action", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveActionEvent.kt */
public final class LiveActionEvent {
    private final String action;
    private final String id;

    public LiveActionEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "action");
        this.id = str;
        this.action = str2;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getId() {
        return this.id;
    }
}
