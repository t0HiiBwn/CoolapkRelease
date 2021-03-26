package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_GoodsCategoryInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class GoodsCategoryInfo implements Parcelable {
    @SerializedName("cat_id")
    public abstract String getCatId();

    @SerializedName("cat_title")
    public abstract String getCatTitle();

    public static TypeAdapter<GoodsCategoryInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_GoodsCategoryInfo.GsonTypeAdapter(gson);
    }
}
