package com.coolapk.market.service.oss;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/service/oss/OSSClientConfig;", "", "endPoint", "", "accessKeyId", "accessKeySecret", "securityToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getAccessKeySecret", "getEndPoint", "getSecurityToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OSSClientConfig.kt */
public final class OSSClientConfig {
    public static final int BUCKET_SUC = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DOWNLOAD_Fail = 2;
    public static final int DOWNLOAD_SUC = 1;
    public static final int FAIL = 9999;
    public static final int GET_STS_SUC = 11;
    public static final int HEAD_SUC = 7;
    public static final int LIST_SUC = 6;
    public static final int MULTIPART_SUC = 12;
    public static final int REQUESTCODE_AUTH = 10111;
    public static final int REQUESTCODE_LOCALPHOTOS = 10112;
    public static final int RESUMABLE_SUC = 8;
    public static final int SIGN_SUC = 9;
    public static final int STS_TOKEN_SUC = 13;
    public static final int UPLOAD_Fail = 4;
    public static final int UPLOAD_PROGRESS = 5;
    public static final int UPLOAD_SUC = 3;
    private final String accessKeyId;
    private final String accessKeySecret;
    private final String endPoint;
    private final String securityToken;

    public static /* synthetic */ OSSClientConfig copy$default(OSSClientConfig oSSClientConfig, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oSSClientConfig.endPoint;
        }
        if ((i & 2) != 0) {
            str2 = oSSClientConfig.accessKeyId;
        }
        if ((i & 4) != 0) {
            str3 = oSSClientConfig.accessKeySecret;
        }
        if ((i & 8) != 0) {
            str4 = oSSClientConfig.securityToken;
        }
        return oSSClientConfig.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.endPoint;
    }

    public final String component2() {
        return this.accessKeyId;
    }

    public final String component3() {
        return this.accessKeySecret;
    }

    public final String component4() {
        return this.securityToken;
    }

    public final OSSClientConfig copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "endPoint");
        Intrinsics.checkNotNullParameter(str2, "accessKeyId");
        Intrinsics.checkNotNullParameter(str3, "accessKeySecret");
        Intrinsics.checkNotNullParameter(str4, "securityToken");
        return new OSSClientConfig(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OSSClientConfig)) {
            return false;
        }
        OSSClientConfig oSSClientConfig = (OSSClientConfig) obj;
        return Intrinsics.areEqual(this.endPoint, oSSClientConfig.endPoint) && Intrinsics.areEqual(this.accessKeyId, oSSClientConfig.accessKeyId) && Intrinsics.areEqual(this.accessKeySecret, oSSClientConfig.accessKeySecret) && Intrinsics.areEqual(this.securityToken, oSSClientConfig.securityToken);
    }

    public int hashCode() {
        String str = this.endPoint;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accessKeyId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accessKeySecret;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.securityToken;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "OSSClientConfig(endPoint=" + this.endPoint + ", accessKeyId=" + this.accessKeyId + ", accessKeySecret=" + this.accessKeySecret + ", securityToken=" + this.securityToken + ")";
    }

    public OSSClientConfig(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "endPoint");
        Intrinsics.checkNotNullParameter(str2, "accessKeyId");
        Intrinsics.checkNotNullParameter(str3, "accessKeySecret");
        Intrinsics.checkNotNullParameter(str4, "securityToken");
        this.endPoint = str;
        this.accessKeyId = str2;
        this.accessKeySecret = str3;
        this.securityToken = str4;
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public final String getEndPoint() {
        return this.endPoint;
    }

    public final String getSecurityToken() {
        return this.securityToken;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/service/oss/OSSClientConfig$Companion;", "", "()V", "BUCKET_SUC", "", "DOWNLOAD_Fail", "DOWNLOAD_SUC", "FAIL", "GET_STS_SUC", "HEAD_SUC", "LIST_SUC", "MULTIPART_SUC", "REQUESTCODE_AUTH", "REQUESTCODE_LOCALPHOTOS", "RESUMABLE_SUC", "SIGN_SUC", "STS_TOKEN_SUC", "UPLOAD_Fail", "UPLOAD_PROGRESS", "UPLOAD_SUC", "fromJSONObject", "Lcom/coolapk/market/service/oss/OSSClientConfig;", "jsonObject", "Lorg/json/JSONObject;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: OSSClientConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OSSClientConfig fromJSONObject(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            String optString = jSONObject.optString("endPoint");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"endPoint\")");
            String optString2 = jSONObject.optString("accessKeyId");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"accessKeyId\")");
            String optString3 = jSONObject.optString("accessKeySecret");
            Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"accessKeySecret\")");
            String optString4 = jSONObject.optString("securityToken");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"securityToken\")");
            return new OSSClientConfig(optString, optString2, optString3, optString4);
        }
    }
}
