package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.coolapk.market.model.$$AutoValue_TopCard  reason: invalid class name */
abstract class C$$AutoValue_TopCard extends TopCard {
    private final Long dateline;
    private final String description;
    private final List<ServiceApp> entities;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String subUrl;
    private final String title;
    private final String url;

    C$$AutoValue_TopCard(String str, String str2, String str3, Integer num, String str4, String str5, String str6, Long l2, Long l3, String str7, String str8, String str9, String str10, String str11, String str12, List<ServiceApp> list) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.logo = str4;
        this.id = str5;
        this.extraData = str6;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.title = str7;
        this.url = str8;
        this.description = str9;
        this.subTitle = str10;
        this.subUrl = str11;
        this.pic = str12;
        this.entities = list;
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

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Card, com.coolapk.market.model.Entity
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.TopCard, com.coolapk.market.model.Entity
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.TopCard
    public String getSubUrl() {
        return this.subUrl;
    }

    @Override // com.coolapk.market.model.TopCard, com.coolapk.market.model.Entity
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.TopCard, com.coolapk.market.model.Card
    public List<ServiceApp> getEntities() {
        return this.entities;
    }

    @Override // java.lang.Object
    public String toString() {
        return "TopCard{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", logo=" + this.logo + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", subTitle=" + this.subTitle + ", subUrl=" + this.subUrl + ", pic=" + this.pic + ", entities=" + this.entities + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopCard)) {
            return false;
        }
        TopCard topCard = (TopCard) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(topCard.getEntityTypeName()) : topCard.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(topCard.getEntityTemplate()) : topCard.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(topCard.getEntityId()) : topCard.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(topCard.getEntityFixed()) : topCard.getEntityFixed() == null) {
                        String str4 = this.logo;
                        if (str4 != null ? str4.equals(topCard.getLogo()) : topCard.getLogo() == null) {
                            String str5 = this.id;
                            if (str5 != null ? str5.equals(topCard.getId()) : topCard.getId() == null) {
                                String str6 = this.extraData;
                                if (str6 != null ? str6.equals(topCard.getExtraData()) : topCard.getExtraData() == null) {
                                    Long l2 = this.dateline;
                                    if (l2 != null ? l2.equals(topCard.getDateline()) : topCard.getDateline() == null) {
                                        Long l3 = this.lastUpdate;
                                        if (l3 != null ? l3.equals(topCard.getLastUpdate()) : topCard.getLastUpdate() == null) {
                                            String str7 = this.title;
                                            if (str7 != null ? str7.equals(topCard.getTitle()) : topCard.getTitle() == null) {
                                                String str8 = this.url;
                                                if (str8 != null ? str8.equals(topCard.getUrl()) : topCard.getUrl() == null) {
                                                    String str9 = this.description;
                                                    if (str9 != null ? str9.equals(topCard.getDescription()) : topCard.getDescription() == null) {
                                                        String str10 = this.subTitle;
                                                        if (str10 != null ? str10.equals(topCard.getSubTitle()) : topCard.getSubTitle() == null) {
                                                            String str11 = this.subUrl;
                                                            if (str11 != null ? str11.equals(topCard.getSubUrl()) : topCard.getSubUrl() == null) {
                                                                String str12 = this.pic;
                                                                if (str12 != null ? str12.equals(topCard.getPic()) : topCard.getPic() == null) {
                                                                    List<ServiceApp> list = this.entities;
                                                                    if (list == null) {
                                                                        if (topCard.getEntities() == null) {
                                                                            return true;
                                                                        }
                                                                    } else if (list.equals(topCard.getEntities())) {
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
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.logo;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.id;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode8 = (hashCode7 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode9 = (hashCode8 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str7 = this.title;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.url;
        int hashCode11 = (hashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.description;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.subTitle;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.subUrl;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.pic;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        List<ServiceApp> list = this.entities;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode15 ^ i;
    }
}
