package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_MessageCard  reason: invalid class name */
abstract class C$$AutoValue_MessageCard extends MessageCard {
    private final Long dateline;
    private final String description;
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
    private final String title;
    private final String url;

    C$$AutoValue_MessageCard(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, String str11) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.pic = str4;
        this.logo = str5;
        this.subTitle = str6;
        this.id = str7;
        this.extraData = str8;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.title = str9;
        this.url = str10;
        this.description = str11;
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

    @Override // java.lang.Object
    public String toString() {
        return "MessageCard{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageCard)) {
            return false;
        }
        MessageCard messageCard = (MessageCard) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(messageCard.getEntityTypeName()) : messageCard.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(messageCard.getEntityTemplate()) : messageCard.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(messageCard.getEntityId()) : messageCard.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(messageCard.getEntityFixed()) : messageCard.getEntityFixed() == null) {
                        String str4 = this.pic;
                        if (str4 != null ? str4.equals(messageCard.getPic()) : messageCard.getPic() == null) {
                            String str5 = this.logo;
                            if (str5 != null ? str5.equals(messageCard.getLogo()) : messageCard.getLogo() == null) {
                                String str6 = this.subTitle;
                                if (str6 != null ? str6.equals(messageCard.getSubTitle()) : messageCard.getSubTitle() == null) {
                                    String str7 = this.id;
                                    if (str7 != null ? str7.equals(messageCard.getId()) : messageCard.getId() == null) {
                                        String str8 = this.extraData;
                                        if (str8 != null ? str8.equals(messageCard.getExtraData()) : messageCard.getExtraData() == null) {
                                            Long l2 = this.dateline;
                                            if (l2 != null ? l2.equals(messageCard.getDateline()) : messageCard.getDateline() == null) {
                                                Long l3 = this.lastUpdate;
                                                if (l3 != null ? l3.equals(messageCard.getLastUpdate()) : messageCard.getLastUpdate() == null) {
                                                    String str9 = this.title;
                                                    if (str9 != null ? str9.equals(messageCard.getTitle()) : messageCard.getTitle() == null) {
                                                        String str10 = this.url;
                                                        if (str10 != null ? str10.equals(messageCard.getUrl()) : messageCard.getUrl() == null) {
                                                            String str11 = this.description;
                                                            if (str11 == null) {
                                                                if (messageCard.getDescription() == null) {
                                                                    return true;
                                                                }
                                                            } else if (str11.equals(messageCard.getDescription())) {
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
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.pic;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.logo;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.subTitle;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.id;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.extraData;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode10 = (hashCode9 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode11 = (hashCode10 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str9 = this.title;
        int hashCode12 = (hashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.url;
        int hashCode13 = (hashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.description;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode13 ^ i;
    }
}
