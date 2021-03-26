package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_BackupInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class BackupInfo implements Entity {
    @SerializedName("apk_num")
    public abstract int getApkNum();

    @SerializedName("backNum")
    public abstract int getBackNum();

    @SerializedName("createdate")
    public abstract Long getCreateTime();

    @SerializedName("device_name")
    public abstract String getDeviceName();

    @SerializedName("device_title")
    public abstract String getDeviceTitle();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "back";
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("unLocalEntities")
    public abstract List<LocalApp> getLocalApps();

    @SerializedName("recovery_time")
    public abstract Long getRecoveryTime();

    @SerializedName("localEntities")
    public abstract List<ServiceApp> getServiceApps();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @SerializedName("uid")
    public abstract String getUid();

    @SerializedName("username")
    public abstract String getUserName();

    @SerializedName("version_md5")
    public abstract String getVersionMD5();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getApkNumTitle() {
        return "共" + getApkNum() + "个应用";
    }

    public static TypeAdapter<BackupInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_BackupInfo.GsonTypeAdapter(gson);
    }
}
