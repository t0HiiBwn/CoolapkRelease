package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ProductMedia  reason: invalid class name */
abstract class C$$AutoValue_ProductMedia extends ProductMedia {
    private final String UID;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String feedId;
    private final String id;
    private final int isRecommend;
    private final Long lastUpdate;
    private final String logo;
    private final String mediaInfo;
    private final String pic;
    private final String productId;
    private final String subTitle;
    private final String title;
    private final String type;
    private final String url;
    private final String urlMd5;
    private final String userName;

    C$$AutoValue_ProductMedia(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i2) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityTypeId = i;
        this.entityId = str4;
        this.entityFixed = num;
        this.title = str5;
        this.url = str6;
        this.description = str7;
        this.pic = str8;
        this.logo = str9;
        this.subTitle = str10;
        this.extraData = str11;
        this.dateline = l;
        this.lastUpdate = l2;
        Objects.requireNonNull(str12, "Null id");
        this.id = str12;
        this.productId = str13;
        this.feedId = str14;
        this.UID = str15;
        this.userName = str16;
        this.type = str17;
        this.mediaInfo = str18;
        this.urlMd5 = str19;
        this.isRecommend = i2;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public String getEntityType() {
        return this.entityType;
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

    @Override // com.coolapk.market.model.ProductMedia, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("product_id")
    public String getProductId() {
        return this.productId;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("feed_id")
    public String getFeedId() {
        return this.feedId;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("uid")
    public String getUID() {
        return this.UID;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("username")
    public String getUserName() {
        return this.userName;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("type")
    public String getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("media_info")
    public String getMediaInfo() {
        return this.mediaInfo;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("url_md5")
    public String getUrlMd5() {
        return this.urlMd5;
    }

    @Override // com.coolapk.market.model.ProductMedia
    @SerializedName("is_recommend")
    public int getIsRecommend() {
        return this.isRecommend;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ProductMedia{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", productId=" + this.productId + ", feedId=" + this.feedId + ", UID=" + this.UID + ", userName=" + this.userName + ", type=" + this.type + ", mediaInfo=" + this.mediaInfo + ", urlMd5=" + this.urlMd5 + ", isRecommend=" + this.isRecommend + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Long l;
        Long l2;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductMedia)) {
            return false;
        }
        ProductMedia productMedia = (ProductMedia) obj;
        String str17 = this.entityTypeName;
        if (str17 != null ? str17.equals(productMedia.getEntityTypeName()) : productMedia.getEntityTypeName() == null) {
            if (this.entityType.equals(productMedia.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(productMedia.getEntityTemplate()) : productMedia.getEntityTemplate() == null) && this.entityTypeId == productMedia.getEntityTypeId() && ((str2 = this.entityId) != null ? str2.equals(productMedia.getEntityId()) : productMedia.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(productMedia.getEntityFixed()) : productMedia.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(productMedia.getTitle()) : productMedia.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(productMedia.getUrl()) : productMedia.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(productMedia.getDescription()) : productMedia.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(productMedia.getPic()) : productMedia.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(productMedia.getLogo()) : productMedia.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(productMedia.getSubTitle()) : productMedia.getSubTitle() == null) && ((str9 = this.extraData) != null ? str9.equals(productMedia.getExtraData()) : productMedia.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(productMedia.getDateline()) : productMedia.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(productMedia.getLastUpdate()) : productMedia.getLastUpdate() == null) && this.id.equals(productMedia.getId()) && ((str10 = this.productId) != null ? str10.equals(productMedia.getProductId()) : productMedia.getProductId() == null) && ((str11 = this.feedId) != null ? str11.equals(productMedia.getFeedId()) : productMedia.getFeedId() == null) && ((str12 = this.UID) != null ? str12.equals(productMedia.getUID()) : productMedia.getUID() == null) && ((str13 = this.userName) != null ? str13.equals(productMedia.getUserName()) : productMedia.getUserName() == null) && ((str14 = this.type) != null ? str14.equals(productMedia.getType()) : productMedia.getType() == null) && ((str15 = this.mediaInfo) != null ? str15.equals(productMedia.getMediaInfo()) : productMedia.getMediaInfo() == null) && ((str16 = this.urlMd5) != null ? str16.equals(productMedia.getUrlMd5()) : productMedia.getUrlMd5() == null) && this.isRecommend == productMedia.getIsRecommend()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.entityType.hashCode()) * 1000003;
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
        int hashCode13 = (((hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str11 = this.productId;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.feedId;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.UID;
        int hashCode16 = (hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.userName;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.type;
        int hashCode18 = (hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.mediaInfo;
        int hashCode19 = (hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.urlMd5;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return ((hashCode19 ^ i) * 1000003) ^ this.isRecommend;
    }
}
