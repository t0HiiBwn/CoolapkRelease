package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_AppCategory  reason: invalid class name */
abstract class C$$AutoValue_AppCategory extends AppCategory {
    private final String apkType;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final String keywords;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final List<String> tagList;
    private final String title;
    private final String url;

    C$$AutoValue_AppCategory(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, Long l, Long l2, String str9, String str10, String str11, String str12, String str13, List<String> list, String str14) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityId = str4;
        this.entityFixed = num;
        this.url = str5;
        this.pic = str6;
        this.subTitle = str7;
        this.extraData = str8;
        this.dateline = l;
        this.lastUpdate = l2;
        Objects.requireNonNull(str9, "Null id");
        this.id = str9;
        Objects.requireNonNull(str10, "Null title");
        this.title = str10;
        this.logo = str11;
        this.keywords = str12;
        this.description = str13;
        Objects.requireNonNull(list, "Null tagList");
        this.tagList = list;
        Objects.requireNonNull(str14, "Null apkType");
        this.apkType = str14;
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
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
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

    @Override // com.coolapk.market.model.AppCategory, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.AppCategory, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.AppCategory, com.coolapk.market.model.Entity
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.AppCategory
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.coolapk.market.model.AppCategory, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.AppCategory
    public List<String> getTagList() {
        return this.tagList;
    }

    @Override // com.coolapk.market.model.AppCategory
    public String getApkType() {
        return this.apkType;
    }

    @Override // java.lang.Object
    public String toString() {
        return "AppCategory{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", title=" + this.title + ", logo=" + this.logo + ", keywords=" + this.keywords + ", description=" + this.description + ", tagList=" + this.tagList + ", apkType=" + this.apkType + "}";
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
        Long l;
        Long l2;
        String str7;
        String str8;
        String str9;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppCategory)) {
            return false;
        }
        AppCategory appCategory = (AppCategory) obj;
        String str10 = this.entityTypeName;
        if (str10 != null ? str10.equals(appCategory.getEntityTypeName()) : appCategory.getEntityTypeName() == null) {
            if (this.entityType.equals(appCategory.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(appCategory.getEntityTemplate()) : appCategory.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(appCategory.getEntityId()) : appCategory.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(appCategory.getEntityFixed()) : appCategory.getEntityFixed() == null) && ((str3 = this.url) != null ? str3.equals(appCategory.getUrl()) : appCategory.getUrl() == null) && ((str4 = this.pic) != null ? str4.equals(appCategory.getPic()) : appCategory.getPic() == null) && ((str5 = this.subTitle) != null ? str5.equals(appCategory.getSubTitle()) : appCategory.getSubTitle() == null) && ((str6 = this.extraData) != null ? str6.equals(appCategory.getExtraData()) : appCategory.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(appCategory.getDateline()) : appCategory.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(appCategory.getLastUpdate()) : appCategory.getLastUpdate() == null) && this.id.equals(appCategory.getId()) && this.title.equals(appCategory.getTitle()) && ((str7 = this.logo) != null ? str7.equals(appCategory.getLogo()) : appCategory.getLogo() == null) && ((str8 = this.keywords) != null ? str8.equals(appCategory.getKeywords()) : appCategory.getKeywords() == null) && ((str9 = this.description) != null ? str9.equals(appCategory.getDescription()) : appCategory.getDescription() == null) && this.tagList.equals(appCategory.getTagList()) && this.apkType.equals(appCategory.getApkType())) {
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
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.pic;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.subTitle;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.extraData;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode9 = (hashCode8 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode10 = (((((hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003;
        String str8 = this.logo;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.keywords;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.description;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return ((((hashCode12 ^ i) * 1000003) ^ this.tagList.hashCode()) * 1000003) ^ this.apkType.hashCode();
    }
}
