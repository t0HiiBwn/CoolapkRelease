package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_PicCategory  reason: invalid class name */
abstract class C$$AutoValue_PicCategory extends PicCategory {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final int entityTypeId;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_PicCategory(String str, String str2, String str3, int i, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, Long l, Long l2, String str11, String str12) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityTypeId = i;
        this.entityId = str4;
        this.entityFixed = num;
        this.url = str5;
        this.description = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.id = str9;
        this.extraData = str10;
        this.dateline = l;
        this.lastUpdate = l2;
        Objects.requireNonNull(str11, "Null pic");
        this.pic = str11;
        Objects.requireNonNull(str12, "Null title");
        this.title = str12;
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
    @SerializedName("id")
    public String getId() {
        return this.id;
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

    @Override // com.coolapk.market.model.PicCategory, com.coolapk.market.model.Entity
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.PicCategory, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PicCategory{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityTypeId=" + this.entityTypeId + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", pic=" + this.pic + ", title=" + this.title + "}";
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
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PicCategory)) {
            return false;
        }
        PicCategory picCategory = (PicCategory) obj;
        String str9 = this.entityTypeName;
        if (str9 != null ? str9.equals(picCategory.getEntityTypeName()) : picCategory.getEntityTypeName() == null) {
            if (this.entityType.equals(picCategory.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(picCategory.getEntityTemplate()) : picCategory.getEntityTemplate() == null) && this.entityTypeId == picCategory.getEntityTypeId() && ((str2 = this.entityId) != null ? str2.equals(picCategory.getEntityId()) : picCategory.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(picCategory.getEntityFixed()) : picCategory.getEntityFixed() == null) && ((str3 = this.url) != null ? str3.equals(picCategory.getUrl()) : picCategory.getUrl() == null) && ((str4 = this.description) != null ? str4.equals(picCategory.getDescription()) : picCategory.getDescription() == null) && ((str5 = this.logo) != null ? str5.equals(picCategory.getLogo()) : picCategory.getLogo() == null) && ((str6 = this.subTitle) != null ? str6.equals(picCategory.getSubTitle()) : picCategory.getSubTitle() == null) && ((str7 = this.id) != null ? str7.equals(picCategory.getId()) : picCategory.getId() == null) && ((str8 = this.extraData) != null ? str8.equals(picCategory.getExtraData()) : picCategory.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(picCategory.getDateline()) : picCategory.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(picCategory.getLastUpdate()) : picCategory.getLastUpdate() == null) && this.pic.equals(picCategory.getPic()) && this.title.equals(picCategory.getTitle())) {
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
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.description;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.logo;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.subTitle;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.id;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.extraData;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode11 = (hashCode10 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return ((((hashCode11 ^ i) * 1000003) ^ this.pic.hashCode()) * 1000003) ^ this.title.hashCode();
    }
}
