package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_ProductSeries;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class ProductSeries implements Entity {
    public static final String TYPE_HOT = "hot";
    public static final String TYPE_OTHER = "other";
    public static final String TYPE_RECOMMEND = "recommend";

    @SerializedName("brand_id")
    public abstract int getBrandId();

    @SerializedName("display_order")
    public abstract int getDisplayOrder();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "productSeries";
    }

    @SerializedName("product_num")
    public abstract int getProductNum();

    @SerializedName("productRows")
    public abstract List<Product> getProductRows();

    public static TypeAdapter<ProductSeries> typeAdapter(Gson gson) {
        return new C$AutoValue_ProductSeries.GsonTypeAdapter(gson);
    }
}
