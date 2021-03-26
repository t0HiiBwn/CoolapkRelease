package com.coolapk.market.model;

import com.coolapk.market.model.MobileApp;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_MobileApp  reason: invalid class name */
abstract class C$AutoValue_MobileApp extends MobileApp {
    private final long apkLength;
    private final String apkMd5;
    private final String apkPath;
    private final String appName;
    private final long created;
    private final long dbId;
    private final boolean exist;
    private final long firstInstallTime;
    private final IgnoreInfo ignoreInfo;
    private final long lastUpdateTime;
    private final long modified;
    private final String packageName;
    private final boolean systemApp;
    private final UpgradeInfo upgradeInfo;
    private final int versionCode;
    private final String versionName;

    C$AutoValue_MobileApp(long j, String str, String str2, int i, String str3, long j2, String str4, long j3, long j4, boolean z, String str5, boolean z2, UpgradeInfo upgradeInfo2, IgnoreInfo ignoreInfo2, long j5, long j6) {
        this.dbId = j;
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
        Objects.requireNonNull(str2, "Null versionName");
        this.versionName = str2;
        this.versionCode = i;
        Objects.requireNonNull(str3, "Null appName");
        this.appName = str3;
        this.apkLength = j2;
        this.apkMd5 = str4;
        this.firstInstallTime = j3;
        this.lastUpdateTime = j4;
        this.exist = z;
        Objects.requireNonNull(str5, "Null apkPath");
        this.apkPath = str5;
        this.systemApp = z2;
        this.upgradeInfo = upgradeInfo2;
        this.ignoreInfo = ignoreInfo2;
        this.created = j5;
        this.modified = j6;
    }

    @Override // com.coolapk.market.model.MobileApp
    public long getDbId() {
        return this.dbId;
    }

    @Override // com.coolapk.market.model.MobileApp
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.MobileApp
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.MobileApp
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.MobileApp
    public String getAppName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.MobileApp
    public long getApkLength() {
        return this.apkLength;
    }

    @Override // com.coolapk.market.model.MobileApp
    public String getApkMd5() {
        return this.apkMd5;
    }

    @Override // com.coolapk.market.model.MobileApp
    public long getFirstInstallTime() {
        return this.firstInstallTime;
    }

    @Override // com.coolapk.market.model.MobileApp
    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Override // com.coolapk.market.model.MobileApp
    public boolean isExist() {
        return this.exist;
    }

    @Override // com.coolapk.market.model.MobileApp
    public String getApkPath() {
        return this.apkPath;
    }

    @Override // com.coolapk.market.model.MobileApp
    public boolean isSystemApp() {
        return this.systemApp;
    }

    @Override // com.coolapk.market.model.MobileApp
    public UpgradeInfo getUpgradeInfo() {
        return this.upgradeInfo;
    }

    @Override // com.coolapk.market.model.MobileApp
    public IgnoreInfo getIgnoreInfo() {
        return this.ignoreInfo;
    }

    @Override // com.coolapk.market.model.MobileApp
    public long getCreated() {
        return this.created;
    }

    @Override // com.coolapk.market.model.MobileApp
    public long getModified() {
        return this.modified;
    }

    @Override // java.lang.Object
    public String toString() {
        return "MobileApp{dbId=" + this.dbId + ", packageName=" + this.packageName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", appName=" + this.appName + ", apkLength=" + this.apkLength + ", apkMd5=" + this.apkMd5 + ", firstInstallTime=" + this.firstInstallTime + ", lastUpdateTime=" + this.lastUpdateTime + ", exist=" + this.exist + ", apkPath=" + this.apkPath + ", systemApp=" + this.systemApp + ", upgradeInfo=" + this.upgradeInfo + ", ignoreInfo=" + this.ignoreInfo + ", created=" + this.created + ", modified=" + this.modified + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        UpgradeInfo upgradeInfo2;
        IgnoreInfo ignoreInfo2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MobileApp)) {
            return false;
        }
        MobileApp mobileApp = (MobileApp) obj;
        if (this.dbId == mobileApp.getDbId() && this.packageName.equals(mobileApp.getPackageName()) && this.versionName.equals(mobileApp.getVersionName()) && this.versionCode == mobileApp.getVersionCode() && this.appName.equals(mobileApp.getAppName()) && this.apkLength == mobileApp.getApkLength() && ((str = this.apkMd5) != null ? str.equals(mobileApp.getApkMd5()) : mobileApp.getApkMd5() == null) && this.firstInstallTime == mobileApp.getFirstInstallTime() && this.lastUpdateTime == mobileApp.getLastUpdateTime() && this.exist == mobileApp.isExist() && this.apkPath.equals(mobileApp.getApkPath()) && this.systemApp == mobileApp.isSystemApp() && ((upgradeInfo2 = this.upgradeInfo) != null ? upgradeInfo2.equals(mobileApp.getUpgradeInfo()) : mobileApp.getUpgradeInfo() == null) && ((ignoreInfo2 = this.ignoreInfo) != null ? ignoreInfo2.equals(mobileApp.getIgnoreInfo()) : mobileApp.getIgnoreInfo() == null) && this.created == mobileApp.getCreated() && this.modified == mobileApp.getModified()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j = this.dbId;
        int hashCode = this.packageName.hashCode();
        long j2 = this.apkLength;
        int hashCode2 = ((int) (((long) ((((((((hashCode ^ (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003)) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.versionCode) * 1000003) ^ this.appName.hashCode()) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003;
        String str = this.apkMd5;
        int i = 0;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.firstInstallTime;
        long j4 = this.lastUpdateTime;
        int i2 = 1231;
        int hashCode4 = ((((this.exist ? 1231 : 1237) ^ (((int) (((long) (((int) (((long) ((hashCode3 ^ hashCode2) * 1000003)) ^ (j3 ^ (j3 >>> 32)))) * 1000003)) ^ (j4 ^ (j4 >>> 32)))) * 1000003)) * 1000003) ^ this.apkPath.hashCode()) * 1000003;
        if (!this.systemApp) {
            i2 = 1237;
        }
        int i3 = (hashCode4 ^ i2) * 1000003;
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        int hashCode5 = (i3 ^ (upgradeInfo2 == null ? 0 : upgradeInfo2.hashCode())) * 1000003;
        IgnoreInfo ignoreInfo2 = this.ignoreInfo;
        if (ignoreInfo2 != null) {
            i = ignoreInfo2.hashCode();
        }
        long j5 = this.created;
        long j6 = (long) (((int) (((long) ((hashCode5 ^ i) * 1000003)) ^ (j5 ^ (j5 >>> 32)))) * 1000003);
        long j7 = this.modified;
        return (int) (j6 ^ (j7 ^ (j7 >>> 32)));
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_MobileApp$Builder */
    static final class Builder extends MobileApp.Builder {
        private Long apkLength;
        private String apkMd5;
        private String apkPath;
        private String appName;
        private Long created;
        private Long dbId;
        private Boolean exist;
        private Long firstInstallTime;
        private IgnoreInfo ignoreInfo;
        private Long lastUpdateTime;
        private Long modified;
        private String packageName;
        private Boolean systemApp;
        private UpgradeInfo upgradeInfo;
        private Integer versionCode;
        private String versionName;

        Builder() {
        }

        Builder(MobileApp mobileApp) {
            this.dbId = Long.valueOf(mobileApp.getDbId());
            this.packageName = mobileApp.getPackageName();
            this.versionName = mobileApp.getVersionName();
            this.versionCode = Integer.valueOf(mobileApp.getVersionCode());
            this.appName = mobileApp.getAppName();
            this.apkLength = Long.valueOf(mobileApp.getApkLength());
            this.apkMd5 = mobileApp.getApkMd5();
            this.firstInstallTime = Long.valueOf(mobileApp.getFirstInstallTime());
            this.lastUpdateTime = Long.valueOf(mobileApp.getLastUpdateTime());
            this.exist = Boolean.valueOf(mobileApp.isExist());
            this.apkPath = mobileApp.getApkPath();
            this.systemApp = Boolean.valueOf(mobileApp.isSystemApp());
            this.upgradeInfo = mobileApp.getUpgradeInfo();
            this.ignoreInfo = mobileApp.getIgnoreInfo();
            this.created = Long.valueOf(mobileApp.getCreated());
            this.modified = Long.valueOf(mobileApp.getModified());
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder dbId(long j) {
            this.dbId = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder versionName(String str) {
            this.versionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder versionCode(int i) {
            this.versionCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder apkLength(long j) {
            this.apkLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder apkMd5(String str) {
            this.apkMd5 = str;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder firstInstallTime(long j) {
            this.firstInstallTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder lastUpdateTime(long j) {
            this.lastUpdateTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder exist(boolean z) {
            this.exist = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder apkPath(String str) {
            this.apkPath = str;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder systemApp(boolean z) {
            this.systemApp = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder upgradeInfo(UpgradeInfo upgradeInfo2) {
            this.upgradeInfo = upgradeInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder ignoreInfo(IgnoreInfo ignoreInfo2) {
            this.ignoreInfo = ignoreInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder created(long j) {
            this.created = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp.Builder modified(long j) {
            this.modified = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.MobileApp.Builder
        public MobileApp build() {
            String str = "";
            if (this.dbId == null) {
                str = str + " dbId";
            }
            if (this.packageName == null) {
                str = str + " packageName";
            }
            if (this.versionName == null) {
                str = str + " versionName";
            }
            if (this.versionCode == null) {
                str = str + " versionCode";
            }
            if (this.appName == null) {
                str = str + " appName";
            }
            if (this.apkLength == null) {
                str = str + " apkLength";
            }
            if (this.firstInstallTime == null) {
                str = str + " firstInstallTime";
            }
            if (this.lastUpdateTime == null) {
                str = str + " lastUpdateTime";
            }
            if (this.exist == null) {
                str = str + " exist";
            }
            if (this.apkPath == null) {
                str = str + " apkPath";
            }
            if (this.systemApp == null) {
                str = str + " systemApp";
            }
            if (this.created == null) {
                str = str + " created";
            }
            if (this.modified == null) {
                str = str + " modified";
            }
            if (str.isEmpty()) {
                return new AutoValue_MobileApp(this.dbId.longValue(), this.packageName, this.versionName, this.versionCode.intValue(), this.appName, this.apkLength.longValue(), this.apkMd5, this.firstInstallTime.longValue(), this.lastUpdateTime.longValue(), this.exist.booleanValue(), this.apkPath, this.systemApp.booleanValue(), this.upgradeInfo, this.ignoreInfo, this.created.longValue(), this.modified.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
