package com.coolapk.market.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_MobileApp;

public abstract class MobileApp implements Parcelable {

    public static abstract class Builder {
        public abstract Builder apkLength(long j);

        public abstract Builder apkMd5(String str);

        public abstract Builder apkPath(String str);

        public abstract Builder appName(String str);

        public abstract MobileApp build();

        public abstract Builder created(long j);

        public abstract Builder dbId(long j);

        public abstract Builder exist(boolean z);

        public abstract Builder firstInstallTime(long j);

        public abstract Builder ignoreInfo(IgnoreInfo ignoreInfo);

        public abstract Builder lastUpdateTime(long j);

        public abstract Builder modified(long j);

        public abstract Builder packageName(String str);

        public abstract Builder systemApp(boolean z);

        public abstract Builder upgradeInfo(UpgradeInfo upgradeInfo);

        public abstract Builder versionCode(int i);

        public abstract Builder versionName(String str);
    }

    public abstract long getApkLength();

    public abstract String getApkMd5();

    public abstract String getApkPath();

    public abstract String getAppName();

    public abstract long getCreated();

    public abstract long getDbId();

    public abstract long getFirstInstallTime();

    public abstract IgnoreInfo getIgnoreInfo();

    public abstract long getLastUpdateTime();

    public abstract long getModified();

    public abstract String getPackageName();

    public abstract UpgradeInfo getUpgradeInfo();

    public abstract int getVersionCode();

    public abstract String getVersionName();

    public abstract boolean isExist();

    public abstract boolean isSystemApp();

    public boolean canUpgrade() {
        return getUpgradeInfo() != null && !TextUtils.isEmpty(getUpgradeInfo().getApkId());
    }

    public static Builder newBuilder() {
        return new C$AutoValue_MobileApp.Builder();
    }

    public static Builder newBuilder(MobileApp mobileApp) {
        return new C$AutoValue_MobileApp.Builder(mobileApp);
    }
}
