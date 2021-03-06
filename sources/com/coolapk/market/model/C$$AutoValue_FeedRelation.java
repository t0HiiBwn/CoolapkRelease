package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedRelation  reason: invalid class name */
abstract class C$$AutoValue_FeedRelation extends FeedRelation {
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

    C$$AutoValue_FeedRelation(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.id = str10;
        this.extraData = str11;
        this.dateline = l;
        this.lastUpdate = l2;
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

    @Override // java.lang.Object
    public String toString() {
        return "FeedRelation{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedRelation)) {
            return false;
        }
        FeedRelation feedRelation = (FeedRelation) obj;
        String str = this.entityTypeName;
        if (str != null ? str.equals(feedRelation.getEntityTypeName()) : feedRelation.getEntityTypeName() == null) {
            String str2 = this.entityTemplate;
            if (str2 != null ? str2.equals(feedRelation.getEntityTemplate()) : feedRelation.getEntityTemplate() == null) {
                String str3 = this.entityId;
                if (str3 != null ? str3.equals(feedRelation.getEntityId()) : feedRelation.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(feedRelation.getEntityFixed()) : feedRelation.getEntityFixed() == null) {
                        String str4 = this.title;
                        if (str4 != null ? str4.equals(feedRelation.getTitle()) : feedRelation.getTitle() == null) {
                            String str5 = this.url;
                            if (str5 != null ? str5.equals(feedRelation.getUrl()) : feedRelation.getUrl() == null) {
                                String str6 = this.description;
                                if (str6 != null ? str6.equals(feedRelation.getDescription()) : feedRelation.getDescription() == null) {
                                    String str7 = this.pic;
                                    if (str7 != null ? str7.equals(feedRelation.getPic()) : feedRelation.getPic() == null) {
                                        String str8 = this.logo;
                                        if (str8 != null ? str8.equals(feedRelation.getLogo()) : feedRelation.getLogo() == null) {
                                            String str9 = this.subTitle;
                                            if (str9 != null ? str9.equals(feedRelation.getSubTitle()) : feedRelation.getSubTitle() == null) {
                                                String str10 = this.id;
                                                if (str10 != null ? str10.equals(feedRelation.getId()) : feedRelation.getId() == null) {
                                                    String str11 = this.extraData;
                                                    if (str11 != null ? str11.equals(feedRelation.getExtraData()) : feedRelation.getExtraData() == null) {
                                                        Long l = this.dateline;
                                                        if (l != null ? l.equals(feedRelation.getDateline()) : feedRelation.getDateline() == null) {
                                                            Long l2 = this.lastUpdate;
                                                            if (l2 == null) {
                                                                if (feedRelation.getLastUpdate() == null) {
                                                                    return true;
                                                                }
                                                            } else if (l2.equals(feedRelation.getLastUpdate())) {
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
        String str10 = this.id;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode13 = (hashCode12 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode13 ^ i;
    }
}
