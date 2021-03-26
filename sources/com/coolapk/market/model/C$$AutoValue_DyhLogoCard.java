package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DyhLogoCard  reason: invalid class name */
abstract class C$$AutoValue_DyhLogoCard extends DyhLogoCard {
    private final Long dateline;
    private final String description;
    private final List<Entity> entities;
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

    C$$AutoValue_DyhLogoCard(String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, Long l2, Long l3, String str8, String str9, String str10, List<Entity> list, String str11, String str12) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.pic = str3;
        this.logo = str4;
        this.subTitle = str5;
        this.id = str6;
        this.extraData = str7;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.title = str8;
        this.url = str9;
        this.description = str10;
        this.entities = list;
        this.entityTypeName = str11;
        Objects.requireNonNull(str12, "Null entityType");
        this.entityType = str12;
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

    @Override // com.coolapk.market.model.DyhLogoCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DyhLogoCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.DyhLogoCard, com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.DyhLogoCard, com.coolapk.market.model.Card
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override // com.coolapk.market.model.DyhLogoCard, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.DyhLogoCard, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DyhLogoCard{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", entities=" + this.entities + ", entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DyhLogoCard)) {
            return false;
        }
        DyhLogoCard dyhLogoCard = (DyhLogoCard) obj;
        String str = this.entityTemplate;
        if (str != null ? str.equals(dyhLogoCard.getEntityTemplate()) : dyhLogoCard.getEntityTemplate() == null) {
            String str2 = this.entityId;
            if (str2 != null ? str2.equals(dyhLogoCard.getEntityId()) : dyhLogoCard.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(dyhLogoCard.getEntityFixed()) : dyhLogoCard.getEntityFixed() == null) {
                    String str3 = this.pic;
                    if (str3 != null ? str3.equals(dyhLogoCard.getPic()) : dyhLogoCard.getPic() == null) {
                        String str4 = this.logo;
                        if (str4 != null ? str4.equals(dyhLogoCard.getLogo()) : dyhLogoCard.getLogo() == null) {
                            String str5 = this.subTitle;
                            if (str5 != null ? str5.equals(dyhLogoCard.getSubTitle()) : dyhLogoCard.getSubTitle() == null) {
                                String str6 = this.id;
                                if (str6 != null ? str6.equals(dyhLogoCard.getId()) : dyhLogoCard.getId() == null) {
                                    String str7 = this.extraData;
                                    if (str7 != null ? str7.equals(dyhLogoCard.getExtraData()) : dyhLogoCard.getExtraData() == null) {
                                        Long l2 = this.dateline;
                                        if (l2 != null ? l2.equals(dyhLogoCard.getDateline()) : dyhLogoCard.getDateline() == null) {
                                            Long l3 = this.lastUpdate;
                                            if (l3 != null ? l3.equals(dyhLogoCard.getLastUpdate()) : dyhLogoCard.getLastUpdate() == null) {
                                                String str8 = this.title;
                                                if (str8 != null ? str8.equals(dyhLogoCard.getTitle()) : dyhLogoCard.getTitle() == null) {
                                                    String str9 = this.url;
                                                    if (str9 != null ? str9.equals(dyhLogoCard.getUrl()) : dyhLogoCard.getUrl() == null) {
                                                        String str10 = this.description;
                                                        if (str10 != null ? str10.equals(dyhLogoCard.getDescription()) : dyhLogoCard.getDescription() == null) {
                                                            List<Entity> list = this.entities;
                                                            if (list != null ? list.equals(dyhLogoCard.getEntities()) : dyhLogoCard.getEntities() == null) {
                                                                String str11 = this.entityTypeName;
                                                                if (str11 != null ? str11.equals(dyhLogoCard.getEntityTypeName()) : dyhLogoCard.getEntityTypeName() == null) {
                                                                    if (this.entityType.equals(dyhLogoCard.getEntityType())) {
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
        String str3 = this.pic;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.logo;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.id;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.extraData;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode9 = (hashCode8 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode10 = (hashCode9 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str8 = this.title;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.url;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.description;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        List<Entity> list = this.entities;
        int hashCode14 = (hashCode13 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        String str11 = this.entityTypeName;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return ((hashCode14 ^ i) * 1000003) ^ this.entityType.hashCode();
    }
}
