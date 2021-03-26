package com.coolapk.market.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_UpgradeInfo;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.StringUtils;

public abstract class UpgradeInfo implements Parcelable {
    public static final int DOWNLOAD_URL_TYPE_APK = 0;
    public static final int DOWNLOAD_URL_TYPE_PATCH = 1;
    private String apkUrlCache;
    private String apkUrlMd5Cache;
    private String patchUrlCache;
    private String patchUrlMd5Cache;

    public static abstract class Builder {
        public abstract Builder apkId(String str);

        public abstract Builder apkSize(String str);

        public abstract UpgradeInfo build();

        public abstract Builder changeLog(String str);

        public abstract Builder displayVersionName(String str);

        public abstract Builder extraAnalysisData(String str);

        public abstract Builder extraFlag(String str);

        public abstract Builder lastUpdate(long j);

        public abstract Builder logo(String str);

        public abstract Builder packageName(String str);

        public abstract Builder patchKey(String str);

        public abstract Builder patchLength(Long l);

        public abstract Builder patchMd5(String str);

        public abstract Builder patchSize(String str);

        public abstract Builder versionCode(int i);

        public abstract Builder versionName(String str);
    }

    public abstract String getApkId();

    public abstract String getApkSize();

    public abstract String getChangeLog();

    public abstract String getDisplayVersionName();

    public abstract String getExtraAnalysisData();

    public abstract String getExtraFlag();

    public abstract long getLastUpdate();

    public abstract String getLogo();

    public abstract String getPackageName();

    public abstract String getPatchKey();

    public abstract Long getPatchLength();

    public abstract String getPatchMd5();

    public abstract String getPatchSize();

    public abstract int getVersionCode();

    public abstract String getVersionName();

    public static Builder newBuilder() {
        return new C$AutoValue_UpgradeInfo.Builder();
    }

    public boolean hasPatch() {
        return !TextUtils.isEmpty(getPatchKey());
    }

    public int getDownloadUrlTypeSmart() {
        return TextUtils.isEmpty(getPatchKey()) ? 0 : 1;
    }

    public String getDownloadUrl(int i) {
        cacheUrl();
        if (i != 1) {
            return this.apkUrlCache;
        }
        if (hasPatch()) {
            return this.patchUrlCache;
        }
        throw new RuntimeException("Are you sure you want to use patch url?! check hasPatch() first");
    }

    public String getDownloadUrlSmart() {
        if (TextUtils.isEmpty(getPatchKey())) {
            return getDownloadUrl(0);
        }
        return getDownloadUrl(1);
    }

    public String getDownloadUrlMd5(int i) {
        cacheUrl();
        if (i != 1) {
            return this.apkUrlMd5Cache;
        }
        return this.patchUrlMd5Cache;
    }

    private void cacheUrl() {
        if (this.apkUrlCache == null) {
            String apkDownloadUrl = CacheUrlUtils.getApkDownloadUrl(getPackageName(), getApkId(), getVersionCode(), false);
            this.apkUrlCache = apkDownloadUrl;
            this.apkUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl);
        }
        if (hasPatch() && this.patchUrlCache == null) {
            String apkDownloadPatchUrl = CacheUrlUtils.getApkDownloadPatchUrl(getPackageName(), getApkId(), getPatchKey());
            this.patchUrlCache = apkDownloadPatchUrl;
            this.patchUrlMd5Cache = StringUtils.toMd5(apkDownloadPatchUrl);
        }
    }
}
