package com.coolapk.market.service.oss;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/service/oss/OSSPutRequest;", "", "bucket", "", "objectName", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBucket", "()Ljava/lang/String;", "getFilePath", "getObjectName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OSSClientConfig.kt */
public final class OSSPutRequest {
    private final String bucket;
    private final String filePath;
    private final String objectName;

    public static /* synthetic */ OSSPutRequest copy$default(OSSPutRequest oSSPutRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oSSPutRequest.bucket;
        }
        if ((i & 2) != 0) {
            str2 = oSSPutRequest.objectName;
        }
        if ((i & 4) != 0) {
            str3 = oSSPutRequest.filePath;
        }
        return oSSPutRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.bucket;
    }

    public final String component2() {
        return this.objectName;
    }

    public final String component3() {
        return this.filePath;
    }

    public final OSSPutRequest copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "bucket");
        Intrinsics.checkNotNullParameter(str2, "objectName");
        Intrinsics.checkNotNullParameter(str3, "filePath");
        return new OSSPutRequest(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OSSPutRequest)) {
            return false;
        }
        OSSPutRequest oSSPutRequest = (OSSPutRequest) obj;
        return Intrinsics.areEqual(this.bucket, oSSPutRequest.bucket) && Intrinsics.areEqual(this.objectName, oSSPutRequest.objectName) && Intrinsics.areEqual(this.filePath, oSSPutRequest.filePath);
    }

    public int hashCode() {
        String str = this.bucket;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.objectName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.filePath;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "OSSPutRequest(bucket=" + this.bucket + ", objectName=" + this.objectName + ", filePath=" + this.filePath + ")";
    }

    public OSSPutRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "bucket");
        Intrinsics.checkNotNullParameter(str2, "objectName");
        Intrinsics.checkNotNullParameter(str3, "filePath");
        this.bucket = str;
        this.objectName = str2;
        this.filePath = str3;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getObjectName() {
        return this.objectName;
    }
}
