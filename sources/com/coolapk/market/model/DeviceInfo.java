package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_DeviceInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class DeviceInfo implements Entity {
    @SerializedName("device_name")
    public abstract String getDeviceName();

    @SerializedName("device_title")
    public abstract String getDeviceTitle();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "device_info";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public static TypeAdapter<DeviceInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_DeviceInfo.GsonTypeAdapter(gson);
    }
}
