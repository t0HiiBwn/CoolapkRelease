package com.coolapk.market.model;

import com.coolapk.market.model.UpgradeInfo;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_UpgradeInfo  reason: invalid class name */
abstract class C$AutoValue_UpgradeInfo extends UpgradeInfo {
    private final String apkId;
    private final String apkSize;
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

    C$AutoValue_UpgradeInfo(String str, String str2, String str3, String str4, int i, String str5, long j, String str6, String str7, String str8, String str9, Long l2, String str10, String str11, String str12) {
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
        Objects.requireNonNull(str2, "Null apkId");
        this.apkId = str2;
        this.displayVersionName = str3;
        Objects.requireNonNull(str4, "Null versionName");
        this.versionName = str4;
        this.versionCode = i;
        Objects.requireNonNull(str5, "Null apkSize");
        this.apkSize = str5;
        this.lastUpdate = j;
        this.changeLog = str6;
        this.logo = str7;
        this.patchKey = str8;
        this.patchSize = str9;
        this.patchLength = l2;
        this.patchMd5 = str10;
        this.extraAnalysisData = str11;
        this.extraFlag = str12;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getApkId() {
        return this.apkId;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getDisplayVersionName() {
        return this.displayVersionName;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getApkSize() {
        return this.apkSize;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getChangeLog() {
        return this.changeLog;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getPatchKey() {
        return this.patchKey;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getPatchSize() {
        return this.patchSize;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public Long getPatchLength() {
        return this.patchLength;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getPatchMd5() {
        return this.patchMd5;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getExtraAnalysisData() {
        return this.extraAnalysisData;
    }

    @Override // com.coolapk.market.model.UpgradeInfo
    public String getExtraFlag() {
        return this.extraFlag;
    }

    @Override // java.lang.Object
    public String toString() {
        return "UpgradeInfo{packageName=" + this.packageName + ", apkId=" + this.apkId + ", displayVersionName=" + this.displayVersionName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", apkSize=" + this.apkSize + ", lastUpdate=" + this.lastUpdate + ", changeLog=" + this.changeLog + ", logo=" + this.logo + ", patchKey=" + this.patchKey + ", patchSize=" + this.patchSize + ", patchLength=" + this.patchLength + ", patchMd5=" + this.patchMd5 + ", extraAnalysisData=" + this.extraAnalysisData + ", extraFlag=" + this.extraFlag + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Long l2;
        String str6;
        String str7;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpgradeInfo)) {
            return false;
        }
        UpgradeInfo upgradeInfo = (UpgradeInfo) obj;
        if (this.packageName.equals(upgradeInfo.getPackageName()) && this.apkId.equals(upgradeInfo.getApkId()) && ((str = this.displayVersionName) != null ? str.equals(upgradeInfo.getDisplayVersionName()) : upgradeInfo.getDisplayVersionName() == null) && this.versionName.equals(upgradeInfo.getVersionName()) && this.versionCode == upgradeInfo.getVersionCode() && this.apkSize.equals(upgradeInfo.getApkSize()) && this.lastUpdate == upgradeInfo.getLastUpdate() && ((str2 = this.changeLog) != null ? str2.equals(upgradeInfo.getChangeLog()) : upgradeInfo.getChangeLog() == null) && ((str3 = this.logo) != null ? str3.equals(upgradeInfo.getLogo()) : upgradeInfo.getLogo() == null) && ((str4 = this.patchKey) != null ? str4.equals(upgradeInfo.getPatchKey()) : upgradeInfo.getPatchKey() == null) && ((str5 = this.patchSize) != null ? str5.equals(upgradeInfo.getPatchSize()) : upgradeInfo.getPatchSize() == null) && ((l2 = this.patchLength) != null ? l2.equals(upgradeInfo.getPatchLength()) : upgradeInfo.getPatchLength() == null) && ((str6 = this.patchMd5) != null ? str6.equals(upgradeInfo.getPatchMd5()) : upgradeInfo.getPatchMd5() == null) && ((str7 = this.extraAnalysisData) != null ? str7.equals(upgradeInfo.getExtraAnalysisData()) : upgradeInfo.getExtraAnalysisData() == null)) {
            String str8 = this.extraFlag;
            if (str8 == null) {
                if (upgradeInfo.getExtraFlag() == null) {
                    return true;
                }
            } else if (str8.equals(upgradeInfo.getExtraFlag())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (((this.packageName.hashCode() ^ 1000003) * 1000003) ^ this.apkId.hashCode()) * 1000003;
        String str = this.displayVersionName;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.lastUpdate;
        int hashCode3 = ((int) (((long) ((((((((hashCode ^ hashCode2) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.versionCode) * 1000003) ^ this.apkSize.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003;
        String str2 = this.changeLog;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.logo;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.patchKey;
        int hashCode6 = (hashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.patchSize;
        int hashCode7 = (hashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Long l2 = this.patchLength;
        int hashCode8 = (hashCode7 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str6 = this.patchMd5;
        int hashCode9 = (hashCode8 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.extraAnalysisData;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraFlag;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode10 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_UpgradeInfo$Builder */
    static final class Builder extends UpgradeInfo.Builder {
        private String apkId;
        private String apkSize;
        private String changeLog;
        private String displayVersionName;
        private String extraAnalysisData;
        private String extraFlag;
        private Long lastUpdate;
        private String logo;
        private String packageName;
        private String patchKey;
        private Long patchLength;
        private String patchMd5;
        private String patchSize;
        private Integer versionCode;
        private String versionName;

        Builder() {
        }

        Builder(UpgradeInfo upgradeInfo) {
            this.packageName = upgradeInfo.getPackageName();
            this.apkId = upgradeInfo.getApkId();
            this.displayVersionName = upgradeInfo.getDisplayVersionName();
            this.versionName = upgradeInfo.getVersionName();
            this.versionCode = Integer.valueOf(upgradeInfo.getVersionCode());
            this.apkSize = upgradeInfo.getApkSize();
            this.lastUpdate = Long.valueOf(upgradeInfo.getLastUpdate());
            this.changeLog = upgradeInfo.getChangeLog();
            this.logo = upgradeInfo.getLogo();
            this.patchKey = upgradeInfo.getPatchKey();
            this.patchSize = upgradeInfo.getPatchSize();
            this.patchLength = upgradeInfo.getPatchLength();
            this.patchMd5 = upgradeInfo.getPatchMd5();
            this.extraAnalysisData = upgradeInfo.getExtraAnalysisData();
            this.extraFlag = upgradeInfo.getExtraFlag();
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder apkId(String str) {
            this.apkId = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder displayVersionName(String str) {
            this.displayVersionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder versionName(String str) {
            this.versionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder versionCode(int i) {
            this.versionCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder apkSize(String str) {
            this.apkSize = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder lastUpdate(long j) {
            this.lastUpdate = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder changeLog(String str) {
            this.changeLog = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder patchKey(String str) {
            this.patchKey = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder patchSize(String str) {
            this.patchSize = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder patchLength(Long l2) {
            this.patchLength = l2;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder patchMd5(String str) {
            this.patchMd5 = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder extraAnalysisData(String str) {
            this.extraAnalysisData = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo.Builder extraFlag(String str) {
            this.extraFlag = str;
            return this;
        }

        @Override // com.coolapk.market.model.UpgradeInfo.Builder
        public UpgradeInfo build() {
            String str = "";
            if (this.packageName == null) {
                str = str + " packageName";
            }
            if (this.apkId == null) {
                str = str + " apkId";
            }
            if (this.versionName == null) {
                str = str + " versionName";
            }
            if (this.versionCode == null) {
                str = str + " versionCode";
            }
            if (this.apkSize == null) {
                str = str + " apkSize";
            }
            if (this.lastUpdate == null) {
                str = str + " lastUpdate";
            }
            if (str.isEmpty()) {
                return new AutoValue_UpgradeInfo(this.packageName, this.apkId, this.displayVersionName, this.versionName, this.versionCode.intValue(), this.apkSize, this.lastUpdate.longValue(), this.changeLog, this.logo, this.patchKey, this.patchSize, this.patchLength, this.patchMd5, this.extraAnalysisData, this.extraFlag);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
