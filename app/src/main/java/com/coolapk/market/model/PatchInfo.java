package com.coolapk.market.model;

import com.coolapk.market.model.AutoValue_PatchInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class PatchInfo {
    @SerializedName("id")
    public abstract String getApkId();

    @SerializedName("apksize")
    public abstract String getApkSize();

    @SerializedName("title")
    public abstract String getAppFullName();

    @SerializedName("shorttitle")
    public abstract String getAppName();

    @SerializedName("changelog")
    public abstract String getChangeLog();

    @SerializedName("version")
    public abstract String getDisplayVersionName();

    public abstract String getExtraAnalysisData();

    public abstract String getExtraFlag();

    @SerializedName("lastupdate")
    public abstract long getLastUpdate();

    public abstract String getLogo();

    public abstract String getPackageName();

    public abstract String getPatchKey();

    public abstract Long getPatchLength();

    public abstract String getPatchMd5();

    public abstract String getPatchSize();

    @SerializedName("apkversioncode")
    public abstract int getVersionCode();

    @SerializedName("apkversionname")
    public abstract String getVersionName();

    public static TypeAdapter<PatchInfo> typeAdapter(Gson gson) {
        return new AutoValue_PatchInfo.GsonTypeAdapter(gson);
    }
}
