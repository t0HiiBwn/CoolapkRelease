package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_Goods  reason: invalid class name */
abstract class C$$AutoValue_Goods extends Goods {
    private final GoodsCategoryInfo categoryInfo;
    private final String categoryTitle;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final int goodIsDirect;
    private final String goodsBuyText;
    private final String goodsBuyUrl;
    private final String goodsPic;
    private final String goodsTags;
    private final String goodsTitle;
    private final String goodsUrl;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final MallInfo mallInfo;
    private final String mallTitle;
    private final String pic;
    private final String promoPrice;
    private final String promoTitle;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_Goods(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, GoodsCategoryInfo goodsCategoryInfo, int i2, MallInfo mallInfo2, String str20, String str21) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityTypeId = i;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.extraData = str10;
        this.dateline = l;
        this.lastUpdate = l2;
        this.id = str11;
        this.goodsTitle = str12;
        this.promoTitle = str13;
        this.promoPrice = str14;
        this.goodsPic = str15;
        this.goodsTags = str16;
        this.goodsUrl = str17;
        this.goodsBuyUrl = str18;
        this.goodsBuyText = str19;
        this.categoryInfo = goodsCategoryInfo;
        this.goodIsDirect = i2;
        this.mallInfo = mallInfo2;
        this.categoryTitle = str20;
        this.mallTitle = str21;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return this.entityTypeId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.Goods, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_title")
    public String getGoodsTitle() {
        return this.goodsTitle;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_promo_title")
    public String getPromoTitle() {
        return this.promoTitle;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_promo_price")
    public String getPromoPrice() {
        return this.promoPrice;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_pic")
    public String getGoodsPic() {
        return this.goodsPic;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_tags")
    public String getGoodsTags() {
        return this.goodsTags;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_url")
    public String getGoodsUrl() {
        return this.goodsUrl;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_buy_url")
    public String getGoodsBuyUrl() {
        return this.goodsBuyUrl;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_buy_text")
    public String getGoodsBuyText() {
        return this.goodsBuyText;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("categoryInfo")
    public GoodsCategoryInfo getCategoryInfo() {
        return this.categoryInfo;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("goods_is_direct")
    public int getGoodIsDirect() {
        return this.goodIsDirect;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("mallInfo")
    public MallInfo getMallInfo() {
        return this.mallInfo;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("category_title")
    public String getCategoryTitle() {
        return this.categoryTitle;
    }

    @Override // com.coolapk.market.model.Goods
    @SerializedName("mall_title")
    public String getMallTitle() {
        return this.mallTitle;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Goods{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", goodsTitle=" + this.goodsTitle + ", promoTitle=" + this.promoTitle + ", promoPrice=" + this.promoPrice + ", goodsPic=" + this.goodsPic + ", goodsTags=" + this.goodsTags + ", goodsUrl=" + this.goodsUrl + ", goodsBuyUrl=" + this.goodsBuyUrl + ", goodsBuyText=" + this.goodsBuyText + ", categoryInfo=" + this.categoryInfo + ", goodIsDirect=" + this.goodIsDirect + ", mallInfo=" + this.mallInfo + ", categoryTitle=" + this.categoryTitle + ", mallTitle=" + this.mallTitle + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        Integer num;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Long l;
        Long l2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        GoodsCategoryInfo goodsCategoryInfo;
        MallInfo mallInfo2;
        String str18;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Goods)) {
            return false;
        }
        Goods goods = (Goods) obj;
        String str19 = this.entityTypeName;
        if (str19 != null ? str19.equals(goods.getEntityTypeName()) : goods.getEntityTypeName() == null) {
            String str20 = this.entityTemplate;
            if (str20 != null ? str20.equals(goods.getEntityTemplate()) : goods.getEntityTemplate() == null) {
                if (this.entityTypeId == goods.getEntityTypeId() && ((str = this.entityId) != null ? str.equals(goods.getEntityId()) : goods.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(goods.getEntityFixed()) : goods.getEntityFixed() == null) && ((str2 = this.title) != null ? str2.equals(goods.getTitle()) : goods.getTitle() == null) && ((str3 = this.url) != null ? str3.equals(goods.getUrl()) : goods.getUrl() == null) && ((str4 = this.description) != null ? str4.equals(goods.getDescription()) : goods.getDescription() == null) && ((str5 = this.pic) != null ? str5.equals(goods.getPic()) : goods.getPic() == null) && ((str6 = this.logo) != null ? str6.equals(goods.getLogo()) : goods.getLogo() == null) && ((str7 = this.subTitle) != null ? str7.equals(goods.getSubTitle()) : goods.getSubTitle() == null) && ((str8 = this.extraData) != null ? str8.equals(goods.getExtraData()) : goods.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(goods.getDateline()) : goods.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(goods.getLastUpdate()) : goods.getLastUpdate() == null) && ((str9 = this.id) != null ? str9.equals(goods.getId()) : goods.getId() == null) && ((str10 = this.goodsTitle) != null ? str10.equals(goods.getGoodsTitle()) : goods.getGoodsTitle() == null) && ((str11 = this.promoTitle) != null ? str11.equals(goods.getPromoTitle()) : goods.getPromoTitle() == null) && ((str12 = this.promoPrice) != null ? str12.equals(goods.getPromoPrice()) : goods.getPromoPrice() == null) && ((str13 = this.goodsPic) != null ? str13.equals(goods.getGoodsPic()) : goods.getGoodsPic() == null) && ((str14 = this.goodsTags) != null ? str14.equals(goods.getGoodsTags()) : goods.getGoodsTags() == null) && ((str15 = this.goodsUrl) != null ? str15.equals(goods.getGoodsUrl()) : goods.getGoodsUrl() == null) && ((str16 = this.goodsBuyUrl) != null ? str16.equals(goods.getGoodsBuyUrl()) : goods.getGoodsBuyUrl() == null) && ((str17 = this.goodsBuyText) != null ? str17.equals(goods.getGoodsBuyText()) : goods.getGoodsBuyText() == null) && ((goodsCategoryInfo = this.categoryInfo) != null ? goodsCategoryInfo.equals(goods.getCategoryInfo()) : goods.getCategoryInfo() == null) && this.goodIsDirect == goods.getGoodIsDirect() && ((mallInfo2 = this.mallInfo) != null ? mallInfo2.equals(goods.getMallInfo()) : goods.getMallInfo() == null) && ((str18 = this.categoryTitle) != null ? str18.equals(goods.getCategoryTitle()) : goods.getCategoryTitle() == null)) {
                    String str21 = this.mallTitle;
                    if (str21 == null) {
                        if (goods.getMallTitle() == null) {
                            return true;
                        }
                    } else if (str21.equals(goods.getMallTitle())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.entityTypeId) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.url;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.description;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.extraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode12 = (hashCode11 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode13 = (hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str11 = this.id;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.goodsTitle;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.promoTitle;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.promoPrice;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.goodsPic;
        int hashCode18 = (hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.goodsTags;
        int hashCode19 = (hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.goodsUrl;
        int hashCode20 = (hashCode19 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.goodsBuyUrl;
        int hashCode21 = (hashCode20 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.goodsBuyText;
        int hashCode22 = (hashCode21 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        GoodsCategoryInfo goodsCategoryInfo = this.categoryInfo;
        int hashCode23 = (((hashCode22 ^ (goodsCategoryInfo == null ? 0 : goodsCategoryInfo.hashCode())) * 1000003) ^ this.goodIsDirect) * 1000003;
        MallInfo mallInfo2 = this.mallInfo;
        int hashCode24 = (hashCode23 ^ (mallInfo2 == null ? 0 : mallInfo2.hashCode())) * 1000003;
        String str20 = this.categoryTitle;
        int hashCode25 = (hashCode24 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.mallTitle;
        if (str21 != null) {
            i = str21.hashCode();
        }
        return hashCode25 ^ i;
    }
}
