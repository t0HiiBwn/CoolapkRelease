package com.coolapk.market.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/model/PendingCheckStateApp;", "", "action", "", "packageName", "key", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAction", "()Ljava/lang/String;", "getKey", "getPackageName", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/coolapk/market/model/PendingCheckStateApp;", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PendingCheckStateApp.kt */
public final class PendingCheckStateApp {
    private final String action;
    private final String key;
    private final String packageName;
    private final Long timestamp;

    public static /* synthetic */ PendingCheckStateApp copy$default(PendingCheckStateApp pendingCheckStateApp, String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pendingCheckStateApp.action;
        }
        if ((i & 2) != 0) {
            str2 = pendingCheckStateApp.packageName;
        }
        if ((i & 4) != 0) {
            str3 = pendingCheckStateApp.key;
        }
        if ((i & 8) != 0) {
            l = pendingCheckStateApp.timestamp;
        }
        return pendingCheckStateApp.copy(str, str2, str3, l);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.key;
    }

    public final Long component4() {
        return this.timestamp;
    }

    public final PendingCheckStateApp copy(String str, String str2, String str3, Long l) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "packageName");
        return new PendingCheckStateApp(str, str2, str3, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingCheckStateApp)) {
            return false;
        }
        PendingCheckStateApp pendingCheckStateApp = (PendingCheckStateApp) obj;
        return Intrinsics.areEqual(this.action, pendingCheckStateApp.action) && Intrinsics.areEqual(this.packageName, pendingCheckStateApp.packageName) && Intrinsics.areEqual(this.key, pendingCheckStateApp.key) && Intrinsics.areEqual(this.timestamp, pendingCheckStateApp.timestamp);
    }

    public int hashCode() {
        String str = this.action;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.packageName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.key;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.timestamp;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PendingCheckStateApp(action=" + this.action + ", packageName=" + this.packageName + ", key=" + this.key + ", timestamp=" + this.timestamp + ")";
    }

    public PendingCheckStateApp(String str, String str2, String str3, Long l) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "packageName");
        this.action = str;
        this.packageName = str2;
        this.key = str3;
        this.timestamp = l;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PendingCheckStateApp(String str, String str2, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l);
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
