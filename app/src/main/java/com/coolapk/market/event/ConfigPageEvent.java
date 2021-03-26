package com.coolapk.market.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/event/ConfigPageEvent;", "", "keepCurrentTab", "", "(Z)V", "getKeepCurrentTab", "()Z", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ConfigPageEvent.kt */
public final class ConfigPageEvent {
    private final boolean keepCurrentTab;

    public ConfigPageEvent() {
        this(false, 1, null);
    }

    public ConfigPageEvent(boolean z) {
        this.keepCurrentTab = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConfigPageEvent(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getKeepCurrentTab() {
        return this.keepCurrentTab;
    }
}
