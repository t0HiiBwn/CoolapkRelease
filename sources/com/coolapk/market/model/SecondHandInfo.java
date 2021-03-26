package com.coolapk.market.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_SecondHandInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class SecondHandInfo implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("city")
    public abstract String getCity();

    @SerializedName("city_code")
    public abstract String getCityCode();

    @SerializedName("product_config_data")
    public abstract String getConfigJson();

    @SerializedName("dateline")
    public abstract Long getDateline();

    @SerializedName("ershou_type_id")
    public abstract String getErshouTypeID();

    @SerializedName("ershou_type_title")
    public abstract String getErshouTypeTitle();

    @SerializedName("exchange_price_type")
    public abstract int getExchangePriceType();

    @SerializedName("feed_id")
    public abstract String getFeedId();

    @SerializedName("ershou_lastupdate")
    public abstract Long getLastUpdate();

    @SerializedName("link_notice")
    public abstract String getLinkNotice();

    @SerializedName("product_logo")
    public abstract String getLogo();

    @SerializedName("product_price")
    public abstract String getPrice();

    @SerializedName("product_config_source")
    public abstract String getProductConfigSource();

    @SerializedName("ershou_product_id")
    public abstract String getProductId();

    @SerializedName("province")
    public abstract String getProvince();

    @SerializedName("deal_type")
    public abstract int getSecondHandDealType();

    @SerializedName("is_face_deal")
    public abstract int getSecondHandFaceDeal();

    @SerializedName("ershou_status")
    public abstract int getSecondHandStatus();

    @SerializedName("link_source")
    public abstract String getSource();

    @SerializedName("store_type")
    public abstract int getStoreType();

    @SerializedName("store_type_txt")
    public abstract String getStoreTypeText();

    @SerializedName("product_title")
    public abstract String getTitle();

    @SerializedName("link_url")
    public abstract String getUrl();

    public String getPriceText() {
        if (isFaceDeal()) {
            return "价格面议";
        }
        return "¥" + getPrice();
    }

    public String getPriceShowText() {
        if (isFaceDeal()) {
            return "价格面议";
        }
        if (isMoneyMe()) {
            return "卖家加钱";
        }
        return isMoneyYou() ? "买家加钱" : "";
    }

    public boolean isShowNotice() {
        return !TextUtils.isEmpty(getLinkNotice());
    }

    public boolean hasLink() {
        return !TextUtils.isEmpty(getUrl());
    }

    public boolean isSelled() {
        return getSecondHandStatus() < 0;
    }

    public boolean isXianyu() {
        return TextUtils.equals(getSource(), "闲鱼");
    }

    public boolean isJiaoYiMao() {
        return TextUtils.equals(getSource(), "交易猫");
    }

    public boolean isZhuanzhuan() {
        return TextUtils.equals(getSource(), "转转");
    }

    public boolean isMoneyMe() {
        return getExchangePriceType() == 1;
    }

    public boolean isMoneyYou() {
        return getExchangePriceType() == 2;
    }

    public String getDealType() {
        int secondHandDealType = getSecondHandDealType();
        if (secondHandDealType == 0) {
            return "出售";
        }
        if (secondHandDealType != 1) {
            return secondHandDealType != 2 ? "" : "换机";
        }
        return "收购";
    }

    public boolean isFaceDeal() {
        return getSecondHandFaceDeal() == 1;
    }

    public static TypeAdapter<SecondHandInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_SecondHandInfo.GsonTypeAdapter(gson);
    }
}
