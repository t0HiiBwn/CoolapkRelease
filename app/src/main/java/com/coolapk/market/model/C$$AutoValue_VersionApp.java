package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_VersionApp  reason: invalid class name */
abstract class C$$AutoValue_VersionApp extends VersionApp {
    private final String appName;
    private final String downloadFrom;
    private final String packageName;
    private final String versionDate;
    private final String versionId;
    private final String versionLength;
    private final String versionName;
    private final String versionSize;

    C$$AutoValue_VersionApp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
        Objects.requireNonNull(str2, "Null versionName");
        this.versionName = str2;
        Objects.requireNonNull(str3, "Null appName");
        this.appName = str3;
        Objects.requireNonNull(str4, "Null versionId");
        this.versionId = str4;
        Objects.requireNonNull(str5, "Null versionSize");
        this.versionSize = str5;
        Objects.requireNonNull(str6, "Null versionLength");
        this.versionLength = str6;
        Objects.requireNonNull(str7, "Null versionDate");
        this.versionDate = str7;
        Objects.requireNonNull(str8, "Null downloadFrom");
        this.downloadFrom = str8;
    }

    @Override // com.coolapk.market.model.VersionApp
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.VersionApp
    @SerializedName("version")
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.VersionApp
    @SerializedName("title")
    public String getAppName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.VersionApp
    public String getVersionId() {
        return this.versionId;
    }

    @Override // com.coolapk.market.model.VersionApp
    public String getVersionSize() {
        return this.versionSize;
    }

    @Override // com.coolapk.market.model.VersionApp
    public String getVersionLength() {
        return this.versionLength;
    }

    @Override // com.coolapk.market.model.VersionApp
    public String getVersionDate() {
        return this.versionDate;
    }

    @Override // com.coolapk.market.model.VersionApp
    public String getDownloadFrom() {
        return this.downloadFrom;
    }

    @Override // java.lang.Object
    public String toString() {
        return "VersionApp{packageName=" + this.packageName + ", versionName=" + this.versionName + ", appName=" + this.appName + ", versionId=" + this.versionId + ", versionSize=" + this.versionSize + ", versionLength=" + this.versionLength + ", versionDate=" + this.versionDate + ", downloadFrom=" + this.downloadFrom + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VersionApp)) {
            return false;
        }
        VersionApp versionApp = (VersionApp) obj;
        if (!this.packageName.equals(versionApp.getPackageName()) || !this.versionName.equals(versionApp.getVersionName()) || !this.appName.equals(versionApp.getAppName()) || !this.versionId.equals(versionApp.getVersionId()) || !this.versionSize.equals(versionApp.getVersionSize()) || !this.versionLength.equals(versionApp.getVersionLength()) || !this.versionDate.equals(versionApp.getVersionDate()) || !this.downloadFrom.equals(versionApp.getDownloadFrom())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((((((((((((this.packageName.hashCode() ^ 1000003) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.appName.hashCode()) * 1000003) ^ this.versionId.hashCode()) * 1000003) ^ this.versionSize.hashCode()) * 1000003) ^ this.versionLength.hashCode()) * 1000003) ^ this.versionDate.hashCode()) * 1000003) ^ this.downloadFrom.hashCode();
    }
}
