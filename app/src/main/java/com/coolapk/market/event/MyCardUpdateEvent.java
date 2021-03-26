package com.coolapk.market.event;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/event/MyCardUpdateEvent;", "", "needRefrash", "", "(Z)V", "getNeedRefrash", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyCardUpdateEvent.kt */
public final class MyCardUpdateEvent {
    private final boolean needRefrash;

    public static /* synthetic */ MyCardUpdateEvent copy$default(MyCardUpdateEvent myCardUpdateEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = myCardUpdateEvent.needRefrash;
        }
        return myCardUpdateEvent.copy(z);
    }

    public final boolean component1() {
        return this.needRefrash;
    }

    public final MyCardUpdateEvent copy(boolean z) {
        return new MyCardUpdateEvent(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MyCardUpdateEvent) && this.needRefrash == ((MyCardUpdateEvent) obj).needRefrash;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.needRefrash;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "MyCardUpdateEvent(needRefrash=" + this.needRefrash + ")";
    }

    public MyCardUpdateEvent(boolean z) {
        this.needRefrash = z;
    }

    public final boolean getNeedRefrash() {
        return this.needRefrash;
    }
}
