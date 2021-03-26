package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_GoodsListItem;
import com.coolapk.market.model.C$AutoValue_GoodsListItem;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class GoodsListItem implements Entity {

    public static abstract class Builder {
        public abstract GoodsListItem build();

        public abstract Builder dateline(Long l2);

        public abstract Builder description(String str);

        public abstract Builder entityFixed(Integer num);

        public abstract Builder entityId(String str);

        public abstract Builder entityTemplate(String str);

        public abstract Builder entityTypeId(int i);

        public abstract Builder entityTypeName(String str);

        public abstract Builder extraData(String str);

        public abstract Builder feedId(String str);

        public abstract Builder goodsUrl(String str);

        public abstract Builder id(String str);

        public abstract Builder lastUpdate(Long l2);

        public abstract Builder logo(String str);

        public abstract Builder mallName(String str);

        public abstract Builder note(String str);

        public abstract Builder pic(String str);

        public abstract Builder price(String str);

        public abstract Builder productGoodsId(String str);

        public abstract Builder productGoodsLogo(String str);

        public abstract Builder productGoodsTitle(String str);

        public abstract Builder sort(int i);

        public abstract Builder subTitle(String str);

        public abstract Builder title(String str);

        public abstract Builder url(String str);
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public abstract Long getDateline();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "goodsListItem";
    }

    @SerializedName("feed_id")
    public abstract String getFeedId();

    @SerializedName("product_goods_url")
    public abstract String getGoodsUrl();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("mall_name")
    public abstract String getMallName();

    @SerializedName("note")
    public abstract String getNote();

    @SerializedName("price")
    public abstract String getPrice();

    @SerializedName("product_goods_id")
    public abstract String getProductGoodsId();

    @SerializedName("product_goods_cover")
    public abstract String getProductGoodsLogo();

    @SerializedName("product_goods_title")
    public abstract String getProductGoodsTitle();

    @SerializedName("sort")
    public abstract int getSort();

    public static TypeAdapter<GoodsListItem> typeAdapter(Gson gson) {
        return new C$AutoValue_GoodsListItem.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_GoodsListItem.Builder();
    }

    public static Builder newBuilder(GoodsListItem goodsListItem) {
        if (goodsListItem == null) {
            return newBuilder();
        }
        return new C$$AutoValue_GoodsListItem.Builder(goodsListItem);
    }
}
