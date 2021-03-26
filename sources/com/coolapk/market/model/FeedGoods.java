package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_FeedGoods;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public abstract class FeedGoods implements Entity {
    @SerializedName("category_name")
    public abstract String getBackendCategoryName();

    @SerializedName("bgColor")
    public abstract String getBgColor();

    @SerializedName("block_status")
    public abstract int getBlockStatus();

    @SerializedName("buy_count")
    public abstract String getBuyCount();

    @SerializedName("category_id")
    public abstract long getCategoryId();

    @SerializedName("categoryRows")
    public abstract List<FeedGoodsCategory> getCategoryRows();

    @SerializedName("cover")
    public abstract String getCover();

    @SerializedName("create_time")
    public abstract long getCreateTime();

    @SerializedName("create_uid")
    public abstract String getCreateUid();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "goods";
    }

    @SerializedName("fromApi")
    public abstract int getFromApi();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("keywords")
    public abstract String getKeyWords();

    @SerializedName("mall_name")
    public abstract String getMallName();

    @SerializedName("mall_sku")
    public abstract String getMallSku();

    public abstract String getPrice();

    @SerializedName("sell_time")
    public abstract long getSellTime();

    @SerializedName("sell_url")
    public abstract String getSellUrl();

    @SerializedName("sku_id")
    public abstract String getSkuId();

    @SerializedName("tabList")
    public abstract List<ConfigPage> getTabApiList();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @SerializedName("update_time")
    public abstract long getUpdateTime();

    @SerializedName("update_uid")
    public abstract String getUpdateUid();

    @SerializedName("wish_count")
    public abstract String getWishCount();

    public static TypeAdapter<FeedGoods> typeAdapter(Gson gson) {
        return new C$AutoValue_FeedGoods.GsonTypeAdapter(gson);
    }

    public String getCategoryName() {
        if (!TextUtils.isEmpty(getBackendCategoryName())) {
            return getBackendCategoryName();
        }
        if (getCategoryId() == 0) {
            return "";
        }
        return (String) Observable.from(getCategoryRows()).filter(new Func1<FeedGoodsCategory, Boolean>() {
            /* class com.coolapk.market.model.FeedGoods.AnonymousClass2 */

            public Boolean call(FeedGoodsCategory feedGoodsCategory) {
                return Boolean.valueOf(feedGoodsCategory.getId() == FeedGoods.this.getCategoryId());
            }
        }).map(new Func1<FeedGoodsCategory, String>() {
            /* class com.coolapk.market.model.FeedGoods.AnonymousClass1 */

            public String call(FeedGoodsCategory feedGoodsCategory) {
                return feedGoodsCategory.getTitle();
            }
        }).toBlocking().firstOrDefault("");
    }
}
