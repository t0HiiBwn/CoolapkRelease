package com.coolapk.market.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/event/AppCheckForUpgradeEvent;", "", "packageName", "", "(Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCheckForUpgradeEvent.kt */
public final class AppCheckForUpgradeEvent {
    private final String packageName;

    public static /* synthetic */ AppCheckForUpgradeEvent copy$default(AppCheckForUpgradeEvent appCheckForUpgradeEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appCheckForUpgradeEvent.packageName;
        }
        return appCheckForUpgradeEvent.copy(str);
    }

    public final String component1() {
        return this.packageName;
    }

    public final AppCheckForUpgradeEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return new AppCheckForUpgradeEvent(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AppCheckForUpgradeEvent) && Intrinsics.areEqual(this.packageName, ((AppCheckForUpgradeEvent) obj).packageName);
        }
        return true;
    }

    public int hashCode() {
        String str = this.packageName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AppCheckForUpgradeEvent(packageName=" + this.packageName + ")";
    }

    public AppCheckForUpgradeEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        this.packageName = str;
    }

    public final String getPackageName() {
        return this.packageName;
    }
}
