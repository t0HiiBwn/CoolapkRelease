package com.coolapk.market.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/event/TabEvent;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TabEvent.kt */
public final class TabEvent {
    private final String name;

    public static /* synthetic */ TabEvent copy$default(TabEvent tabEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tabEvent.name;
        }
        return tabEvent.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final TabEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new TabEvent(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TabEvent) && Intrinsics.areEqual(this.name, ((TabEvent) obj).name);
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TabEvent(name=" + this.name + ")";
    }

    public TabEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
