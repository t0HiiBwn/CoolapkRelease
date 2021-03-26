package com.coolapk.market.service.oss;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OSSClientConfig.kt */
public final class OSSImagePersist {
    private final String action;
    private final String fromBucket;
    private final String fromObjectKey;
    private final String toBucket;
    private final String toObjectKey;

    public static /* synthetic */ OSSImagePersist copy$default(OSSImagePersist oSSImagePersist, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oSSImagePersist.fromBucket;
        }
        if ((i & 2) != 0) {
            str2 = oSSImagePersist.fromObjectKey;
        }
        if ((i & 4) != 0) {
            str3 = oSSImagePersist.toBucket;
        }
        if ((i & 8) != 0) {
            str4 = oSSImagePersist.toObjectKey;
        }
        if ((i & 16) != 0) {
            str5 = oSSImagePersist.action;
        }
        return oSSImagePersist.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.fromBucket;
    }

    public final String component2() {
        return this.fromObjectKey;
    }

    public final String component3() {
        return this.toBucket;
    }

    public final String component4() {
        return this.toObjectKey;
    }

    public final String component5() {
        return this.action;
    }

    public final OSSImagePersist copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "fromBucket");
        Intrinsics.checkNotNullParameter(str2, "fromObjectKey");
        Intrinsics.checkNotNullParameter(str3, "toBucket");
        Intrinsics.checkNotNullParameter(str4, "toObjectKey");
        Intrinsics.checkNotNullParameter(str5, "action");
        return new OSSImagePersist(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OSSImagePersist)) {
            return false;
        }
        OSSImagePersist oSSImagePersist = (OSSImagePersist) obj;
        return Intrinsics.areEqual(this.fromBucket, oSSImagePersist.fromBucket) && Intrinsics.areEqual(this.fromObjectKey, oSSImagePersist.fromObjectKey) && Intrinsics.areEqual(this.toBucket, oSSImagePersist.toBucket) && Intrinsics.areEqual(this.toObjectKey, oSSImagePersist.toObjectKey) && Intrinsics.areEqual(this.action, oSSImagePersist.action);
    }

    public int hashCode() {
        String str = this.fromBucket;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fromObjectKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.toBucket;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.toObjectKey;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.action;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "OSSImagePersist(fromBucket=" + this.fromBucket + ", fromObjectKey=" + this.fromObjectKey + ", toBucket=" + this.toBucket + ", toObjectKey=" + this.toObjectKey + ", action=" + this.action + ")";
    }

    public OSSImagePersist(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "fromBucket");
        Intrinsics.checkNotNullParameter(str2, "fromObjectKey");
        Intrinsics.checkNotNullParameter(str3, "toBucket");
        Intrinsics.checkNotNullParameter(str4, "toObjectKey");
        Intrinsics.checkNotNullParameter(str5, "action");
        this.fromBucket = str;
        this.fromObjectKey = str2;
        this.toBucket = str3;
        this.toObjectKey = str4;
        this.action = str5;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getFromBucket() {
        return this.fromBucket;
    }

    public final String getFromObjectKey() {
        return this.fromObjectKey;
    }

    public final String getToBucket() {
        return this.toBucket;
    }

    public final String getToObjectKey() {
        return this.toObjectKey;
    }
}
