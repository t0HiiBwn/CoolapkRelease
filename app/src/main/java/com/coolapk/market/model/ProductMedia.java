package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_ProductMedia;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class ProductMedia implements Entity {
    @SerializedName("feed_id")
    public abstract String getFeedId();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("is_recommend")
    public abstract int getIsRecommend();

    @SerializedName("media_info")
    public abstract String getMediaInfo();

    @SerializedName("product_id")
    public abstract String getProductId();

    @SerializedName("type")
    public abstract String getType();

    @SerializedName("uid")
    public abstract String getUID();

    @SerializedName("url_md5")
    public abstract String getUrlMd5();

    @SerializedName("username")
    public abstract String getUserName();

    public static TypeAdapter<ProductMedia> typeAdapter(Gson gson) {
        return new C$AutoValue_ProductMedia.GsonTypeAdapter(gson);
    }
}
