package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_ProductConfig;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class ProductConfig implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("cpu")
    public abstract String getCPU();

    @SerializedName("config_data")
    public abstract String getConfigData();

    @SerializedName("fingerpoint_type")
    public abstract String getFingerpointType();

    @SerializedName("id")
    public abstract String getId();

    @SerializedName("keywords")
    public abstract String getKeywords();

    @SerializedName("phone_material")
    public abstract String getPhoneMaterial();

    @SerializedName("price")
    public abstract float getPrice();

    @SerializedName("product_id")
    public abstract String getProductId();

    @SerializedName("ram")
    public abstract String getRAM();

    @SerializedName("release_time")
    public abstract String getReleaseTime();

    @SerializedName("screen_material")
    public abstract String getScreenMaterial();

    @SerializedName("title")
    public abstract String getTitle();

    @SerializedName("zol_id")
    public abstract String getZolId();

    public static TypeAdapter<ProductConfig> typeAdapter(Gson gson) {
        return new C$AutoValue_ProductConfig.GsonTypeAdapter(gson);
    }
}
