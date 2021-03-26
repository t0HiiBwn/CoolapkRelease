package com.coolapk.market.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/model/PackageServiceEvent;", "", "action", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PackageServiceEvent.kt */
public final class PackageServiceEvent {
    private final String action;
    private final String key;

    public static /* synthetic */ PackageServiceEvent copy$default(PackageServiceEvent packageServiceEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = packageServiceEvent.action;
        }
        if ((i & 2) != 0) {
            str2 = packageServiceEvent.key;
        }
        return packageServiceEvent.copy(str, str2);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.key;
    }

    public final PackageServiceEvent copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "key");
        return new PackageServiceEvent(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageServiceEvent)) {
            return false;
        }
        PackageServiceEvent packageServiceEvent = (PackageServiceEvent) obj;
        return Intrinsics.areEqual(this.action, packageServiceEvent.action) && Intrinsics.areEqual(this.key, packageServiceEvent.key);
    }

    public int hashCode() {
        String str = this.action;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.key;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PackageServiceEvent(action=" + this.action + ", key=" + this.key + ")";
    }

    public PackageServiceEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "key");
        this.action = str;
        this.key = str2;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getKey() {
        return this.key;
    }
}
