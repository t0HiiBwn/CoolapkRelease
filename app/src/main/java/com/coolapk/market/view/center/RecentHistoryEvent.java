package com.coolapk.market.view.center;

import com.coolapk.market.model.RecentHistory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryEvent;", "", "data", "Lcom/coolapk/market/model/RecentHistory;", "type", "", "(Lcom/coolapk/market/model/RecentHistory;Ljava/lang/String;)V", "getData", "()Lcom/coolapk/market/model/RecentHistory;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentHistoryEvent.kt */
public final class RecentHistoryEvent {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_CLEAR = "clear";
    public static final String TYPE_DELETE = "delete";
    public static final String TYPE_SET_TOP = "set_top";
    public static final String TYPE_UNSET_TOP = "unset_top";
    private final RecentHistory data;
    private final String type;

    public static /* synthetic */ RecentHistoryEvent copy$default(RecentHistoryEvent recentHistoryEvent, RecentHistory recentHistory, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            recentHistory = recentHistoryEvent.data;
        }
        if ((i & 2) != 0) {
            str = recentHistoryEvent.type;
        }
        return recentHistoryEvent.copy(recentHistory, str);
    }

    public final RecentHistory component1() {
        return this.data;
    }

    public final String component2() {
        return this.type;
    }

    public final RecentHistoryEvent copy(RecentHistory recentHistory, String str) {
        Intrinsics.checkNotNullParameter(recentHistory, "data");
        Intrinsics.checkNotNullParameter(str, "type");
        return new RecentHistoryEvent(recentHistory, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecentHistoryEvent)) {
            return false;
        }
        RecentHistoryEvent recentHistoryEvent = (RecentHistoryEvent) obj;
        return Intrinsics.areEqual(this.data, recentHistoryEvent.data) && Intrinsics.areEqual(this.type, recentHistoryEvent.type);
    }

    public int hashCode() {
        RecentHistory recentHistory = this.data;
        int i = 0;
        int hashCode = (recentHistory != null ? recentHistory.hashCode() : 0) * 31;
        String str = this.type;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RecentHistoryEvent(data=" + this.data + ", type=" + this.type + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryEvent$Companion;", "", "()V", "TYPE_CLEAR", "", "TYPE_DELETE", "TYPE_SET_TOP", "TYPE_UNSET_TOP", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RecentHistoryEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RecentHistoryEvent(RecentHistory recentHistory, String str) {
        Intrinsics.checkNotNullParameter(recentHistory, "data");
        Intrinsics.checkNotNullParameter(str, "type");
        this.data = recentHistory;
        this.type = str;
    }

    public final RecentHistory getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
