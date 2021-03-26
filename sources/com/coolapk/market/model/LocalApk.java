package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_LocalApk;
import com.coolapk.market.util.StringUtils;

public abstract class LocalApk implements Parcelable {
    private String filePathMd5;
    private int packageHashCode = 0;

    public static abstract class Builder {
        public abstract Builder apkLength(long j);

        public abstract Builder appName(String str);

        public abstract LocalApk build();

        public abstract Builder filePath(String str);

        public abstract Builder firstInstallTime(long j);

        public abstract Builder lastUpdateTime(long j);

        public abstract Builder packageName(String str);

        public abstract Builder systemApp(boolean z);

        public abstract Builder targetSdkVersion(int i);

        public abstract Builder versionCode(int i);

        public abstract Builder versionName(String str);
    }

    public abstract long getApkLength();

    public abstract String getAppName();

    public abstract String getFilePath();

    public abstract long getFirstInstallTime();

    public abstract long getLastUpdateTime();

    public abstract String getPackageName();

    public abstract int getTargetSdkVersion();

    public abstract int getVersionCode();

    public abstract String getVersionName();

    public abstract boolean isSystemApp();

    public int getPackageNameHashCode() {
        if (this.packageHashCode == 0) {
            this.packageHashCode = getPackageName().hashCode();
        }
        return this.packageHashCode;
    }

    public String getFilePathMd5() {
        if (this.filePathMd5 == null) {
            this.filePathMd5 = StringUtils.toMd5(getFilePath());
        }
        return this.filePathMd5;
    }

    public static Builder newBuilder() {
        return new C$AutoValue_LocalApk.Builder();
    }
}
