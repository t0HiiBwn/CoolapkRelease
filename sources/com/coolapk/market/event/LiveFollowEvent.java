package com.coolapk.market.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/event/LiveFollowEvent;", "", "liveId", "", "follow", "", "(Ljava/lang/String;Z)V", "getFollow", "()Z", "getLiveId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveFollowEvent.kt */
public final class LiveFollowEvent {
    private final boolean follow;
    private final String liveId;

    public static /* synthetic */ LiveFollowEvent copy$default(LiveFollowEvent liveFollowEvent, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveFollowEvent.liveId;
        }
        if ((i & 2) != 0) {
            z = liveFollowEvent.follow;
        }
        return liveFollowEvent.copy(str, z);
    }

    public final String component1() {
        return this.liveId;
    }

    public final boolean component2() {
        return this.follow;
    }

    public final LiveFollowEvent copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        return new LiveFollowEvent(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveFollowEvent)) {
            return false;
        }
        LiveFollowEvent liveFollowEvent = (LiveFollowEvent) obj;
        return Intrinsics.areEqual(this.liveId, liveFollowEvent.liveId) && this.follow == liveFollowEvent.follow;
    }

    public int hashCode() {
        String str = this.liveId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.follow;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public String toString() {
        return "LiveFollowEvent(liveId=" + this.liveId + ", follow=" + this.follow + ")";
    }

    public LiveFollowEvent(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        this.liveId = str;
        this.follow = z;
    }

    public final boolean getFollow() {
        return this.follow;
    }

    public final String getLiveId() {
        return this.liveId;
    }
}
