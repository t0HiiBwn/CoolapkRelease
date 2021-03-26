package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_MallInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class MallInfo implements Parcelable {
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("mall_domain")
    public abstract String getMallDomain();

    @SerializedName("mall_logo")
    public abstract String getMallLogo();

    @SerializedName("mall_title")
    public abstract String getMallTitle();

    @SerializedName("name")
    public abstract String getName();

    public static TypeAdapter<MallInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_MallInfo.GsonTypeAdapter(gson);
    }
}
