package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_SecondHandInfo  reason: invalid class name */
abstract class C$$AutoValue_SecondHandInfo extends SecondHandInfo {
    private final String city;
    private final String cityCode;
    private final String configJson;
    private final Long dateline;
    private final String ershouTypeID;
    private final String ershouTypeTitle;
    private final int exchangePriceType;
    private final String feedId;
    private final Long lastUpdate;
    private final String linkNotice;
    private final String logo;
    private final String price;
    private final String productConfigSource;
    private final String productId;
    private final String province;
    private final int secondHandDealType;
    private final int secondHandFaceDeal;
    private final int secondHandStatus;
    private final String source;
    private final int storeType;
    private final String storeTypeText;
    private final String title;
    private final String url;

    C$$AutoValue_SecondHandInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, String str13, String str14, int i2, Long l, Long l2, String str15, int i3, int i4, int i5, String str16) {
        this.feedId = str;
        this.title = str2;
        this.logo = str3;
        this.price = str4;
        this.configJson = str5;
        this.productConfigSource = str6;
        this.productId = str7;
        this.ershouTypeTitle = str8;
        this.ershouTypeID = str9;
        this.city = str10;
        this.province = str11;
        this.cityCode = str12;
        this.storeType = i;
        this.url = str13;
        this.source = str14;
        this.secondHandStatus = i2;
        this.dateline = l;
        this.lastUpdate = l2;
        this.storeTypeText = str15;
        this.secondHandDealType = i3;
        this.secondHandFaceDeal = i4;
        this.exchangePriceType = i5;
        this.linkNotice = str16;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("feed_id")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("product_title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("product_logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("product_price")
    public String getPrice() {
        return this.price;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("product_config_data")
    public String getConfigJson() {
        return this.configJson;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("product_config_source")
    public String getProductConfigSource() {
        return this.productConfigSource;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("ershou_product_id")
    public String getProductId() {
        return this.productId;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("ershou_type_title")
    public String getErshouTypeTitle() {
        return this.ershouTypeTitle;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("ershou_type_id")
    public String getErshouTypeID() {
        return this.ershouTypeID;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("city")
    public String getCity() {
        return this.city;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("province")
    public String getProvince() {
        return this.province;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("city_code")
    public String getCityCode() {
        return this.cityCode;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("store_type")
    public int getStoreType() {
        return this.storeType;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("link_url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("link_source")
    public String getSource() {
        return this.source;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("ershou_status")
    public int getSecondHandStatus() {
        return this.secondHandStatus;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("ershou_lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("store_type_txt")
    public String getStoreTypeText() {
        return this.storeTypeText;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("deal_type")
    public int getSecondHandDealType() {
        return this.secondHandDealType;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("is_face_deal")
    public int getSecondHandFaceDeal() {
        return this.secondHandFaceDeal;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("exchange_price_type")
    public int getExchangePriceType() {
        return this.exchangePriceType;
    }

    @Override // com.coolapk.market.model.SecondHandInfo
    @SerializedName("link_notice")
    public String getLinkNotice() {
        return this.linkNotice;
    }

    @Override // java.lang.Object
    public String toString() {
        return "SecondHandInfo{feedId=" + this.feedId + ", title=" + this.title + ", logo=" + this.logo + ", price=" + this.price + ", configJson=" + this.configJson + ", productConfigSource=" + this.productConfigSource + ", productId=" + this.productId + ", ershouTypeTitle=" + this.ershouTypeTitle + ", ershouTypeID=" + this.ershouTypeID + ", city=" + this.city + ", province=" + this.province + ", cityCode=" + this.cityCode + ", storeType=" + this.storeType + ", url=" + this.url + ", source=" + this.source + ", secondHandStatus=" + this.secondHandStatus + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", storeTypeText=" + this.storeTypeText + ", secondHandDealType=" + this.secondHandDealType + ", secondHandFaceDeal=" + this.secondHandFaceDeal + ", exchangePriceType=" + this.exchangePriceType + ", linkNotice=" + this.linkNotice + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Long l;
        Long l2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecondHandInfo)) {
            return false;
        }
        SecondHandInfo secondHandInfo = (SecondHandInfo) obj;
        String str4 = this.feedId;
        if (str4 != null ? str4.equals(secondHandInfo.getFeedId()) : secondHandInfo.getFeedId() == null) {
            String str5 = this.title;
            if (str5 != null ? str5.equals(secondHandInfo.getTitle()) : secondHandInfo.getTitle() == null) {
                String str6 = this.logo;
                if (str6 != null ? str6.equals(secondHandInfo.getLogo()) : secondHandInfo.getLogo() == null) {
                    String str7 = this.price;
                    if (str7 != null ? str7.equals(secondHandInfo.getPrice()) : secondHandInfo.getPrice() == null) {
                        String str8 = this.configJson;
                        if (str8 != null ? str8.equals(secondHandInfo.getConfigJson()) : secondHandInfo.getConfigJson() == null) {
                            String str9 = this.productConfigSource;
                            if (str9 != null ? str9.equals(secondHandInfo.getProductConfigSource()) : secondHandInfo.getProductConfigSource() == null) {
                                String str10 = this.productId;
                                if (str10 != null ? str10.equals(secondHandInfo.getProductId()) : secondHandInfo.getProductId() == null) {
                                    String str11 = this.ershouTypeTitle;
                                    if (str11 != null ? str11.equals(secondHandInfo.getErshouTypeTitle()) : secondHandInfo.getErshouTypeTitle() == null) {
                                        String str12 = this.ershouTypeID;
                                        if (str12 != null ? str12.equals(secondHandInfo.getErshouTypeID()) : secondHandInfo.getErshouTypeID() == null) {
                                            String str13 = this.city;
                                            if (str13 != null ? str13.equals(secondHandInfo.getCity()) : secondHandInfo.getCity() == null) {
                                                String str14 = this.province;
                                                if (str14 != null ? str14.equals(secondHandInfo.getProvince()) : secondHandInfo.getProvince() == null) {
                                                    String str15 = this.cityCode;
                                                    if (str15 != null ? str15.equals(secondHandInfo.getCityCode()) : secondHandInfo.getCityCode() == null) {
                                                        if (this.storeType == secondHandInfo.getStoreType() && ((str = this.url) != null ? str.equals(secondHandInfo.getUrl()) : secondHandInfo.getUrl() == null) && ((str2 = this.source) != null ? str2.equals(secondHandInfo.getSource()) : secondHandInfo.getSource() == null) && this.secondHandStatus == secondHandInfo.getSecondHandStatus() && ((l = this.dateline) != null ? l.equals(secondHandInfo.getDateline()) : secondHandInfo.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(secondHandInfo.getLastUpdate()) : secondHandInfo.getLastUpdate() == null) && ((str3 = this.storeTypeText) != null ? str3.equals(secondHandInfo.getStoreTypeText()) : secondHandInfo.getStoreTypeText() == null) && this.secondHandDealType == secondHandInfo.getSecondHandDealType() && this.secondHandFaceDeal == secondHandInfo.getSecondHandFaceDeal() && this.exchangePriceType == secondHandInfo.getExchangePriceType()) {
                                                            String str16 = this.linkNotice;
                                                            if (str16 == null) {
                                                                if (secondHandInfo.getLinkNotice() == null) {
                                                                    return true;
                                                                }
                                                            } else if (str16.equals(secondHandInfo.getLinkNotice())) {
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.feedId;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.title;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.logo;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.price;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.configJson;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.productConfigSource;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.productId;
        int hashCode7 = (hashCode6 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.ershouTypeTitle;
        int hashCode8 = (hashCode7 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.ershouTypeID;
        int hashCode9 = (hashCode8 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.city;
        int hashCode10 = (hashCode9 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.province;
        int hashCode11 = (hashCode10 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.cityCode;
        int hashCode12 = (((hashCode11 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.storeType) * 1000003;
        String str13 = this.url;
        int hashCode13 = (hashCode12 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.source;
        int hashCode14 = (((hashCode13 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ this.secondHandStatus) * 1000003;
        Long l = this.dateline;
        int hashCode15 = (hashCode14 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode16 = (hashCode15 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str15 = this.storeTypeText;
        int hashCode17 = (((((((hashCode16 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003) ^ this.secondHandDealType) * 1000003) ^ this.secondHandFaceDeal) * 1000003) ^ this.exchangePriceType) * 1000003;
        String str16 = this.linkNotice;
        if (str16 != null) {
            i = str16.hashCode();
        }
        return hashCode17 ^ i;
    }
}
