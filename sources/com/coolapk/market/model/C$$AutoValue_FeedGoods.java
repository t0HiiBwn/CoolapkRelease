package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedGoods  reason: invalid class name */
abstract class C$$AutoValue_FeedGoods extends FeedGoods {
    private final String backendCategoryName;
    private final String bgColor;
    private final int blockStatus;
    private final String buyCount;
    private final long categoryId;
    private final List<FeedGoodsCategory> categoryRows;
    private final String cover;
    private final long createTime;
    private final String createUid;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final String keyWords;
    private final Long lastUpdate;
    private final String logo;
    private final String mallName;
    private final String mallSku;
    private final String pic;
    private final String price;
    private final long sellTime;
    private final String sellUrl;
    private final String skuId;
    private final String subTitle;
    private final List<ConfigPage> tabApiList;
    private final String title;
    private final long updateTime;
    private final String updateUid;
    private final String url;
    private final String wishCount;

    C$$AutoValue_FeedGoods(String str, String str2, int i, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, Long l3, String str10, String str11, String str12, String str13, long j, String str14, String str15, String str16, String str17, String str18, String str19, long j2, int i2, long j3, String str20, long j4, String str21, List<FeedGoodsCategory> list, String str22, String str23, String str24, List<ConfigPage> list2) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityTypeId = i;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.extraData = str9;
        this.dateline = l2;
        this.lastUpdate = l3;
        Objects.requireNonNull(str10, "Null id");
        this.id = str10;
        Objects.requireNonNull(str11, "Null mallName");
        this.mallName = str11;
        this.skuId = str12;
        this.mallSku = str13;
        this.categoryId = j;
        Objects.requireNonNull(str14, "Null title");
        this.title = str14;
        this.cover = str15;
        Objects.requireNonNull(str16, "Null wishCount");
        this.wishCount = str16;
        Objects.requireNonNull(str17, "Null buyCount");
        this.buyCount = str17;
        this.keyWords = str18;
        this.sellUrl = str19;
        this.sellTime = j2;
        this.blockStatus = i2;
        this.createTime = j3;
        Objects.requireNonNull(str20, "Null createUid");
        this.createUid = str20;
        this.updateTime = j4;
        Objects.requireNonNull(str21, "Null updateUid");
        this.updateUid = str21;
        Objects.requireNonNull(list, "Null categoryRows");
        this.categoryRows = list;
        this.bgColor = str22;
        this.backendCategoryName = str23;
        this.price = str24;
        Objects.requireNonNull(list2, "Null tabApiList");
        this.tabApiList = list2;
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

    @Override // com.coolapk.market.model.FeedGoods, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("mall_name")
    public String getMallName() {
        return this.mallName;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("sku_id")
    public String getSkuId() {
        return this.skuId;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("mall_sku")
    public String getMallSku() {
        return this.mallSku;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("category_id")
    public long getCategoryId() {
        return this.categoryId;
    }

    @Override // com.coolapk.market.model.FeedGoods, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("cover")
    public String getCover() {
        return this.cover;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("wish_count")
    public String getWishCount() {
        return this.wishCount;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("buy_count")
    public String getBuyCount() {
        return this.buyCount;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("keywords")
    public String getKeyWords() {
        return this.keyWords;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("sell_url")
    public String getSellUrl() {
        return this.sellUrl;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("sell_time")
    public long getSellTime() {
        return this.sellTime;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("create_time")
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("create_uid")
    public String getCreateUid() {
        return this.createUid;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("update_time")
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("update_uid")
    public String getUpdateUid() {
        return this.updateUid;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("categoryRows")
    public List<FeedGoodsCategory> getCategoryRows() {
        return this.categoryRows;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("bgColor")
    public String getBgColor() {
        return this.bgColor;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("category_name")
    public String getBackendCategoryName() {
        return this.backendCategoryName;
    }

    @Override // com.coolapk.market.model.FeedGoods
    public String getPrice() {
        return this.price;
    }

    @Override // com.coolapk.market.model.FeedGoods
    @SerializedName("tabList")
    public List<ConfigPage> getTabApiList() {
        return this.tabApiList;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedGoods{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", mallName=" + this.mallName + ", skuId=" + this.skuId + ", mallSku=" + this.mallSku + ", categoryId=" + this.categoryId + ", title=" + this.title + ", cover=" + this.cover + ", wishCount=" + this.wishCount + ", buyCount=" + this.buyCount + ", keyWords=" + this.keyWords + ", sellUrl=" + this.sellUrl + ", sellTime=" + this.sellTime + ", blockStatus=" + this.blockStatus + ", createTime=" + this.createTime + ", createUid=" + this.createUid + ", updateTime=" + this.updateTime + ", updateUid=" + this.updateUid + ", categoryRows=" + this.categoryRows + ", bgColor=" + this.bgColor + ", backendCategoryName=" + this.backendCategoryName + ", price=" + this.price + ", tabApiList=" + this.tabApiList + "}";
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
        Long l2;
        Long l3;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedGoods)) {
            return false;
        }
        FeedGoods feedGoods = (FeedGoods) obj;
        String str16 = this.entityTypeName;
        if (str16 != null ? str16.equals(feedGoods.getEntityTypeName()) : feedGoods.getEntityTypeName() == null) {
            String str17 = this.entityTemplate;
            if (str17 != null ? str17.equals(feedGoods.getEntityTemplate()) : feedGoods.getEntityTemplate() == null) {
                if (this.entityTypeId == feedGoods.getEntityTypeId() && ((str = this.entityId) != null ? str.equals(feedGoods.getEntityId()) : feedGoods.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(feedGoods.getEntityFixed()) : feedGoods.getEntityFixed() == null) && ((str2 = this.url) != null ? str2.equals(feedGoods.getUrl()) : feedGoods.getUrl() == null) && ((str3 = this.description) != null ? str3.equals(feedGoods.getDescription()) : feedGoods.getDescription() == null) && ((str4 = this.pic) != null ? str4.equals(feedGoods.getPic()) : feedGoods.getPic() == null) && ((str5 = this.logo) != null ? str5.equals(feedGoods.getLogo()) : feedGoods.getLogo() == null) && ((str6 = this.subTitle) != null ? str6.equals(feedGoods.getSubTitle()) : feedGoods.getSubTitle() == null) && ((str7 = this.extraData) != null ? str7.equals(feedGoods.getExtraData()) : feedGoods.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(feedGoods.getDateline()) : feedGoods.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(feedGoods.getLastUpdate()) : feedGoods.getLastUpdate() == null) && this.id.equals(feedGoods.getId()) && this.mallName.equals(feedGoods.getMallName()) && ((str8 = this.skuId) != null ? str8.equals(feedGoods.getSkuId()) : feedGoods.getSkuId() == null) && ((str9 = this.mallSku) != null ? str9.equals(feedGoods.getMallSku()) : feedGoods.getMallSku() == null) && this.categoryId == feedGoods.getCategoryId() && this.title.equals(feedGoods.getTitle()) && ((str10 = this.cover) != null ? str10.equals(feedGoods.getCover()) : feedGoods.getCover() == null) && this.wishCount.equals(feedGoods.getWishCount()) && this.buyCount.equals(feedGoods.getBuyCount()) && ((str11 = this.keyWords) != null ? str11.equals(feedGoods.getKeyWords()) : feedGoods.getKeyWords() == null) && ((str12 = this.sellUrl) != null ? str12.equals(feedGoods.getSellUrl()) : feedGoods.getSellUrl() == null) && this.sellTime == feedGoods.getSellTime() && this.blockStatus == feedGoods.getBlockStatus() && this.createTime == feedGoods.getCreateTime() && this.createUid.equals(feedGoods.getCreateUid()) && this.updateTime == feedGoods.getUpdateTime() && this.updateUid.equals(feedGoods.getUpdateUid()) && this.categoryRows.equals(feedGoods.getCategoryRows()) && ((str13 = this.bgColor) != null ? str13.equals(feedGoods.getBgColor()) : feedGoods.getBgColor() == null) && ((str14 = this.backendCategoryName) != null ? str14.equals(feedGoods.getBackendCategoryName()) : feedGoods.getBackendCategoryName() == null) && ((str15 = this.price) != null ? str15.equals(feedGoods.getPrice()) : feedGoods.getPrice() == null) && this.tabApiList.equals(feedGoods.getTabApiList())) {
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
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.description;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.pic;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.logo;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.subTitle;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.extraData;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode11 = (hashCode10 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode12 = (((((hashCode11 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.mallName.hashCode()) * 1000003;
        String str10 = this.skuId;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.mallSku;
        int hashCode14 = str11 == null ? 0 : str11.hashCode();
        long j = this.categoryId;
        int hashCode15 = (this.title.hashCode() ^ (((int) (((long) ((hashCode13 ^ hashCode14) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) * 1000003;
        String str12 = this.cover;
        int hashCode16 = (((((hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ this.wishCount.hashCode()) * 1000003) ^ this.buyCount.hashCode()) * 1000003;
        String str13 = this.keyWords;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.sellUrl;
        int hashCode18 = str14 == null ? 0 : str14.hashCode();
        long j2 = this.sellTime;
        int i2 = this.blockStatus;
        long j3 = this.createTime;
        int hashCode19 = this.createUid.hashCode();
        long j4 = this.updateTime;
        int hashCode20 = ((((((int) (((long) ((hashCode19 ^ (((int) (((long) ((i2 ^ (((int) (((long) ((hashCode17 ^ hashCode18) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) * 1000003)) ^ (j3 ^ (j3 >>> 32)))) * 1000003)) * 1000003)) ^ (j4 ^ (j4 >>> 32)))) * 1000003) ^ this.updateUid.hashCode()) * 1000003) ^ this.categoryRows.hashCode()) * 1000003;
        String str15 = this.bgColor;
        int hashCode21 = (hashCode20 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.backendCategoryName;
        int hashCode22 = (hashCode21 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.price;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return ((hashCode22 ^ i) * 1000003) ^ this.tabApiList.hashCode();
    }
}
