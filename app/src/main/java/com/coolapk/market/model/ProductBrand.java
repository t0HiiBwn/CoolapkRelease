package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_ProductBrand;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class ProductBrand implements Entity {
    public static final String TYPE_HOT = "hot";
    public static final String TYPE_OTHER = "other";
    public static final String TYPE_RECOMMEND = "recommend";

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "productBrand";
    }

    @SerializedName("is_recommend")
    public abstract int getIsRecommend();

    @SerializedName("product_num")
    public abstract int getProductNum();

    @SerializedName("series_num")
    public abstract int getSeriesNum();

    @SerializedName("type")
    public abstract String getType();

    public static TypeAdapter<ProductBrand> typeAdapter(Gson gson) {
        return new C$AutoValue_ProductBrand.GsonTypeAdapter(gson);
    }
}
