package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_VersionApp;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class VersionApp implements Parcelable {
    private String apkUrlCache;
    private String apkUrlMd5Cache;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("title")
    public abstract String getAppName();

    public abstract String getDownloadFrom();

    public abstract String getPackageName();

    public abstract String getVersionDate();

    public abstract String getVersionId();

    public abstract String getVersionLength();

    @SerializedName("version")
    public abstract String getVersionName();

    public abstract String getVersionSize();

    public String getDownloadUrl(String str) {
        cacheUrl(str);
        return this.apkUrlCache;
    }

    public String getDownloadUrlMd5(String str) {
        cacheUrl(str);
        return this.apkUrlMd5Cache;
    }

    private void cacheUrl(String str) {
        if (this.apkUrlCache == null) {
            String apkVersionDownloadUrl = CacheUrlUtils.getApkVersionDownloadUrl(getPackageName(), str, getVersionId(), getDownloadFrom());
            this.apkUrlCache = apkVersionDownloadUrl;
            this.apkUrlMd5Cache = StringUtils.toMd5(apkVersionDownloadUrl);
        }
    }

    public static TypeAdapter<VersionApp> typeAdapter(Gson gson) {
        return new C$AutoValue_VersionApp.GsonTypeAdapter(gson);
    }
}
