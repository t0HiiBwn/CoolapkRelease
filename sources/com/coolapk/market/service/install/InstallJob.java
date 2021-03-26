package com.coolapk.market.service.install;

import com.coolapk.market.model.Extra;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/service/install/InstallJob;", "", "filePath", "", "from", "extra", "Lcom/coolapk/market/model/Extra;", "useSignatures", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/coolapk/market/model/Extra;Z)V", "getExtra", "()Lcom/coolapk/market/model/Extra;", "getFilePath", "()Ljava/lang/String;", "getFrom", "getUseSignatures", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: InstallQueue.kt */
public final class InstallJob {
    private final Extra extra;
    private final String filePath;
    private final String from;
    private final boolean useSignatures;

    public static /* synthetic */ InstallJob copy$default(InstallJob installJob, String str, String str2, Extra extra2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installJob.filePath;
        }
        if ((i & 2) != 0) {
            str2 = installJob.from;
        }
        if ((i & 4) != 0) {
            extra2 = installJob.extra;
        }
        if ((i & 8) != 0) {
            z = installJob.useSignatures;
        }
        return installJob.copy(str, str2, extra2, z);
    }

    public final String component1() {
        return this.filePath;
    }

    public final String component2() {
        return this.from;
    }

    public final Extra component3() {
        return this.extra;
    }

    public final boolean component4() {
        return this.useSignatures;
    }

    public final InstallJob copy(String str, String str2, Extra extra2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        return new InstallJob(str, str2, extra2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstallJob)) {
            return false;
        }
        InstallJob installJob = (InstallJob) obj;
        return Intrinsics.areEqual(this.filePath, installJob.filePath) && Intrinsics.areEqual(this.from, installJob.from) && Intrinsics.areEqual(this.extra, installJob.extra) && this.useSignatures == installJob.useSignatures;
    }

    public int hashCode() {
        String str = this.filePath;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.from;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Extra extra2 = this.extra;
        if (extra2 != null) {
            i = extra2.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.useSignatures;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "InstallJob(filePath=" + this.filePath + ", from=" + this.from + ", extra=" + this.extra + ", useSignatures=" + this.useSignatures + ")";
    }

    public InstallJob(String str, String str2, Extra extra2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        this.filePath = str;
        this.from = str2;
        this.extra = extra2;
        this.useSignatures = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InstallJob(String str, String str2, Extra extra2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, extra2, (i & 8) != 0 ? true : z);
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFrom() {
        return this.from;
    }

    public final boolean getUseSignatures() {
        return this.useSignatures;
    }
}
