package com.coolapk.market.event;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/event/CoolPicScrollEvent;", "", "index", "", "(I)V", "getIndex", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicScrollEvent.kt */
public final class CoolPicScrollEvent {
    private final int index;

    public static /* synthetic */ CoolPicScrollEvent copy$default(CoolPicScrollEvent coolPicScrollEvent, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = coolPicScrollEvent.index;
        }
        return coolPicScrollEvent.copy(i);
    }

    public final int component1() {
        return this.index;
    }

    public final CoolPicScrollEvent copy(int i) {
        return new CoolPicScrollEvent(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoolPicScrollEvent) && this.index == ((CoolPicScrollEvent) obj).index;
        }
        return true;
    }

    public int hashCode() {
        return this.index;
    }

    public String toString() {
        return "CoolPicScrollEvent(index=" + this.index + ")";
    }

    public CoolPicScrollEvent(int i) {
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }
}
