package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_FeedGoodsCategory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FeedGoodsCategory implements Parcelable {
    @SerializedName("create_time")
    public abstract long getCreateTime();

    @SerializedName("create_uid")
    public abstract String getCreateUid();

    @SerializedName("display_order")
    public abstract int getDisplayOrder();

    @SerializedName("goods_count")
    public abstract String getGoodsCount();

    @SerializedName("id")
    public abstract long getId();

    @SerializedName("keywords")
    public abstract String getKeyWords();

    @SerializedName("log")
    public abstract String getLogo();

    @SerializedName("title")
    public abstract String getTitle();

    @SerializedName("update_time")
    public abstract long getUpdateTime();

    @SerializedName("update_uid")
    public abstract String getUpdateUid();

    public static TypeAdapter<FeedGoodsCategory> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedGoodsCategory.GsonTypeAdapter(gson);
    }
}
