package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_Tips;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class Tips implements Parcelable {
    @SerializedName("buttonName")
    public abstract String getButtonName();

    @SerializedName("closable")
    public abstract int getClosable();

    @SerializedName("logo")
    public abstract String getLogo();

    @SerializedName("title")
    public abstract String getTitle();

    @SerializedName("url")
    public abstract String getUrl();

    public static TypeAdapter<Tips> typeAdapter(Gson gson) {
        return new C$AutoValue_Tips.GsonTypeAdapter(gson);
    }
}
