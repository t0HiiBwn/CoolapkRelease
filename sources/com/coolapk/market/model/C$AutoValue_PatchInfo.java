package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_PatchInfo  reason: invalid class name */
abstract class C$AutoValue_PatchInfo extends PatchInfo {
    private final String apkId;
    private final String apkSize;
    private final String appFullName;
    private final String appName;
    private final String changeLog;
    private final String displayVersionName;
    private final String extraAnalysisData;
    private final String extraFlag;
    private final long lastUpdate;
    private final String logo;
    private final String packageName;
    private final String patchKey;
    private final Long patchLength;
    private final String patchMd5;
    private final String patchSize;
    private final int versionCode;
    private final String versionName;

    C$AutoValue_PatchInfo(String str, String str2, String str3, String str4, int i, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l2, String str13, String str14) {
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
        Objects.requireNonNull(str2, "Null apkId");
        this.apkId = str2;
        Objects.requireNonNull(str3, "Null displayVersionName");
        this.displayVersionName = str3;
        Objects.requireNonNull(str4, "Null versionName");
        this.versionName = str4;
        this.versionCode = i;
        Objects.requireNonNull(str5, "Null apkSize");
        this.apkSize = str5;
        this.lastUpdate = j;
        this.changeLog = str6;
        Objects.requireNonNull(str7, "Null logo");
        this.logo = str7;
        Objects.requireNonNull(str8, "Null appFullName");
        this.appFullName = str8;
        Objects.requireNonNull(str9, "Null appName");
        this.appName = str9;
        this.extraAnalysisData = str10;
        this.patchKey = str11;
        this.patchSize = str12;
        this.patchLength = l2;
        this.patchMd5 = str13;
        this.extraFlag = str14;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("id")
    public String getApkId() {
        return this.apkId;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("version")
    public String getDisplayVersionName() {
        return this.displayVersionName;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("apkversionname")
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("apkversioncode")
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("apksize")
    public String getApkSize() {
        return this.apkSize;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("lastupdate")
    public long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("changelog")
    public String getChangeLog() {
        return this.changeLog;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("title")
    public String getAppFullName() {
        return this.appFullName;
    }

    @Override // com.coolapk.market.model.PatchInfo
    @SerializedName("shorttitle")
    public String getAppName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getExtraAnalysisData() {
        return this.extraAnalysisData;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getPatchKey() {
        return this.patchKey;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getPatchSize() {
        return this.patchSize;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public Long getPatchLength() {
        return this.patchLength;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getPatchMd5() {
        return this.patchMd5;
    }

    @Override // com.coolapk.market.model.PatchInfo
    public String getExtraFlag() {
        return this.extraFlag;
    }

    public String toString() {
        return "PatchInfo{packageName=" + this.packageName + ", apkId=" + this.apkId + ", displayVersionName=" + this.displayVersionName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", apkSize=" + this.apkSize + ", lastUpdate=" + this.lastUpdate + ", changeLog=" + this.changeLog + ", logo=" + this.logo + ", appFullName=" + this.appFullName + ", appName=" + this.appName + ", extraAnalysisData=" + this.extraAnalysisData + ", patchKey=" + this.patchKey + ", patchSize=" + this.patchSize + ", patchLength=" + this.patchLength + ", patchMd5=" + this.patchMd5 + ", extraFlag=" + this.extraFlag + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Long l2;
        String str5;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PatchInfo)) {
            return false;
        }
        PatchInfo patchInfo = (PatchInfo) obj;
        if (this.packageName.equals(patchInfo.getPackageName()) && this.apkId.equals(patchInfo.getApkId()) && this.displayVersionName.equals(patchInfo.getDisplayVersionName()) && this.versionName.equals(patchInfo.getVersionName()) && this.versionCode == patchInfo.getVersionCode() && this.apkSize.equals(patchInfo.getApkSize()) && this.lastUpdate == patchInfo.getLastUpdate() && ((str = this.changeLog) != null ? str.equals(patchInfo.getChangeLog()) : patchInfo.getChangeLog() == null) && this.logo.equals(patchInfo.getLogo()) && this.appFullName.equals(patchInfo.getAppFullName()) && this.appName.equals(patchInfo.getAppName()) && ((str2 = this.extraAnalysisData) != null ? str2.equals(patchInfo.getExtraAnalysisData()) : patchInfo.getExtraAnalysisData() == null) && ((str3 = this.patchKey) != null ? str3.equals(patchInfo.getPatchKey()) : patchInfo.getPatchKey() == null) && ((str4 = this.patchSize) != null ? str4.equals(patchInfo.getPatchSize()) : patchInfo.getPatchSize() == null) && ((l2 = this.patchLength) != null ? l2.equals(patchInfo.getPatchLength()) : patchInfo.getPatchLength() == null) && ((str5 = this.patchMd5) != null ? str5.equals(patchInfo.getPatchMd5()) : patchInfo.getPatchMd5() == null)) {
            String str6 = this.extraFlag;
            if (str6 == null) {
                if (patchInfo.getExtraFlag() == null) {
                    return true;
                }
            } else if (str6.equals(patchInfo.getExtraFlag())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.lastUpdate;
        int hashCode = ((int) (((long) ((((((((((((this.packageName.hashCode() ^ 1000003) * 1000003) ^ this.apkId.hashCode()) * 1000003) ^ this.displayVersionName.hashCode()) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.versionCode) * 1000003) ^ this.apkSize.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        String str = this.changeLog;
        int i = 0;
        int hashCode2 = (((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.logo.hashCode()) * 1000003) ^ this.appFullName.hashCode()) * 1000003) ^ this.appName.hashCode()) * 1000003;
        String str2 = this.extraAnalysisData;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.patchKey;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.patchSize;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Long l2 = this.patchLength;
        int hashCode6 = (hashCode5 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str5 = this.patchMd5;
        int hashCode7 = (hashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraFlag;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode7 ^ i;
    }
}
