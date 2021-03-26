package com.coolapk.market.model;

import com.coolapk.market.model.LocalApk;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_LocalApk  reason: invalid class name */
abstract class C$AutoValue_LocalApk extends LocalApk {
    private final long apkLength;
    private final String appName;
    private final String filePath;
    private final long firstInstallTime;
    private final long lastUpdateTime;
    private final String packageName;
    private final boolean systemApp;
    private final int targetSdkVersion;
    private final int versionCode;
    private final String versionName;

    C$AutoValue_LocalApk(String str, String str2, int i, String str3, long j, long j2, long j3, boolean z, String str4, int i2) {
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
        Objects.requireNonNull(str2, "Null versionName");
        this.versionName = str2;
        this.versionCode = i;
        Objects.requireNonNull(str3, "Null appName");
        this.appName = str3;
        this.apkLength = j;
        this.firstInstallTime = j2;
        this.lastUpdateTime = j3;
        this.systemApp = z;
        Objects.requireNonNull(str4, "Null filePath");
        this.filePath = str4;
        this.targetSdkVersion = i2;
    }

    @Override // com.coolapk.market.model.LocalApk
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.LocalApk
    public String getVersionName() {
        return this.versionName;
    }

    @Override // com.coolapk.market.model.LocalApk
    public int getVersionCode() {
        return this.versionCode;
    }

    @Override // com.coolapk.market.model.LocalApk
    public String getAppName() {
        return this.appName;
    }

    @Override // com.coolapk.market.model.LocalApk
    public long getApkLength() {
        return this.apkLength;
    }

    @Override // com.coolapk.market.model.LocalApk
    public long getFirstInstallTime() {
        return this.firstInstallTime;
    }

    @Override // com.coolapk.market.model.LocalApk
    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Override // com.coolapk.market.model.LocalApk
    public boolean isSystemApp() {
        return this.systemApp;
    }

    @Override // com.coolapk.market.model.LocalApk
    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.coolapk.market.model.LocalApk
    public int getTargetSdkVersion() {
        return this.targetSdkVersion;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LocalApk{packageName=" + this.packageName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", appName=" + this.appName + ", apkLength=" + this.apkLength + ", firstInstallTime=" + this.firstInstallTime + ", lastUpdateTime=" + this.lastUpdateTime + ", systemApp=" + this.systemApp + ", filePath=" + this.filePath + ", targetSdkVersion=" + this.targetSdkVersion + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalApk)) {
            return false;
        }
        LocalApk localApk = (LocalApk) obj;
        if (this.packageName.equals(localApk.getPackageName()) && this.versionName.equals(localApk.getVersionName()) && this.versionCode == localApk.getVersionCode() && this.appName.equals(localApk.getAppName()) && this.apkLength == localApk.getApkLength() && this.firstInstallTime == localApk.getFirstInstallTime() && this.lastUpdateTime == localApk.getLastUpdateTime() && this.systemApp == localApk.isSystemApp() && this.filePath.equals(localApk.getFilePath()) && this.targetSdkVersion == localApk.getTargetSdkVersion()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j = this.apkLength;
        long j2 = this.firstInstallTime;
        long j3 = this.lastUpdateTime;
        return (((((((int) (((long) (((int) (((long) (((int) (((long) ((((((((this.packageName.hashCode() ^ 1000003) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.versionCode) * 1000003) ^ this.appName.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) ^ (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.systemApp ? 1231 : 1237)) * 1000003) ^ this.filePath.hashCode()) * 1000003) ^ this.targetSdkVersion;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LocalApk$Builder */
    static final class Builder extends LocalApk.Builder {
        private Long apkLength;
        private String appName;
        private String filePath;
        private Long firstInstallTime;
        private Long lastUpdateTime;
        private String packageName;
        private Boolean systemApp;
        private Integer targetSdkVersion;
        private Integer versionCode;
        private String versionName;

        Builder() {
        }

        Builder(LocalApk localApk) {
            this.packageName = localApk.getPackageName();
            this.versionName = localApk.getVersionName();
            this.versionCode = Integer.valueOf(localApk.getVersionCode());
            this.appName = localApk.getAppName();
            this.apkLength = Long.valueOf(localApk.getApkLength());
            this.firstInstallTime = Long.valueOf(localApk.getFirstInstallTime());
            this.lastUpdateTime = Long.valueOf(localApk.getLastUpdateTime());
            this.systemApp = Boolean.valueOf(localApk.isSystemApp());
            this.filePath = localApk.getFilePath();
            this.targetSdkVersion = Integer.valueOf(localApk.getTargetSdkVersion());
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder versionName(String str) {
            this.versionName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder versionCode(int i) {
            this.versionCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder apkLength(long j) {
            this.apkLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder firstInstallTime(long j) {
            this.firstInstallTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder lastUpdateTime(long j) {
            this.lastUpdateTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder systemApp(boolean z) {
            this.systemApp = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder filePath(String str) {
            this.filePath = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk.Builder targetSdkVersion(int i) {
            this.targetSdkVersion = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.LocalApk.Builder
        public LocalApk build() {
            String str = "";
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
            if (this.systemApp == null) {
                str = str + " systemApp";
            }
            if (this.filePath == null) {
                str = str + " filePath";
            }
            if (this.targetSdkVersion == null) {
                str = str + " targetSdkVersion";
            }
            if (str.isEmpty()) {
                return new AutoValue_LocalApk(this.packageName, this.versionName, this.versionCode.intValue(), this.appName, this.apkLength.longValue(), this.firstInstallTime.longValue(), this.lastUpdateTime.longValue(), this.systemApp.booleanValue(), this.filePath, this.targetSdkVersion.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
