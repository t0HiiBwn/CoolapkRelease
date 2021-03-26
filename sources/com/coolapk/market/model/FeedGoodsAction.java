package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$$AutoValue_FeedGoodsAction;
import com.coolapk.market.model.C$AutoValue_FeedGoodsAction;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FeedGoodsAction implements Parcelable {
    public static FeedGoodsAction EMPTY = new C$$AutoValue_FeedGoodsAction.Builder().star(0).wishBuyStatus(0).categoryId(0).hotNum(0).status(0).recommendStatus(0).categoryName("无").sellUrl("").price("").mallName("").build();

    public static abstract class Builder {
        public abstract FeedGoodsAction build();

        public abstract Builder categoryId(int i);

        public abstract Builder categoryName(String str);

        public abstract Builder hotNum(int i);

        public abstract Builder mallName(String str);

        public abstract Builder price(String str);

        public abstract Builder recommendStatus(int i);

        public abstract Builder sellUrl(String str);

        public abstract Builder star(int i);

        public abstract Builder status(int i);

        public abstract Builder wishBuyStatus(int i);
    }

    @SerializedName("category_id")
    public abstract int getCategoryId();

    @SerializedName("category_name")
    public abstract String getCategoryName();

    @SerializedName("hot_num")
    public abstract int getHotNum();

    @SerializedName("mall_name")
    public abstract String getMallName();

    public abstract String getPrice();

    @SerializedName("recommend_status")
    public abstract int getRecommendStatus();

    @SerializedName("sell_url")
    public abstract String getSellUrl();

    public abstract int getStar();

    @SerializedName("status")
    public abstract int getStatus();

    @SerializedName("wish_buy_status")
    public abstract int getWishBuyStatus();

    public static Builder newBuilder(FeedGoodsAction feedGoodsAction) {
        return new C$$AutoValue_FeedGoodsAction.Builder(feedGoodsAction);
    }

    public static TypeAdapter<FeedGoodsAction> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedGoodsAction.GsonTypeAdapter(gson);
    }
}
