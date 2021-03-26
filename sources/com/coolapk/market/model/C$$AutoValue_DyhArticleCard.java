package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DyhArticleCard  reason: invalid class name */
abstract class C$$AutoValue_DyhArticleCard extends DyhArticleCard {
    private final Long dateline;
    private final String description;
    private final List<DyhArticle> entities;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_DyhArticleCard(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, List<DyhArticle> list, String str10, String str11, String str12, Long l2) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.logo = str3;
        this.subTitle = str4;
        this.id = str5;
        this.extraData = str6;
        this.dateline = l;
        this.description = str7;
        this.title = str8;
        this.url = str9;
        this.entities = list;
        this.entityTypeName = str10;
        Objects.requireNonNull(str11, "Null entityType");
        this.entityType = str11;
        Objects.requireNonNull(str12, "Null pic");
        this.pic = str12;
        Objects.requireNonNull(l2, "Null lastUpdate");
        this.lastUpdate = l2;
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

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Card
    public List<DyhArticle> getEntities() {
        return this.entities;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.DyhArticleCard, com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DyhArticleCard{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", description=" + this.description + ", title=" + this.title + ", url=" + this.url + ", entities=" + this.entities + ", entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", pic=" + this.pic + ", lastUpdate=" + this.lastUpdate + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DyhArticleCard)) {
            return false;
        }
        DyhArticleCard dyhArticleCard = (DyhArticleCard) obj;
        String str = this.entityTemplate;
        if (str != null ? str.equals(dyhArticleCard.getEntityTemplate()) : dyhArticleCard.getEntityTemplate() == null) {
            String str2 = this.entityId;
            if (str2 != null ? str2.equals(dyhArticleCard.getEntityId()) : dyhArticleCard.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(dyhArticleCard.getEntityFixed()) : dyhArticleCard.getEntityFixed() == null) {
                    String str3 = this.logo;
                    if (str3 != null ? str3.equals(dyhArticleCard.getLogo()) : dyhArticleCard.getLogo() == null) {
                        String str4 = this.subTitle;
                        if (str4 != null ? str4.equals(dyhArticleCard.getSubTitle()) : dyhArticleCard.getSubTitle() == null) {
                            String str5 = this.id;
                            if (str5 != null ? str5.equals(dyhArticleCard.getId()) : dyhArticleCard.getId() == null) {
                                String str6 = this.extraData;
                                if (str6 != null ? str6.equals(dyhArticleCard.getExtraData()) : dyhArticleCard.getExtraData() == null) {
                                    Long l = this.dateline;
                                    if (l != null ? l.equals(dyhArticleCard.getDateline()) : dyhArticleCard.getDateline() == null) {
                                        String str7 = this.description;
                                        if (str7 != null ? str7.equals(dyhArticleCard.getDescription()) : dyhArticleCard.getDescription() == null) {
                                            String str8 = this.title;
                                            if (str8 != null ? str8.equals(dyhArticleCard.getTitle()) : dyhArticleCard.getTitle() == null) {
                                                String str9 = this.url;
                                                if (str9 != null ? str9.equals(dyhArticleCard.getUrl()) : dyhArticleCard.getUrl() == null) {
                                                    List<DyhArticle> list = this.entities;
                                                    if (list != null ? list.equals(dyhArticleCard.getEntities()) : dyhArticleCard.getEntities() == null) {
                                                        String str10 = this.entityTypeName;
                                                        if (str10 != null ? str10.equals(dyhArticleCard.getEntityTypeName()) : dyhArticleCard.getEntityTypeName() == null) {
                                                            if (this.entityType.equals(dyhArticleCard.getEntityType()) && this.pic.equals(dyhArticleCard.getPic()) && this.lastUpdate.equals(dyhArticleCard.getLastUpdate())) {
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
        String str = this.entityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.logo;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.subTitle;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.id;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode8 = (hashCode7 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        String str7 = this.description;
        int hashCode9 = (hashCode8 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.title;
        int hashCode10 = (hashCode9 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.url;
        int hashCode11 = (hashCode10 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        List<DyhArticle> list = this.entities;
        int hashCode12 = (hashCode11 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str10 = this.entityTypeName;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return ((((((hashCode12 ^ i) * 1000003) ^ this.entityType.hashCode()) * 1000003) ^ this.pic.hashCode()) * 1000003) ^ this.lastUpdate.hashCode();
    }
}
