package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_Goods;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Goods implements Entity {
    @SerializedName("categoryInfo")
    public abstract GoodsCategoryInfo getCategoryInfo();

    @SerializedName("category_title")
    public abstract String getCategoryTitle();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "pear_goods";
    }

    @SerializedName("goods_is_direct")
    public abstract int getGoodIsDirect();

    @SerializedName("goods_buy_text")
    public abstract String getGoodsBuyText();

    @SerializedName("goods_buy_url")
    public abstract String getGoodsBuyUrl();

    @SerializedName("goods_pic")
    public abstract String getGoodsPic();

    @SerializedName("goods_tags")
    public abstract String getGoodsTags();

    @SerializedName("goods_title")
    public abstract String getGoodsTitle();

    @SerializedName("goods_url")
    public abstract String getGoodsUrl();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public abstract String getId();

    @SerializedName("mallInfo")
    public abstract MallInfo getMallInfo();

    @SerializedName("mall_title")
    public abstract String getMallTitle();

    @SerializedName("goods_promo_price")
    public abstract String getPromoPrice();

    @SerializedName("goods_promo_title")
    public abstract String getPromoTitle();

    public boolean isDirect() {
        return getGoodIsDirect() == 1;
    }

    public String getBuyShowText() {
        if (TextUtils.isEmpty(getGoodsBuyText())) {
            return "立即购买";
        }
        return getGoodsBuyText();
    }

    public String getPromoPriceText() {
        if (TextUtils.isEmpty(getPromoPrice())) {
            return "";
        }
        return "￥" + getPromoPrice();
    }

    public List<String> getTags() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(getGoodsTags())) {
            Collections.addAll(arrayList, getGoodsTags().split(","));
        }
        if (!TextUtils.isEmpty(getCategoryTitle())) {
            arrayList.add(0, getCategoryTitle());
        } else if (getCategoryInfo() != null && !TextUtils.isEmpty(getCategoryInfo().getCatTitle())) {
            arrayList.add(0, getCategoryInfo().getCatTitle());
        }
        if (!TextUtils.isEmpty(getMallTitle())) {
            arrayList.add(0, getMallTitle());
        } else if (getMallInfo() != null && !TextUtils.isEmpty(getMallInfo().getMallTitle())) {
            arrayList.add(0, getMallInfo().getMallTitle());
        }
        return arrayList;
    }

    public static TypeAdapter<Goods> typeAdapter(Gson gson) {
        return new C$AutoValue_Goods.GsonTypeAdapter(gson);
    }
}
