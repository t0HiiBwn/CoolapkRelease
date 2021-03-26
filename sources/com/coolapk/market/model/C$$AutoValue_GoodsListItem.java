package com.coolapk.market.model;

import com.coolapk.market.model.GoodsListItem;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_GoodsListItem  reason: invalid class name */
abstract class C$$AutoValue_GoodsListItem extends GoodsListItem {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String feedId;
    private final String goodsUrl;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String mallName;
    private final String note;
    private final String pic;
    private final String price;
    private final String productGoodsId;
    private final String productGoodsLogo;
    private final String productGoodsTitle;
    private final int sort;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_GoodsListItem(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i2, Long l3) {
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
        this.lastUpdate = l2;
        this.id = str11;
        this.feedId = str12;
        this.productGoodsId = str13;
        this.productGoodsLogo = str14;
        this.productGoodsTitle = str15;
        this.goodsUrl = str16;
        this.price = str17;
        this.mallName = str18;
        this.note = str19;
        this.sort = i2;
        Objects.requireNonNull(l3, "Null dateline");
        this.dateline = l3;
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
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.GoodsListItem, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("feed_id")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("product_goods_id")
    public String getProductGoodsId() {
        return this.productGoodsId;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("product_goods_cover")
    public String getProductGoodsLogo() {
        return this.productGoodsLogo;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("product_goods_title")
    public String getProductGoodsTitle() {
        return this.productGoodsTitle;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("product_goods_url")
    public String getGoodsUrl() {
        return this.goodsUrl;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("price")
    public String getPrice() {
        return this.price;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("mall_name")
    public String getMallName() {
        return this.mallName;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("note")
    public String getNote() {
        return this.note;
    }

    @Override // com.coolapk.market.model.GoodsListItem
    @SerializedName("sort")
    public int getSort() {
        return this.sort;
    }

    @Override // com.coolapk.market.model.GoodsListItem, com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // java.lang.Object
    public String toString() {
        return "GoodsListItem{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", feedId=" + this.feedId + ", productGoodsId=" + this.productGoodsId + ", productGoodsLogo=" + this.productGoodsLogo + ", productGoodsTitle=" + this.productGoodsTitle + ", goodsUrl=" + this.goodsUrl + ", price=" + this.price + ", mallName=" + this.mallName + ", note=" + this.note + ", sort=" + this.sort + ", dateline=" + this.dateline + "}";
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoodsListItem)) {
            return false;
        }
        GoodsListItem goodsListItem = (GoodsListItem) obj;
        String str18 = this.entityTypeName;
        if (str18 != null ? str18.equals(goodsListItem.getEntityTypeName()) : goodsListItem.getEntityTypeName() == null) {
            String str19 = this.entityTemplate;
            if (str19 != null ? str19.equals(goodsListItem.getEntityTemplate()) : goodsListItem.getEntityTemplate() == null) {
                if (this.entityTypeId == goodsListItem.getEntityTypeId() && ((str = this.entityId) != null ? str.equals(goodsListItem.getEntityId()) : goodsListItem.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(goodsListItem.getEntityFixed()) : goodsListItem.getEntityFixed() == null) && ((str2 = this.title) != null ? str2.equals(goodsListItem.getTitle()) : goodsListItem.getTitle() == null) && ((str3 = this.url) != null ? str3.equals(goodsListItem.getUrl()) : goodsListItem.getUrl() == null) && ((str4 = this.description) != null ? str4.equals(goodsListItem.getDescription()) : goodsListItem.getDescription() == null) && ((str5 = this.pic) != null ? str5.equals(goodsListItem.getPic()) : goodsListItem.getPic() == null) && ((str6 = this.logo) != null ? str6.equals(goodsListItem.getLogo()) : goodsListItem.getLogo() == null) && ((str7 = this.subTitle) != null ? str7.equals(goodsListItem.getSubTitle()) : goodsListItem.getSubTitle() == null) && ((str8 = this.extraData) != null ? str8.equals(goodsListItem.getExtraData()) : goodsListItem.getExtraData() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(goodsListItem.getLastUpdate()) : goodsListItem.getLastUpdate() == null) && ((str9 = this.id) != null ? str9.equals(goodsListItem.getId()) : goodsListItem.getId() == null) && ((str10 = this.feedId) != null ? str10.equals(goodsListItem.getFeedId()) : goodsListItem.getFeedId() == null) && ((str11 = this.productGoodsId) != null ? str11.equals(goodsListItem.getProductGoodsId()) : goodsListItem.getProductGoodsId() == null) && ((str12 = this.productGoodsLogo) != null ? str12.equals(goodsListItem.getProductGoodsLogo()) : goodsListItem.getProductGoodsLogo() == null) && ((str13 = this.productGoodsTitle) != null ? str13.equals(goodsListItem.getProductGoodsTitle()) : goodsListItem.getProductGoodsTitle() == null) && ((str14 = this.goodsUrl) != null ? str14.equals(goodsListItem.getGoodsUrl()) : goodsListItem.getGoodsUrl() == null) && ((str15 = this.price) != null ? str15.equals(goodsListItem.getPrice()) : goodsListItem.getPrice() == null) && ((str16 = this.mallName) != null ? str16.equals(goodsListItem.getMallName()) : goodsListItem.getMallName() == null) && ((str17 = this.note) != null ? str17.equals(goodsListItem.getNote()) : goodsListItem.getNote() == null) && this.sort == goodsListItem.getSort() && this.dateline.equals(goodsListItem.getDateline())) {
                    return true;
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
        Long l2 = this.lastUpdate;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str11 = this.id;
        int hashCode13 = (hashCode12 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.feedId;
        int hashCode14 = (hashCode13 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.productGoodsId;
        int hashCode15 = (hashCode14 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.productGoodsLogo;
        int hashCode16 = (hashCode15 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.productGoodsTitle;
        int hashCode17 = (hashCode16 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.goodsUrl;
        int hashCode18 = (hashCode17 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.price;
        int hashCode19 = (hashCode18 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.mallName;
        int hashCode20 = (hashCode19 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.note;
        if (str19 != null) {
            i = str19.hashCode();
        }
        return ((((hashCode20 ^ i) * 1000003) ^ this.sort) * 1000003) ^ this.dateline.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_GoodsListItem$Builder */
    /* compiled from: $$AutoValue_GoodsListItem */
    static final class Builder extends GoodsListItem.Builder {
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private Integer entityTypeId;
        private String entityTypeName;
        private String extraData;
        private String feedId;
        private String goodsUrl;
        private String id;
        private Long lastUpdate;
        private String logo;
        private String mallName;
        private String note;
        private String pic;
        private String price;
        private String productGoodsId;
        private String productGoodsLogo;
        private String productGoodsTitle;
        private Integer sort;
        private String subTitle;
        private String title;
        private String url;

        Builder() {
        }

        Builder(GoodsListItem goodsListItem) {
            this.entityTypeName = goodsListItem.getEntityTypeName();
            this.entityTemplate = goodsListItem.getEntityTemplate();
            this.entityTypeId = Integer.valueOf(goodsListItem.getEntityTypeId());
            this.entityId = goodsListItem.getEntityId();
            this.entityFixed = goodsListItem.getEntityFixed();
            this.title = goodsListItem.getTitle();
            this.url = goodsListItem.getUrl();
            this.description = goodsListItem.getDescription();
            this.pic = goodsListItem.getPic();
            this.logo = goodsListItem.getLogo();
            this.subTitle = goodsListItem.getSubTitle();
            this.extraData = goodsListItem.getExtraData();
            this.lastUpdate = goodsListItem.getLastUpdate();
            this.id = goodsListItem.getId();
            this.feedId = goodsListItem.getFeedId();
            this.productGoodsId = goodsListItem.getProductGoodsId();
            this.productGoodsLogo = goodsListItem.getProductGoodsLogo();
            this.productGoodsTitle = goodsListItem.getProductGoodsTitle();
            this.goodsUrl = goodsListItem.getGoodsUrl();
            this.price = goodsListItem.getPrice();
            this.mallName = goodsListItem.getMallName();
            this.note = goodsListItem.getNote();
            this.sort = Integer.valueOf(goodsListItem.getSort());
            this.dateline = goodsListItem.getDateline();
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder entityTypeId(int i) {
            this.entityTypeId = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder feedId(String str) {
            this.feedId = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder productGoodsId(String str) {
            this.productGoodsId = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder productGoodsLogo(String str) {
            this.productGoodsLogo = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder productGoodsTitle(String str) {
            this.productGoodsTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder goodsUrl(String str) {
            this.goodsUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder price(String str) {
            this.price = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder mallName(String str) {
            this.mallName = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder note(String str) {
            this.note = str;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder sort(int i) {
            this.sort = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.GoodsListItem.Builder
        public GoodsListItem build() {
            String str = "";
            if (this.entityTypeId == null) {
                str = str + " entityTypeId";
            }
            if (this.sort == null) {
                str = str + " sort";
            }
            if (this.dateline == null) {
                str = str + " dateline";
            }
            if (str.isEmpty()) {
                return new AutoValue_GoodsListItem(this.entityTypeName, this.entityTemplate, this.entityTypeId.intValue(), this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.extraData, this.lastUpdate, this.id, this.feedId, this.productGoodsId, this.productGoodsLogo, this.productGoodsTitle, this.goodsUrl, this.price, this.mallName, this.note, this.sort.intValue(), this.dateline);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
